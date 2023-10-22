package de.tum.in.ase.pse;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Driver extends Application {

    private static final int PADDING = 10;
    private static final int V_GAP = 8;
    private static final int H_GAP = 10;
    private static final int INDEX = 3;

    private static final int SCENE_WIDTH = 300;
    private static final int SCENE_HEIGHT = 130;
    private Switch lightSwitch;
    private Label lightLabel;

    public void init() {
        lightLabel = new Label("lamp");
        Light lamp = new Light(lightLabel);
        LightSwitchCommand switchUp = new FlipUpCommand(lamp);
        LightSwitchCommand switchDown = new FlipDownCommand(lamp);
        lightSwitch = new Switch(switchUp, switchDown);
    }

    public void buttonUpActionListener() {
        lightSwitch.flipUp();
    }

    public void buttonDownActionListener() {
        lightSwitch.flipDown();
    }

    @Override
    public void start(Stage stage) {

        VBox vbox = new VBox();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
        grid.setVgap(V_GAP);
        grid.setHgap(H_GAP);

        GridPane.setConstraints(lightLabel, 0, 1);

        Button buttonUp = new Button("Switch up");
        GridPane.setConstraints(buttonUp, 0, 2);
        buttonUp.setOnAction(event -> buttonUpActionListener());

        Button buttonDown = new Button("Switch down");
        GridPane.setConstraints(buttonDown, 0, INDEX);
        buttonDown.setOnAction(event -> buttonDownActionListener());

        grid.getChildren().addAll(lightLabel);
        grid.getChildren().addAll(buttonUp, buttonDown);
        vbox.getChildren().add(grid);

        Scene scene = new Scene(vbox, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setTitle("Driver");
        stage.setScene(scene);

        stage.show();

    }

    public static void startApp(String[] args) {
        launch(args);
    }
}
