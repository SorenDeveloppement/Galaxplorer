package fr.galaglow.scenes.components;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;

public class ListFile {
    public ListFile(Pane pane, File[] files) {
        ArrayList<FlatFileCard> fls = new ArrayList<>();

        int space = 30;
        int i = 0;
        for (File file : files) {
            fls.add(new FlatFileCard(pane, 250, 40 + i, file));
            i += space;
        }

        VBox root = new VBox();
        ScrollPane sp = new ScrollPane();
        HBox scrollbox = new HBox();
        scrollbox.getChildren().addAll(fls);
        sp.setContent(scrollbox);
        root.getChildren().add(sp);
    }
}
