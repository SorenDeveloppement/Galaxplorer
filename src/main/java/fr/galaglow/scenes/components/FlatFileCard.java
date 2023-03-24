package fr.galaglow.scenes.components;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.File;

public class FlatFileCard {
    public FlatFileCard(Pane pane, double x, double y, File file) {

        if(y < 40d) y = 40d;
        if(x < 40d) x = 40d;

        Rectangle card = new Rectangle();

        card.setTranslateX(x);
        card.setTranslateY(y);
        card.setWidth(150);
        card.setHeight(20);
        card.getStyleClass().add("flatFileCard");

        Region button = new Region();

        button.setPrefSize(card.getWidth(), card.getHeight());
        button.setTranslateX(x);
        button.setTranslateY(y);
        button.getStyleClass().add("goToFileButton");

        HBox box = new HBox();

        box.setPrefSize(card.getWidth(), card.getHeight());
        box.setTranslateX(x);
        box.setTranslateY(y);
        box.setAlignment(Pos.BASELINE_CENTER);

        Text fileName = new Text(file.getName());
        fileName.setStyle("-fx-font-size: 18px; -fx-font-familly: regular;");
        fileName.setFill(Color.WHITE);

        box.getChildren().add(fileName);

        pane.getChildren().addAll(card, button, box);
    }
}
