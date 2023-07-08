package fr.galaglow.helper;

import fr.galaglow.Main;
import fr.galaglow.scenes.MainScene;
import fr.galaglow.scenes.components.ListFile;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Objects;

public class Constants {
    public static Stage STAGE = Main.getStage();
    public static ListFile FILE_LIST = new ListFile(MainScene.getPane());
    // Replace it by a FilesLister
    public static HashMap<String, String> DISK_FILES = new HashMap<>();
    public static String ACTUAL_DIR = "";
}
