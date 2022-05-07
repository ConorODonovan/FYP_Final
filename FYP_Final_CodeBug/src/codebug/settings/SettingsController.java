/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
SettingsController - Controls logic for Settings page
 */

package codebug.settings;

import codebug.database.DBUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import java.sql.SQLException;

public class SettingsController {

    // Declaration of variables
    // Variables annotated with @FXML are UI elements
    @FXML
    private ChoiceBox<String> settingsChoiceBox;
    @FXML
    private Button saveButton;

    // List of Themes to go into ChoiceBox
    private String[] themes = {"Default", "Nature", "Ocean", "Dusk", "Sunset", "Monochrome", "High Contrast"};

    // Initialize method runs on first opening the page
    @FXML
    private void initialize() {
        settingsChoiceBox.getItems().addAll(themes);
        settingsChoiceBox.setValue(DBUtils.getTheme());
        System.out.println("Settings page theme: " + settingsChoiceBox.getValue());
    }

    // Save theme selection and update database accordingly
    @FXML
    private void saveAndClose() throws SQLException {
        DBUtils.saveTheme(settingsChoiceBox.getValue());
        System.out.println("Theme updated to: " + DBUtils.getTheme());
        System.out.println("Theme updated to (DB): " + DBUtils.loadTheme());
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }
}