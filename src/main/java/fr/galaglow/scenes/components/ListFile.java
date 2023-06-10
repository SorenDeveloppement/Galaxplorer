package fr.galaglow.scenes.components;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;

public class ListFile {
    private final Pane pane;
    private File[] files = null;
    private final ArrayList<FlatFileCard> fls = new ArrayList<>();


    private final VBox root = new VBox();
    private final ScrollPane sp = new ScrollPane();
    private final VBox scrollbox = new VBox();

    public ListFile(Pane pane) {
        this.pane = pane;
    }

    public void show() {
        int space = 30;
        int i = 0;
        try {
            for (File file : files) {
                fls.add(new FlatFileCard(pane, 250, 40 + i, file));
                i += space;
            }
        } catch (Exception e) {
            System.out.println("There is no files in the path ! \r" + e);
        }

        scrollbox.getChildren().addAll(fls);
        root.getChildren().addAll(sp);
        scrollbox.getChildren().add(root);
    }

    public void clear() {
        files = null;
        fls.clear();
        pane.getChildren().remove(6, pane.getChildren().size());
        scrollbox.getChildren().clear();
        root.getChildren().clear();
    }

    public void setFiles(File[] files) {
        this.files = files;
    }
    
}
