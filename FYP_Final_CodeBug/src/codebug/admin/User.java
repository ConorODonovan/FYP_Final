/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
User class - creates a user object storing all of the user data for population in the TableView on the Admin page
 */

package codebug.admin;

public class User {

    String userID, userName, userEmail, userPassword, userAdmin, userTheme;

    public User(String userID, String userName, String userEmail, String userPassword, String userAdmin, String userTheme) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAdmin = userAdmin;
        this.userTheme = userTheme;
    }

    // Getters and Setters
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }

    public String getUserTheme() {
        return userTheme;
    }

    public void setUserTheme(String userTheme) {
        this.userTheme = userTheme;
    }
}
