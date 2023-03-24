package fr.galaglow.scenes;

import fr.galaglow.scenes.components.FlatFileCard;
import fr.galaglow.scenes.components.TopBar;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        new FlatFileCard(pane, 10, 10, new File(System.getProperty("user.home") + "/Desktop"));
        new TopBar(pane, STAGE);
    }

}
