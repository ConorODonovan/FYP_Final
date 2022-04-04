package codebug.exercises.ciphers;

import animatefx.animation.Shake;
import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class CiphersController {

    @FXML
    ImageView logo;

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


    @FXML
    private void initialize() {
        // Caesar Cipher field listeners
        textToEncrypt.textProperty().addListener((ov, oldValue, newValue) -> {
            textToEncrypt.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < textToEncrypt.getText().length(); i++) {
                char c = textToEncrypt.getText().charAt(i);

                // This doesn't work properly
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

                // This doesn't work properly
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

                // This doesn't work properly
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

                // This doesn't work properly
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

                // This doesn't work properly
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

                // This doesn't work properly
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
    public void encrypt() {
        String plainText = textToEncrypt.getText();
        String cipherText = CaesarCipher.encrypt(plainText, 3);
        encryptedText.setText(cipherText);
    }

    @FXML
    public void decrypt() {
        String cipherText = textToDecrypt.getText();
        String plainText = CaesarCipher.decrypt(cipherText, 3);
        decryptedText.setText(plainText);
    }

    @FXML
    public void encryptVigenere() {
        String plainText = vigenereTextToEncrypt.getText();
        String keyword = keywordEncrypt.getText();
        vigenereEncryptedText.setText(VigenereCipher.encrypt(plainText, keyword));
    }

    @FXML
    public void decryptVigenere() {
        String cipherText = vigenereTextToDecrypt.getText();
        String keyword = keywordDecrypt.getText();
        vigenereDecryptedText.setText(VigenereCipher.decrypt(cipherText, keyword));
    }

    // Go back to exercise menu
    @FXML
    public void backToExerciseMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/Exercises.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }
}
