package codebug.exercises.escaperoom;

import animatefx.animation.Shake;
import animatefx.animation.Tada;
import codebug.database.DBUtils;
import codebug.exercises.ciphers.CaesarCipher;
import codebug.exercises.ciphers.VigenereCipher;
import codebug.exercises.numbers.NumberConversion;
import codebug.ui.NavigationManager;
import codebug.ui.TopMenuBar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EscapeRoomController {

    @FXML
    ImageView logoTop;

    @FXML
    Label usernameLabel;

    @FXML
    Label updateLabel;

    // Room objects that can be interacted with
    @FXML
    ImageView objectJournal;
    @FXML
    ImageView objectTablet;
    @FXML
    ImageView objectWallSafe;
    @FXML
    ImageView objectComputer;
    @FXML
    ImageView objectPowerBox;
    @FXML
    ImageView objectDoorNumpad;
    @FXML
    ImageView objectFilingCabinetTopDrawer;
    @FXML
    ImageView objectFilingCabinetMiddleDrawer;
    @FXML
    ImageView objectFilingCabinetBottomDrawer;
    @FXML
    Image transistorBoxOpened = new Image("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/exercises/escaperoom/images/er_powerpanel_opened.png");
    @FXML
    Image wallSafeOpened = new Image("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/exercises/escaperoom/images/er_wallsafe_opened.png");
    @FXML
    Image computerOn = new Image("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/exercises/escaperoom/images/er_computer_on.png");

    // Room object screens
    @FXML
    GridPane numpadFilingCabinet;
    @FXML
    GridPane numpadWallSafe;
    @FXML
    GridPane numpadDoor;
    @FXML
    VBox passwordComputer;
    @FXML
    VBox passwordFilingCabinet;
    @FXML
    AnchorPane transistorBox;

    // Interface
    @FXML
    VBox journal;
    @FXML
    Pane tablet;

    // Number conversion tablet screen
    @FXML
    TextField textFieldBinary;
    @FXML
    TextField textFieldOctal;
    @FXML
    TextField textFieldDecimal;
    @FXML
    TextField textFieldHexadecimal;
    @FXML
    Button buttonClear;

    // Caesar Cipher tablet screen
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

    // Vigenere Cipher tablet screen
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

    // Journal entries
    @FXML
    Label journalComputerPassword1;
    @FXML
    Label journalComputerPassword2;
    @FXML
    Label journalFilingCabinetNumpad1;
    @FXML
    Label journalFilingCabinetNumpad2;
    @FXML
    Label journalFilingCabinetPassword1;
    @FXML
    Label journalFilingCabinetPassword2;
    @FXML
    Label journalWallSafeNumpad1;
    @FXML
    Label journalWallSafeNumpad2;
    @FXML
    Label journalDoorNumpad1;
    @FXML
    Label journalDoorNumpad2;

    // Tablet logic gates descriptions
    @FXML
    StackPane stackPaneAND;
    @FXML
    StackPane stackPaneOR;
    @FXML
    StackPane stackPaneNOT;
    @FXML
    StackPane stackPaneNAND;
    @FXML
    StackPane stackPaneNOR;
    @FXML
    StackPane stackPaneXOR;
    @FXML
    StackPane stackPaneXNOR;

    // Filing Cabinet numpad
    @FXML
    TextField numpadFilingCabinetTextField;
    @FXML
    Button filingCabinetButton1;
    @FXML
    Button filingCabinetButton2;
    @FXML
    Button filingCabinetButton3;
    @FXML
    Button filingCabinetButton4;
    @FXML
    Button filingCabinetButton5;
    @FXML
    Button filingCabinetButton6;
    @FXML
    Button filingCabinetButton7;
    @FXML
    Button filingCabinetButton8;
    @FXML
    Button filingCabinetButton9;
    @FXML
    Button filingCabinetButton0;
    @FXML
    Button filingCabinetButtonClear;
    @FXML
    Button filingCabinetButtonOK;

    // Wall Safe numpad
    @FXML
    TextField numpadWallSafeTextField;
    @FXML
    Button wallSafeButton1;
    @FXML
    Button wallSafeButton2;
    @FXML
    Button wallSafeButton3;
    @FXML
    Button wallSafeButton4;
    @FXML
    Button wallSafeButton5;
    @FXML
    Button wallSafeButton6;
    @FXML
    Button wallSafeButton7;
    @FXML
    Button wallSafeButton8;
    @FXML
    Button wallSafeButton9;
    @FXML
    Button wallSafeButton0;
    @FXML
    Button wallSafeButtonClear;
    @FXML
    Button wallSafeButtonOK;

    // Door numpad
    @FXML
    TextField numpadDoorTextField;
    @FXML
    Button doorButton1;
    @FXML
    Button doorButton2;
    @FXML
    Button doorButton3;
    @FXML
    Button doorButton4;
    @FXML
    Button doorButton5;
    @FXML
    Button doorButton6;
    @FXML
    Button doorButton7;
    @FXML
    Button doorButton8;
    @FXML
    Button doorButton9;
    @FXML
    Button doorButton0;
    @FXML
    Button doorButtonClear;
    @FXML
    Button doorButtonOK;

    // Power box transistors items
    @FXML
    ComboBox<Image> answer1;
    @FXML
    ComboBox<Image> answer2;
    @FXML
    ComboBox<Image> answer3;
    @FXML
    Button powerBoxButton;

    // Game loop flags and fields
    Boolean computerPower = false;
    @FXML
    TextField computerPasswordField;
    @FXML
    Button computerPasswordSubmit;
    @FXML
    Label labelComputerAnswer1;
    @FXML
    Label labelComputerAnswer2;
    @FXML
    TextField topDrawerTextField;
    @FXML
    Button topDrawerButton;

    @FXML
    MenuItem menuPreferences;
    @FXML
    MenuItem menuLogout;
    @FXML
    MenuItem menuExit;
    @FXML
    MenuItem menuAbout;

    public EscapeRoomController() throws FileNotFoundException {
    }

    @FXML
    private void initialize() throws FileNotFoundException {

        // Get user currently logged in
        String currentUser = DBUtils.getCurrentUser();

        // Sets label in top right to username
        if (currentUser == null) {
            usernameLabel.setText("Please log in");
        } else {
            usernameLabel.setText("Logged in as " + currentUser);
        }

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

        // Update label
        updateLabel.setText("");
        journalComputerPassword1.setText("");
        journalComputerPassword2.setText("");
        journalFilingCabinetNumpad1.setText("");
        journalFilingCabinetNumpad2.setText("");
        journalFilingCabinetPassword1.setText("");
        journalFilingCabinetPassword2.setText("");
        journalWallSafeNumpad1.setText("");
        journalWallSafeNumpad2.setText("");
        journalDoorNumpad1.setText("");
        journalDoorNumpad2.setText("");

        // Tablet interface
        // Number conversion tab
        textFieldBinary.textProperty().addListener(e -> {
            for (int i = 0; i < textFieldBinary.getText().length(); i++) {
                char c = textFieldBinary.getText().charAt(i);

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


        // Power box transistors ComboBox
        // TODO
        // Change file paths from absolute to relative

        // AND
        FileInputStream iconAND = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/AND.png");
        Image imageAND = new Image(iconAND);

        // Tooltip
        Tooltip tooltipAND = new Tooltip("0 AND 0 = 0\n" +
                "0 AND 1 = 0\n" +
                "1 AND 0 = 0\n" +
                "1 AND 1 = 1");
        Tooltip.install(stackPaneAND, tooltipAND);

        // OR
        FileInputStream iconOR = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/OR.png");
        Image imageOR = new Image(iconOR);

        // Tooltip
        Tooltip tooltipOR = new Tooltip("0 OR 0 = 0\n" +
                "0 OR 1 = 1\n" +
                "1 OR 0 = 1\n" +
                "1 OR 1 = 1");
        Tooltip.install(stackPaneOR, tooltipOR);

        // NOT
        FileInputStream iconNOT = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/NOT.png");
        Image imageNOT = new Image(iconNOT);

        // Tooltip
        Tooltip tooltipNOT = new Tooltip("NOT 0 = 1\n" +
                "NOT 1 = 0");
        Tooltip.install(stackPaneNOT, tooltipNOT);

        // NAND
        FileInputStream iconNAND = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/NAND.png");
        Image imageNAND = new Image(iconNAND);

        // Tooltip
        Tooltip tooltipNAND = new Tooltip("0 NAND 0 = 1\n" +
                "0 NAND 1 = 1\n" +
                "1 NAND 0 = 1\n" +
                "1 NAND 1 = 0");
        Tooltip.install(stackPaneNAND, tooltipNAND);

        // NOR
        FileInputStream iconNOR = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/NOR.png");
        Image imageNOR = new Image(iconNOR);

        // Tooltip
        Tooltip tooltipNOR = new Tooltip("0 NOR 0 = 1\n" +
                "0 NOR 1 = 0\n" +
                "1 NOR 0 = 0\n" +
                "1 NOR 1 = 0");
        Tooltip.install(stackPaneNOR, tooltipNOR);

        // XOR
        FileInputStream iconXOR = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/XOR.png");
        Image imageXOR = new Image(iconXOR);

        // Tooltip
        Tooltip tooltipXOR = new Tooltip("0 XOR 0 = 0\n" +
                "0 XOR 1 = 1\n" +
                "1 XOR 0 = 1\n" +
                "1 XOR 1 = 0");
        Tooltip.install(stackPaneXOR, tooltipXOR);

        // XNOR
        FileInputStream iconXNOR = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/XNOR.png");
        Image imageXNOR = new Image(iconXNOR);

        // Tooltip
        Tooltip tooltipXNOR = new Tooltip("0 XNOR 0 = 1\n" +
                "0 XNOR 1 = 0\n" +
                "1 XNOR 0 = 0\n" +
                "1 XNOR 1 = 1");
        Tooltip.install(stackPaneXNOR, tooltipXNOR);

        answer1.getItems().add(imageAND);
        answer1.getItems().add(imageOR);
        answer1.getItems().add(imageNOT);
        answer1.getItems().add(imageNAND);
        answer1.getItems().add(imageNOR);
        answer1.getItems().add(imageXOR);
        answer1.getItems().add(imageXNOR);

        // TODO
        // Image not displaying as selected
        answer1.setCellFactory(new Callback<ListView<Image>, ListCell<Image>>() {
            @Override public ListCell<Image> call(ListView<Image> p) {
                return new ListCell<Image>() {
                    //                    private final Image image;
                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//                        image = new Image();
                    }

                    @Override protected void updateItem(Image item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(new ImageView(item));
                        }
                    }
                };
            }
        });

        answer1.setButtonCell(answer1.getCellFactory().call(null));

        answer2.getItems().add(imageAND);
        answer2.getItems().add(imageOR);
        answer2.getItems().add(imageNOT);
        answer2.getItems().add(imageNAND);
        answer2.getItems().add(imageNOR);
        answer2.getItems().add(imageXOR);
        answer2.getItems().add(imageXNOR);

        // TODO
        // Image not displaying as selected
        answer2.setCellFactory(new Callback<ListView<Image>, ListCell<Image>>() {
            @Override public ListCell<Image> call(ListView<Image> p) {
                return new ListCell<Image>() {
                    //                    private final Image image;
                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//                        image = new Image();
                    }

                    @Override protected void updateItem(Image item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(new ImageView(item));
                        }
                    }
                };
            }
        });

        answer2.setButtonCell(answer2.getCellFactory().call(null));

        answer3.getItems().add(imageAND);
        answer3.getItems().add(imageOR);
        answer3.getItems().add(imageNOT);
        answer3.getItems().add(imageNAND);
        answer3.getItems().add(imageNOR);
        answer3.getItems().add(imageXOR);
        answer3.getItems().add(imageXNOR);

        // TODO
        // Image not displaying as selected
        answer3.setCellFactory(new Callback<ListView<Image>, ListCell<Image>>() {
            @Override public ListCell<Image> call(ListView<Image> p) {
                return new ListCell<Image>() {
                    //                    private final Image image;
                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//                        image = new Image();
                    }

                    @Override protected void updateItem(Image item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(new ImageView(item));
                        }
                    }
                };
            }
        });

        answer3.setButtonCell(answer3.getCellFactory().call(null));
    }

    // Return to main menu by clicking logo
    @FXML
    public void goToMainMenu() {
        NavigationManager.goToMainMenuNoButton(logoTop);
    }

    // Glow effect for Journal and Table
    public void objectJournalGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.ORANGE);
        borderGlow.setWidth(120);
        borderGlow.setHeight(120);
        objectJournal.setEffect(borderGlow);
    }

    public void objectJournalRemoveGlow() {
        objectJournal.setEffect(null);
    }

    public void objectTabletGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.ORANGE);
        borderGlow.setWidth(120);
        borderGlow.setHeight(120);
        objectTablet.setEffect(borderGlow);
    }

    public void objectTabletRemoveGlow() {
        objectTablet.setEffect(null);
    }

    // Glow effect when hovering over room objects
    public void objectWallSafeGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.LIMEGREEN);
        borderGlow.setWidth(120);
        borderGlow.setHeight(120);
        objectWallSafe.setEffect(borderGlow);
    }

    public void objectWallSafeRemoveGlow() {
        objectWallSafe.setEffect(null);
    }

    public void objectComputerGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.LIMEGREEN);
        borderGlow.setWidth(120);
        borderGlow.setHeight(120);
        objectComputer.setEffect(borderGlow);
    }

    public void objectComputerRemoveGlow() {
        objectComputer.setEffect(null);
    }

    public void objectPowerBoxGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.LIMEGREEN);
        borderGlow.setWidth(120);
        borderGlow.setHeight(120);
        objectPowerBox.setEffect(borderGlow);
    }

    public void objectPowerBoxRemoveGlow() {
        objectPowerBox.setEffect(null);
    }

    public void objectDoorNumpadGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.LIMEGREEN);
        borderGlow.setWidth(120);
        borderGlow.setHeight(120);
        objectDoorNumpad.setEffect(borderGlow);
    }

    public void objectDoorNumpadRemoveGlow() {
        objectDoorNumpad.setEffect(null);
    }

    public void objectFilingCabinetTopDrawerGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.LIMEGREEN);
        borderGlow.setWidth(120);
        borderGlow.setHeight(120);
        objectFilingCabinetTopDrawer.setEffect(borderGlow);
    }

    public void objectFilingCabinetTopDrawerRemoveGlow() {
        objectFilingCabinetTopDrawer.setEffect(null);
    }

    public void objectFilingCabinetMiddleDrawerGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.LIMEGREEN);
        borderGlow.setWidth(120);
        borderGlow.setHeight(120);
        objectFilingCabinetMiddleDrawer.setEffect(borderGlow);
    }

    public void objectFilingCabinetMiddleDrawerRemoveGlow() {
        objectFilingCabinetMiddleDrawer.setEffect(null);
    }

    public void objectFilingCabinetBottomDrawerGlow() {
        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.LIMEGREEN);
        borderGlow.setWidth(120);
        borderGlow.setHeight(120);
        objectFilingCabinetBottomDrawer.setEffect(borderGlow);
    }

    public void objectFilingCabinetBottomDrawerRemoveGlow() {
        objectFilingCabinetBottomDrawer.setEffect(null);
    }


    // Opening and closing journal and tablet
    public void openJournal() {
        if (journal.isVisible()) {
            journal.setVisible(false);
        } else {
            journal.setVisible(true);
        }

        updateLabel.setText("");
    }

    public void openTablet() {
        if (tablet.isVisible()) {
            tablet.setVisible(false);
        } else {
            tablet.setVisible(true);
        }
    }

    // Number methods for tablet interface
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

    // Encryption/Decryption methods for tablet interface
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


    // Game loop interactions

    // Power/transistor box
    public void openPowerBox() {
        objectPowerBox.setImage(transistorBoxOpened);

        if (transistorBox.isVisible()) {
            transistorBox.setVisible(false);
        } else {
            transistorBox.setVisible(true);
        }
    }

    // Filing cabinet top drawer
    public void filingCabinetMiddleDrawer() {
        if (numpadFilingCabinet.isVisible()) {
            numpadFilingCabinet.setVisible(false);
        } else {
            numpadFilingCabinet.setVisible(true);
        }
    }

    // Filing cabinet middle drawer
    public void filingCabinetTopDrawer() {
        if (passwordFilingCabinet.isVisible()) {
            passwordFilingCabinet.setVisible(false);
        } else {
            passwordFilingCabinet.setVisible(true);
        }
    }

    // Computer
    public void computer() {
        if (computerPower) {
            if (passwordComputer.isVisible()) {
                passwordComputer.setVisible(false);
            } else {
                passwordComputer.setVisible(true);
            }
        } else {
            updateLabel.setText("The computer has no power!");
            Tada logoTada = new Tada(updateLabel);
            logoTada.play();
        }
    }

    // Wall safe
    public void wallSafe() {
        if (numpadWallSafe.isVisible()) {
            numpadWallSafe.setVisible(false);
        } else {
            numpadWallSafe.setVisible(true);
        }
    }

    // Door numpad
    public void doorNumpad() {
        if (numpadDoor.isVisible()) {
            numpadDoor.setVisible(false);
        } else {
            numpadDoor.setVisible(true);
        }
    }


    // Game loop methods

    // Filing cabinet numpad functionality
    public void filingCabinetButton1() {
        numpadFilingCabinetTextField.setText(numpadFilingCabinetTextField.getText() + "1");
    }

    public void filingCabinetButton2() {
        numpadFilingCabinetTextField.setText(numpadFilingCabinetTextField.getText() + "2");
    }

    public void filingCabinetButton3() {
        numpadFilingCabinetTextField.setText(numpadFilingCabinetTextField.getText() + "3");
    }

    public void filingCabinetButton4() {
        numpadFilingCabinetTextField.setText(numpadFilingCabinetTextField.getText() + "4");
    }

    public void filingCabinetButton5() {
        numpadFilingCabinetTextField.setText(numpadFilingCabinetTextField.getText() + "5");
    }

    public void filingCabinetButton6() {
        numpadFilingCabinetTextField.setText(numpadFilingCabinetTextField.getText() + "6");
    }

    public void filingCabinetButton7() {
        numpadFilingCabinetTextField.setText(numpadFilingCabinetTextField.getText() + "7");
    }

    public void filingCabinetButton8() {
        numpadFilingCabinetTextField.setText(numpadFilingCabinetTextField.getText() + "8");
    }

    public void filingCabinetButton9() {
        numpadFilingCabinetTextField.setText(numpadFilingCabinetTextField.getText() + "9");
    }

    public void filingCabinetButton0() {
        numpadFilingCabinetTextField.setText(numpadFilingCabinetTextField.getText() + "0");
    }

    public void filingCabinetButtonClear() {
        numpadFilingCabinetTextField.clear();
    }


    // Wall Safe numpad functionality
    public void wallSafeButton1() {
        numpadWallSafeTextField.setText(numpadWallSafeTextField.getText() + "1");
    }

    public void wallSafeButton2() {
        numpadWallSafeTextField.setText(numpadWallSafeTextField.getText() + "2");
    }

    public void wallSafeButton3() {
        numpadWallSafeTextField.setText(numpadWallSafeTextField.getText() + "3");
    }

    public void wallSafeButton4() {
        numpadWallSafeTextField.setText(numpadWallSafeTextField.getText() + "4");
    }

    public void wallSafeButton5() {
        numpadWallSafeTextField.setText(numpadWallSafeTextField.getText() + "5");
    }

    public void wallSafeButton6() {
        numpadWallSafeTextField.setText(numpadWallSafeTextField.getText() + "6");
    }

    public void wallSafeButton7() {
        numpadWallSafeTextField.setText(numpadWallSafeTextField.getText() + "7");
    }

    public void wallSafeButton8() {
        numpadWallSafeTextField.setText(numpadWallSafeTextField.getText() + "8");
    }

    public void wallSafeButton9() {
        numpadWallSafeTextField.setText(numpadWallSafeTextField.getText() + "9");
    }

    public void wallSafeButton0() {
        numpadWallSafeTextField.setText(numpadWallSafeTextField.getText() + "0");
    }

    public void wallSafeButtonClear() {
        numpadWallSafeTextField.clear();
    }


    // Door numpad functionality
    public void doorButton1() {
        numpadDoorTextField.setText(numpadDoorTextField.getText() + "1");
    }

    public void doorButton2() {
        numpadDoorTextField.setText(numpadDoorTextField.getText() + "2");
    }

    public void doorButton3() {
        numpadDoorTextField.setText(numpadDoorTextField.getText() + "3");
    }

    public void doorButton4() {
        numpadDoorTextField.setText(numpadDoorTextField.getText() + "4");
    }

    public void doorButton5() {
        numpadDoorTextField.setText(numpadDoorTextField.getText() + "5");
    }

    public void doorButton6() {
        numpadDoorTextField.setText(numpadDoorTextField.getText() + "6");
    }

    public void doorButton7() {
        numpadDoorTextField.setText(numpadDoorTextField.getText() + "7");
    }

    public void doorButton8() {
        numpadDoorTextField.setText(numpadDoorTextField.getText() + "8");
    }

    public void doorButton9() {
        numpadDoorTextField.setText(numpadDoorTextField.getText() + "9");
    }

    public void doorButton0() {
        numpadDoorTextField.setText(numpadDoorTextField.getText() + "0");
    }

    public void doorButtonClear() {
        numpadDoorTextField.clear();
    }


    // Game flow

    // Filing cabinet bottom drawer
    public void filingCabinetBottomDrawer() {
        updateLabel.setText("You received a new journal entry!");
        Tada logoTada = new Tada(updateLabel);
        logoTada.play();
        journalComputerPassword1.setText("Computer Login encrypted");
        journalComputerPassword2.setText("with Caesar Cipher: HOHFWURQ");
    }

    // Power box answer
    @FXML
    public void checkPowerBoxAnswers() {
        if ((answer1.getValue() == answer1.getItems().get(1) || answer1.getValue() == answer1.getItems().get(3))|| (answer1.getValue() == answer1.getItems().get(5))
                && (answer2.getValue() == answer2.getItems().get(2))
                && (answer3.getValue() == answer3.getItems().get(3) || answer3.getValue() == answer3.getItems().get(4)  || answer3.getValue() == answer3.getItems().get(6))) {
            computerPower = true;
            objectComputer.setImage(computerOn);
            updateLabel.setText("The computer has power now!");
            Tada logoTada = new Tada(updateLabel);
            logoTada.play();
        }
    }

    // Computer answer
    @FXML
    public void checkComputerAnswer() {
        String compAns = computerPasswordField.getText().toUpperCase();

        if (compAns.equals("ELECTRON")) {
            labelComputerAnswer1.setText("Login successful... Filing cabinet");
            labelComputerAnswer2.setText("code in Binary is 10100011010011");
            journalFilingCabinetNumpad1.setText("The code to the filing cabinet is");
            journalFilingCabinetNumpad2.setText("10100011010011 - must convert to Decimal");
            updateLabel.setText("New journal entry!");
            Tada logoTada = new Tada(updateLabel);
            logoTada.play();
        } else {
            labelComputerAnswer1.setText("Login unsuccessful... Please try again");
        }
    }

    // Middle filing cabinet drawer answer
    @FXML
    public void checkMiddleFilingCabinetDrawerAnswer() {
        if (numpadFilingCabinetTextField.getText().equals("10451")) {
            numpadFilingCabinetTextField.setText("CORRECT");
            journalFilingCabinetPassword1.setText("Password to the filing cabinet is");
            journalFilingCabinetPassword2.setText("VCLRYCX encrypted with the keyword FILE");
            updateLabel.setText("New journal entry!");
            Tada logoTada = new Tada(updateLabel);
            logoTada.play();
        } else {
            numpadFilingCabinetTextField.setText("INCORRECT");
        }
    }

    // Top filing cabinet drawer answer
    @FXML
    public void checkTopFilingCabinetDrawerAnswer() {
        String filingCabinetAnswer = topDrawerTextField.getText().toUpperCase();

        if (filingCabinetAnswer.equals("QUANTUM")) {
            topDrawerTextField.setText("CORRECT");
            journalWallSafeNumpad1.setText("Code for wall safe is 16C -");
            journalWallSafeNumpad2.setText("it must be converted from Hex to Decimal");
            updateLabel.setText("New journal entry!");
            Tada logoTada = new Tada(updateLabel);
            logoTada.play();
        } else {
            topDrawerTextField.setText("INCORRECT");
        }
    }

    // Wall safe answer
    @FXML
    public void checkWallSafeAnswer() {
        if (numpadWallSafeTextField.getText().equals("364")) {
            numpadWallSafeTextField.setText("CORRECT");
            updateLabel.setText("New journal entry!");
            journalDoorNumpad1.setText("The code for the door is 33B -");
            journalDoorNumpad2.setText("it must be converted from Hex to Decimal");
            objectWallSafe.setImage(wallSafeOpened);
            Tada logoTada = new Tada(updateLabel);
            logoTada.play();
        } else {
            numpadWallSafeTextField.setText("INCORRECT");
        }
    }

    // Door answer
    @FXML
    public void checkDoorAnswer() {
        if (numpadDoorTextField.getText().equals("827")) {
            numpadWallSafeTextField.setText("CORRECT");
            updateLabel.setText("Congratulations! You have escaped!");
            DBUtils.updateEscapeRoom();
            Tada logoTada = new Tada(updateLabel);
            logoTada.play();
        } else {
            numpadWallSafeTextField.setText("INCORRECT");
        }
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