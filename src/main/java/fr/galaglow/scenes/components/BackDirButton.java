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

import static fr.galaglow.helper.Constants.ACTUAL_DIR;
import static fr.galaglow.helper.Constants.FILE_LIST;

public class BackDirButton {

    public BackDirButton(Pane pane, double x, double y) {

        Text backDirImage = GlyphsDude.createIcon(FontAwesomeIcon.ARROW_LEFT, "30px");
        backDirImage.setTranslateX(x);
        backDirImage.setTranslateY(y);
        backDirImage.setFill(Color.WHITE);

        StringBuilder lastDir = new StringBuilder();

        backDirImage.setOnMouseClicked(event -> {
            ACTUAL_DIR = ACTUAL_DIR.replace("\\", "/");
            System.out.println(ACTUAL_DIR);
            String[] splitedDir = ACTUAL_DIR.split("/");
            System.out.println(Arrays.toString(splitedDir));

            ArrayList<String> sDir = new ArrayList<>();
            Collections.addAll(sDir, splitedDir);
            sDir.remove(sDir.toArray().length - 1);
            System.out.println(sDir);

            for (String s : sDir) {
                lastDir.append(s).append("\\");
            }

            FILE_LIST.clear();
            System.out.println(lastDir);
            FILE_LIST.setFiles(new File(lastDir.toString()).listFiles());
            FILE_LIST.show();

            ACTUAL_DIR = String.valueOf(lastDir);

            lastDir.delete(0, lastDir.length() - 1);
        });

        pane.getChildren().add(backDirImage);
    }

}
