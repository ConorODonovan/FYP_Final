module JavaFX.Tests {

    requires javafx.fxml;
    requires javafx.controls;

    opens codebug.login;
    opens codebug.homepage;
    opens codebug;
}