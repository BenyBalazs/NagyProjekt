package controllers;

import database.Repositories;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Car;
import models.CarOwner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CarsAndOwnersController {

    private static Logger logger = LoggerFactory.getLogger("CarsAndOwnersController.class");

    @FXML
    private TextField searchField;

    @FXML
    private ListView<Car> listOfCars;

    @FXML
    private ListView<CarOwner> listOfOwners;

    @FXML
    public void initialize(){
        listOfOwners.setItems(FXCollections.observableList(Repositories.carOwnerRepository.findAll()));
        listOfOwners.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listOfOwners.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 2){
                        listOfCars.setItems(FXCollections.
                                observableList(Repositories.carRepository
                                        .findEveryCarWithSameOwner(listOfOwners.getSelectionModel().getSelectedItem())));
                    }
                }
            }
        });
    }

    @FXML
    void editOwner(MouseEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("editOwner.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Tulaj szerkesztése");
            stage.setResizable(false);
            stage.sizeToScene();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(Stage.getWindows().stream().filter(Window::isShowing).findFirst().get());
            stage.show();
        } catch (IOException ex) {
            logger.error("A hiba forrása {}", ex.toString());
        }
    }

    @FXML
    void editCarAndWork(MouseEvent event) {
        WizardController.createStage("workflow","Munkafolyamatok");
        WizardController.showStage();
    }

    @FXML
    void searchOwner(MouseEvent event) {
        Repositories.repairRepository.findAll();
    }



}
