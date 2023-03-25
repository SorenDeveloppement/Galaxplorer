package fr.galaglow.scenes.components;

import fr.galaglow.Main;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.File;
import java.util.Objects;

public class FlatFileCard {

    public FlatFileCard(Pane pane, double x, double y, File file) {

        if(y < 40d) y = 40d;
        if(x < 0d) x = 0d;

        Rectangle card = new Rectangle();

        card.setTranslateX(x);
        card.setTranslateY(y);
        card.setWidth(150);
        card.setHeight(20);
        card.setFill(Color.valueOf("#272727"));
        card.getStyleClass().add("flatFileCard");

        HBox box = new HBox();

        box.setMinWidth(150);
        box.setMinHeight(20);
        box.setMaxWidth(150);
        box.setMaxHeight(20);
        box.setTranslateX(x);
        box.setTranslateY(y);
        box.setAlignment(Pos.BASELINE_LEFT);

        box.setOnMouseClicked(event -> System.out.println("Clicked !"));

        Text fileName = new Text(file.getName());
        fileName.setStyle("-fx-font-size: 15px;  -fx-font-family: regular;");
        fileName.setFill(Color.WHITE);
        fileName.setTranslateX(15);

        ImageView icon = new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/icons/logo.png")).toExternalForm(), 18, 18, false, false));

        box.getChildren().addAll(icon, fileName);
        pane.getChildren().addAll(card, box);
    }
}
