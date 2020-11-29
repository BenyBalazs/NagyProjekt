package controllers;

import database.Repositories;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import models.Mechanic;
import models.Repair;
import utility.RepairTransfer;

public class RepairController {

    @FXML
    private ComboBox<String> brand;

    @FXML
    private ComboBox<String> type;

    @FXML
    private TextField licencePlate;

    @FXML
    private DatePicker manufacturedDate;

    @FXML
    private TextArea description;

    @FXML
    private Spinner<Integer> price;

    @FXML
    private ComboBox<Repair.RepairState> status;

    @FXML
    private ListView<Mechanic> listOfWorkers;

    @FXML
    private ComboBox<Mechanic> pickWorker;

    private Repair currentRepair = RepairTransfer.repairTransfer;

    @FXML
    public void initialize(){
        licencePlate.setText(currentRepair.getCarOnRepair().getLicensePlate());
        manufacturedDate.setValue(currentRepair.getCarOnRepair().getManufacturedDate());
        brand.setItems(FXCollections.observableList(Repositories.carModelRepository.getEveryBrandAsStringList()));
        brand.getSelectionModel().select(currentRepair.getCarOnRepair().getModel().getBrand());
        type.setItems(FXCollections.
                observableList(Repositories.
                        carModelRepository.
                        getEveryTypeFromGivenBrand(currentRepair.
                                getCarOnRepair().getModel().getBrand())));
        type.getSelectionModel().select(currentRepair.
                getCarOnRepair().getModel().getType());
        brand.setOnAction((actionEvent) -> {
               type.setItems(FXCollections.observableList(Repositories.
                       carModelRepository.getEveryTypeFromGivenBrand(brand.getValue())));
        });

        description.setText(currentRepair.getDescription());

        if(currentRepair.getPrice() != null)
            price.getValueFactory().setValue(currentRepair.getPrice());

        status.getItems().addAll(Repair.RepairState.values());
        status.getSelectionModel().select(currentRepair.getRepairState());

        listOfWorkers.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listOfWorkers.setItems(FXCollections.observableList(currentRepair.getMechanics()));

        pickWorker.getItems().addAll(Repositories.mechanicRepository.findAll());
    }

    @FXML
    void addWorker(MouseEvent event) {

    }

    @FXML
    void removeWorker(MouseEvent event) {

    }

    @FXML
    void saveEditCar(MouseEvent event) {

    }

}
