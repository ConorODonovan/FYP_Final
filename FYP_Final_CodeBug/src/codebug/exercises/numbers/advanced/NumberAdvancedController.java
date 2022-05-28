/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
NumberAdvancedController - Controls logic for Number Advanced Exercise
 */

package codebug.exercises.numbers.advanced;

import animatefx.animation.Shake;
import codebug.database.DBUtils;
import codebug.exercises.numbers.NumberConversion;
import codebug.exercises.numbers.RandomNumberGenerator;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class NumberAdvancedController {

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
    Label numberToConvert1a;
    @FXML
    Label numberToConvert1b;
    @FXML
    Label numberToConvert2a;
    @FXML
    Label numberToConvert2b;
    @FXML
    Label numberToConvert3a;
    @FXML
    Label numberToConvert3b;
    @FXML
    Label numberToConvert4a;
    @FXML
    Label numberToConvert4b;
    @FXML
    Label numberToConvert5a;
    @FXML
    Label numberToConvert5b;
    @FXML
    TextField answer1;
    @FXML
    TextField answer2;
    @FXML
    TextField answer3;
    @FXML
    TextField answer4;
    @FXML
    TextField answer5;
    @FXML
    Button checkAnswer1;
    @FXML
    Button checkAnswer2;
    @FXML
    Button checkAnswer3;
    @FXML
    Button checkAnswer4;
    @FXML
    Button checkAnswer5;
    @FXML
    Label result1;
    @FXML
    Label result2;
    @FXML
    Label result3;
    @FXML
    Label result4;
    @FXML
    Label result5;
    @FXML
    Button buttonPreviousExercise;
    @FXML
    Button backToExerciseMenu;

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
        numberToConvert1a.setText(generateRandomHex());
        numberToConvert1b.setText(generateRandomOct());
        numberToConvert2a.setText(generateRandomBin());
        numberToConvert2b.setText(generateRandomHex());
        numberToConvert3a.setText(generateRandomBin());
        numberToConvert3b.setText(generateRandomBin());
        numberToConvert4a.setText(generateRandomBin());
        numberToConvert4b.setText(generateRandomHex());
        numberToConvert5a.setText(generateRandomHex());
        numberToConvert5b.setText(generateRandomHex());
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

    // Convert Binary Number to Hexadecimal number
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

    // Clear all fields
    @FXML
    public void clearTextFields() {
        binFieldConverter.clear();
        octFieldConverter.clear();
        decFieldConverter.clear();
        hexFieldConverter.clear();
    }

    // Adds a glow effect to buttons on mouse hover
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

    // Removes glow effect on buttons when mouse exits
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
        checkAnswer1.setEffect(borderGlow);
    }

    @FXML
    public void answer1NoGlow() {
        answer1.setEffect(null);
        checkAnswer1.setEffect(null);
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
        checkAnswer2.setEffect(borderGlow);
    }

    @FXML
    public void answer2NoGlow() {
        answer2.setEffect(null);
        checkAnswer2.setEffect(null);
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
        checkAnswer3.setEffect(borderGlow);
    }

    @FXML
    public void answer3NoGlow() {
        answer3.setEffect(null);
        checkAnswer3.setEffect(null);
    }

    @FXML
    public void answer4Glow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GREEN);
        borderGlow.setWidth(30);
        borderGlow.setHeight(30);
        answer4.setEffect(borderGlow);
        checkAnswer4.setEffect(borderGlow);
    }

    @FXML
    public void answer4NoGlow() {
        answer4.setEffect(null);
        checkAnswer4.setEffect(null);
    }

    @FXML
    public void answer5Glow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GREEN);
        borderGlow.setWidth(30);
        borderGlow.setHeight(30);
        answer5.setEffect(borderGlow);
        checkAnswer5.setEffect(borderGlow);
    }

    @FXML
    public void answer5NoGlow() {
        answer5.setEffect(null);
        checkAnswer5.setEffect(null);
    }

    @FXML
    public void buttonPreviousExerciseGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GREEN);
        borderGlow.setWidth(30);
        borderGlow.setHeight(30);
        buttonPreviousExercise.setEffect(borderGlow);
        buttonPreviousExercise.setEffect(borderGlow);
    }

    @FXML
    public void buttonPreviousExerciseNoGlow() {
        buttonPreviousExercise.setEffect(null);
        buttonPreviousExercise.setEffect(null);
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

    // Random number generation
    // Generate random Binary number
    @FXML
    private String generateRandomBin() {
        return RandomNumberGenerator.randomBinaryNumber(24, 255);
    }

    // Generate random Octal number
    @FXML
    private String generateRandomOct() {
        return RandomNumberGenerator.randomOctalNumber(32, 255);
    }

    // Generate random Decimal number
    @FXML
    private String generateRandomDec() {
        return RandomNumberGenerator.randomDecimalNumber(32, 255);
    }

    // Generate random Hexadecimal number
    @FXML
    private String generateRandomHex() {
        return RandomNumberGenerator.randomHexadecimalNumber(32, 255);
    }

    // Check if answers are correct
    @FXML
    public void checkAnswer1() {
        String num1String = NumberConversion.convertHexToDec(numberToConvert1a.getText());
        String num2String = NumberConversion.convertOctToDec(numberToConvert1b.getText());
        int num1 = Integer.parseInt(num1String);
        int num2 = Integer.parseInt(num2String);
        int numsAdded = num1 + num2;
        String numsAddedString = Integer.toString(numsAdded);

        if (numsAddedString.equals(answer1.getText())) {
            result1.setText("Correct!");
            result1.setTextFill(Color.FORESTGREEN);
        } else {
            result1.setText("Incorrect!");
            result1.setTextFill(Color.INDIANRED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!") && result4.getText().equals("Correct!") && result5.getText().equals("Correct!")) {
            DBUtils.updateNumbersAdvanced();
        }
    }

    @FXML
    public void checkAnswer2() {
        String num1String = NumberConversion.convertBinToDec(numberToConvert2a.getText());
        String num2String = NumberConversion.convertHexToDec(numberToConvert2b.getText());
        int num1 = Integer.parseInt(num1String);
        int num2 = Integer.parseInt(num2String);
        int numsAdded = num1 + num2;
        String numsAddedString = Integer.toString(numsAdded);

        if (numsAddedString.equals(answer2.getText())) {
            result2.setText("Correct!");
            result2.setTextFill(Color.FORESTGREEN);
        } else {
            result2.setText("Incorrect!");
            result2.setTextFill(Color.INDIANRED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!") && result4.getText().equals("Correct!") && result5.getText().equals("Correct!")) {
            DBUtils.updateNumbersAdvanced();
        }
    }

    @FXML
    public void checkAnswer3() {
        String num1String = NumberConversion.convertBinToDec(numberToConvert3a.getText());
        String num2String = NumberConversion.convertBinToDec(numberToConvert3b.getText());
        int num1 = Integer.parseInt(num1String);
        int num2 = Integer.parseInt(num2String);
        int numsAdded = num1 * num2;
        String numsAddedString = Integer.toString(numsAdded);

        if (numsAddedString.equals(answer3.getText())) {
            result3.setText("Correct!");
            result3.setTextFill(Color.FORESTGREEN);
        } else {
            result3.setText("Incorrect!");
            result3.setTextFill(Color.INDIANRED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!") && result4.getText().equals("Correct!") && result5.getText().equals("Correct!")) {
            DBUtils.updateNumbersAdvanced();
        }
    }

    @FXML
    public void checkAnswer4() {
        String num1String = NumberConversion.convertBinToDec(numberToConvert4a.getText());
        String num2String = NumberConversion.convertHexToDec(numberToConvert4b.getText());
        int num1 = Integer.parseInt(num1String);
        int num2 = Integer.parseInt(num2String);
        int numsAdded = num1 * num2;
        String numsAddedString = Integer.toString(numsAdded);

        if (numsAddedString.equals(answer4.getText())) {
            result4.setText("Correct!");
            result4.setTextFill(Color.FORESTGREEN);
        } else {
            result4.setText("Incorrect!");
            result4.setTextFill(Color.INDIANRED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!") && result4.getText().equals("Correct!") && result5.getText().equals("Correct!")) {
            DBUtils.updateNumbersAdvanced();
        }
    }

    @FXML
    public void checkAnswer5() {
        String num1String = NumberConversion.convertHexToDec(numberToConvert5a.getText());
        String num2String = NumberConversion.convertHexToDec(numberToConvert5b.getText());
        int num1 = Integer.parseInt(num1String);
        int num2 = Integer.parseInt(num2String);
        int numsAdded = num1 * num2;
        String numsAddedString = Integer.toString(numsAdded);

        if (numsAddedString.equals(answer5.getText())) {
            result5.setText("Correct!");
            result5.setTextFill(Color.FORESTGREEN);
        } else {
            result5.setText("Incorrect!");
            result5.setTextFill(Color.INDIANRED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!") && result4.getText().equals("Correct!") && result5.getText().equals("Correct!")) {
            DBUtils.updateNumbersAdvanced();
        }
    }

    // Return to main menu by clicking logo
    @FXML
    public void goToMainMenu() {
        NavigationManager.goToMainMenuNoButton(logoTop);
    }

    // Return to exercise menu
    @FXML
    public void backToExerciseMenu(ActionEvent e) throws IOException {
        NavigationManager.goToExercises(e);
    }

    // Go to previous exercise
    @FXML
    public void previousExercise(ActionEvent e) throws IOException {
        NavigationManager.goToNumbersIntermediate(e);
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