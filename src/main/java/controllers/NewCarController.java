package controllers;

import database.Repositories;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import models.Car;
import models.CarModel;
import models.CarOwner;
import models.Repair;
import utility.OwnerTransfer;

import java.time.LocalDate;

public class NewCarController {

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
    public void initialize(){
        brand.setItems(FXCollections.observableList(Repositories.carModelRepository.getEveryBrandAsStringList()));
        //type.setItems(FXCollections.observableList(Repositories.carModelRepository.getEveryTypeAsStringList()));
        brand.setOnAction((actionEvent) -> {
            type.getItems().removeAll();
            type.setItems(FXCollections.
                    observableList(Repositories.carModelRepository.
                            getEveryTypeFromGivenBrand(brand.getValue())));
        });
    }

    @FXML
    void ownerAndCarSave(MouseEvent event) {
        Car car = new Car();
        car.setLicensePlate(licencePlate.getText());
        car.setManufacturedDate(manufacturedDate.getValue());
        CarModel model = Repositories.carModelRepository.getModelByBrandAndType(brand.getValue(),type.getValue());
        if(model == null) {
            model = new CarModel();
            model.setBrand(brand.getValue());
            model.setType(type.getValue());
            Repositories.carModelRepository.createNew(model);
        }
        car.setModel(model);
        car.setOwner(OwnerTransfer.ownerTransfer);
        Repositories.carRepository.createNew(car);
        Repair repair = new Repair();
        repair.setCarOnRepair(car);
        repair.setStartOfRepair(LocalDate.now());
        repair.setDescription(description.getText());
        repair.setRepairState(Repair.RepairState.UNDER_REPAIR);
        Repositories.repairRepository.createNew(repair);

        Alert deleteSuccess = new Alert(Alert.AlertType.INFORMATION);
        deleteSuccess.setTitle("Sikeres atfeltöltés!");
        deleteSuccess.setContentText("Az autó és a tulajdonos adatai elmentve. Az ablak az OK gomb megnyomása után be fog záródni.");
        deleteSuccess.showAndWait();
    }

}
