package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NewOwnerController {

    @FXML
    private ComboBox<?> ownerList;

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
    void existingOwner(MouseEvent event) {
        email.setDisable(true);
        name.setDisable(true);
        address.setDisable(true);
        phoneNumber.setDisable(true);
        birthDate.setDisable(true);
        ownerList.setDisable(false);
    }

    @FXML
    void newOwner(MouseEvent event) {
        email.setDisable(false);
        name.setDisable(false);
        address.setDisable(false);
        phoneNumber.setDisable(false);
        birthDate.setDisable(false);
        ownerList.setDisable(true);
    }

    @FXML
    void next(MouseEvent event) {
        WizardController.changeScene("newCar", "Új autó adatai");
        WizardController.showStage();
    }

}
