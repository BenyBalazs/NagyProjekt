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
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Repair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.CarTransfer;
import utility.OwnerTransfer;
import utility.RepairTransfer;

import java.io.IOException;
import java.util.Optional;

public class WorkflowController {

    private static Logger logger = LoggerFactory.getLogger("WorkerController.class");

    @FXML
    private ListView<Repair> listOfRepairs;

    @FXML
    public void initialize(){
        listOfRepairs.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listOfRepairs.setItems(FXCollections.observableList(CarTransfer.carTransfer.getRepairs()));
    }

    @FXML
    void deleteRepair(MouseEvent event) {
        Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDelete.setTitle("Törlés megerősítése!");
        confirmDelete.setContentText("A törlés visszaállíthatatlanul eltávolítja az objektumot az adatbázisból és anomáliákhoz vezethet! Kérjük győződjön meg arról, hogy nincs aktuális munkafolyamat!");
        ButtonType confirm = new ButtonType("Törölje az adatbázisból!");
        ButtonType cancel = new ButtonType("Mégse");
        confirmDelete.getButtonTypes().setAll(confirm,cancel);

        Optional<ButtonType> result = confirmDelete.showAndWait();

        if(result.get() == confirm){
            logger.trace("A felhasználó törölni kívánta az entitást!");
            Repositories.repairRepository.deleteAndSetConnectionToNull(listOfRepairs.getSelectionModel().getSelectedItem());
            Alert deleteSuccess = new Alert(Alert.AlertType.INFORMATION);
            deleteSuccess.setTitle("Sikeres törlés!");
            deleteSuccess.setContentText("A munkafolyamat sikeresen törölve lett az adatbázisból!");
            deleteSuccess.showAndWait();
        }
    }

    @FXML
    void editRepair(MouseEvent event) {
        RepairTransfer.repairTransfer = listOfRepairs.getSelectionModel().getSelectedItem();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("repair.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Munkafolyamat");
            stage.setResizable(false);
            stage.sizeToScene();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(Stage.getWindows().stream().filter(Window::isShowing).findFirst().get());
            stage.show();
            stage.setOnCloseRequest(windowEvent -> RepairTransfer.repairTransfer = null);
        } catch (IOException ex) {
            logger.error("A hiba forrása {}", ex.toString());
        }
    }

}
