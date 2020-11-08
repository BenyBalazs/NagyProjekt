package controllers;

import database.Repositories;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import models.Mechanic;

public class WorkerController {

    @FXML
    private ListView<Mechanic> listOfWorkers;

    @FXML
    public void initialize(){
        listOfWorkers.setItems(FXCollections.observableList(Repositories.mechanicRepository.findAll()));
    }

    @FXML
    void deleteWorker(MouseEvent event) {

    }

    @FXML
    void editWorker(MouseEvent event) {

    }

}
