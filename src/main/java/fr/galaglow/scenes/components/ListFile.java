package fr.galaglow.scenes.components;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;

public class ListFile {
    private final Pane pane;
    private File[] files = null;
    private final ArrayList<FlatFileCard> fls = new ArrayList<>();

    private final ScrollPane sp = new ScrollPane();

    private final VBox root = new VBox();

    private final BorderPane box = new BorderPane(sp);

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

//        box.getChildren().addAll(fls);
//        root.getChildren().addAll(box);
//        sp.setContent(root);
//        sp.setFitToHeight(true);
//        pane.getChildren().addAll(sp);

        box.getChildren().addAll(fls);
        box.getChildren().addAll(sp);
        pane.getChildren().addAll(root);
        sp.setContent(root);
        sp.setFitToHeight(true);
    }

    public void clear() {
        files = null;
        fls.clear();
        pane.getChildren().remove(7, pane.getChildren().size());
        root.getChildren().clear();
        box.getChildren().clear();
    }

    public void setFiles(File[] files) {
        this.files = files;
    }
    
}
