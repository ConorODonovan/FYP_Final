/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
NavigationManager Class - Handles all navigation between different screens of the application
 */

package codebug.ui;

import codebug.themes.ThemeManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationManager {

    // Go to Main Menu - button
    @FXML
    public static void goToMainMenuButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/homepage/Homepage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/homepage/homepageDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/homepage/homepageNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/homepage/homepageOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/homepage/homepageDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/homepage/homepageSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/homepage/homepageMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/homepage/homepageHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/homepage/homepage" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Main Menu - not button
    @FXML
    public static void goToMainMenuNoButton(Node node) {
        node.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/homepage/Homepage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            assert root != null;
            Scene scene = new Scene(root, 1920, 1080);

            // Setting correct theme
            root.getStylesheets().remove("codebug/genericDefault.css");
            root.getStylesheets().remove("codebug/homepage/homepageDefault.css");
            root.getStylesheets().remove("codebug/genericNature.css");
            root.getStylesheets().remove("codebug/homepage/homepageNature.css");
            root.getStylesheets().remove("codebug/genericOcean.css");
            root.getStylesheets().remove("codebug/homepage/homepageOcean.css");
            root.getStylesheets().remove("codebug/genericDusk.css");
            root.getStylesheets().remove("codebug/homepage/homepageDusk.css");
            root.getStylesheets().remove("codebug/genericSunset.css");
            root.getStylesheets().remove("codebug/homepage/homepageSunset.css");
            root.getStylesheets().remove("codebug/genericMonochrome.css");
            root.getStylesheets().remove("codebug/homepage/homepageMonochrome.css");
            root.getStylesheets().remove("codebug/genericHighContrast.css");
            root.getStylesheets().remove("codebug/homepage/homepageHighContrast.css");
            String css1 = "codebug/generic" + ThemeManager.loadCSS();
            String css2 = "codebug/homepage/homepage" + ThemeManager.loadCSS();
            root.getStylesheets().add(css1);
            root.getStylesheets().add(css2);

            stage.setScene(scene);
            stage.show();
        });
    }

    // Go to Exercises
    @FXML
    public static void goToExercises(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/Exercises.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Numbers - Beginner
    @FXML
    public static void goToNumbersBeginner(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/numbers/beginner/NumberBeginner.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Numbers - Intermediate
    @FXML
    public static void goToNumbersIntermediate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/numbers/intermediate/NumberIntermediate.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Numbers - Advanced
    @FXML
    public static void goToNumbersAdvanced(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/numbers/advanced/NumberAdvanced.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Numbers - Sandbox
    @FXML
    public static void goToNumbersSandbox(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/numbers/BinaryConverter.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Ciphers - Beginner
    @FXML
    public static void goToCiphersBeginner(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/ciphers/beginner/CipherBeginner.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Ciphers - Intermediate
    @FXML
    public static void goToCiphersIntermediate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/ciphers/intermediate/CipherIntermediate.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Ciphers - Advanced
    @FXML
    public static void goToCiphersAdvanced(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/ciphers/advanced/CipherAdvanced.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Ciphers - Sandbox
    @FXML
    public static void goToCiphersSandbox(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/ciphers/Ciphers.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Transistors - Beginner
    @FXML
    public static void goToTransistorsBeginner(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/transistors/beginner/TransistorsBeginner.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Transistors - Intermediate
    @FXML
    public static void goToTransistorsIntermediate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/transistors/intermediate/TransistorsIntermediate.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Transistors - Advanced
    @FXML
    public static void goToTransistorsAdvanced(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/transistors/advanced/TransistorsAdvanced.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Escape Room
    @FXML
    public static void goToEscapeRoom(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/exercises/escaperoom/EscapeRoom.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/exercises/exercisesNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/exercises/exercisesOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/exercises/exercisesDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/exercises/exercisesSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/exercises/exercisesMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        root.getStylesheets().remove("codebug/exercises/exercisesHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        String css2 = "codebug/exercises/exercises" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);
        root.getStylesheets().add(css2);

        stage.setScene(scene);
        stage.show();
    }

    // Go to Game Engine
    @FXML
    public static void goToGameEngine(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/gameengine/GameEngine.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);

        stage.setScene(scene);
        stage.show();
    }

    // Go to admin menu
    @FXML
    public static void goToAdmin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/admin/Admin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);

        // Setting correct theme
        root.getStylesheets().remove("codebug/genericDefault.css");
        root.getStylesheets().remove("codebug/genericNature.css");
        root.getStylesheets().remove("codebug/genericOcean.css");
        root.getStylesheets().remove("codebug/genericDusk.css");
        root.getStylesheets().remove("codebug/genericSunset.css");
        root.getStylesheets().remove("codebug/genericMonochrome.css");
        root.getStylesheets().remove("codebug/genericHighContrast.css");
        String css1 = "codebug/generic" + ThemeManager.loadCSS();
        root.getStylesheets().add(css1);

        stage.setScene(scene);
        stage.show();
    }
}