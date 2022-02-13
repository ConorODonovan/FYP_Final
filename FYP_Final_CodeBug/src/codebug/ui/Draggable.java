package codebug.ui;

import javafx.scene.Node;

public class Draggable {

    private double startX;
    private double startY;

    public void makeDraggable(Node node) {
        node.setOnMousePressed(mouseEvent -> {
            if (mouseEvent.isPrimaryButtonDown()) {
                startX = mouseEvent.getSceneX() - node.getTranslateX();
                startY = mouseEvent.getSceneY() - node.getTranslateY();
            }
        });

        node.setOnMouseDragged(mouseEvent -> {
            if (mouseEvent.isPrimaryButtonDown()) {
                node.setTranslateX(mouseEvent.getSceneX() - startX);
                node.setTranslateY(mouseEvent.getSceneY() - startY);
            }
        });
    }
}