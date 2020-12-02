package controllers;

import database.Repositories;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Mechanic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.MechanicTransfer;

import java.io.IOException;
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
        listOfWorkers.refresh();

        Optional<ButtonType> result = confirmDelete.showAndWait();

        if(result.get() == confirm){
            logger.trace("A felhasználó törölni kívánta az entitást!");
            Repositories.mechanicRepository.deleteAndSetConnectionToNull(listOfWorkers.getSelectionModel().getSelectedItem());
            Alert deleteSuccess = new Alert(Alert.AlertType.INFORMATION);
            deleteSuccess.setTitle("Sikeres törlés!");
            deleteSuccess.setContentText("A szerelő sikeresen törölve lett az adatbázisból!");
            deleteSuccess.showAndWait();
        }
    }

    @FXML
    void editWorker(MouseEvent event) {

        MechanicTransfer.mechanicTransfer = listOfWorkers.getSelectionModel().getSelectedItem();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("editWorker.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Szerelő szerkesztése");
            stage.setResizable(false);
            stage.sizeToScene();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(Stage.getWindows().stream().filter(Window::isShowing).findFirst().get());
            stage.show();
            stage.setOnCloseRequest(windowEvent -> MechanicTransfer.mechanicTransfer = null);
        } catch (IOException ex) {
            logger.error("A hiba forrása {}", ex.toString());
        }
    }

}
