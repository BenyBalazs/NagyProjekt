package controllers;

import database.Repositories;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import models.Car;
import models.CarOwner;

public class CarsAndOwnersController {

    @FXML
    private TextField searchField;

    @FXML
    private ListView<Car> listOfCars;

    @FXML
    private ListView<CarOwner> listOfOwners;

    @FXML
    public void initialize(){
        listOfOwners.setItems(FXCollections.observableList(Repositories.carOwnerRepository.findAll()));
        listOfOwners.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listOfOwners.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 2){
                        CarOwner owner = listOfOwners.getSelectionModel().getSelectedItem();
                        listOfCars.setItems(FXCollections.observableList(owner.getOwnedCars()));
                    }
                }
            }
        });
    }

    @FXML
    void searchOwner(MouseEvent event) {
        Repositories.repairRepository.findAll();
    }

}
