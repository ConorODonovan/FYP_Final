/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
HomepageController - Controls logic for Main Menu page
 */

package codebug.homepage;

import animatefx.animation.*;
import codebug.database.DBUtils;
import codebug.ui.NavigationManager;
import codebug.ui.TopMenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.sql.SQLException;

public class HomepageController {

    // Declaration of variables
    // Variables annotated with @FXML are UI elements
    @FXML
    HBox topHBox;
    @FXML
    Label usernameLabel;
    @FXML
    ImageView logoTop;
    @FXML
    ImageView imageViewLogo;
    @FXML
    Button learnButton;
    @FXML
    Button createButton;
    @FXML
    Button playButton;
    @FXML
    private Image imgLearn = new Image("codebug/homepage/icon-learn.png");
    @FXML
    private ImageView learnImage = new ImageView(imgLearn);
    @FXML
    private Image imgCreate = new Image("codebug/homepage/icon-create.png");
    @FXML
    private ImageView createImage = new ImageView(imgCreate);
    @FXML
    private Image imgPlay = new Image("codebug/homepage/icon-play.png");
    @FXML
    private ImageView playImage = new ImageView(imgPlay);

    // Initialize method runs on first opening the page
    @FXML
    private void initialize() throws SQLException {

        // Get user currently logged in
        String currentUser = DBUtils.getCurrentUser();
        String theme = DBUtils.loadTheme();

        // Check if user is admin user
        String adminUser = DBUtils.checkIfAdminUser();

        // Add Admin menu button if user is admin user
        if (adminUser.equals("1")) {
            Button adminButton = new Button("Admin Menu");
            topHBox.getChildren().add(adminButton);

            // Sets up admin button with correct theme
            switch (theme) {
                case "Default":
                    adminButton.setStyle("-fx-font-size: 20px;\n" +
                            "            -fx-font-weight: 800;\n" +
                            "            -fx-text-fill: #FFFFFF;\n" +
                            "            -fx-background-color: #EC9706;\n" +
                            "            -fx-padding: 16px;\n" +
                            "            -fx-border-insets: 8px;\n" +
                            "            -fx-background-insets: 8px;\n" +
                            "            -fx-cursor: hand;");
                    break;
                case "Nature":
                    adminButton.setStyle("-fx-font-size: 20px;\n" +
                            "            -fx-font-weight: 800;\n" +
                            "            -fx-text-fill: #FFFFFF;\n" +
                            "            -fx-background-color: #52B788;\n" +
                            "            -fx-padding: 16px;\n" +
                            "            -fx-border-insets: 8px;\n" +
                            "            -fx-background-insets: 8px;\n" +
                            "            -fx-cursor: hand;");
                    break;
                case "Ocean":
                    adminButton.setStyle("-fx-font-size: 20px;\n" +
                            "            -fx-font-weight: 800;\n" +
                            "            -fx-text-fill: #FFFFFF;\n" +
                            "            -fx-background-color: #7ABFC9;\n" +
                            "            -fx-padding: 16px;\n" +
                            "            -fx-border-insets: 8px;\n" +
                            "            -fx-background-insets: 8px;\n" +
                            "            -fx-cursor: hand;");
                    break;
                case "Dusk":
                    adminButton.setStyle("-fx-font-size: 20px;\n" +
                            "            -fx-font-weight: 800;\n" +
                            "            -fx-text-fill: #FFFFFF;\n" +
                            "            -fx-background-color: #F69C99;\n" +
                            "            -fx-padding: 16px;\n" +
                            "            -fx-border-insets: 8px;\n" +
                            "            -fx-background-insets: 8px;\n" +
                            "            -fx-cursor: hand;");
                    break;
                case "Sunset":
                    adminButton.setStyle("-fx-font-size: 20px;\n" +
                            "            -fx-font-weight: 800;\n" +
                            "            -fx-text-fill: #FFFFFF;\n" +
                            "            -fx-background-color: #FF6F4B;\n" +
                            "            -fx-padding: 16px;\n" +
                            "            -fx-border-insets: 8px;\n" +
                            "            -fx-background-insets: 8px;\n" +
                            "            -fx-cursor: hand;");
                    break;
                case "Monochrome":
                    adminButton.setStyle("-fx-font-size: 20px;\n" +
                            "            -fx-font-weight: 800;\n" +
                            "            -fx-text-fill: #FFFFFF;\n" +
                            "            -fx-background-color: #949494;\n" +
                            "            -fx-padding: 16px;\n" +
                            "            -fx-border-insets: 8px;\n" +
                            "            -fx-background-insets: 8px;\n" +
                            "            -fx-cursor: hand;");
                    break;
                case "High Contrast":
                    adminButton.setStyle("-fx-font-size: 20px;\n" +
                            "            -fx-font-weight: 800;\n" +
                            "            -fx-text-fill: #FFFFFF;\n" +
                            "            -fx-background-color: #FFB400;\n" +
                            "            -fx-padding: 16px;\n" +
                            "            -fx-border-insets: 8px;\n" +
                            "            -fx-background-insets: 8px;\n" +
                            "            -fx-cursor: hand;");
                    break;
            }

            // Admin button event listener
            adminButton.setOnAction(event -> {
                try {
                    NavigationManager.goToAdmin(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        // Sets label in top right to username
        if (currentUser == null) {
            usernameLabel.setText("Please log in");
        } else {
            usernameLabel.setText("Logged in as " + currentUser);
        }

        // Main homepage navigation buttons
        learnImage.setFitWidth(300);
        learnImage.setFitHeight(300);
        learnImage.setTranslateY(-16);
        learnButton.setGraphic(learnImage);

        createImage.setFitWidth(300);
        createImage.setFitHeight(300);
        createImage.setTranslateY(-16);
        createButton.setGraphic(createImage);

        playImage.setFitWidth(300);
        playImage.setFitHeight(300);
        playImage.setTranslateY(-16);
        playButton.setGraphic(playImage);

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
                learnImage.setEffect(lighting);
                createImage.setEffect(lighting);
                playImage.setEffect(lighting);
                logoTop.setEffect(lighting);
                imageViewLogo.setEffect(lighting);

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
                learnImage.setEffect(lighting);
                createImage.setEffect(lighting);
                playImage.setEffect(lighting);
                logoTop.setEffect(lighting);
                imageViewLogo.setEffect(lighting);

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
                learnImage.setEffect(lighting);
                createImage.setEffect(lighting);
                playImage.setEffect(lighting);
                logoTop.setEffect(lighting);
                imageViewLogo.setEffect(lighting);

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
                learnImage.setEffect(lighting);
                createImage.setEffect(lighting);
                playImage.setEffect(lighting);
                logoTop.setEffect(lighting);
                imageViewLogo.setEffect(lighting);

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
                learnImage.setEffect(lighting);
                createImage.setEffect(lighting);
                playImage.setEffect(lighting);
                logoTop.setEffect(lighting);
                imageViewLogo.setEffect(lighting);

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
                learnImage.setEffect(lighting);
                createImage.setEffect(lighting);
                playImage.setEffect(lighting);
                logoTop.setEffect(lighting);
                imageViewLogo.setEffect(lighting);

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
                learnImage.setEffect(lighting);
                createImage.setEffect(lighting);
                playImage.setEffect(lighting);
                logoTop.setEffect(lighting);
                imageViewLogo.setEffect(lighting);

                break;
            }
        }
    }

    // Top Menu Bar functionality
    @FXML
    public void openSettingsWindow() throws Exception {
        TopMenuBar.openSettingsWindow();
    }

    // Open About screen
    @FXML
    public void openAboutWindow() throws Exception {
        TopMenuBar.openAboutWindow();
    }

    // Makes logo animate when clicked on
    @FXML
    public void mouseClick() {
        RubberBand logoTada = new RubberBand(imageViewLogo);
        logoTada.play();
    }

    // Makes Learn button animate on mouse hover
    @FXML
    public void mouseEnterLearnButton() {
        RubberBand logoTada = new RubberBand(learnImage);
        logoTada.play();
    }

    // Makes Create button animate on mouse hover
    @FXML
    public void mouseEnterCreateButton() {
        RubberBand logoTada = new RubberBand(createImage);
        logoTada.play();
    }

    // Makes Play button animate on mouse hover
    @FXML
    public void mouseEnterPlayButton() {
        RubberBand logoTada = new RubberBand(playImage);
        logoTada.play();
    }

    // Go to exercise menu
    @FXML
    public void goToExercises(ActionEvent e) throws IOException {
        NavigationManager.goToExercises(e);
    }

    // Go to game engine
    public void goToGameEngine(ActionEvent e) throws IOException {
        NavigationManager.goToGameEngine(e);
    }
}