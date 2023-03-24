package fr.galaglow.scenes.components;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
// import fr.galaglow.helper.FileHelper;
import fr.galaglow.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

import static fr.galaglow.helper.Constants.STAGE;

public class TopBar {

    double y = 0;
    double x = 0;

    public TopBar(Pane pane, Stage stage) {

        Pane bar = new Pane();

        bar.setPrefSize(1080, 35);
        bar.setTranslateX(0);
        bar.setTranslateY(0);
        bar.setStyle("-fx-background-color: #363636;");

        bar.setOnMousePressed(event -> {
            y = event.getSceneY();
            x = event.getSceneX();
        });

        bar.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        Text close = GlyphsDude.createIcon(FontAwesomeIcon.CLOSE, "25px");
        close.setTranslateX(1040);
        close.setTranslateY(25);
        close.setFill(Color.WHITE);

        close.setOnMouseClicked(event -> {
            double x = STAGE.getX();
            double y = STAGE.getY();
            stage.close();
        });

        Text reduce = GlyphsDude.createIcon(FontAwesomeIcon.MINUS, "25px");
        reduce.setTranslateX(1000);
        reduce.setTranslateY(27);
        reduce.setFill(Color.WHITE);

        reduce.setOnMouseClicked(event -> {
            stage.setIconified(true);
        });

        Text name = new Text("Galaxplorer [ DEV ]");
        name.setFill(Color.WHITE);
        name.setFont(Font.font("Poppins", FontWeight.BOLD, 20));
        name.setTranslateX(1080 / 2 - (name.getLayoutBounds().getWidth() / 2));
        name.setTranslateY(25);

        ImageView icon = new ImageView(new Image(Objects.requireNonNull(Main.class.getResource("/icons/logo.png")).toExternalForm(), 25, 25, false, false));
        icon.setTranslateY(5);
        icon.setTranslateX(5);

        bar.getChildren().addAll(close, reduce, name, icon);

        pane.getChildren().addAll(bar);
    }

}
