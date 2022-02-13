package codebug.exercises.ciphers;

import animatefx.animation.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CiphersController {

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
    private void initialize() {
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
}
