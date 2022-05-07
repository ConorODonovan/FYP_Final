/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
AdminController - Controls logic for Admin page
Admin page is only available for Admin users
 */

package codebug.admin;

import codebug.database.DBUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class AdminController {

    // Declaration of variables
    // Variables annotated with @FXML are UI elements
    @FXML
    private TableView<User> adminTable;
    @FXML
    private TableColumn<User, String> colUserID;
    @FXML
    private TableColumn<User, String> colUsername;
    @FXML
    private TableColumn<User, String> colEmailAddress;
    @FXML
    private TableColumn<User, String> colPassword;
    @FXML
    private TableColumn<User, String> colAdminUser;
    @FXML
    private TableColumn<User, String> colThemeSelected;

    private ObservableList<User> userList = FXCollections.observableArrayList();

    // Initialize method runs on first opening the page
    @FXML
    private void initialize() throws SQLException {

        // Sets up the cells in the table view so they can display data from the data base
        colUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colEmailAddress.setCellValueFactory(new PropertyValueFactory<>("userEmail"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("userPassword"));
        colAdminUser.setCellValueFactory(new PropertyValueFactory<>("userAdmin"));
        colThemeSelected.setCellValueFactory(new PropertyValueFactory<>("userTheme"));

        // Calls the method from the DBUtils (database handler) class to return the user data to populate the TableView
        adminTable.setItems(DBUtils.userList(userList));
    }
}
