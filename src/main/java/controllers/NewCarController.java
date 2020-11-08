package controllers;

import database.Repositories;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import models.Car;
import models.CarModel;

public class NewCarController {

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
    void ownerAndCarSave(MouseEvent event) {
        Car car = new Car();
        car.setLicensePlate(licencePlate.getText());
        car.setManufacturedDate(manufacturedDate.getValue());
        CarModel model = Repositories.carModelRepository.getByBrandAndType(brand.getValue(),type.getValue());
        if(model == null) {
            model = new CarModel();
            model.setBrand(brand.getValue());
            model.setType(type.getValue());
            Repositories.carModelRepository.createNew(model);
        }
        car.setModel(model);

    }

}
