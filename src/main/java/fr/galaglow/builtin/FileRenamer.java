package fr.galaglow.builtin;

import fr.galaglow.helper.BuiltInApp;

import java.io.File;

public class FileRenamer implements BuiltInApp {
    private File file = new File("C:\\Users\\soren\\Documents\\Test");
    private String newName = "";

    @Override
    public void init(Object... args) {
        this.file = new File((String) args[0]);
        this.newName = (String) args[1];
    }

    @Override
    public void execute() {
        this.file.renameTo(new File(this.file.getParent() + "\\" + newName));
    }
}
