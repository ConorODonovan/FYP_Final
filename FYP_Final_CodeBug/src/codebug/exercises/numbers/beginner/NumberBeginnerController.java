/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
NumberBeginnerController - Controls logic for Number Beginner Exercise
 */

package codebug.exercises.numbers.beginner;

import animatefx.animation.*;
import codebug.database.DBUtils;
import codebug.exercises.numbers.NumberConversion;
import codebug.exercises.numbers.RandomNumberGenerator;
import codebug.ui.NavigationManager;
import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.io.IOException;

public class NumberBeginnerController {

    // Declaration of variables
    // Variables annotated with @FXML are UI elements
    @FXML
    Label usernameLabel;
    @FXML
    ImageView logoTop;
    @FXML
    TextField binFieldConverter;
    @FXML
    TextField octFieldConverter;
    @FXML
    TextField decFieldConverter;
    @FXML
    TextField hexFieldConverter;
    @FXML
    Button buttonClear;
    @FXML
    Label numToConvert1;
    @FXML
    Label numToConvert2;
    @FXML
    Label numToConvert3;
    @FXML
    TextField answer1;
    @FXML
    TextField answer2;
    @FXML
    TextField answer3;
    @FXML
    Button submitAnswer1;
    @FXML
    Button submitAnswer2;
    @FXML
    Button submitAnswer3;
    @FXML
    Label result1;
    @FXML
    Label result2;
    @FXML
    Label result3;
    @FXML
    Button backToExerciseMenu;
    @FXML
    Button nextExercise;

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

