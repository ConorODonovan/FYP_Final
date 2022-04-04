package codebug.login;

import animatefx.animation.RubberBand;
import codebug.database.DBUtils;
import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

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
    MenuItem LoginMenuHelp;
    @FXML
    ImageView imageViewLogo;
    @FXML
    VBox vboxLogin;
    @FXML
    TextField textFieldUserName;
    @FXML
    TextField textFieldPassword;
    @FXML
    TextField registerUsername;
    @FXML
    TextField registerEmail;
    @FXML
    TextField registerPassword;
    @FXML
    TextField registerConfirmPassword;
    @FXML
    Button buttonLogin;
    @FXML
    Button buttonRegister;

    @FXML
    private void initialize() {

    }

    // Top Menu Bar functionality
    @FXML
    public void openAboutWindow() throws Exception {
        TopMenuBar.openAboutWindow();
    }

    public void mouseClick() {
        RubberBand logoTada = new RubberBand(imageViewLogo);
        logoTada.play();
    }

    private boolean loginCheck() {
        return DBUtils.loginUser(textFieldUserName.getText(), textFieldPassword.getText());
//        return true;
    }

    @FXML
    private void userRegistration(ActionEvent event) throws SQLException, IOException {
        // Check that al registration fields are complete
        if (registerUsername.getText().isEmpty() || registerEmail.getText().isEmpty() || registerPassword.getText().isEmpty() || registerConfirmPassword.getText().isEmpty()) {
            System.out.println("Please enter all required fields!");
        // Check if Password and Confirm Password match
        } else if (!registerPassword.getText().equals(registerConfirmPassword.getText())) {
            System.out.println("Password and Confirm Password do not match");
        // Add user details to database
        } else {
            DBUtils.registerUser(registerUsername.getText(), registerEmail.getText(), registerPassword.getText());

            Parent root = FXMLLoader.load(getClass().getResource("/codebug/homepage/Homepage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 1920, 1080);
            stage.setScene(scene);
            stage.show();
        }
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

    // For testing database connection
    @FXML
    public void checkDBConnection() {
        String un = textFieldUserName.getText();
        String pw = textFieldPassword.getText();

        DBUtils.loginUser(un, pw);
    }
}
