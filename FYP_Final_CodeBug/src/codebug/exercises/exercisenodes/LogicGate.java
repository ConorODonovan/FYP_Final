package codebug.exercises.exercisenodes;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class LogicGate extends AnchorPane {

    public LogicGate() {
        Rectangle rec = new Rectangle();
        rec.setFill(Color.ORANGE);
        rec.setStroke(Color.BLACK);
        rec.setStrokeWidth(2);
        rec.setWidth(100);
        rec.setHeight(100);

        Circle leftTop = new Circle();
        leftTop.setRadius(8);
        leftTop.setFill(Color.GREEN);
        leftTop.setStroke(Color.BLACK);
        leftTop.setStrokeWidth(2);

        Circle leftBottom = new Circle();
        leftBottom.setRadius(8);
        leftBottom.setFill(Color.GREEN);
        leftBottom.setStroke(Color.BLACK);
        leftBottom.setStrokeWidth(2);

        Circle rightTop = new Circle();
        rightTop.setRadius(8);
        rightTop.setFill(Color.GREEN);
        rightTop.setStroke(Color.BLACK);
        rightTop.setStrokeWidth(2);

        Circle rightBottom = new Circle();
        rightBottom.setRadius(8);
        rightBottom.setFill(Color.GREEN);
        rightBottom.setStroke(Color.BLACK);
        rightBottom.setStrokeWidth(2);

        this.getChildren().add(rec);
        this.getChildren().add(leftTop);
        this.getChildren().add(leftBottom);
        this.getChildren().add(rightTop);
        this.getChildren().add(rightBottom);

        setTopAnchor(leftTop, 22.0);
        setTopAnchor(leftBottom, 62.0);

        setLeftAnchor(leftTop, -8.0);
        setLeftAnchor(leftBottom, -8.0);

        setTopAnchor(rightTop, 22.0);
        setTopAnchor(rightBottom, 62.0);

        setRightAnchor(rightTop, -8.0);
        setRightAnchor(rightBottom, -8.0);
    }
}
