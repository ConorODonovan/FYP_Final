/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
DBUtils - handles the MySQL database connection and all of the SQL queries
 */

package codebug.database;

import codebug.admin.User;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import java.sql.*;

public class DBUtils {

    private static String currentUser = null;
    private static String theme = "Default";
    private static String isAdmin = "0";

    // Getters and Setters
    public static String getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(String user) {
        currentUser = user;
    }

    public static String getTheme() {
        return theme;
    }

    public static String getIsAdmin() {
        return isAdmin;
    }

    public static void setIsAdmin(String changeAdmin) {
        isAdmin = changeAdmin;
    }

    public static void setTheme(String newTheme) {
        theme = newTheme;
    }

    // Saves a newly registered user in the database
    public static void registerUser(String username, String email, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username not available!");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO users (username, user_email, user_password, is_admin, theme, exercise1, exercise2, exercise3, exercise4, exercise5, exercise6, exercise7, exercise8, exercise9, exercise10) " +
                        "VALUES (?, ?, ?, 0, 'Default', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)");
                psInsert.setString(1, username);
                psInsert.setString(2, email);
                psInsert.setString(3, password);
                psInsert.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Attempts to login a user based on their entered username and password on the login page
    public static boolean loginUser(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            System.out.println("Connecting... first try block");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT user_password FROM users WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

                return false;
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("user_password");

                    if (retrievedPassword.equals(password)) {
                        System.out.println("Login details correct");
                        currentUser = username;

                        return true;
                    } else {
                        System.out.println("Login details incorrect");

                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("First catch block");
            e.printStackTrace();
            return false;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    // Checks if the logged in user has Admin privileges - if they do, they can access the Admin page
    public static String checkIfAdminUser() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT is_admin FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        String currentAdmin =  resultText.toString();

        isAdmin = currentAdmin;
        return currentAdmin;
    }

    // Checks which theme the user had last set, and ensures it is applied on login
    public static String loadTheme() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT theme FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        String currentTheme =  resultText.toString();

        System.out.println("Theme: " + currentTheme);
        theme = currentTheme;
        return currentTheme;
    }

    // Updates the theme associated with the logged in user in the database so it is applied the next time they log in
    public static void saveTheme(String newTheme) {
        Connection connection;
        PreparedStatement changeTheme;

        try {
            System.out.println("Connecting... first try block themes");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            changeTheme = connection.prepareStatement("UPDATE users " +
                    "SET theme = ? " +
                    "WHERE username = ?");
            changeTheme.setString(1, newTheme);
            changeTheme.setString(2, getCurrentUser());
            changeTheme.executeUpdate();
            changeTheme.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("New Theme: " + newTheme);
        theme = newTheme;
    }


    // Showing user exercise progress
    // Numbers - Beginner
    public static String loadExercise1Progress() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT exercise1 FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        return resultText.toString();
    }

