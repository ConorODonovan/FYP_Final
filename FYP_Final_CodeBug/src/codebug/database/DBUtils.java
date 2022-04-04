package codebug.database;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import java.sql.*;

public class DBUtils {

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
                        "VALUES (?, ?, ?, 0, 'default', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)");
                psInsert.setString(1, username);
                psInsert.setString(2, email);
                psInsert.setString(3, password);
                psInsert.executeUpdate();

                // TODO
                // Add action on registration here - return true?
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

    public static boolean loginUser(String username, String password) {
        System.out.println("Connecting...");

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
}
