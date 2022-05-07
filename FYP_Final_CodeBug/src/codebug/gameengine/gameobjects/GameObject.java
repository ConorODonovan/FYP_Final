/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
GameObject Class - Parent class for all game objects
 */

package codebug.gameengine.gameobjects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

// Parent game engine object
// All other game objects inherit from this

public class GameObject extends Rectangle {

    private Color color;

    GameObject(double x, double y, double height, double width, Color color) {

        super(x, y, height, width);

        this.color = color;
    }

    public GameObject getSelected() {
        return this;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
        this.setFill(newColor);
    }
}
