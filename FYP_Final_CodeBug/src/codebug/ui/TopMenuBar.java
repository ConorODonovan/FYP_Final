/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
TopMenuBar Class - Handles all top menu bar actions
 */

package codebug.ui;

import codebug.themes.ThemeManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TopMenuBar {

    // Open About page and apply correct theme
    public static void openAboutWindow() throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(TopMenuBar.class.getResource("/codebug/about/About.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();

            // Setting correct theme
            root1.getStylesheets().remove("codebug/genericDefault.css");
            root1.getStylesheets().remove("codebug/about/aboutDefault.css");
            root1.getStylesheets().remove("codebug/genericNature.css");
            root1.getStylesheets().remove("codebug/about/aboutNature.css");
            root1.getStylesheets().remove("codebug/genericOcean.css");
            root1.getStylesheets().remove("codebug/about/aboutOcean.css");
            root1.getStylesheets().remove("codebug/genericDusk.css");
            root1.getStylesheets().remove("codebug/about/aboutDusk.css");
            root1.getStylesheets().remove("codebug/genericSunset.css");
            root1.getStylesheets().remove("codebug/about/aboutSunset.css");
            root1.getStylesheets().remove("codebug/genericMonochrome.css");
            root1.getStylesheets().remove("codebug/about/aboutMonochrome.css");
            root1.getStylesheets().remove("codebug/genericHighContrast.css");
            root1.getStylesheets().remove("codebug/about/aboutHighContrast.css");
            String css1 = "codebug/generic" + ThemeManager.loadCSS();
            String css2 = "codebug/about/about" + ThemeManager.loadCSS();
            root1.getStylesheets().add(css1);
            root1.getStylesheets().add(css2);

            stage.setScene(new Scene(root1));
            stage.setTitle("About Codebug");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Open settings page
    public static void openSettingsWindow() throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(TopMenuBar.class.getResource("/codebug/settings/Settings.fxml"));
            Parent root2 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.setTitle("Settings");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}