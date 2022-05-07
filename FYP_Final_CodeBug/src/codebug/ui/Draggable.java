/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
Draggable Class - Allows JavaFX to be made draggable with the mouse
 */

package codebug.ui;

import javafx.scene.Node;

public class Draggable {

    private double startX;
    private double startY;

    // Call this method and add any node as a parameter to make the node draggable
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