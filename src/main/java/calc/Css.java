package calc;

import javafx.scene.layout.Pane;

public class Css {
    static void RootButtonsEN (Pane pane) {
        pane.getStyleClass().add("mouseEntered");
    }
    static void RootButtonsEX (Pane pane) {
        pane.getStyleClass().remove("mouseEntered");
    }
}
