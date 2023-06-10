package fr.galaglow.builtin;

import fr.galaglow.helper.BuiltInApp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL")
public class FileOrganizer implements BuiltInApp {
    private File file = null; // new File("C:\\Users\\soren\\Documents\\Test");

    @Override
    public void init(String... args) {
        this.file = new File(args[0]);
    }

    @Override
    public void execute() {
        if (file.isDirectory()) {
            ArrayList<File> files = new ArrayList<>(List.of(Objects.requireNonNull(this.file.listFiles())));

            files.removeIf(f -> !f.isFile());
            for (File f: files){
                String ext = f.getName().substring(f.getName().lastIndexOf('.')).replace(".", "");
                File path = new File(f.getParent() + "\\" + ext);

                try {
                    path.mkdirs();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                f.renameTo(new File(path + "\\" + f.getName()));
            }
            System.out.println(files);
        }
    }
}
