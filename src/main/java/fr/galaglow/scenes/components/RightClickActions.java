package fr.galaglow.scenes.components;

import fr.galaglow.builtin.FileOrganizer;
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
            box.setOpacity(100);
            box.setFocusTraversable(false);
            // TODO actualiser les fichiers modifiés
            System.out.println("Clicked !");
            FileRenamer renamer = new FileRenamer();
            // TODO choisir le nv nom du fichier
            TextInputBox tib = new TextInputBox(pane, "Enter the name");
            tib.getValidateButton().setOnMouseClicked(e -> {
                int ext = file.getName().lastIndexOf(".");

                if (ext != -1) {
                    renamer.init(file.getAbsoluteFile().toString(), tib.getTextArea().getText() + file.getName().substring(ext));
                } else {
                    renamer.init(file.getAbsoluteFile().toString(), tib.getTextArea().getText());
                }
                renamer.execute();
                tib.destroy();
            });
            box.setOpacity(0);
            box.setFocusTraversable(true);
        });

        HBox separator = new HBox();
        separator.setTranslateY(2);
        separator.setMaxHeight(box.getWidth());
        separator.setMaxHeight(1);
        separator.setStyle("-fx-border-color: white transparent transparent transparent;");

        Text organizeFileText = new Text("Organize files");
        organizeFileText.setTranslateX(10);
        organizeFileText.setFill(Color.WHITE);
        organizeFileText.setFont(Font.font("Poppins", FontWeight.NORMAL, 16));

        organizeFileText.setOnMouseClicked(event -> {
            box.setOpacity(100);
            box.setFocusTraversable(false);

            // TODO actualiser les fichiers modifiés
            System.out.println("Clicked !");
            FileOrganizer organizer = new FileOrganizer();

            // TODO choisir le nv nom du fichier
            organizer.init(file.getAbsoluteFile().toString());
            organizer.execute();

            box.setOpacity(0);
            box.setFocusTraversable(true);
        });

        HBox separator_two = new HBox();
        separator_two.setTranslateY(2);
        separator_two.setMaxHeight(box.getWidth());
        separator_two.setMaxHeight(1);
        separator_two.setStyle("-fx-border-color: white transparent transparent transparent;");

        box.getChildren().addAll(renameFileText, separator, organizeFileText, separator_two);

        pane.getChildren().addAll(box);
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}