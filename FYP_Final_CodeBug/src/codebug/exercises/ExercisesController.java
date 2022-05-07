/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
ExercisesController - Controls logic for Exercises Menu
 */

package codebug.exercises;

import codebug.database.DBUtils;
import codebug.ui.NavigationManager;
import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.sql.SQLException;

public class ExercisesController {

    // Declaration of variables
    // Variables annotated with @FXML are UI elements
    @FXML
    Label usernameLabel;
    @FXML
    ImageView logoTop;

    // Numbers buttons
    @FXML
    Button numbersButtonBeginner;
    @FXML
    Button numbersButtonIntermediate;
    @FXML
    Button numbersButtonAdvanced;
    @FXML
    Button buttonBinaryConverter;

    // Ciphers buttons
    @FXML
    Button cipherButtonBeginner;
    @FXML
    Button cipherButtonIntermediate;
    @FXML
    Button cipherButtonAdvanced;
    @FXML
    Button buttonCiphers;

    // Transistors buttons
    @FXML
    Button transistorsButtonBeginner;
    @FXML
    Button transistorsButtonIntermediate;
    @FXML
    Button transistorsButtonAdvanced;

    // Escape Room buttons
    @FXML
    Button buttonEscapeRoom;

    // Exercise Progress label
    @FXML
    Label exercise1ProgressLabel;
    @FXML
    Label exercise2ProgressLabel;
    @FXML
    Label exercise3ProgressLabel;
    @FXML
    Label exercise4ProgressLabel;
    @FXML
    Label exercise5ProgressLabel;
    @FXML
    Label exercise6ProgressLabel;
    @FXML
    Label exercise7ProgressLabel;
    @FXML
    Label exercise8ProgressLabel;
    @FXML
    Label exercise9ProgressLabel;
    @FXML
    Label exercise10ProgressLabel;

    // Initialize method runs on first opening the page
    @FXML
    private void initialize() throws SQLException {

        // Get user currently logged in
        String currentUser = DBUtils.getCurrentUser();

        // Sets label in top right to username
        if (currentUser == null) {
            usernameLabel.setText("Please log in");
        } else {
            usernameLabel.setText("Logged in as " + currentUser);
        }

        // Checks which theme the user last selected and ensures it is applied
        switch (DBUtils.getTheme()) {
            case "Default": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(236, 151, 6);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "Nature": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(82, 183, 136);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "Ocean": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(122, 191, 201);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "Dusk": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(246, 156, 153);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "Sunset": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(255, 111, 75);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "Monochrome": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(148, 148, 148);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "High Contrast": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(255, 180, 0);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
        }

        // Load user exercise progress
        String exercise1Progress = DBUtils.loadExercise1Progress();
        String exercise2Progress = DBUtils.loadExercise2Progress();
        String exercise3Progress = DBUtils.loadExercise3Progress();
        String exercise4Progress = DBUtils.loadExercise4Progress();
        String exercise5Progress = DBUtils.loadExercise5Progress();
        String exercise6Progress = DBUtils.loadExercise6Progress();
        String exercise7Progress = DBUtils.loadExercise7Progress();
        String exercise8Progress = DBUtils.loadExercise8Progress();
        String exercise9Progress = DBUtils.loadExercise9Progress();
        String exercise10Progress = DBUtils.loadExercise10Progress();

        // Sets labels to red by default if not completed
        exercise1ProgressLabel.setTextFill(Color.INDIANRED);
        exercise2ProgressLabel.setTextFill(Color.INDIANRED);
        exercise3ProgressLabel.setTextFill(Color.INDIANRED);
        exercise4ProgressLabel.setTextFill(Color.INDIANRED);
        exercise5ProgressLabel.setTextFill(Color.INDIANRED);
        exercise6ProgressLabel.setTextFill(Color.INDIANRED);
        exercise7ProgressLabel.setTextFill(Color.INDIANRED);
        exercise8ProgressLabel.setTextFill(Color.INDIANRED);
        exercise9ProgressLabel.setTextFill(Color.INDIANRED);
        exercise10ProgressLabel.setTextFill(Color.INDIANRED);


        // Update exercise progress labels appropriately
        if (exercise1Progress.equals("1")) {
            exercise1ProgressLabel.setText("Completed!");
            exercise1ProgressLabel.setTextFill(Color.FORESTGREEN);
        }

        if (exercise2Progress.equals("1")) {
            exercise2ProgressLabel.setText("Completed!");
            exercise2ProgressLabel.setTextFill(Color.FORESTGREEN);
        }

        if (exercise3Progress.equals("1")) {
            exercise3ProgressLabel.setText("Completed!");
            exercise3ProgressLabel.setTextFill(Color.FORESTGREEN);
        }

        if (exercise4Progress.equals("1")) {
            exercise4ProgressLabel.setText("Completed!");
            exercise4ProgressLabel.setTextFill(Color.FORESTGREEN);
        }

        if (exercise5Progress.equals("1")) {
            exercise5ProgressLabel.setText("Completed!");
            exercise5ProgressLabel.setTextFill(Color.FORESTGREEN);
        }

        if (exercise6Progress.equals("1")) {
            exercise6ProgressLabel.setText("Completed!");
            exercise6ProgressLabel.setTextFill(Color.FORESTGREEN);
        }

        if (exercise7Progress.equals("1")) {
            exercise7ProgressLabel.setText("Completed!");
            exercise7ProgressLabel.setTextFill(Color.FORESTGREEN);
        }

        if (exercise8Progress.equals("1")) {
            exercise8ProgressLabel.setText("Completed!");
            exercise8ProgressLabel.setTextFill(Color.FORESTGREEN);
        }

        if (exercise9Progress.equals("1")) {
            exercise9ProgressLabel.setText("Completed!");
            exercise9ProgressLabel.setTextFill(Color.FORESTGREEN);
        }

        if (exercise10Progress.equals("1")) {
            exercise10ProgressLabel.setText("Completed!");
            exercise10ProgressLabel.setTextFill(Color.FORESTGREEN);
        }
    }

