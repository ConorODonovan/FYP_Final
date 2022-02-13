package codebug.exercises.exercisenodes;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Transistor extends AnchorPane {

    public Transistor() {
        Rectangle rec = new Rectangle();
        rec.setFill(Color.LIGHTGREY);
        rec.setWidth(100);
        rec.setHeight(100);

        Rectangle recLeft = new Rectangle();
        recLeft.setWidth(20);
        recLeft.setHeight(100);
        recLeft.setFill(Color.ORANGE);

        Rectangle recRight = new Rectangle();
        recRight.setWidth(20);
        recRight.setHeight(100);
        recRight.setFill(Color.ORANGE);

        this.getChildren().add(rec);
        this.getChildren().add(recLeft);
        this.getChildren().add(recRight);

        setTopAnchor(recLeft, 0.0);
        setLeftAnchor(recLeft, -20.0);
        setTopAnchor(recRight, 0.0);
        setRightAnchor(recRight, -20.0);
    }
}