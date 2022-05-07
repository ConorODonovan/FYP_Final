/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
CiphersController - Controls logic for Cipher Sandbox
 */

package codebug.exercises.ciphers;

import animatefx.animation.Shake;
import codebug.database.DBUtils;
import codebug.ui.NavigationManager;
import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import java.io.IOException;

public class CiphersController {

    // Declaration of variables
    // Variables annotated with @FXML are UI elements
    @FXML
    Label usernameLabel;
    @FXML
    ImageView logoTop;
    @FXML
    TextField textToEncrypt;
    @FXML
    TextField encryptedText;
    @FXML
    TextField textToDecrypt;
    @FXML
    TextField decryptedText;
    @FXML
    Button buttonEncrypt;
    @FXML
    Button buttonDecrypt;
    @FXML
    TextField vigenereTextToEncrypt;
    @FXML
    TextField keywordEncrypt;
    @FXML
    Button vigenereEncrypt;
    @FXML
    TextField vigenereEncryptedText;
    @FXML
    TextField vigenereTextToDecrypt;
    @FXML
    TextField keywordDecrypt;
    @FXML
    Button vigenereDecrypt;
    @FXML
    TextField vigenereDecryptedText;
    @FXML
    Button backToExerciseMenuCaesar;
    @FXML
    Button backToExerciseMenuVigenere;

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
        textToEncrypt.textProperty().addListener((ov, oldValue, newValue) -> {
            textToEncrypt.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < textToEncrypt.getText().length(); i++) {
                char c = textToEncrypt.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    textToEncrypt.setText("" + textToEncrypt.getText().substring(0, textToEncrypt.getText().length() - 1));
                    Shake shake = new Shake(textToEncrypt);
                    shake.play();
                }
            }
        });

        textToDecrypt.textProperty().addListener((ov, oldValue, newValue) -> {
            textToDecrypt.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < textToDecrypt.getText().length(); i++) {
                char c = textToDecrypt.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    textToDecrypt.setText("" + textToDecrypt.getText().substring(0, textToDecrypt.getText().length() - 1));
                    Shake shake = new Shake(textToDecrypt);
                    shake.play();
                }
            }
        });

        encryptedText.setEditable(false);
        decryptedText.setEditable(false);

        // Vigenere Cipher field listeners
        vigenereTextToEncrypt.textProperty().addListener((ov, oldValue, newValue) -> {
            vigenereTextToEncrypt.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < vigenereTextToEncrypt.getText().length(); i++) {
                char c = vigenereTextToEncrypt.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    vigenereTextToEncrypt.setText("" + vigenereTextToEncrypt.getText().substring(0, vigenereTextToEncrypt.getText().length() - 1));
                    Shake shake = new Shake(vigenereTextToEncrypt);
                    shake.play();
                }
            }
        });

        keywordEncrypt.textProperty().addListener((ov, oldValue, newValue) -> {
            keywordEncrypt.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < keywordEncrypt.getText().length(); i++) {
                char c = keywordEncrypt.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    keywordEncrypt.setText("" + keywordEncrypt.getText().substring(0, keywordEncrypt.getText().length() - 1));
                    Shake shake = new Shake(keywordEncrypt);
                    shake.play();
                }
            }
        });

        vigenereTextToDecrypt.textProperty().addListener((ov, oldValue, newValue) -> {
            vigenereTextToDecrypt.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < vigenereTextToDecrypt.getText().length(); i++) {
                char c = vigenereTextToDecrypt.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    vigenereTextToDecrypt.setText("" + vigenereTextToDecrypt.getText().substring(0, vigenereTextToDecrypt.getText().length() - 1));
                    Shake shake = new Shake(vigenereTextToDecrypt);
                    shake.play();
                }
            }
        });

        keywordDecrypt.textProperty().addListener((ov, oldValue, newValue) -> {
            keywordDecrypt.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < keywordDecrypt.getText().length(); i++) {
                char c = keywordDecrypt.getText().charAt(i);

                if (allowedCharacters.indexOf(c) == -1) {
                    keywordDecrypt.setText("" + keywordDecrypt.getText().substring(0, keywordDecrypt.getText().length() - 1));
                    Shake shake = new Shake(keywordDecrypt);
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

    // Return to main menu by clicking logo
    @FXML
    public void goToMainMenu() {
        NavigationManager.goToMainMenuNoButton(logoTop);
    }

    // Calls encrypt method from CaesarCipher class
    @FXML
    public void encrypt() {
        String plainText = textToEncrypt.getText();
        String cipherText = CaesarCipher.encrypt(plainText, 3);
        encryptedText.setText(cipherText);
    }

    // Calls decrypt method from CaesarCipher class
    @FXML
    public void decrypt() {
        String cipherText = textToDecrypt.getText();
        String plainText = CaesarCipher.decrypt(cipherText, 3);
        decryptedText.setText(plainText);
    }

    // Calls encrypt method from VigenereCipher class
    @FXML
    public void encryptVigenere() {
        String plainText = vigenereTextToEncrypt.getText();
        String keyword = keywordEncrypt.getText();
        vigenereEncryptedText.setText(VigenereCipher.encrypt(plainText, keyword));
    }

    // Calls decrypt method from VigenereCipher class
    @FXML
    public void decryptVigenere() {
        String cipherText = vigenereTextToDecrypt.getText();
        String keyword = keywordDecrypt.getText();
        vigenereDecryptedText.setText(VigenereCipher.decrypt(cipherText, keyword));
    }

    // Go back to exercise menu
    @FXML
    public void backToExerciseMenu(ActionEvent e) throws IOException {
        NavigationManager.goToExercises(e);
    }
}