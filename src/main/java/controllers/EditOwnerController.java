package controllers;

import database.Repositories;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.OwnerTransfer;

import java.util.Optional;

public class EditOwnerController {

    private static final Logger logger = LoggerFactory.getLogger("EditOwnerController.class");

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
    public void initialize(){
        name.setText(OwnerTransfer.ownerTransfer.getName());
        address.setText(OwnerTransfer.ownerTransfer.getAddress());
        phoneNumber.setText(OwnerTransfer.ownerTransfer.getPhoneNum());
        email.setText(OwnerTransfer.ownerTransfer.getEmail());
        birthDate.setValue(OwnerTransfer.ownerTransfer.getDateOfBirth());
    }

    @FXML
    void deleteOwner(MouseEvent event) {

    }

    @FXML
    void saveEditOwner(MouseEvent event) {

    }

}
