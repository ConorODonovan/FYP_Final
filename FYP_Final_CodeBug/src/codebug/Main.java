package codebug;

import codebug.ui.ScreenResolution;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private ScreenResolution screenResolution = new ScreenResolution();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login/Login.fxml")); // Loads the login and registration screen first upon starting the app
        primaryStage.setMaximized(true); // Start application in fullscreen
        primaryStage.setTitle("CodeBug"); // Set title of window to "CodeBug"
        primaryStage.setScene(new Scene(root, screenResolution.getScreenWidth(), screenResolution.getScreenHeight()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
