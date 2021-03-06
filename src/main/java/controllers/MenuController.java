package controllers;


import database.EmfHelper;
import database.Repositories;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuController {

    private static Logger logger = LoggerFactory.getLogger("MenuController.class");

    @FXML
    private Button carAndOwner;

    @FXML
    private Button mechanic;

    @FXML
    public void initialize(){
        new Thread(EmfHelper::openEmf).start();
    }

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
        carAndOwner.setStyle("-fx-background-color: rgba(0, 0, 0, 0.2);");
        mechanic.setStyle("-fx-background-color: transparent;");
    }

    @FXML
    void worker(MouseEvent event) {
        loadUi("worker");
        carAndOwner.setStyle("-fx-background-color: transparent;");
        mechanic.setStyle("-fx-background-color: rgba(0, 0, 0, 0.2);");
    }

    private void loadUi(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException ex) {
            logger.error("A hiba forrása {}", ex.toString());
        }
        borderPane.setCenter(root);
        logger.trace("Sikeres betöltés.");
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
