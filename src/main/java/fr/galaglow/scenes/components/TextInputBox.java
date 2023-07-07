package fr.galaglow.scenes.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TextInputBox {

    private final double x = 400;
    private final double y = 120;

    private final Pane pane;

    private final VBox box = new VBox();
    private final Button validateButton = new Button("Validate");
    private final TextField textArea = new TextField();

    public TextInputBox(Pane pane, String title) {
        this.pane = pane;

        box.setPrefSize(x, y);
        box.setTranslateX(pane.getWidth() / 2 - x / 2);
        box.setTranslateY(pane.getHeight() / 2 - y / 2);
        box.setStyle("-fx-background-color: #3E3E3E; -fx-border: #000 #000 #000 #000");

        Text nameText = new Text(title);
        nameText.setTranslateX(10);
        nameText.setFill(Color.WHITE);
        nameText.setFont(Font.font("Poppins", FontWeight.NORMAL, 16));

        textArea.setTranslateY(20);

        validateButton.setTranslateX(x - 65);
        validateButton.setTranslateY(40);

        box.getChildren().addAll(nameText, textArea, validateButton);

        pane.getChildren().add(box);
    }

    public void destroy() {
        pane.getChildren().remove(box);
    }

    public Button getValidateButton() {
        return validateButton;
    }

    public TextField getTextArea() {
        return textArea;
    }
}
