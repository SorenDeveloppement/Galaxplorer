package fr.galaglow.scenes.components;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Separator {
    public Separator(Pane pane, double x, double y) {
        HBox sep = new HBox();

        sep.setTranslateX(x);
        sep.setTranslateY(y);
        sep.setMinHeight(pane.getHeight());
        sep.setMaxWidth(1);
        sep.setStyle("-fx-border-color: transparent linear-gradient(to top, transparent, white, white, transparent) transparent transparent;");

        pane.getChildren().add(sep);
    }
}
