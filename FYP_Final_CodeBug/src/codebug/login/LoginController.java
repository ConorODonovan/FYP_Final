/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
LoginController - Controls logic for Login and Registration page
 */

package codebug.login;

import animatefx.animation.RubberBand;
import codebug.database.DBUtils;
import codebug.ui.NavigationManager;
import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    // Declaration of variables
    // Variables annotated with @FXML are UI elements
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
    MenuItem menuExit;
    @FXML
    ImageView logoTop;
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
    Label loginWarningLabel;
    @FXML
    Label registerWarningLabel;

    // Initialize method runs on first opening the page
    @FXML
    private void initialize() {

        Lighting lighting = new Lighting();
        Color color = Color.rgb(236, 151, 6);
        lighting.setDiffuseConstant(1.0);
        lighting.setSpecularConstant(0.0);
        lighting.setSpecularExponent(0.0);
        lighting.setSurfaceScale(0.0);
        lighting.setLight(new Light.Distant(100, 100, color));
        logoTop.setEffect(lighting);
        imageViewLogo.setEffect(lighting);

        loginWarningLabel.setText("");
        registerWarningLabel.setText("");
    }

    // Top Menu Bar functionality
    @FXML
    public void openAboutWindow() throws Exception {
        TopMenuBar.openAboutWindow();
    }

    // Animate logo on mouse click
    public void mouseClick() {
        RubberBand logoTada = new RubberBand(imageViewLogo);
        logoTada.play();
    }

    // Check database to see if login details are correct
    private boolean loginCheck() {
        return DBUtils.loginUser(textFieldUserName.getText(), textFieldPassword.getText());
    }

    // User registration
    @FXML
    private void userRegistration(ActionEvent event) throws SQLException, IOException {
        // Check that all registration fields are complete
        if (registerUsername.getText().isEmpty() || registerEmail.getText().isEmpty() || registerPassword.getText().isEmpty() || registerConfirmPassword.getText().isEmpty()) {
            registerWarningLabel.setText("Please complete all required fields!");
        // Check if Password and Confirm Password match
        } else if (!registerPassword.getText().equals(registerConfirmPassword.getText())) {
            registerWarningLabel.setText("Password and Confirm Password do not match!");
            // Add user details to database
        } else {
            DBUtils.registerUser(registerUsername.getText(), registerEmail.getText(), registerPassword.getText());
            registerWarningLabel.setText("Registered successfully, please login to continue!");
        }
    }

    // Go to main menu on successful login
    @FXML
    public void switchToHomepage(ActionEvent e) throws IOException {
        if (!loginBlank()) {
            loginWarningLabel.setText("Username field cannot be blank!");
        } else if (!loginPasswordBlank()) {
            loginWarningLabel.setText("Password field cannot be blank!");
        } else if (!loginCheck()) {
            loginWarningLabel.setText("Username or password is incorrect!");
        } if (loginCheck()) {
            NavigationManager.goToMainMenuButton(e);
        }
    }

    // Login error messages
    @FXML
    public boolean loginBlank() {
        return !textFieldUserName.getText().equals("");
    }

    @FXML
    public boolean loginPasswordBlank() {
        return !textFieldPassword.getText().equals("");
    }

    // Registration error messages
    @FXML
    public boolean usernameBlank() {
        return !registerUsername.getText().equals("");
    }

    @FXML
    public boolean emailBlank() {
        return !registerEmail.getText().equals("");
    }

    @FXML
    public boolean passwordBlank() {
        return !registerPassword.getText().equals("") && !registerConfirmPassword.getText().equals("");
    }

    @FXML
    public void usernameUnavailable() {

    }

    @FXML
    public boolean passwordMismatch() {
        return !registerPassword.getText().equals(registerConfirmPassword.getText());
    }

    // Exit application
    @FXML
    public void exitApplication() {
        TopMenuBar.exitApplication();
    }
}