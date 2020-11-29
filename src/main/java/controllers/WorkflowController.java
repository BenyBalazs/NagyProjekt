package controllers;

import database.Repositories;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import models.Repair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class WorkflowController {

    private static Logger logger = LoggerFactory.getLogger("WorkerController.class");

    @FXML
    private ListView<Repair> listOfRepairs;

    @FXML
    void deleteRepair(MouseEvent event) {
        Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDelete.setTitle("Törlés megerősítése!");
        confirmDelete.setContentText("A törlés visszaállíthatatlanul eltávolítja az objektumot az adatbázisból és anomáliákhoz vezethet! Kérjük győződjön meg arról, hogy a szerelés eltávolítódott!");
        ButtonType confirm = new ButtonType("Törölje az adatbázisból!");
        ButtonType cancel = new ButtonType("Mégse");
        confirmDelete.getButtonTypes().setAll(confirm,cancel);

        Optional<ButtonType> result = confirmDelete.showAndWait();

        if(result.get() == confirm){
            logger.trace("A felhasználó törölni kívánta az entitást!");
            Repositories.repairRepository.deleteAndSetConnectionToNull(listOfRepairs.getSelectionModel().getSelectedItem());
            Alert deleteSuccess = new Alert(Alert.AlertType.INFORMATION);
            deleteSuccess.setTitle("Sikeres törlés!");
            deleteSuccess.setContentText("A szerelési státusz sikeresen törölve lett az adatbázisból!");
            deleteSuccess.showAndWait();
        }
    }

    @FXML
    void editRepair(MouseEvent event) {
        WizardController.changeScene("repair", "Munkafolyamat szerkesztése");
    }

}
