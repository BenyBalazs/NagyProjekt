package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WizardController {

    private static Logger logger = LoggerFactory.getLogger("WizardController.class");

    private static BorderPane root = new BorderPane();

    private static Stage stage = new Stage();

    public static void createStage(String ui, String title){
        try {
            root.setCenter(FXMLLoader.load(WizardController.class.getResource(ui + ".fxml")));
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.setResizable(false);
            stage.sizeToScene();
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(Stage.getWindows().stream().filter(Window::isShowing).findFirst().get());
            stage.setOnCloseRequest(windowEvent -> stage = new Stage());
        } catch (IOException ex) {
            logger.error("A hiba forrása {}", ex.toString());
        }
    }

    public static void changeScene(String ui, String title){
        try {
            root.setCenter(FXMLLoader.load(WizardController.class.getResource(ui + ".fxml")));
            stage.setTitle(title);
        } catch (IOException ex) {
            logger.error("A hiba forrása {}", ex.toString());
        }
    }

    public static void showStage() {
        try{
            stage.showAndWait();
        } catch (Exception ex){
            logger.error("A hiba forrása {}", ex.toString());
        }
    }




}
