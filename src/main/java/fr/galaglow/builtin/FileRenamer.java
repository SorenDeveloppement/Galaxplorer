package fr.galaglow.builtin;

import fr.galaglow.helper.BuiltInApp;

import java.io.File;

public class FileRenamer implements BuiltInApp {
    private File file = new File("C:\\Users\\soren\\Documents\\Test");
    private String newName = "";

    @Override
    public void init(String... args) {
        this.file = new File(args[0]);
        this.newName = args[1];
    }

    @Override
    public void execute() {
        this.file.renameTo(new File(this.file + "\\" + newName));
    }
}
