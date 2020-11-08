package controllers;

import database.Repositories;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import models.CarOwner;
import utility.OwnerTransfer;

public class NewOwnerController {

    @FXML
    private ComboBox<CarOwner> ownerList;

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField email;

    @FXML
    private DatePicker birthDate;

    @FXML
    private RadioButton eowner;

    @FXML
    private RadioButton nowner;

    @FXML
    public void initialize(){
        disableNewOwner();
        eowner.setSelected(true);
        ownerList.setItems(FXCollections.observableList(Repositories.carOwnerRepository.findAll()));
    }

    @FXML
    void existingOwner(MouseEvent event) {
        disableNewOwner();
    }

    private void disableNewOwner(){
        email.setDisable(true);
        name.setDisable(true);
        address.setDisable(true);
        phoneNumber.setDisable(true);
        birthDate.setDisable(true);
        ownerList.setDisable(false);
        nowner.setSelected(false);
    }

    @FXML
    void newOwner(MouseEvent event) {
        email.setDisable(false);
        name.setDisable(false);
        address.setDisable(false);
        phoneNumber.setDisable(false);
        birthDate.setDisable(false);
        ownerList.setDisable(true);
        eowner.setSelected(false);
    }

    @FXML
    void next(MouseEvent event) {
        CarOwner carOwner = new CarOwner();
        if(nowner.isSelected()) {
            carOwner.setName(name.getText());
            carOwner.setEmail(email.getText());
            carOwner.setAddress(address.getText());
            carOwner.setPhoneNum(phoneNumber.getText());
            carOwner.setDateOfBirth(birthDate.getValue());
            Repositories.carOwnerRepository.createNew(carOwner);
        }
        else {
            carOwner = ownerList.getValue();
        }
        OwnerTransfer.ownerTransfer = carOwner;
        WizardController.changeScene("newCar", "Új autó adatai");
        WizardController.showStage();
    }

}
