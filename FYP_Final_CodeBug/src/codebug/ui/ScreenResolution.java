package codebug.ui;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class ScreenResolution {

    // Allows application to get user's screen resolution and resize the app accordingly

    // Get the user's primary screen resolution
    private Rectangle2D screenRes = Screen.getPrimary().getVisualBounds();

    // Getters and Setters
    public double getScreenWidth() {
        // Returns width of user's screen resolution in pixels
        return screenRes.getWidth();
    }

    public double getScreenHeight() {
        // Returns height of user's screen resolution in pixels
        return screenRes.getHeight();
    }
}