package codebug.exercises.ciphers.beginner;

import animatefx.animation.Shake;
import codebug.exercises.ciphers.CaesarCipher;
import codebug.exercises.ciphers.VigenereCipher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class CipherBeginnerController {

    @FXML
    ImageView logo;

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
    Tab tab1;
    @FXML
    Tab tab2;

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
        // Caesar Cipher field listeners
        caesarEncryptField.textProperty().addListener((ov, oldValue, newValue) -> {
            caesarEncryptField.setText(newValue.toUpperCase());

            String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";

            for (int i = 0; i < caesarEncryptField.getText().length(); i++) {
                char c = caesarEncryptField.getText().charAt(i);

                // This doesn't work properly
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

                // This doesn't work properly
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

                // This doesn't work properly
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

                // This doesn't work properly
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

                // This doesn't work properly
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

                // This doesn't work properly
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

    // Questions

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
    }

    // Question 3
    public void question3() {
        String answer = (labelQuestion3a.getText().toUpperCase() + " " + labelQuestion2b.getText().toUpperCase());

        if (textFieldAnswer3.getText().equals(VigenereCipher.encrypt(answer.toUpperCase(), "LEMON"))) {
            result3.setText("Correct!");
            result3.setTextFill(Color.GREEN);
        } else {
            result3.setText("Incorrect!");
            result3.setTextFill(Color.RED);
        }
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

    // Go to next exercise
    @FXML
    public void nextExercise(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/ciphers/intermediate/CipherIntermediate.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }
}
