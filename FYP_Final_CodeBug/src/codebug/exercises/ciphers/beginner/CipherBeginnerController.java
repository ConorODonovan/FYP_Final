/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
CipherBeginnerController - Controls logic for Cipher Beginner Exercise
 */

package codebug.exercises.ciphers.beginner;

import animatefx.animation.Shake;
import codebug.database.DBUtils;
import codebug.exercises.ciphers.CaesarCipher;
import codebug.exercises.ciphers.VigenereCipher;
import codebug.ui.NavigationManager;
import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.io.IOException;

public class CipherBeginnerController {

    // Declaration of variables
    // Variables annotated with @FXML are UI elements
    @FXML
    Label usernameLabel;
    @FXML
    ImageView logoTop;
    @FXML
    TextField caesarEncryptField;
    @FXML
    Button caesarEncryptButton;
    @FXML
    TextField caesarEncryptedText;
    @FXML
    TextField caesarDecryptField;
    @FXML
    Button caesarDecryptButton;
    @FXML
    TextField caesarDecryptedText;
    @FXML
    TextField vigenereEncryptField;
    @FXML
    TextField vigenereEncryptKeyword;
    @FXML
    Button vigenereEncryptButton;
    @FXML
    TextField vigenereEncryptedText;
    @FXML
    TextField vigenereDecryptField;
    @FXML
    TextField vigenereDecryptKeyword;
    @FXML
    Button vigenereDecryptButton;
    @FXML
    TextField vigenereDecryptedText;
    @FXML
    Label labelQuestion1a;
    @FXML
    Label labelQuestion1b;
    @FXML
    Label labelQuestion1c;
    @FXML
    TextField textFieldAnswer1;
    @FXML
    Label result1;
    @FXML
    Button buttonQuestion1;
    @FXML
    Label labelQuestion2a;
    @FXML
    Label labelQuestion2b;
    @FXML
    TextField textFieldAnswer2;
    @FXML
    Label result2;
    @FXML
    Button buttonQuestion2;
    @FXML
    Label labelQuestion3a;
    @FXML
    Label labelQuestion3b;
    @FXML
    TextField textFieldAnswer3;
    @FXML
    Label result3;
    @FXML
    Button buttonQuestion3;

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

