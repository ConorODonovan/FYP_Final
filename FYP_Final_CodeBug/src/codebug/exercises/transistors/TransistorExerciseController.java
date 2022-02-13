package codebug.exercises.transistors;

import codebug.exercises.exercisenodes.LogicGate;
import codebug.exercises.exercisenodes.Transistor;
import codebug.ui.Draggable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class TransistorExerciseController {

    @FXML
    Pane mainPane;
    @FXML
    Button buttonCreateTransistor;
    @FXML
    Button buttonCreateLogicGate;

    @FXML
    public void createTransistor() {
        Draggable draggable = new Draggable();
        Transistor transistor = new Transistor();
        draggable.makeDraggable(transistor);
        mainPane.getChildren().add(transistor);
    }

    @FXML
    public void createLogicGate() {
        Draggable draggable = new Draggable();
        LogicGate logicGate = new LogicGate();
        draggable.makeDraggable(logicGate);
        mainPane.getChildren().add(logicGate);
    }
}