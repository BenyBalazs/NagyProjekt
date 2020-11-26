package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RepairController {

    @FXML
    private ComboBox<?> brand;

    @FXML
    private ComboBox<?> type;

    @FXML
    private TextField licencePlate;

    @FXML
    private DatePicker manufacturedDate;

    @FXML
    private TextArea description;

    @FXML
    private Spinner<?> price;

    @FXML
    private ComboBox<?> status;

    @FXML
    private ListView<?> listOfWorkers;

    @FXML
    private ComboBox<?> pickWorker;

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
