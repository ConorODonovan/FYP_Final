package codebug.exercises.exercisenodes;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Transistor extends AnchorPane {

    public Transistor() {
        Rectangle rec = new Rectangle();
        rec.setFill(Color.LIGHTBLUE);
        rec.setStroke(Color.BLACK);
        rec.setStrokeWidth(2);
        rec.setWidth(100);
        rec.setHeight(100);

        Circle left = new Circle();
        left.setRadius(8);
        left.setFill(Color.GREEN);
        left.setStroke(Color.BLACK);
        left.setStrokeWidth(2);

        Circle right = new Circle();
        right.setRadius(8);
        right.setFill(Color.GREEN);
        right.setStroke(Color.BLACK);
        right.setStrokeWidth(2);

        this.getChildren().add(rec);
        this.getChildren().add(left);
        this.getChildren().add(right);

        setTopAnchor(left, 42.0);
        setTopAnchor(right, 42.0);
        setLeftAnchor(left, -8.0);
        setRightAnchor(right, -8.0);
    }
}