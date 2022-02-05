module JavaFX.Tests {

    requires javafx.fxml;
    requires javafx.controls;
    requires AnimateFX;
    requires java.logging;

    opens codebug.exercises;
    opens codebug.exercises.binaryconverter;
    opens codebug.exercises.transistors;
    opens codebug.exercises.ciphers;
    opens codebug.exercises.cpuramrom;
    opens codebug.exercises.functions;
    opens codebug.gameengine;
    opens codebug.login;
    opens codebug.homepage;
    opens codebug;
}