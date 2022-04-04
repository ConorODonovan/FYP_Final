package codebug.exercises.numbers;

import animatefx.animation.Shake;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class BinaryConverterController {

    // TODO
    // Limit each field's character length to prevent overflow
    // Display specific input error text

    @FXML
    ImageView logo;

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
    private void initialize() {
        // Input validation for Binary TextField
        textFieldBinary.textProperty().addListener(e -> {
            for (int i = 0; i < textFieldBinary.getText().length(); i++) {
                char c = textFieldBinary.getText().charAt(i);

                if (c == '0' || c == '1') {
                    labelTestBinary.setText("");
                } else {
//                    labelTestBinary.setText("Invalid character");
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

                if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7') {
                    labelTestOctal.setText("");
                } else {
//                    labelTestOctal.setText("Invalid character");
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

                if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                    labelTestDecimal.setText("");
                } else {
//                    labelTestDecimal.setText("Invalid character");
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

                if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
                        || c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f') {
                    labelTestHexadecimal.setText("");
                } else {
//                    labelTestHexadecimal.setText("Invalid character");
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

    private void convertBinToOct() {
        if (!textFieldBinary.getText().isEmpty()) {
            textFieldOctal.setText(NumberConversion.convertBinToOct(textFieldBinary.getText())); // Set textFieldOctal to octal value of binary input
        }
    }

    private void convertBinToDec() {
        if (!textFieldBinary.getText().isEmpty()) {
            textFieldDecimal.setText(NumberConversion.convertBinToDec(textFieldBinary.getText())); // Set textFieldDecimal to decimal value of binary input
        }
    }

    private void convertBinToHex() {
        if (!textFieldBinary.getText().isEmpty()) {
            textFieldHexadecimal.setText(NumberConversion.convertBinToHex(textFieldBinary.getText())); // Set textFieldHexadecimal to hexadecimal value of binary input
        }
    }

    private void convertOctToBin() {
        if (!textFieldOctal.getText().isEmpty()) {
            textFieldBinary.setText(NumberConversion.convertOctToBin(textFieldOctal.getText())); // Set textFieldBinary to binary value of octal input
        }
    }

    private void convertDecToBin() {
        if (!textFieldDecimal.getText().isEmpty()) {
            textFieldBinary.setText(NumberConversion.convertDecToBin(textFieldDecimal.getText())); // Set textFieldBinary to binary value of decimal input
        }
    }

    private void convertHexToBin() {
        if (!textFieldHexadecimal.getText().isEmpty()) {
            textFieldBinary.setText(NumberConversion.convertHexToBin(textFieldHexadecimal.getText())); // Set textFieldBinary to binary value of hexadecimal input
        }
    }

    @FXML
    public void clearTextFields() {
        textFieldBinary.clear();
        textFieldOctal.clear();
        textFieldDecimal.clear();
        textFieldHexadecimal.clear();
    }

    @FXML
    public void backToExerciseMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/Exercises.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }
}