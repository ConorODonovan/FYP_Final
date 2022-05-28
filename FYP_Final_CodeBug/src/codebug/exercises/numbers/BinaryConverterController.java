/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
BinaryConverterController - Controls logic for Number Conversion Sandbox
 */

package codebug.exercises.numbers;

import animatefx.animation.Shake;
import codebug.database.DBUtils;
import codebug.ui.NavigationManager;
import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class BinaryConverterController {

    // Declaration of variables
    // Variables annotated with @FXML are UI elements
    @FXML
    Label usernameLabel;
    @FXML
    ImageView logoTop;
    @FXML
    TextField textFieldBinary;
    @FXML
    Label labelTestBinary;
    @FXML
    TextField textFieldOctal;
    @FXML
    Label labelTestOctal;
    @FXML
    TextField textFieldDecimal;
    @FXML
    Label labelTestDecimal;
    @FXML
    TextField textFieldHexadecimal;
    @FXML
    Label labelTestHexadecimal;
    @FXML
    Button buttonClear;
    @FXML
    Button buttonBackToExerciseMenu;

    @FXML
    MenuItem menuPreferences;
    @FXML
    MenuItem menuLogout;
    @FXML
    MenuItem menuExit;
    @FXML
    MenuItem menuAbout;

    // Initialize method runs on first opening the page
    @FXML
    private void initialize() {

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

        // Input validation for Binary TextField
        textFieldBinary.textProperty().addListener(e -> {
            for (int i = 0; i < textFieldBinary.getText().length(); i++) {
                char c = textFieldBinary.getText().charAt(i);

                // Causes field to shake if invalid character entered
                if (!(c == '0' || c == '1')) {
                    textFieldBinary.setText("" + textFieldBinary.getText().substring(0, textFieldBinary.getText().length() - 1));
                    Shake shake = new Shake(textFieldBinary);
                    shake.play();
                }
            }

            if (!textFieldOctal.isFocused()) {
                convertBinToOct(); // Automatically updates textFieldOctal with converted binary input
            }

            if(!textFieldDecimal.isFocused()){
                convertBinToDec(); // Automatically updates textFieldDecimal with converted binary input
            }

            if (!textFieldHexadecimal.isFocused()) {
                convertBinToHex(); // Automatically update textFieldHexadecimal with converted binary input
            }

            if (textFieldBinary.isFocused()) {
                if (textFieldBinary.getText().isEmpty()) {
                    textFieldOctal.clear();
                    textFieldDecimal.clear();
                    textFieldHexadecimal.clear();
                }
            }
        });

        // Input validation for Octal TextField
        textFieldOctal.textProperty().addListener(e -> {
            for (int i = 0; i < textFieldOctal.getText().length(); i++) {
                char c = textFieldOctal.getText().charAt(i);

                // Causes field to shake if invalid character entered
                if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7')) {
                    textFieldOctal.setText("" + textFieldOctal.getText().substring(0, textFieldOctal.getText().length() - 1));
                    Shake shake = new Shake(textFieldOctal);
                    shake.play();
                }
            }

            if (!textFieldBinary.isFocused()) {
                if (textFieldOctal.isFocused()) {
                    convertOctToBin(); // Automatically updates textFieldBinary with converted octal input
                }
            }

            if (textFieldOctal.isFocused()) {
                if (textFieldOctal.getText().isEmpty()) {
                    textFieldBinary.clear();
                    textFieldDecimal.clear();
                    textFieldHexadecimal.clear();
                }
            }
        });

        // Input validation for Decimal TextField
        textFieldDecimal.textProperty().addListener(e -> {
            for (int i = 0; i < textFieldDecimal.getText().length(); i++) {
                char c = textFieldDecimal.getText().charAt(i);

                // Causes field to shake if invalid character entered
                if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
                    textFieldDecimal.setText("" + textFieldDecimal.getText().substring(0, textFieldDecimal.getText().length() - 1));
                    Shake shake = new Shake(textFieldDecimal);
                    shake.play();
                }
            }

            if (!textFieldBinary.isFocused()) {
                if (textFieldDecimal.isFocused()) {
                    convertDecToBin(); // Automatically updates textFieldBinary with converted decimal input
                }
            }

            if (textFieldDecimal.isFocused()) {
                if (textFieldDecimal.getText().isEmpty()) {
                    textFieldBinary.clear();
                    textFieldOctal.clear();
                    textFieldHexadecimal.clear();
                }
            }
        });

        // Converts lowercase characters in Hexadecimal TextField to uppercase automatically as the user types
        textFieldHexadecimal.textProperty().addListener((ov, oldValue, newValue) -> textFieldHexadecimal.setText(newValue.toUpperCase()));

        // Input validation for Hexadecimal TextField
        textFieldHexadecimal.textProperty().addListener(e -> {
            for (int i = 0; i < textFieldHexadecimal.getText().length(); i++) {
                char c = textFieldHexadecimal.getText().charAt(i);

                // Causes field to shake if invalid character entered
                if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
                        || c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f')) {
                    textFieldHexadecimal.setText("" + textFieldHexadecimal.getText().substring(0, textFieldHexadecimal.getText().length() - 1));
                    Shake shake = new Shake(textFieldHexadecimal);
                    shake.play();
                }
            }

            if (!textFieldBinary.isFocused()) {
                if (textFieldHexadecimal.isFocused()) {
                    convertHexToBin(); // Automatically updates textFieldBinary with converted hexadecimal input
                }
            }

            if (textFieldHexadecimal.isFocused()) {
                if (textFieldHexadecimal.getText().isEmpty()) {
                    textFieldBinary.clear();
                    textFieldOctal.clear();
                    textFieldDecimal.clear();
                }
            }
        });
    }

    // Convert Binary number to Octal number
    private void convertBinToOct() {
        if (!textFieldBinary.getText().isEmpty()) {
            textFieldOctal.setText(NumberConversion.convertBinToOct(textFieldBinary.getText())); // Set textFieldOctal to octal value of binary input
        }
    }

    // Convert Binary number to Decimal number
    private void convertBinToDec() {
        if (!textFieldBinary.getText().isEmpty()) {
            textFieldDecimal.setText(NumberConversion.convertBinToDec(textFieldBinary.getText())); // Set textFieldDecimal to decimal value of binary input
        }
    }

    // Convert Binary number to Hexadecimal number
    private void convertBinToHex() {
        if (!textFieldBinary.getText().isEmpty()) {
            textFieldHexadecimal.setText(NumberConversion.convertBinToHex(textFieldBinary.getText())); // Set textFieldHexadecimal to hexadecimal value of binary input
        }
    }

    // Convert Octal number to Binary number
    private void convertOctToBin() {
        if (!textFieldOctal.getText().isEmpty()) {
            textFieldBinary.setText(NumberConversion.convertOctToBin(textFieldOctal.getText())); // Set textFieldBinary to binary value of octal input
        }
    }

    // Convert Decimal number to Binary number
    private void convertDecToBin() {
        if (!textFieldDecimal.getText().isEmpty()) {
            textFieldBinary.setText(NumberConversion.convertDecToBin(textFieldDecimal.getText())); // Set textFieldBinary to binary value of decimal input
        }
    }

    // Convert Hexadecimal number to Binary number
    private void convertHexToBin() {
        if (!textFieldHexadecimal.getText().isEmpty()) {
            textFieldBinary.setText(NumberConversion.convertHexToBin(textFieldHexadecimal.getText())); // Set textFieldBinary to binary value of hexadecimal input
        }
    }

    // Clear fields
    @FXML
    public void clearTextFields() {
        textFieldBinary.clear();
        textFieldOctal.clear();
        textFieldDecimal.clear();
        textFieldHexadecimal.clear();
    }

    // Return to main menu by clicking logo
    @FXML
    public void goToMainMenu() {
        NavigationManager.goToMainMenuNoButton(logoTop);
    }

    // Go to exercise menu
    @FXML
    public void backToExerciseMenu(ActionEvent e) throws IOException {
        NavigationManager.goToExercises(e);
    }

    // Top Menu Bar functionality
    // Open Settings Screen
    @FXML
    public void openSettingsWindow() throws Exception {
        TopMenuBar.openSettingsWindow();
    }

    // Open About screen
    @FXML
    public void openAboutWindow() throws Exception {
        TopMenuBar.openAboutWindow();
    }

    // Logout
    @FXML
    public void logout() throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/login/Login.fxml"));
        Stage stage = (Stage) logoTop.getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        DBUtils.setCurrentUser(null);
        stage.setScene(scene);
        stage.show();
    }

    // Exit application
    @FXML
    public void exitApplication() {
        TopMenuBar.exitApplication();
    }
}