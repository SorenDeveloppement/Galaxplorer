package fr.galaglow.scenes;

import fr.galaglow.scenes.components.BackDirButton;
import fr.galaglow.scenes.components.FlatFileCard;
import fr.galaglow.scenes.components.Separator;
import fr.galaglow.scenes.components.TopBar;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.File;

import static fr.galaglow.helper.Constants.STAGE;

public class MainScene {

    private static final Pane pane = new Pane();
    private static final Scene scene = new Scene(pane, 1080, 720);

    private static boolean loaded = false;

    public static Scene get() {

        pane.setStyle("-fx-background-color: #272727;");

        if(!loaded) {
            addElements();
            addStyleSheets();

            loaded = true;
        }

        return scene;
    }

    private static void addStyleSheets() {
        // pane.getStylesheets().add(Objects.requireNonNull(App.class.getResource("/css/file.css")).toExternalForm());
    }

    private static void addElements() {
        new FlatFileCard(pane,5, 60, new File(System.getProperty("user.home") + "/Desktop"));
        new FlatFileCard(pane,5, 85, new File(System.getProperty("user.home") + "/Documents"));
        new FlatFileCard(pane,5, 110, new File(System.getProperty("user.home") + "/Downloads"));
        new FlatFileCard(pane,5, 135, new File(System.getProperty("user.home") + "/Music"));
        new BackDirButton(pane, 5, 710);
        new Separator(pane, 200, 0);
        new TopBar(pane, STAGE);
    }

    public static Pane getPane() {
        return pane;
    }

}
