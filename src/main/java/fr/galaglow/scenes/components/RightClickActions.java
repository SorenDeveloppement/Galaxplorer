package fr.galaglow.scenes.components;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RightClickActions {
    private double x;
    private double y;

    public RightClickActions(Pane pane, double x, double y) {
        this.x = x;
        this.y = y;

        VBox box = new VBox();
        box.setTranslateX(x);
        box.setTranslateY(y);
        box.setPrefSize(200, 200);
        box.setStyle("-fx-background-color: #272727; -fx-border-color: #000 #000 #000 #000;");

        Text renameFileText = new Text("Rename file");
        renameFileText.setFill(Color.WHITE);
        renameFileText.setFont(Font.font("Poppins", FontWeight.NORMAL, 12));

        box.getChildren().addAll(renameFileText);

        pane.getChildren().addAll(box);
    }
}