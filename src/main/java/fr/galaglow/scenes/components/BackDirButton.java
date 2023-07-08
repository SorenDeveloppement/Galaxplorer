package fr.galaglow.scenes.components;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

import static fr.galaglow.helper.Constants.ACTUAL_DIR;
import static fr.galaglow.helper.Constants.FILE_LIST;

public class BackDirButton {

    public BackDirButton(Pane pane, double x, double y) {

        Text backDirImage = GlyphsDude.createIcon(FontAwesomeIcon.ARROW_LEFT, "30px");
        backDirImage.setTranslateX(x);
        backDirImage.setTranslateY(y);
        backDirImage.setFill(Color.WHITE);

        AtomicReference<StringBuilder> lastDir = new AtomicReference<>(new StringBuilder());

        backDirImage.setOnMouseClicked(event -> {
            ACTUAL_DIR = ACTUAL_DIR.replace("\\", "/");
            System.out.println(ACTUAL_DIR);
            String[] splitedDir = ACTUAL_DIR.split("/");
            System.out.println(Arrays.toString(splitedDir));

            ArrayList<String> sDir = new ArrayList<>();
            Collections.addAll(sDir, splitedDir);
            sDir.remove(sDir.toArray().length - 1);
            System.out.println(sDir);
            System.out.println(sDir.toArray().length);

            if (sDir.toArray().length > 0) {
                for (String s : sDir) {
                    lastDir.get().append(s).append("\\");
                }

                FILE_LIST.clear();
                System.out.println(lastDir);
                FILE_LIST.setFiles(new File(lastDir.toString()).listFiles());
                FILE_LIST.show();

                ACTUAL_DIR = String.valueOf(lastDir);
                System.out.println(ACTUAL_DIR);

                splitedDir = new String[]{};
                sDir = new ArrayList<>();
                lastDir.set(new StringBuilder());
            }
        });

        pane.getChildren().add(backDirImage);
    }

}
