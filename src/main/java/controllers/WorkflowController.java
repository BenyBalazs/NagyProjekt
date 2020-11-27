package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import models.Repair;

public class WorkflowController {

    @FXML
    private ListView<Repair> listOfRepairs;

    @FXML
    void deleteRepair(MouseEvent event) {

    }

    @FXML
    void editRepair(MouseEvent event) {
        WizardController.changeScene("repair", "Munkafolyamat szerkesztése");
    }

}
