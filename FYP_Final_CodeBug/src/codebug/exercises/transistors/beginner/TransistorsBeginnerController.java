/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
TransistorsBeginnerController - Controls logic for Transistors Beginner Exercise
 */

package codebug.exercises.transistors.beginner;

import codebug.database.DBUtils;
import codebug.ui.NavigationManager;
import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TransistorsBeginnerController {

    // Declaration of variables
    // Variables annotated with @FXML are UI elements
    @FXML
    Label usernameLabel;
    @FXML
    ImageView logoTop;
    @FXML
    ImageView logicGateIconAND;
    @FXML
    Line lineMiddleLeft1;
    @FXML
    Line lineMiddleLeft2;
    @FXML
    Line lineMiddleLeft3;
    @FXML
    ComboBox<Image> answer1;
    @FXML
    ComboBox<Image> answer2;
    @FXML
    ComboBox<Image> answer3;
    @FXML
    Button checkAnswerButton1;
    @FXML
    Button checkAnswerButton2;
    @FXML
    Button checkAnswerButton3;
    @FXML
    Label result1;
    @FXML
    Label result2;
    @FXML
    Label result3;
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
    @FXML
    Button buttonBackToExerciseMenu;
    @FXML
    Button buttonNextExercise;

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
    public void initialize() throws FileNotFoundException {

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

        // Explanatory icons on left side
        // AND
        FileInputStream iconAND = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/AND.png");
        Image imageAND = new Image(iconAND);
        ImageView logicGateAND = new ImageView(imageAND);
        logicGateAND.setFitWidth(64);
        logicGateAND.setFitHeight(64);

        // Tooltip
        Tooltip tooltipAND = new Tooltip("0 AND 0 = 0\n" +
                "0 AND 1 = 0\n" +
                "1 AND 0 = 0\n" +
                "1 AND 1 = 1");
        Tooltip.install(stackPaneAND, tooltipAND);

        // OR
        FileInputStream iconOR = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/OR.png");
        Image imageOR = new Image(iconOR);
        ImageView logicGateOR = new ImageView(imageOR);
        logicGateOR.setFitWidth(64);
        logicGateOR.setFitHeight(64);

        // Tooltip
        Tooltip tooltipOR = new Tooltip("0 OR 0 = 0\n" +
                "0 OR 1 = 1\n" +
                "1 OR 0 = 1\n" +
                "1 OR 1 = 1");
        Tooltip.install(stackPaneOR, tooltipOR);

        // NOT
        FileInputStream iconNOT = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/NOT.png");
        Image imageNOT = new Image(iconNOT);
        ImageView logicGateNOT = new ImageView(imageNOT);
        logicGateNOT.setFitWidth(64);
        logicGateNOT.setFitHeight(64);

        // Tooltip
        Tooltip tooltipNOT = new Tooltip("NOT 0 = 1\n" +
                "NOT 1 = 0");
        Tooltip.install(stackPaneNOT, tooltipNOT);

        // NAND
        FileInputStream iconNAND = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/NAND.png");
        Image imageNAND = new Image(iconNAND);
        ImageView logicGateNAND = new ImageView(imageNAND);
        logicGateNAND.setFitWidth(64);
        logicGateNAND.setFitHeight(64);

        // Tooltip
        Tooltip tooltipNAND = new Tooltip("0 NAND 0 = 1\n" +
                "0 NAND 1 = 1\n" +
                "1 NAND 0 = 1\n" +
                "1 NAND 1 = 0");
        Tooltip.install(stackPaneNAND, tooltipNAND);

        // NOR
        FileInputStream iconNOR = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/NOR.png");
        Image imageNOR = new Image(iconNOR);
        ImageView logicGateNOR = new ImageView(imageNOR);
        logicGateNOR.setFitWidth(64);
        logicGateNOR.setFitHeight(64);

        // Tooltip
        Tooltip tooltipNOR = new Tooltip("0 NOR 0 = 1\n" +
                "0 NOR 1 = 0\n" +
                "1 NOR 0 = 0\n" +
                "1 NOR 1 = 0");
        Tooltip.install(stackPaneNOR, tooltipNOR);

        // XOR
        FileInputStream iconXOR = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/XOR.png");
        Image imageXOR = new Image(iconXOR);
        ImageView logicGateXOR = new ImageView(imageXOR);
        logicGateXOR.setFitWidth(64);
        logicGateXOR.setFitHeight(64);

        // Tooltip
        Tooltip tooltipXOR = new Tooltip("0 XOR 0 = 0\n" +
                "0 XOR 1 = 1\n" +
                "1 XOR 0 = 1\n" +
                "1 XOR 1 = 0");
        Tooltip.install(stackPaneXOR, tooltipXOR);

        // XNOR
        FileInputStream iconXNOR = new FileInputStream("F:/Dropbox/Dropbox/College/Year 4/Final Year Project/Project/FYP_Final_CodeBug/src/codebug/resources/transistors/XNOR.png");
        Image imageXNOR = new Image(iconXNOR);
        ImageView logicGateXNOR = new ImageView(imageXNOR);
        logicGateXNOR.setFitWidth(64);
        logicGateXNOR.setFitHeight(64);

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

        answer1.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Image> call(ListView<Image> p) {
                return new ListCell<>() {
                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                    }

                    @Override
                    protected void updateItem(Image item, boolean empty) {
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

        answer2.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Image> call(ListView<Image> p) {
                return new ListCell<>() {
                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                    }

                    @Override
                    protected void updateItem(Image item, boolean empty) {
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

        answer3.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Image> call(ListView<Image> p) {
                return new ListCell<>() {
                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                    }

                    @Override
                    protected void updateItem(Image item, boolean empty) {
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

    // Check answers
    @FXML
    public void checkAnswer1() {
        if (answer1.getValue() == answer1.getItems().get(3) || answer1.getValue() == answer1.getItems().get(4) || answer1.getValue() == answer1.getItems().get(6)) {
            result1.setText("Correct!");
            result1.setTextFill(Color.FORESTGREEN);
        } else {
            result1.setText("Incorrect!");
            result1.setTextFill(Color.INDIANRED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!")) {
            DBUtils.updateTransistorsBeginner();
        }
    }

    @FXML
    public void checkAnswer2() {
        if (answer2.getValue() == answer2.getItems().get(1) || answer2.getValue() == answer2.getItems().get(3) || answer2.getValue() == answer2.getItems().get(5)) {
            result2.setText("Correct!");
            result2.setTextFill(Color.FORESTGREEN);
        } else {
            result2.setText("Incorrect!");
            result2.setTextFill(Color.INDIANRED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!")) {
            DBUtils.updateTransistorsBeginner();
        }
    }

    @FXML
    public void checkAnswer3() {
        if (answer3.getValue() == answer3.getItems().get(0) || answer3.getValue() == answer3.getItems().get(1) || answer3.getValue() == answer3.getItems().get(6)) {
            result3.setText("Correct!");
            result3.setTextFill(Color.FORESTGREEN);
        } else {
            result3.setText("Incorrect!");
            result3.setTextFill(Color.INDIANRED);
        }

        // Check if all answers are correct - this triggers the exercise to be flagged as complete in the database for the user
        if (result1.getText().equals("Correct!") && result2.getText().equals("Correct!") && result3.getText().equals("Correct!")) {
            DBUtils.updateTransistorsBeginner();
        }
    }

    // Return to main menu by clicking logo
    @FXML
    public void goToMainMenu() {
        NavigationManager.goToMainMenuNoButton(logoTop);
    }

    // Go to exercise menu
    @FXML
    public void backToExerciseMenu(ActionEvent e) throws IOException {
        NavigationManager.goToExercises(e);
    }

    // Go to next exercise
    @FXML
    public void nextExercise(ActionEvent e) throws IOException {
        NavigationManager.goToTransistorsIntermediate(e);
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