        // TextField border glow effect
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GREEN);
        borderGlow.setWidth(30);
        borderGlow.setHeight(30);

        binFieldConverter.setEffect(borderGlow);
        octFieldConverter.setEffect(borderGlow);
        decFieldConverter.setEffect(borderGlow);
        hexFieldConverter.setEffect(borderGlow);

        // Input validation for Binary TextField
        binFieldConverter.textProperty().addListener(e -> {
            for (int i = 0; i < binFieldConverter.getText().length(); i++) {
                char c = binFieldConverter.getText().charAt(i);

                // Causes field to shake if invalid character entered
                if (!(c == '0' || c == '1')) {
                    binFieldConverter.setText("" + binFieldConverter.getText().substring(0, binFieldConverter.getText().length() - 1));

                    Shake shake = new Shake(binFieldConverter);
                    shake.play();
                }
            }

            if (!octFieldConverter.isFocused()) {
                convertBinToOct(); // Automatically updates textFieldOctal with converted binary input
            }

            if(!decFieldConverter.isFocused()){
                convertBinToDec(); // Automatically updates textFieldDecimal with converted binary input
            }

            if (!hexFieldConverter.isFocused()) {
                convertBinToHex(); // Automatically update textFieldHexadecimal with converted binary input
            }

            if (binFieldConverter.isFocused()) {
                if (binFieldConverter.getText().isEmpty()) {
                    octFieldConverter.clear();
                    decFieldConverter.clear();
                    hexFieldConverter.clear();
                }
            }
        });

        // Input validation for Octal TextField
        octFieldConverter.textProperty().addListener(e -> {
            for (int i = 0; i < octFieldConverter.getText().length(); i++) {
                char c = octFieldConverter.getText().charAt(i);

                // Causes field to shake if invalid character entered
                if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7')) {
                    octFieldConverter.setText("" + octFieldConverter.getText().substring(0, octFieldConverter.getText().length() - 1));
                    Shake shake = new Shake(octFieldConverter);
                    shake.play();
                }
            }

            if (!binFieldConverter.isFocused()) {
                if (octFieldConverter.isFocused()) {
                    convertOctToBin(); // Automatically updates textFieldBinary with converted octal input
                }
            }

            if (octFieldConverter.isFocused()) {
                if (octFieldConverter.getText().isEmpty()) {
                    binFieldConverter.clear();
                    decFieldConverter.clear();
                    hexFieldConverter.clear();
                }
            }
        });

        // Input validation for Decimal TextField
        decFieldConverter.textProperty().addListener(e -> {
            for (int i = 0; i < decFieldConverter.getText().length(); i++) {
                char c = decFieldConverter.getText().charAt(i);

                // Causes field to shake if invalid character entered
                if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')) {
                    decFieldConverter.setText("" + decFieldConverter.getText().substring(0, decFieldConverter.getText().length() - 1));
                    Shake shake = new Shake(decFieldConverter);
                    shake.play();
                }
            }

            if (!binFieldConverter.isFocused()) {
                if (decFieldConverter.isFocused()) {
                    convertDecToBin(); // Automatically updates textFieldBinary with converted decimal input
                }
            }

            if (decFieldConverter.isFocused()) {
                if (decFieldConverter.getText().isEmpty()) {
                    binFieldConverter.clear();
                    octFieldConverter.clear();
                    hexFieldConverter.clear();
                }
            }
        });

        // Converts lowercase characters in Hexadecimal TextField to uppercase automatically as the user types
        hexFieldConverter.textProperty().addListener((ov, oldValue, newValue) -> hexFieldConverter.setText(newValue.toUpperCase()));

        // Input validation for Hexadecimal TextField
        hexFieldConverter.textProperty().addListener(e -> {
            for (int i = 0; i < hexFieldConverter.getText().length(); i++) {
                char c = hexFieldConverter.getText().charAt(i);

                // Causes field to shake if invalid character entered
                if (!(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
                        || c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f')) {
                    hexFieldConverter.setText("" + hexFieldConverter.getText().substring(0, hexFieldConverter.getText().length() - 1));
                    Shake shake = new Shake(hexFieldConverter);
                    shake.play();
                }
            }

            if (!binFieldConverter.isFocused()) {
                if (hexFieldConverter.isFocused()) {
                    convertHexToBin(); // Automatically updates textFieldBinary with converted hexadecimal input
                }
            }

            if (hexFieldConverter.isFocused()) {
                if (hexFieldConverter.getText().isEmpty()) {
                    binFieldConverter.clear();
                    octFieldConverter.clear();
                    decFieldConverter.clear();
                }
            }
        });

        // Generating random numbers to convert
        numToConvert1.setText(generateRandomDec());
        numToConvert2.setText(generateRandomBin());
        numToConvert3.setText(generateRandomBin());
    }

    // Top Menu Bar functionality
    @FXML
    public void openAboutWindow() throws Exception {
        TopMenuBar.openAboutWindow();
    }

    // Convert Binary number to Octal number
    private void convertBinToOct() {
        if (!binFieldConverter.getText().isEmpty()) {
            octFieldConverter.setText(NumberConversion.convertBinToOct(binFieldConverter.getText())); // Set textFieldOctal to octal value of binary input
        }
    }

    // Convert Binary number to Decimal number
    private void convertBinToDec() {
        if (!binFieldConverter.getText().isEmpty()) {
            decFieldConverter.setText(NumberConversion.convertBinToDec(binFieldConverter.getText())); // Set textFieldDecimal to decimal value of binary input
        }
    }

    // Convert Binary number to Hexadecimal number
    private void convertBinToHex() {
        if (!binFieldConverter.getText().isEmpty()) {
            hexFieldConverter.setText(NumberConversion.convertBinToHex(binFieldConverter.getText())); // Set textFieldHexadecimal to hexadecimal value of binary input
        }
    }

    // Convert Octal number to Binary number
    private void convertOctToBin() {
        if (!octFieldConverter.getText().isEmpty()) {
            binFieldConverter.setText(NumberConversion.convertOctToBin(octFieldConverter.getText())); // Set textFieldBinary to binary value of octal input
        }
    }

    // Convert Decimal number to Binary number
    private void convertDecToBin() {
        if (!decFieldConverter.getText().isEmpty()) {
            binFieldConverter.setText(NumberConversion.convertDecToBin(decFieldConverter.getText())); // Set textFieldBinary to binary value of decimal input
        }
    }

    // Convert Hexadecimal number to Binary number
    private void convertHexToBin() {
        if (!hexFieldConverter.getText().isEmpty()) {
            binFieldConverter.setText(NumberConversion.convertHexToBin(hexFieldConverter.getText())); // Set textFieldBinary to binary value of hexadecimal input
        }
    }

    // Clear fields
    @FXML
    public void clearTextFields() {
        binFieldConverter.clear();
        octFieldConverter.clear();
        decFieldConverter.clear();
        hexFieldConverter.clear();
    }

    // Add glow effect to buttons on hover
    @FXML
    public void buttonGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GREEN);
        borderGlow.setWidth(30);
        borderGlow.setHeight(30);
        buttonClear.setEffect(borderGlow);
    }

    // Remove glow effect from buttons on mouse exit
    @FXML
    public void buttonNoGlow() {
        buttonClear.setEffect(null);
    }

    @FXML
    public void answer1Glow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GREEN);
        borderGlow.setWidth(30);
        borderGlow.setHeight(30);
        answer1.setEffect(borderGlow);
        submitAnswer1.setEffect(borderGlow);
    }

    @FXML
    public void answer1NoGlow() {
        answer1.setEffect(null);
        submitAnswer1.setEffect(null);
    }

    @FXML
    public void answer2Glow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GREEN);
        borderGlow.setWidth(30);
        borderGlow.setHeight(30);
        answer2.setEffect(borderGlow);
        submitAnswer2.setEffect(borderGlow);
    }

    @FXML
    public void answer2NoGlow() {
        answer2.setEffect(null);
        submitAnswer2.setEffect(null);
    }

    @FXML
    public void answer3Glow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GREEN);
        borderGlow.setWidth(30);
        borderGlow.setHeight(30);
        answer3.setEffect(borderGlow);
        submitAnswer3.setEffect(borderGlow);
    }

    @FXML
    public void answer3NoGlow() {
        answer3.setEffect(null);
        submitAnswer3.setEffect(null);
    }

    @FXML
    public void buttonExerciseMenuGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GREEN);
        borderGlow.setWidth(30);
        borderGlow.setHeight(30);
        backToExerciseMenu.setEffect(borderGlow);
    }

    @FXML
    public void buttonExerciseMenuNoGlow() {
        backToExerciseMenu.setEffect(null);
    }

    @FXML
    public void buttonNextExerciseGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GREEN);
        borderGlow.setWidth(30);
        borderGlow.setHeight(30);
        nextExercise.setEffect(borderGlow);
        nextExercise.setEffect(borderGlow);
    }

    @FXML
    public void buttonNextExerciseNoGlow() {
        nextExercise.setEffect(null);
        nextExercise.setEffect(null);
    }

    // Random number generation
    // Generate random Binary number
    @FXML
    private String generateRandomBin() {
        return RandomNumberGenerator.randomBinaryNumber(1, 32);
    }

    // Generate random Octal number
    @FXML
    private String generateRandomOct() {
        return RandomNumberGenerator.randomOctalNumber(1, 32);
    }

    // Generate random Decimal number
    @FXML
    private String generateRandomDec() {
        return RandomNumberGenerator.randomDecimalNumber(1, 32);
    }

    // Generate random Hexadecimal number
    @FXML
    private String generateRandomHex() {
        return RandomNumberGenerator.randomHexadecimalNumber(1, 32);
    }

    // Check if answers are correct
    @FXML
    public void checkAnswer1() {
        if (NumberConversion.convertBinToDec(answer1.getText()).equals(numToConvert1.getText())) {
            result1.setText("Correct!");
            result1.setTextFill(Color.FORESTGREEN);
        } else {
            result1.setText("Incorrect!");
            result1.setTextFill(Color.INDIANRED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!")) {
            DBUtils.updateNumbersBeginner();
        }
    }

    @FXML
    public void checkAnswer2() {
        if (NumberConversion.convertDecToBin(answer2.getText()).equals(numToConvert2.getText())) {
            result2.setText("Correct!");
            result2.setTextFill(Color.FORESTGREEN);
        } else {
            result2.setText("Incorrect!");
            result2.setTextFill(Color.INDIANRED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!")) {
            DBUtils.updateNumbersBeginner();
        }
    }

    @FXML
    public void checkAnswer3() {
        if (NumberConversion.convertHexToBin(answer3.getText()).equals(numToConvert3.getText())) {
            result3.setText("Correct!");
            result3.setTextFill(Color.FORESTGREEN);
        } else {
            result3.setText("Incorrect!");
            result3.setTextFill(Color.INDIANRED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!")) {
            DBUtils.updateNumbersBeginner();
        }
    }

    // Return to main menu
    @FXML
    public void goToMainMenu() {
        NavigationManager.goToMainMenuNoButton(logoTop);
    }

    // Return to exercise menu
    @FXML
    public void backToExerciseMenu(ActionEvent e) throws IOException {
        NavigationManager.goToExercises(e);
    }

    // Go to next exercise
    @FXML
    public void nextExercise(ActionEvent e) throws IOException {
        NavigationManager.goToNumbersIntermediate(e);
    }
}