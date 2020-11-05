package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NewWorkerController {

    @FXML
    private TextField workerName;

    @FXML
    private TextField workerEmail;

    @FXML
    private TextField workerPhoneNumber;

    @FXML
    private DatePicker workerBirthDate;

    @FXML
    void newWorkerSave(MouseEvent event) {

    }

}
