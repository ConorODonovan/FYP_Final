package codebug.homepage;

import animatefx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController {

    @FXML
    ImageView imageViewLogo;
    @FXML
    VBox vBoxLearn = new VBox();
    @FXML
    VBox vBoxCreate = new VBox();
    @FXML
    VBox vBoxPlay = new VBox();
    @FXML
    Label labelLearn = new Label();
    @FXML
    Label labelCreate = new Label();
    @FXML
    Label labelPlay = new Label();
    @FXML
    ImageView imageViewLearn = new ImageView();
    @FXML
    ImageView imageViewCreate = new ImageView();
    @FXML
    ImageView imageViewPlay = new ImageView();

    public void mouseClick() {
        RubberBand logoTada = new RubberBand(imageViewLogo);
        logoTada.play();
    }

    @FXML
    public void mouseEnterLearn() {
        RubberBand rubberBand = new RubberBand(imageViewLearn);
        rubberBand.play();
        Pulse pulse = new Pulse(labelLearn);
        pulse.play();
    }

    @FXML
    public void mouseEnterCreate() {
        RubberBand rubberBand = new RubberBand(imageViewCreate);
        rubberBand.play();
        Pulse pulse = new Pulse(labelCreate);
        pulse.play();
    }

    @FXML
    public void mouseEnterPlay() {
        RubberBand rubberBand = new RubberBand(imageViewPlay);
        rubberBand.play();
        Pulse pulse = new Pulse(labelPlay);
        pulse.play();
    }

    // TODO
    // Fix errors that occur when this method is called
    @FXML
    public void goToExercises() {
        vBoxLearn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/codebug/exercises/Exercises.fxml"));
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

    // TODO
    // Fix errors that occur when this method is called
    @FXML
    public void goToGameEngine() {
        vBoxCreate.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/codebug/gameengine/GameEngine.fxml"));
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

//    @FXML
//    public void goToExercises(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/codebug/exercises/Exercises.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root, 1920, 1080);
//        stage.setScene(scene);
//        stage.show();
//    }

//    @FXML
//    public void goToGameEngine(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/codebug/gameengine/GameEngine.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root, 1920, 1080);
//        stage.setScene(scene);
//        stage.show();
//    }

    @FXML
    public void backToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/codebug/login/Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }
}
