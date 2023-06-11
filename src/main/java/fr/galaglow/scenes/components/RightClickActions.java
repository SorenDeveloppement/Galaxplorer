package fr.galaglow.scenes.components;

import fr.galaglow.builtin.FileRenamer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class RightClickActions extends Group {
    private double x;
    private double y;

    public RightClickActions(Pane pane, File file, double x, double y) {
        this.x = x;
        this.y = y;

        VBox box = new VBox();
        box.setTranslateX(x);
        box.setTranslateY(y);
        box.setPrefSize(200, 200);
        box.setStyle("-fx-background-color: #272727; -fx-border-color: #000 #000 #000 #000;");

        Text renameFileText = new Text("Rename file");
        renameFileText.setTranslateX(10);
        renameFileText.setFill(Color.WHITE);
        renameFileText.setFont(Font.font("Poppins", FontWeight.NORMAL, 16));

        renameFileText.setOnMouseClicked(event -> {
            // TODO actualiser les fichiers modifiés
            System.out.println("Clicked !");
            FileRenamer renamer = new FileRenamer();
            // TODO choisir le nv nom du fichier
            renamer.init(file.getAbsoluteFile().toString(), "test" + file.getName().substring(file.getName().lastIndexOf(".")));
            renamer.execute();
        });

        HBox separator = new HBox();
        separator.setTranslateY(2);
        separator.setMaxHeight(box.getWidth());
        separator.setMaxHeight(1);
        separator.setStyle("-fx-border-color: white transparent transparent transparent;");

        box.getChildren().addAll(renameFileText, separator);

        pane.getChildren().addAll(box);
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}