package fr.galaglow.helper;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;

public class FilesLister {

    private File dir;

    public HashMap<String, String> disk_files = new HashMap<>();

    public FilesLister(String src) {
        this.dir = new File(src);

        this.listFiles(this.dir);
    }

    private void listFiles(File dir) {
        for (File f : Objects.requireNonNull(dir.listFiles())) {
            if (f.isFile()) {
                this.disk_files.put(f.getName(), f.getAbsolutePath());
            } else {
                this.listFiles(f);
            }
        }
    }

    public HashMap<String, String> getDiskFiles() {
        return this.disk_files;
    }

}
