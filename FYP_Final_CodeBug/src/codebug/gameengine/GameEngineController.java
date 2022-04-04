package codebug.gameengine;

import codebug.ui.TopMenuBar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class GameEngineController {

    @FXML
    ImageView logo;

    // Create objects
    @FXML
    Button createPlayerButton;
    @FXML
    Button createWallButton;

    // General properties
    @FXML
    ColorPicker colorPicker;
    @FXML
    Slider widthSlider;
    @FXML
    Slider heightSlider;
    @FXML
    Slider gravitySlider;

    // Movement properties
    @FXML
    Slider speedSlider;
    @FXML
    ChoiceBox<String> leftInputChoiceBox;
    @FXML
    ChoiceBox<String> rightInputChoiceBox;
    @FXML
    ChoiceBox<String> upInputChoiceBox;
    @FXML
    ChoiceBox<String> downInputChoiceBox;
    @FXML
    ChoiceBox<String> jumpInputChoiceBox;
    @FXML
    Slider jumpHeightSlider;

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
}
