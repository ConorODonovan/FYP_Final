package codebug.exercises;

import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ExercisesController {

    @FXML
    ImageView logo;

    @FXML
    Button buttonBackToLogin; // Temporary button for screen navigation
    @FXML
    Button buttonBackToHomepage; // Temporary button for screen navigation
    @FXML
    Button buttonTestTransistorExercise; // Temporary button to take me to transistor exercise test environment
    @FXML
    Button buttonBinaryConverter; // Temporary button to take me to binary converter exercise
    @FXML
    Button buttonCiphers; // Temporary button to take me to ciphers exercise
    @FXML
    Button functionsButtonSandbox;

    // Numbers buttons
    @FXML
    Button numbersButtonBeginner;
    @FXML
    Button numbersButtonIntermediate;
    @FXML
    Button numbersButtonAdvanced;

    // Ciphers buttons
    @FXML
    Button cipherButtonBeginner;
    @FXML
    Button cipherButtonIntermediate;
    @FXML
    Button cipherButtonAdvanced;

    // Transistors buttons
    @FXML
    Button transistorsButtonBeginner;
    @FXML
    Button transistorsButtonIntermediate;
    @FXML
    Button transistorsButtonAdvanced;

    // Functions buttons
    @FXML
    Button functionsButtonBeginner;
    @FXML
    Button functionsButtonIntermediate;
    @FXML
    Button functionsButtonAdvanced;

    // Escape Room buttons
    @FXML
    Button buttonEscapeRoom;

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
    public void backToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/login/Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void backToHomepage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/homepage/Homepage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToTestScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/transistors/TransistorExercise.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToBinaryConverter(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/numbers/BinaryConverter.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToCiphers(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/ciphers/Ciphers.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    // Numbers - go to exercises
    public void goToNumbersBeginner(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/numbers/beginner/NumberBeginner.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    public void goToNumbersIntermediate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/numbers/intermediate/NumberIntermediate.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    public void goToNumbersAdvanced(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/numbers/advanced/NumberAdvanced.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    // Ciphers - go to exercises
    public void goToCiphersBeginner(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/ciphers/beginner/CipherBeginner.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    public void goToCiphersIntermediate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/ciphers/intermediate/CipherIntermediate.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    public void goToCiphersAdvanced(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/ciphers/advanced/CipherAdvanced.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    // Transistors - go to exercises
    public void goToTransistorsBeginner(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/transistors/beginner/TransistorsBeginner.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    public void goToTransistorsIntermediate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/transistors/intermediate/TransistorsIntermediate.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    public void goToTransistorsAdvanced(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/transistors/advanced/TransistorsAdvanced.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    public void goToEscapeRoom(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/escaperoom/EscapeRoom.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }
}
