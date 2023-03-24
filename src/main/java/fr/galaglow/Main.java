package fr.galaglow;

import fr.galaglow.scenes.MainScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class Main extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;

        stage.getIcons().add(new Image(Objects.requireNonNull(this.getClass().getResource("/icons/logo.png")).toExternalForm()));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setTitle("Galaxplorer");
        setScene(MainScene.get());
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setScene(Scene scene) {
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}