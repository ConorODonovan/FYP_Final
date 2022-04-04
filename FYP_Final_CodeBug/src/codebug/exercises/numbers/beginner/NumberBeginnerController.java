package codebug.exercises.numbers.beginner;

import animatefx.animation.*;
import codebug.exercises.numbers.NumberConversion;
import codebug.exercises.numbers.RandomNumberGenerator;
import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class NumberBeginnerController {

    @FXML
    ImageView logo;

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

    @FXML
    private void initialize() {

        // TextField border glow effect
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.GREEN); // TODO Change this colour to match the other green
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

                if (c == '0' || c == '1') {
                    // Add later
                } else {
//                    labelTestBinary.setText("Invalid character");
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

                if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7') {
                    // Add later
                } else {
//                    labelTestOctal.setText("Invalid character");
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

                if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                    // Add later
                } else {
//                    labelTestDecimal.setText("Invalid character");
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

                if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
                        || c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f') {
                    // Add later
                } else {
//                    labelTestHexadecimal.setText("Invalid character");
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

    private void convertBinToOct() {
        if (!binFieldConverter.getText().isEmpty()) {
            octFieldConverter.setText(NumberConversion.convertBinToOct(binFieldConverter.getText())); // Set textFieldOctal to octal value of binary input
        }
    }

    private void convertBinToDec() {
        if (!binFieldConverter.getText().isEmpty()) {
            decFieldConverter.setText(NumberConversion.convertBinToDec(binFieldConverter.getText())); // Set textFieldDecimal to decimal value of binary input
        }
    }

    private void convertBinToHex() {
        if (!binFieldConverter.getText().isEmpty()) {
            hexFieldConverter.setText(NumberConversion.convertBinToHex(binFieldConverter.getText())); // Set textFieldHexadecimal to hexadecimal value of binary input
        }
    }

    private void convertOctToBin() {
        if (!octFieldConverter.getText().isEmpty()) {
            binFieldConverter.setText(NumberConversion.convertOctToBin(octFieldConverter.getText())); // Set textFieldBinary to binary value of octal input
        }
    }

    private void convertDecToBin() {
        if (!decFieldConverter.getText().isEmpty()) {
            binFieldConverter.setText(NumberConversion.convertDecToBin(decFieldConverter.getText())); // Set textFieldBinary to binary value of decimal input
        }
    }

    private void convertHexToBin() {
        if (!hexFieldConverter.getText().isEmpty()) {
            binFieldConverter.setText(NumberConversion.convertHexToBin(hexFieldConverter.getText())); // Set textFieldBinary to binary value of hexadecimal input
        }
    }

    @FXML
    public void clearTextFields() {
        binFieldConverter.clear();
        octFieldConverter.clear();
        decFieldConverter.clear();
        hexFieldConverter.clear();
    }

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
    @FXML
    private String generateRandomBin() {
        return RandomNumberGenerator.randomBinaryNumber(1, 32);
    }

    @FXML
    private String generateRandomOct() {
        return RandomNumberGenerator.randomOctalNumber(1, 32);
    }

    @FXML
    private String generateRandomDec() {
        return RandomNumberGenerator.randomDecimalNumber(1, 32);
    }

    @FXML
    private String generateRandomHex() {
        return RandomNumberGenerator.randomHexadecimalNumber(1, 32);
    }

    @FXML
    public void checkAnswer1() {
        if (NumberConversion.convertBinToDec(answer1.getText()).equals(numToConvert1.getText())) {
            result1.setText("Correct!");
            result1.setTextFill(Color.FORESTGREEN);
        } else {
            result1.setText("Incorrect!");
            result1.setTextFill(Color.INDIANRED);
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
    }

    @FXML
    public void backToExerciseMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/Exercises.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void nextExercise(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/numbers/intermediate/NumberIntermediate.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }
}