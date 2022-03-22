package codebug.gameengine.gameobjects;

import javafx.scene.paint.Color;

public class Player extends GameObject {

    private double gravity;
    private double speed;
    private String moveLeft;
    private String moveRight;
    private String moveUp;
    private String moveDown;
    private String jump;
    private double jumpHeight;
    private String shoot;

    Player(double x, double y, double height, double width, Color color, double gravity, double speed, String moveLeft, String moveRight, String moveUp, String moveDown, String jump, double jumpHeight, String shoot) {
        super(x, y, height, width, color);
    }

    double getGravity() {
        return gravity;
    }

    void setGravity(double newGravity) {
        this.gravity = newGravity;
    }

    double getSpeed() {
        return speed;
    }

    void setSpeed(double newSpeed) {
        this.speed = newSpeed;
    }

    public String getMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(String newMoveLeft) {
        this.moveLeft = newMoveLeft;
    }

    public String getMoveRight() {
        return moveRight;
    }

    public void setMoveRight(String newMoveRight) {
        this.moveRight = newMoveRight;
    }

    public String getMoveUp() {
        return moveUp;
    }

    public void setMoveUp(String newMoveUp) {
        this.moveUp = newMoveUp;
    }

    public String getMoveDown() {
        return moveDown;
    }

    public void setMoveDown(String newMoveDown) {
        this.moveDown = newMoveDown;
    }

    public String getJump() {
        return jump;
    }

    void setJump(String newJump) {
        this.jump = newJump;
    }

    double getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(double newJumpHeight) {
        this.jumpHeight = newJumpHeight;
    }

    public String getShoot() {
        return shoot;
    }

    public void setShoot(String newShoot) {
        this.shoot = newShoot;
    }
}