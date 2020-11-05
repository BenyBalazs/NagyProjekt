package controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MenuController {

    private static Logger logger = LoggerFactory.getLogger("MenuController.class");

    @FXML
    private BorderPane borderPane;

    @FXML
    void newRecord(MouseEvent event) {

    }

    @FXML
    void newWorker(MouseEvent event) {

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

}
