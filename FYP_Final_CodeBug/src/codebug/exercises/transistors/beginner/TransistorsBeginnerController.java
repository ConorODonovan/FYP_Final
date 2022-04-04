package codebug.exercises.transistors.beginner;

import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TransistorsBeginnerController {

    @FXML
    ImageView logo;

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
//    ComboBox<ImageView> answer1;
    @FXML
    ComboBox<ImageView> answer2;
    @FXML
    ComboBox<ImageView> answer3;

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
    public void initialize() throws FileNotFoundException {

        // TODO
        // Change file paths from absolute to relative

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

        // TODO
        // Fix ComboBox items disappearing once selected (CellFactory?)

//        answer1.getItems().add(logicGateAND);
//        answer1.getItems().add(logicGateOR);
//        answer1.getItems().add(logicGateNOT);
//        answer1.getItems().add(logicGateNAND);
//        answer1.getItems().add(logicGateNOR);
//        answer1.getItems().add(logicGateXOR);
//        answer1.getItems().add(logicGateXNOR);

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

        answer2.getItems().add(logicGateAND);
        answer2.getItems().add(logicGateOR);
        answer2.getItems().add(logicGateNOT);
        answer2.getItems().add(logicGateNAND);
        answer2.getItems().add(logicGateNOR);
        answer2.getItems().add(logicGateXOR);
        answer2.getItems().add(logicGateXNOR);

        answer3.getItems().add(logicGateAND);
        answer3.getItems().add(logicGateOR);
        answer3.getItems().add(logicGateNOT);
        answer3.getItems().add(logicGateNAND);
        answer3.getItems().add(logicGateNOR);
        answer3.getItems().add(logicGateXOR);
        answer3.getItems().add(logicGateXNOR);

        System.out.println(answer1.getItems().get(0));
        System.out.println(answer1.getItems().get(6));
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
    public void checkAnswer1() {
        if (answer1.getValue() == answer1.getItems().get(3) || answer1.getValue() == answer1.getItems().get(4) || answer1.getValue() == answer1.getItems().get(6)) {
            result1.setText("Correct!");
            result1.setTextFill(Color.FORESTGREEN);
        } else {
            result1.setText("Incorrect!");
            result1.setTextFill(Color.INDIANRED);
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
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/transistors/intermediate/TransistorsIntermediate.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }
}