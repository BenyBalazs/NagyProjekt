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
import utility.MechanicTransfer;

import java.util.Optional;

public class EditWorkerController {

    private static Logger logger = LoggerFactory.getLogger("EditWorkerController.class");

    @FXML
    private TextField workerName;

    @FXML
    private TextField workerEmail;

    @FXML
    private TextField workerPhoneNumber;

    @FXML
    private DatePicker workerBirthDate;

    @FXML
    public void initialize(){

    }

    @FXML
    void save(MouseEvent event) {

    }

    @FXML
    void deleteOwner(MouseEvent event) {
        Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDelete.setTitle("Törlés megerősítése!");
        confirmDelete.setContentText("A törlés visszaállíthatatlanul eltávolítja az objektumot az adatbázisból és anomáliákhoz vezethet! Kérjük győződjön meg arról, hogy a szerelő már nincs benne az adatbázisban!");
        ButtonType confirm = new ButtonType("Törölje az adatbázisból!");
        ButtonType cancel = new ButtonType("Mégse");
        confirmDelete.getButtonTypes().setAll(confirm,cancel);

        Optional<ButtonType> result = confirmDelete.showAndWait();

        if(result.get() == confirm){
            logger.trace("A felhasználó törölni kívánta az entitást!");
            Repositories.mechanicRepository.deleteAndSetConnectionToNull(MechanicTransfer.mechanicTransfer);
            Alert deleteSuccess = new Alert(Alert.AlertType.INFORMATION);
            deleteSuccess.setTitle("Sikeres törlés!");
            deleteSuccess.setContentText("A szerelő sikeresen törölve lett az adatbázisból!");
            deleteSuccess.showAndWait();
        }
    }

}
