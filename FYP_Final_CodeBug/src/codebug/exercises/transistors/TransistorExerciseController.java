package codebug.exercises.transistors;

import codebug.exercises.exercisenodes.LogicGate;
import codebug.exercises.exercisenodes.Transistor;
import codebug.ui.Draggable;
import codebug.ui.TopMenuBar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class TransistorExerciseController {

    @FXML
    ImageView logo;

    @FXML
    Pane mainPane;
    @FXML
    BorderPane centerPane;

    @FXML
    public void initialize() {
        centerPane.setCenter(new RootLayout());
    }

    // Top Menu Bar functionality
    @FXML
    public void openAboutWindow() throws Exception {
        TopMenuBar.openAboutWindow();
    }

    // Return to main menu by clicking logo
    // TODO
    // Fix errors that occur when this method is called
    @FXML
    public void goToMainMenu() {
        logo.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/codebug/homepage/Homepage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            assert root != null;
            Scene scene = new Scene(root, 1920, 1080);
            stage.setScene(scene);
            stage.show();
        });
    }

    @FXML
    public void createTransistor() {
        Draggable draggable = new Draggable();
        Transistor transistor = new Transistor();
        draggable.makeDraggable(transistor);
        mainPane.getChildren().add(transistor);
    }

    @FXML
    public void createLogicGate() {
        Draggable draggable = new Draggable();
        LogicGate logicGate = new LogicGate();
        draggable.makeDraggable(logicGate);
        mainPane.getChildren().add(logicGate);
    }
}