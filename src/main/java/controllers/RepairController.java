package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import models.Mechanic;
import models.Repair;

public class RepairController {

    @FXML
    private ComboBox<String> brand;

    @FXML
    private ComboBox<String> type;

    @FXML
    private TextField licencePlate;

    @FXML
    private DatePicker manufacturedDate;

    @FXML
    private TextArea description;

    @FXML
    private Spinner<Integer> price;

    @FXML
    private ComboBox<Repair.RepairState> status;

    @FXML
    private ListView<Mechanic> listOfWorkers;

    @FXML
    private ComboBox<Mechanic> pickWorker;

    @FXML
    void addWorker(MouseEvent event) {

    }

    @FXML
    void removeWorker(MouseEvent event) {

    }

    @FXML
    void saveEditCar(MouseEvent event) {

    }

}