    // Numbers - Intermediate
    public static String loadExercise2Progress() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT exercise2 FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        return resultText.toString();
    }

    // Numbers - Advanced
    public static String loadExercise3Progress() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT exercise3 FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        return resultText.toString();
    }

    // Ciphers - Beginner
    public static String loadExercise4Progress() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT exercise4 FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        return resultText.toString();
    }

    // Ciphers - Intermediate
    public static String loadExercise5Progress() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT exercise5 FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        return resultText.toString();
    }

    // Ciphers - Advanced
    public static String loadExercise6Progress() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT exercise6 FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        return resultText.toString();
    }

    // Transistors - Beginner
    public static String loadExercise7Progress() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT exercise7 FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        return resultText.toString();
    }

    // Transistors - Intermediate
    public static String loadExercise8Progress() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT exercise8 FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        return resultText.toString();
    }

    // Transistors - Advanced
    public static String loadExercise9Progress() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT exercise9 FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        return resultText.toString();
    }

    // Escape Room
    public static String loadExercise10Progress() throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT exercise10 FROM users WHERE username = ?");
            preparedStatement.setString(1, getCurrentUser());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StringBuilder resultText = new StringBuilder();

        assert resultSet != null;
        while (resultSet.next()) {
            resultText.append(resultSet.getString(1));
        }

        return resultText.toString();
    }


    // Updating user exercise progress
    // Numbers Beginner
    public static void updateNumbersBeginner() {
        Connection connection;
        PreparedStatement updateExercise1;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            updateExercise1 = connection.prepareStatement("UPDATE users " +
                    "SET exercise1 = 1 " +
                    "WHERE username = ?");
            updateExercise1.setString(1, getCurrentUser());
            updateExercise1.executeUpdate();
            updateExercise1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Numbers Intermediate
    public static void updateNumbersIntermediate() {
        Connection connection;
        PreparedStatement updateExercise2;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            updateExercise2 = connection.prepareStatement("UPDATE users " +
                    "SET exercise2 = 1 " +
                    "WHERE username = ?");
            updateExercise2.setString(1, getCurrentUser());
            updateExercise2.executeUpdate();
            updateExercise2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Numbers Advanced
    public static void updateNumbersAdvanced() {
        Connection connection;
        PreparedStatement updateExercise3;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            updateExercise3 = connection.prepareStatement("UPDATE users " +
                    "SET exercise3 = 1 " +
                    "WHERE username = ?");
            updateExercise3.setString(1, getCurrentUser());
            updateExercise3.executeUpdate();
            updateExercise3.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ciphers Beginner
    public static void updateCiphersBeginner() {
        Connection connection;
        PreparedStatement updateExercise4;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            updateExercise4 = connection.prepareStatement("UPDATE users " +
                    "SET exercise4 = 1 " +
                    "WHERE username = ?");
            updateExercise4.setString(1, getCurrentUser());
            updateExercise4.executeUpdate();
            updateExercise4.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ciphers Intermediate
    public static void updateCiphersIntermediate() {
        Connection connection;
        PreparedStatement updateExercise5;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            updateExercise5 = connection.prepareStatement("UPDATE users " +
                    "SET exercise5 = 1 " +
                    "WHERE username = ?");
            updateExercise5.setString(1, getCurrentUser());
            updateExercise5.executeUpdate();
            updateExercise5.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ciphers Advanced
    public static void updateCiphersAdvanced() {
        Connection connection;
        PreparedStatement updateExercise6;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            updateExercise6 = connection.prepareStatement("UPDATE users " +
                    "SET exercise6 = 1 " +
                    "WHERE username = ?");
            updateExercise6.setString(1, getCurrentUser());
            updateExercise6.executeUpdate();
            updateExercise6.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Transistors Beginner
    public static void updateTransistorsBeginner() {
        Connection connection;
        PreparedStatement updateExercise7;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            updateExercise7 = connection.prepareStatement("UPDATE users " +
                    "SET exercise7 = 1 " +
                    "WHERE username = ?");
            updateExercise7.setString(1, getCurrentUser());
            updateExercise7.executeUpdate();
            updateExercise7.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Transistors Intermediate
    public static void updateTransistorsIntermediate() {
        Connection connection;
        PreparedStatement updateExercise8;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            updateExercise8 = connection.prepareStatement("UPDATE users " +
                    "SET exercise8 = 1 " +
                    "WHERE username = ?");
            updateExercise8.setString(1, getCurrentUser());
            updateExercise8.executeUpdate();
            updateExercise8.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Transistors Advanced
    public static void updateTransistorsAdvanced() {
        Connection connection;
        PreparedStatement updateExercise9;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            updateExercise9 = connection.prepareStatement("UPDATE users " +
                    "SET exercise9 = 1 " +
                    "WHERE username = ?");
            updateExercise9.setString(1, getCurrentUser());
            updateExercise9.executeUpdate();
            updateExercise9.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Escape Room
    public static void updateEscapeRoom() {
        Connection connection;
        PreparedStatement updateExercise10;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            updateExercise10 = connection.prepareStatement("UPDATE users " +
                    "SET exercise10 = 1 " +
                    "WHERE username = ?");
            updateExercise10.setString(1, getCurrentUser());
            updateExercise10.executeUpdate();
            updateExercise10.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Populate admin table with user list
    public static ObservableList<User> userList(ObservableList<User> userList) throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codebug-db", "root", "");
            preparedStatement = connection.prepareStatement("SELECT user_id, username, user_email, user_password, is_admin, theme FROM users");
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assert resultSet != null;
        while (resultSet.next()) {
            userList.add(new User(resultSet.getString("user_id"), resultSet.getString("username"), resultSet.getString("user_email"), resultSet.getString("user_password"), resultSet.getString("is_admin"), resultSet.getString("theme")));
        }

        return userList;
    }
}