package codebug.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    @FXML
    AnchorPane loginTop;
    @FXML
    VBox loginTopVBox;
    @FXML
    MenuBar loginMenuBar;
    @FXML
    MenuItem LoginMenuFile;
    @FXML
    MenuItem LoginMenuEdit;
    @FXML
    MenuItem LoginMenuHelp;
    @FXML
    Button loginButtonTest; // Temporary button for screen navigation

    private boolean loginCheck() {
        return true;
    }

    @FXML
    public void switchToHomepage(ActionEvent event) throws IOException {
        if (loginCheck()) {
            Parent root = FXMLLoader.load(getClass().getResource("/codebug/homepage/Homepage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 1920, 1080);
            stage.setScene(scene);
            stage.show();
        }
    }
}