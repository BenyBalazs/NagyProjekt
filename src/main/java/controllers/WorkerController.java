package controllers;

import database.Repositories;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import models.Mechanic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger("WorkerController.class");

    @FXML
    private ListView<Mechanic> listOfWorkers;

    @FXML
    public void initialize(){
        listOfWorkers.setItems(FXCollections.observableList(Repositories.mechanicRepository.findAll()));
    }

    @FXML
    void deleteWorker(MouseEvent event) {
        Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDelete.setTitle("Törlés megerősítése!");
        confirmDelete.setContentText("A törlés visszaállíthatatlanul eltávolítja az objektumot az adatbázisból és anomáliákhoz vezethet! Kérjük győződjön meg arról, hogy a szerelőhöz nem tartozik szerelés!");
        ButtonType confirm = new ButtonType("Törölje az adatbázisból!");
        ButtonType cancel = new ButtonType("Mégse");
        confirmDelete.getButtonTypes().setAll(confirm,cancel);

        Optional<ButtonType> result = confirmDelete.showAndWait();

        if(result.get() == confirm){
            logger.trace("A felhasználó törölni kívánta az entitást!");
            Repositories.mechanicRepository.deleteAndSetConnectionToNull(listOfWorkers.getSelectionModel().getSelectedItem());

        }
    }

    @FXML
    void editWorker(MouseEvent event) {

    }

}
