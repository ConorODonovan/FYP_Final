/*
Conor O'Donovan - D18125705
Final Year Project
CodeBug
ExercisesController - Controls logic for Exercises Menu
 */

package codebug.gameengine;

import codebug.database.DBUtils;
import codebug.gameengine.gameobjects.Player;
import codebug.gameengine.gameobjects.Wall;
import codebug.ui.Draggable;
import codebug.ui.NavigationManager;
import codebug.ui.TopMenuBar;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GameEngineController {

    // Declaration of variables
    // Variables annotated with @FXML are UI elements
    @FXML
    Label usernameLabel;
    @FXML
    ImageView logoTop;

    // Game window
    @FXML
    Pane gameWindow;

    // Play and Clear Screen buttons
    @FXML
    Button playButton;
    @FXML
    Button buttonReset;

    // Is Object Selected label
    @FXML
    Label isObjectSelectedLabel;

    // Create objects
    @FXML
    Button createPlayerButton;
    @FXML
    Button createWallButton;

    // General properties
    @FXML
    ColorPicker colorPicker;
    @FXML
    Slider widthSlider;
    @FXML
    Slider heightSlider;
    @FXML
    Slider gravitySlider;

    // Movement properties
    @FXML
    Slider speedSlider;
    @FXML
    ChoiceBox<String> leftInputChoiceBox;
    @FXML
    ChoiceBox<String> rightInputChoiceBox;
    @FXML
    ChoiceBox<String> upInputChoiceBox;
    @FXML
    ChoiceBox<String> downInputChoiceBox;
    @FXML
    ChoiceBox<String> jumpInputChoiceBox;
    @FXML
    Slider jumpHeightSlider;

    // Save Properties buttons
    @FXML
    Button saveGeneralPropertiesButton;
    @FXML
    Button saveMovementPropertiesButton;

    @FXML
    MenuItem menuPreferences;
    @FXML
    MenuItem menuLogout;
    @FXML
    MenuItem menuExit;
    @FXML
    MenuItem menuAbout;

    // Other variables
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    private boolean gameState = false;
    private Node currentlySelected = null;
    private boolean objectSelected = false;
    private boolean cannotUnselect = false;
    private ObservableList<String> input = FXCollections.observableArrayList("None", "Left Arrow", "Right Arrow", "Up Arrow", "Down Arrow", "A", "D", "W", "S", "Space");
    private Draggable draggable = new Draggable();
    private ArrayList<Wall> platforms = new ArrayList<Wall>();
    private Player player;
    private Point2D playerVelocity = new Point2D(0, 0);
    private boolean canJump = true;

    // List of game objects
    private List<Node> allObjects() {
        return gameWindow.getChildren().stream().map(n -> (Node)n).collect(Collectors.toList());
    }

    // Initialize method runs on first opening the page
    @FXML
    private void initialize() {

        // Get user currently logged in
        String currentUser = DBUtils.getCurrentUser();

        // Sets label in top right to username
        if (currentUser == null) {
            usernameLabel.setText("Please log in");
        } else {
            usernameLabel.setText("Logged in as " + currentUser);
        }

        // Checks which theme the user last selected and ensures it is applied
        switch (DBUtils.getTheme()) {
            case "Default": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(236, 151, 6);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "Nature": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(82, 183, 136);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "Ocean": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(122, 191, 201);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "Dusk": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(246, 156, 153);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "Sunset": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(255, 111, 75);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "Monochrome": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(148, 148, 148);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
            case "High Contrast": {
                Lighting lighting = new Lighting();
                Color color = Color.rgb(255, 180, 0);
                lighting.setDiffuseConstant(1.0);
                lighting.setSpecularConstant(0.0);
                lighting.setSpecularExponent(0.0);
                lighting.setSurfaceScale(0.0);
                lighting.setLight(new Light.Distant(100, 100, color));
                logoTop.setEffect(lighting);

                break;
            }
        }

        // Set up Play Button
        playButton.setText("PLAY!");

        // Set up ChoiceBoxes
        leftInputChoiceBox.setItems(input);
        rightInputChoiceBox.setItems(input);
        upInputChoiceBox.setItems(input);
        downInputChoiceBox.setItems(input);
        jumpInputChoiceBox.setItems(input);
        unselectObject();
    }

    // Change game state from running to stopped
    @FXML
    public void changeGameState() {
        if (gameState) {
            gameState = false;
//            playButton.setGraphic(viewPlay);
            playButton.setText("PLAY!");
            a.stop();
        } else {
            gameState = true;
//            playButton.setGraphic(viewStop);
            playButton.setText("STOP");
            a.start();
        }

        System.out.println("Game State: " + gameState);
    }

    // Clears game window of objects
    @FXML
    private void reset() {
        allObjects().clear();
        gameWindow.getChildren().clear();
        platforms.clear();
    }

    @FXML
    public void unselectObject() {
        gameWindow.setPickOnBounds(false);

        if (!cannotUnselect) {
            objectSelected = false;
            updateObjectProperties();
            System.out.println("Object selected: " + objectSelected);

            // Deselecting object by clicking in window
            allObjects().forEach(s -> {
                if (objectSelected == false) {
                    s.setEffect(null);

                    updateObjectProperties();
                    getObjectProperties(s);
                }
            });
        }
    }

    // Runs every frame
    private void update() {
        gameWindow.requestFocus();

        allObjects().forEach(s -> {
            s.setOnMouseEntered(e -> cannotUnselect = true);
            s.setOnMouseExited(e -> cannotUnselect = false);
        });

        // Collision and movement
        if (isPressed(getKeyJump(jumpInputChoiceBox.getValue())) && player.getTranslateY() >= jumpHeightSlider.getValue()) {
            jumpPlayer();
        }

        if (isPressed(getKeyLeft(player.getMoveLeft()))) {
            movePlayerX(-((int) player.getSpeed()));
        }

        if (isPressed(getKeyRight(rightInputChoiceBox.getValue()))) {
            movePlayerX((int) player.getSpeed());
        }

        if (playerVelocity.getY() < player.getGravity()) {
            playerVelocity = playerVelocity.add(0, player.getGravity());
        }

        movePlayerY((int)playerVelocity.getY());
    }

    // Player movement and collision - horizontal
    private void movePlayerX(int value) {
        boolean movingRight = value > 0;

        for (int i = 0; i < Math.abs(value); i++) {
            for (Wall platform: platforms) {
                if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingRight) {
                        if (player.getTranslateX() + player.getWidth() == platform.getTranslateX()) {
                            return;
                        }
                    } else {
                        if (player.getTranslateX() == platform.getTranslateX() + platform.getWidth()) {
                            return;
                        }
                    }
                }
            }
            player.setTranslateX(player.getTranslateX() + (movingRight ? 1 : -1));
        }
    }

    // Player movement and collision - vertical
    private void movePlayerY(int value) {
        boolean movingDown = value > 0;

        for (int i = 0; i < Math.abs(value); i++) {
            for (Wall platform : platforms) {
                if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingDown) {
                        if (player.getTranslateY() + player.getWidth() == platform.getTranslateY()) {
                            player.setTranslateY(player.getTranslateY() - 1);
                            canJump = true;
                            return;
                        }
                    } else {
                        if (player.getTranslateY() == platform.getTranslateY() + platform.getHeight()) {
                            return;
                        }
                    }
                }
            }
            player.setTranslateY(player.getTranslateY() + (movingDown ? 1 : -1));
        }
    }

    // Player jump
    private void jumpPlayer() {
        if (canJump) {
            playerVelocity = playerVelocity.add(0, -player.getJumpHeight());
            canJump = false;
        }
    }

    // Sets up an AnimationTimer (JavaFX component) which allows a method (in this case, update()) to be called every frame
    private AnimationTimer a = new AnimationTimer() {

        @Override
        public void handle(long currentNanoTime) {
            gameWindow.setOnKeyPressed(e -> keys.put(e.getCode(), true));
            gameWindow.setOnKeyReleased(e -> keys.put(e.getCode(), false));
            update();
        }
    };

    // Create a player object in the game window
    @FXML
    public void createPlayer() {
        player = new Player(200.0, 200.0, 100.0, 100.0, Color.BLUE, 0.0, 0.0, "None", "None", "None", "None", "None", 0.0, "None");
        player.setFill(Color.GREEN);
        player.setStroke(Color.BLACK);
        draggable.makeDraggable(player);
        gameWindow.getChildren().add(player);

        player.setOnMouseEntered(e -> cannotUnselect = true);
        player.setOnMouseExited(e -> cannotUnselect = false);

        player.setOnMouseClicked(e -> {
            objectSelected = true;
            currentlySelected = player.getSelected();

            allObjects().forEach(s -> {
                if (s == currentlySelected) {
                    DropShadow borderGlow = new DropShadow();
                    borderGlow.setOffsetY(0f);
                    borderGlow.setOffsetX(0f);
                    borderGlow.setColor(Color.RED);
                    borderGlow.setWidth(60);
                    borderGlow.setHeight(60);
                    s.setEffect(borderGlow);
                }
                else {
                    s.setEffect(null);
                }
            });

            updateObjectProperties();
            getObjectProperties(currentlySelected);
            System.out.println("Current Object Selected: " + currentlySelected); // For testing
        });
    }

    // Create a wall object in the game window
    @FXML
    public void createWall() {
        Wall wall = new Wall(200.0, 200.0, 100.0, 100.0, Color.GREY);
        draggable.makeDraggable(wall);
        wall.setFill(Color.GREY);
        wall.setStroke(Color.BLACK);
        gameWindow.getChildren().add(wall);
        platforms.add(wall);

        wall.setOnMouseEntered(e -> cannotUnselect = true);
        wall.setOnMouseExited(e -> cannotUnselect = false);

        wall.setOnMouseClicked(e -> {
            objectSelected = true;
            currentlySelected = wall.getSelected();

            allObjects().forEach(s -> {
                if (s == currentlySelected) {
                    DropShadow borderGlow = new DropShadow();
                    borderGlow.setOffsetY(0f);
                    borderGlow.setOffsetX(0f);
                    borderGlow.setColor(Color.RED);
                    borderGlow.setWidth(60);
                    borderGlow.setHeight(60);
                    s.setEffect(borderGlow);
                }
                else {
                    s.setEffect(null);
                }
            });

            updateObjectProperties();
            getObjectProperties(currentlySelected);
            System.out.println("Current Object Selected: " + currentlySelected); // For testing
        });
    }

    // Show object properties fields
    @FXML
    private void updateObjectProperties() {

        if (!objectSelected) {
            isObjectSelectedLabel.setText("Please select an object");

            gravitySlider.setDisable(true);
            gravitySlider.setValue(0);
            speedSlider.setDisable(true);
            speedSlider.setValue(0);
            leftInputChoiceBox.setDisable(true);
            leftInputChoiceBox.setValue("None");
            rightInputChoiceBox.setDisable(true);
            rightInputChoiceBox.setValue("None");
            upInputChoiceBox.setDisable(true);
            upInputChoiceBox.setValue("None");
            downInputChoiceBox.setDisable(true);
            downInputChoiceBox.setValue("None");
            jumpInputChoiceBox.setDisable(true);
            jumpInputChoiceBox.setValue("None");
            jumpHeightSlider.setDisable(true);
            jumpHeightSlider.setValue(0);
            widthSlider.setDisable(true);
            heightSlider.setDisable(true);
            colorPicker.setDisable(true);
            colorPicker.setValue(Color.WHITE);
            saveGeneralPropertiesButton.setDisable(true);
            saveMovementPropertiesButton.setDisable(true);

            System.out.println("objectSelected = " + objectSelected); // For testing
        } else {
            isObjectSelectedLabel.setText("Object selected!");

            if (currentlySelected.getClass() == Player.class) {

                gravitySlider.setDisable(false);
                speedSlider.setDisable(false);
                leftInputChoiceBox.setDisable(false);
                rightInputChoiceBox.setDisable(false);
                upInputChoiceBox.setDisable(false);
                downInputChoiceBox.setDisable(false);
                jumpInputChoiceBox.setDisable(false);
                jumpHeightSlider.setDisable(false);
                widthSlider.setDisable(false);
                heightSlider.setDisable(false);
                colorPicker.setDisable(false);
                saveGeneralPropertiesButton.setDisable(false);
                saveMovementPropertiesButton.setDisable(false);

            } else if (currentlySelected.getClass() == Wall.class) {

                gravitySlider.setDisable(true);
                gravitySlider.setValue(0);
                speedSlider.setDisable(true);
                speedSlider.setValue(0);
                leftInputChoiceBox.setDisable(true);
                leftInputChoiceBox.setValue("None");
                rightInputChoiceBox.setDisable(true);
                rightInputChoiceBox.setValue("None");
                upInputChoiceBox.setDisable(true);
                upInputChoiceBox.setValue("None");
                downInputChoiceBox.setDisable(true);
                downInputChoiceBox.setValue("None");
                jumpInputChoiceBox.setDisable(true);
                jumpInputChoiceBox.setValue("None");
                jumpHeightSlider.setDisable(true);
                jumpHeightSlider.setValue(0);
                widthSlider.setDisable(false);
                heightSlider.setDisable(false);
                colorPicker.setDisable(false);
                saveGeneralPropertiesButton.setDisable(false);
                saveMovementPropertiesButton.setDisable(false);
            }

            System.out.println("objectSelected = " + objectSelected); // For testing
        }
    }

    // Get object properties
    @FXML
    private void getObjectProperties(Node currentlySelected) {
        if (currentlySelected.getClass() == Player.class) {

            double gravity = player.getGravity();
            gravitySlider.setValue(gravity);

            double speed = player.getSpeed();
            speedSlider.setValue(speed);

            String moveLeft = player.getMoveLeft();
            leftInputChoiceBox.setValue(moveLeft);

            String moveRight = player.getMoveRight();
            rightInputChoiceBox.setValue(moveRight);

            String moveUp = player.getMoveUp();
            upInputChoiceBox.setValue(moveUp);

            String moveDown = player.getMoveDown();
            downInputChoiceBox.setValue(moveDown);

            String jumpKey = player.getJump();
            jumpInputChoiceBox.setValue(jumpKey);

            double jumpHeight = player.getJumpHeight();
            jumpHeightSlider.setValue(jumpHeight);

            double width = player.getWidth();
            widthSlider.setValue(width / 100);

            double height = player.getHeight();
            heightSlider.setValue(height / 100);

            Color color = player.getColor();
            colorPicker.setValue(color);

        } else if (currentlySelected.getClass() == Wall.class) {

            for (Wall platform : platforms) {

                double width = platform.getWidth();
                widthSlider.setValue(width / 100);

                double height = platform.getHeight();
                heightSlider.setValue(height / 100);

                Color color = platform.getColor();
                colorPicker.setValue(color);
            }
        }
    }

    // Set object properties
    @FXML
    private void setObjectProperties(Node currentlySelected) {
        if (currentlySelected.getClass() == Player.class) {

            System.out.println("Saving for" + currentlySelected);
            player.setGravity(gravitySlider.getValue());
            player.setSpeed(speedSlider.getValue());
            player.setMoveLeft(leftInputChoiceBox.getValue());
            player.setMoveRight(rightInputChoiceBox.getValue());
            player.setMoveUp(upInputChoiceBox.getValue());
            player.setMoveDown(downInputChoiceBox.getValue());
            player.setJump(jumpInputChoiceBox.getValue());
            player.setJumpHeight(jumpHeightSlider.getValue());
            player.setWidth(widthSlider.getValue() * 100);
            player.setHeight(heightSlider.getValue() * 100);
            player.setColor(colorPicker.getValue());

        } else {

            if (currentlySelected.getClass() == Wall.class) {

                for (Wall platform : platforms) {

                    if (currentlySelected == platform) {
                        platform.setWidth(widthSlider.getValue() * 100);
                        platform.setHeight(heightSlider.getValue() * 100);
                        platform.setColor(colorPicker.getValue());
                    }
                }
            }
        }
    }

    // Save object properties
    @FXML
    public void saveObjectProperties() {
        setObjectProperties(currentlySelected);
    }

    // Key codes
    @FXML
    private KeyCode getKeyCode(String s) {
        KeyCode key = null;

        switch(s) {
            case "None":
                key = null;
                break;
            case "Left Arrow":
                key = KeyCode.LEFT;
                break;
            case "Right Arrow":
                key = KeyCode.RIGHT;
                break;
            case "Up Arrow":
                key = KeyCode.UP;
                break;
            case "Down Arrow":
                key = KeyCode.DOWN;
                break;
            case "A":
                key = KeyCode.A;
                break;
            case "D":
                key = KeyCode.D;
                break;
            case "W":
                key = KeyCode.W;
                break;
            case "S":
                key = KeyCode.S;
                break;
            case "Space":
                key = KeyCode.SPACE;
        }
        return key;
    }

    private KeyCode getKeyLeft(String s) {
        KeyCode leftInput;
        leftInput = getKeyCode(s);
        return leftInput;
    }

    private KeyCode getKeyRight(String s) {
        KeyCode rightInput;
        rightInput = getKeyCode(s);
        return rightInput;
    }

    public KeyCode getKeyUp(String s) {
        KeyCode upInput;
        upInput = getKeyCode(s);
        return upInput;
    }

    public KeyCode getKeyDown(String s) {
        KeyCode downInput;
        downInput = getKeyCode(s);
        return downInput;
    }

    private KeyCode getKeyJump(String s) {
        KeyCode jumpInput;
        jumpInput = getKeyCode(s);
        return jumpInput;
    }

    private boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    // Return to main menu by clicking logo
    @FXML
    public void goToMainMenu() {
        NavigationManager.goToMainMenuNoButton(logoTop);
    }

    // Top Menu Bar functionality
    // Open Settings Screen
    @FXML
    public void openSettingsWindow() throws Exception {
        TopMenuBar.openSettingsWindow();
    }

    // Open About screen
    @FXML
    public void openAboutWindow() throws Exception {
        TopMenuBar.openAboutWindow();
    }

    // Logout
    @FXML
    public void logout() throws IOException {
        Parent root = FXMLLoader.load(NavigationManager.class.getResource("/codebug/login/Login.fxml"));
        Stage stage = (Stage) logoTop.getScene().getWindow();
        Scene scene = new Scene(root, 1920, 1080);
        DBUtils.setCurrentUser(null);
        stage.setScene(scene);
        stage.show();
    }

    // Exit application
    @FXML
    public void exitApplication() {
        TopMenuBar.exitApplication();
    }
}