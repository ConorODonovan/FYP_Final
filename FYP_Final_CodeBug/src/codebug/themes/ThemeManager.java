package codebug.themes;

import codebug.database.DBUtils;

public class ThemeManager {

    public static String loadCSS() {

        String theme = DBUtils.getTheme();
        String result = "";

        switch (theme) {
            case "Default":
                 result = "Default.css";
                break;
            case "Nature":
                result = "Nature.css";
                break;
            case "Ocean":
                result = "Ocean.css";
                break;
            case "Dusk":
                result = "Dusk.css";
                break;
            case "Sunset":
                result = "Sunset.css";
                break;
            case "Monochrome":
                result = "Monochrome.css";
                break;
            case "High Contrast":
                result = result = "HighContrast.css";
                break;
        }

        return result;
    }
}