package controllers;

import java.io.IOException;
import javafx.fxml.FXML;

public class NewOwnerController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}