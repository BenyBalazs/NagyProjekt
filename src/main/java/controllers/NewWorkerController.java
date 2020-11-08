package controllers;

import database.Repositories;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import models.Mechanic;

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
        Mechanic mechanic = new Mechanic();
        mechanic.setName(workerName.getText());
        mechanic.setEmail(workerEmail.getText());
        mechanic.setPhoneNum(workerPhoneNumber.getText());
        mechanic.setDateOfBirth(workerBirthDate.getValue());
        Repositories.mechanicRepository.createNew(mechanic);
    }

}