    // Top Menu Bar functionality
    @FXML
    public void openAboutWindow() throws Exception {
        TopMenuBar.openAboutWindow();
    }

    // Return to main menu by clicking CodeBug logo
    @FXML
    public void goToMainMenu() {
        NavigationManager.goToMainMenuNoButton(logoTop);
    }

    // Numbers - go to exercises
    @FXML
    public void goToNumbersBeginner(ActionEvent e) throws IOException {
        NavigationManager.goToNumbersBeginner(e);
    }

    @FXML
    public void goToNumbersIntermediate(ActionEvent e) throws IOException {
        NavigationManager.goToNumbersIntermediate(e);
    }

    @FXML
    public void goToNumbersAdvanced(ActionEvent e) throws IOException {
        NavigationManager.goToNumbersAdvanced(e);
    }

    @FXML
    public void goToNumbersSandbox(ActionEvent e) throws IOException {
        NavigationManager.goToNumbersSandbox(e);
    }

    // Ciphers - go to exercises
    public void goToCiphersBeginner(ActionEvent e) throws IOException {
        NavigationManager.goToCiphersBeginner(e);
    }

    public void goToCiphersIntermediate(ActionEvent e) throws IOException {
        NavigationManager.goToCiphersIntermediate(e);
    }

    public void goToCiphersAdvanced(ActionEvent e) throws IOException {
        NavigationManager.goToCiphersAdvanced(e);
    }

    @FXML
    public void goToCiphers(ActionEvent e) throws IOException {
        NavigationManager.goToCiphersSandbox(e);
    }

    // Transistors - go to exercises
    @FXML
    public void goToTransistorsBeginner(ActionEvent e) throws IOException {
        NavigationManager.goToTransistorsBeginner(e);
    }

    @FXML
    public void goToTransistorsIntermediate(ActionEvent e) throws IOException {
        NavigationManager.goToTransistorsIntermediate(e);
    }

    @FXML
    public void goToTransistorsAdvanced(ActionEvent e) throws IOException {
        NavigationManager.goToTransistorsAdvanced(e);
    }

    // Go to Escape Room game
    @FXML
    public void goToEscapeRoom(ActionEvent e) throws IOException {
        NavigationManager.goToEscapeRoom(e);
    }
}