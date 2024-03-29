module JavaFX.Tests {

    requires javafx.fxml;
    requires javafx.controls;
    requires AnimateFX;
    requires java.logging;
    requires java.sql;

    opens codebug.play;
    opens codebug.themes;
    opens codebug.settings;
    opens codebug.about;
    opens codebug.exercises;
    opens codebug.exercises.numbers;
    opens codebug.exercises.numbers.beginner;
    opens codebug.exercises.numbers.intermediate;
    opens codebug.exercises.numbers.advanced;
    opens codebug.exercises.ciphers;
    opens codebug.exercises.ciphers.beginner;
    opens codebug.exercises.ciphers.intermediate;
    opens codebug.exercises.ciphers.advanced;
    opens codebug.exercises.transistors;
    opens codebug.exercises.transistors.beginner;
    opens codebug.exercises.transistors.intermediate;
    opens codebug.exercises.transistors.advanced;
    opens codebug.exercises.escaperoom;
    opens codebug.gameengine;
    opens codebug.login;
    opens codebug.homepage;
    opens codebug.admin;
    opens codebug;
}