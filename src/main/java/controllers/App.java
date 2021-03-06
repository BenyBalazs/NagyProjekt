package controllers;

import database.EmfHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Műhelyi adminisztráció");
        stage.setMinWidth(700);
        stage.setMinHeight(500);
        stage.show();
        stage.setOnCloseRequest(windowEvent -> EmfHelper.closeEmf());
    }

}