        // Caesar Cipher field listeners
        caesarEncryptField.textProperty().addListener((ov, oldValue, newValue) -> {
            caesarEncryptField.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < caesarEncryptField.getText().length(); i++) {
                char c = caesarEncryptField.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    caesarEncryptField.setText("" + caesarEncryptField.getText().substring(0, caesarEncryptField.getText().length() - 1));
                    Shake shake = new Shake(caesarEncryptField);
                    shake.play();
                }
            }
        });

        caesarDecryptField.textProperty().addListener((ov, oldValue, newValue) -> {
            caesarDecryptField.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < caesarDecryptField.getText().length(); i++) {
                char c = caesarDecryptField.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    caesarDecryptField.setText("" + caesarDecryptField.getText().substring(0, caesarDecryptField.getText().length() - 1));
                    Shake shake = new Shake(caesarDecryptField);
                    shake.play();
                }
            }
        });

        caesarEncryptedText.setEditable(false);
        caesarDecryptedText.setEditable(false);

        // Vigenere Cipher field listeners
        vigenereEncryptField.textProperty().addListener((ov, oldValue, newValue) -> {
            vigenereEncryptField.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < vigenereEncryptField.getText().length(); i++) {
                char c = vigenereEncryptField.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    vigenereEncryptField.setText("" + vigenereEncryptField.getText().substring(0, vigenereEncryptField.getText().length() - 1));
                    Shake shake = new Shake(vigenereEncryptField);
                    shake.play();
                }
            }
        });

        vigenereEncryptKeyword.textProperty().addListener((ov, oldValue, newValue) -> {
            vigenereEncryptKeyword.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < vigenereEncryptKeyword.getText().length(); i++) {
                char c = vigenereEncryptKeyword.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    vigenereEncryptKeyword.setText("" + vigenereEncryptKeyword.getText().substring(0, vigenereEncryptKeyword.getText().length() - 1));
                    Shake shake = new Shake(vigenereEncryptKeyword);
                    shake.play();
                }
            }
        });

        vigenereDecryptField.textProperty().addListener((ov, oldValue, newValue) -> {
            vigenereDecryptField.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < vigenereDecryptField.getText().length(); i++) {
                char c = vigenereDecryptField.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    vigenereDecryptField.setText("" + vigenereDecryptField.getText().substring(0, vigenereDecryptField.getText().length() - 1));
                    Shake shake = new Shake(vigenereDecryptField);
                    shake.play();
                }
            }
        });

        vigenereDecryptKeyword.textProperty().addListener((ov, oldValue, newValue) -> {
            vigenereDecryptKeyword.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < vigenereDecryptKeyword.getText().length(); i++) {
                char c = vigenereDecryptKeyword.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    vigenereDecryptKeyword.setText("" + vigenereDecryptKeyword.getText().substring(0, vigenereDecryptKeyword.getText().length() - 1));
                    Shake shake = new Shake(vigenereDecryptKeyword);
                    shake.play();
                }
            }
        });

        vigenereEncryptedText.setEditable(false);
        vigenereDecryptedText.setEditable(false);
    }

    // Top Menu Bar functionality
    @FXML
    public void openAboutWindow() throws Exception {
        TopMenuBar.openAboutWindow();
    }

    @FXML
    public void encryptCaesar() {
        String plainText = caesarEncryptField.getText();
        String cipherText = CaesarCipher.encrypt(plainText, 3);
        caesarEncryptedText.setText(cipherText);
    }

    @FXML
    public void decryptCaesar() {
        String cipherText = caesarDecryptField.getText();
        String plainText = CaesarCipher.decrypt(cipherText, 3);
        caesarDecryptedText.setText(plainText);
    }

    @FXML
    public void encryptVigenere() {
        String plainText = vigenereEncryptField.getText();
        String keyword = vigenereEncryptKeyword.getText();
        vigenereEncryptedText.setText(VigenereCipher.encrypt(plainText, keyword));
    }

    @FXML
    public void decryptVigenere() {
        String cipherText = vigenereDecryptField.getText();
        String keyword = vigenereDecryptKeyword.getText();
        vigenereDecryptedText.setText(VigenereCipher.decrypt(cipherText, keyword));
    }

    // Checking the answers to each question
    // Question 1
    public void question1() {
        String answer = (labelQuestion1a.getText().toUpperCase()) + " " + (labelQuestion1b.getText().toUpperCase()) + " " + (labelQuestion1c.getText().toUpperCase());

        System.out.println(answer);
        System.out.println(CaesarCipher.encrypt(textFieldAnswer1.getText().toUpperCase(), 3));

        if (textFieldAnswer1.getText().equals(CaesarCipher.encrypt(answer.toUpperCase(), 3))) {
            result1.setText("Correct!");
            result1.setTextFill(Color.GREEN);
        } else {
            result1.setText("Incorrect!");
            result1.setTextFill(Color.RED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!")) {
            DBUtils.updateCiphersBeginner();
        }
    }

    // Question 2
    public void question2() {
        String answer = (labelQuestion2a.getText().toUpperCase() + " " + labelQuestion2b.getText().toUpperCase());

        System.out.println(answer);
        System.out.println(CaesarCipher.decrypt(textFieldAnswer2.getText().toUpperCase(), 3));

        if (textFieldAnswer2.getText().equals(CaesarCipher.decrypt(answer.toUpperCase(), 3))) {
            result2.setText("Correct!");
            result2.setTextFill(Color.GREEN);
        } else {
            result2.setText("Incorrect!");
            result2.setTextFill(Color.RED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!")) {
            DBUtils.updateCiphersBeginner();
        }
    }

    // Question 3
    public void question3() {
        String answer = (labelQuestion3a.getText().toUpperCase() + " " + labelQuestion3b.getText().toUpperCase());

        if (textFieldAnswer3.getText().equals(VigenereCipher.encrypt(answer.toUpperCase(), "LEMON"))) {
            result3.setText("Correct!");
            result3.setTextFill(Color.GREEN);
        } else {
            result3.setText("Incorrect!");
            result3.setTextFill(Color.RED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!")) {
            DBUtils.updateCiphersBeginner();
        }
    }

    // Return to main menu by clicking logo
    @FXML
    public void goToMainMenu() {
        NavigationManager.goToMainMenuNoButton(logoTop);
    }

    // Go back to exercise menu
    @FXML
    public void backToExerciseMenu(ActionEvent e) throws IOException {
        NavigationManager.goToExercises(e);
    }

    // Go to next exercise
    @FXML
    public void nextExercise(ActionEvent e) throws IOException {
        NavigationManager.goToCiphersIntermediate(e);
    }
}