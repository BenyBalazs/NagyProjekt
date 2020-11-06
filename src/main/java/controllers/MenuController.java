package controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MenuController {

    private static Logger logger = LoggerFactory.getLogger("MenuController.class");

    @FXML
    private BorderPane borderPane;

    @FXML
    void newRecord(MouseEvent event) {
        WizardController.createStage("newOwner","Tulaj adatai");
        WizardController.showStage();
    }

    @FXML
    void newWorker(MouseEvent event) {
        loadUiNewWindow("newWorker", "Új munkatárs adatai");
    }

    @FXML
    void ownerAndCar(MouseEvent event) {
        loadUi("carsAndOwners");
    }

    @FXML
    void worker(MouseEvent event) {
        loadUi("worker");
    }

    private void loadUi(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException ex) {
            logger.error("A hiba forrása {}", ex.toString());
        }
        borderPane.setCenter(root);
    }

    private void loadUiNewWindow(String ui, String title){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setResizable(false);
            stage.sizeToScene();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(Stage.getWindows().stream().filter(Window::isShowing).findFirst().get());
            stage.show();
        } catch (IOException ex) {
            logger.error("A hiba forrása {}", ex.toString());
        }
    }

}
