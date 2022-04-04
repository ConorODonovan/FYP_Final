package codebug.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TopMenuBar {

    public static void openAboutWindow() throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(TopMenuBar.class.getResource("/codebug/about/About.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("About Codebug");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}