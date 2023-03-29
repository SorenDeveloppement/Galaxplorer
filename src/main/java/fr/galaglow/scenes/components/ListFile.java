package fr.galaglow.scenes.components;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.ArrayList;

public class ListFile {
    private final Pane pane;
    private File[] files = null;
    private final ArrayList<FlatFileCard> fls = new ArrayList<>();


    private VBox root = new VBox();
    private ScrollPane sp = new ScrollPane();
    private VBox scrollbox = new VBox();

    public ListFile(Pane pane) {
        this.pane = pane;
    }

    public void show() {
        int space = 30;
        int i = 0;
        for (File file : files) {
            fls.add(new FlatFileCard(pane, 250, 40 + i, file));
            i += space;
        }

        scrollbox.getChildren().addAll(fls);
        root.getChildren().addAll(sp);
        sp.setContent(root);
    }

    public void clear() {
        fls.clear();
        root.getChildren().clear();
        root.getChildren().removeAll(root.getChildren());
        scrollbox.getChildren().clear();
        scrollbox.getChildren().removeAll(scrollbox.getChildren());
    }

    public void setFiles(File[] files) {
        this.files = files;
    }
    
}
