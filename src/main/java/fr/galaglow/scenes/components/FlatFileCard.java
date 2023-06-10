package fr.galaglow.scenes.components;

import fr.galaglow.Main;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static fr.galaglow.helper.Constants.FILE_LIST;

public class FlatFileCard extends Group {

    public FlatFileCard(Pane pane, double x, double y, File file) {

        if(y < 40d) y = 40d;
        if(x < 0d) x = 0d;

        HBox box = new HBox();

        box.setMinWidth(200);
        box.setMinHeight(20);
        box.setMaxHeight(20);
        box.setTranslateX(x);
        box.setTranslateY(y);
        box.setAlignment(Pos.BASELINE_LEFT);
        box.setStyle("-fx-border-color: transparent transparent linear-gradient(to right, transparent, transparent, white, white, white, transparent, transparent) transparent; -fx-background-color: #272727;");

        box.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                System.out.println("Clicked on " + file);
                if (file.isDirectory()) {
                /* System.out.println("Dir");
                for (File f : Objects.requireNonNull(file.listFiles())) {
                    System.out.println("Name : " + f.getName() + "\nPath : " + f.getAbsolutePath() + "\nSize : " + f.length() + "o");
                    System.out.println("----------------------------------------");
                } */

                    FILE_LIST.clear();
                    FILE_LIST.setFiles(file.listFiles());
                    FILE_LIST.show();
                } else {
                    System.out.println("File");
                }
            } else if (event.getButton().equals(MouseButton.SECONDARY)) {
                System.out.println("Right click !");
            }
        });

        String fName;
        if (file.getName().length() >= 18) {
            fName = file.getName().substring(0, 18) + "…";
        } else fName = file.getName();
        Text fileName = new Text(fName);
        fileName.setStyle("-fx-font-size: 15px;  -fx-font-family: regular;");
        fileName.setFill(Color.WHITE);
        fileName.setTranslateX(15);
        fileName.setTranslateY(-5);

        String[] codeFileType = new String[] {".java", ".class", ".py", ".c", ".cpp", ".cs", ".js"};

        ImageView icon;
        try {
            // TODO comprendre pourquoi il ne veut pas mettre la bonne icone pour les fichiers de code
            if (Arrays.asList(codeFileType).contains(Files.probeContentType(file.toPath()))) icon = new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/icons/code.png")).toExternalForm(), 18, 18, false, false));
            else if (file.isFile()) icon = new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/icons/file.png")).toExternalForm(), 18, 18, false, false));
            else icon = new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/icons/logo.png")).toExternalForm(), 18, 18, false, false));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        icon.setTranslateY(-2);

        box.getChildren().addAll(icon, fileName);
        pane.getChildren().addAll(box);
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
