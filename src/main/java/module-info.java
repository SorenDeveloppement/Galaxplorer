module Galaxplorer {
    requires javafx.controls;
    requires javafx.fxml;
    requires fontawesomefx;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;

    opens fr.galaglow to javafx.fxml;
    exports fr.galaglow;
}