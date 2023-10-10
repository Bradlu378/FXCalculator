package calc;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import static calc.Css.RootButtonsEN;
import static calc.Css.RootButtonsEX;

public class HelloController {
    private boolean MouseInside;
    static Stage Stage;
    private double num1 = 0;
    private String operator = "+";
    private String num;
    @FXML
    Label fieldd;
    @FXML
    private AnchorPane rootPane;

    /**
     * Кнопки root
     * Функционал*
     */
    public static void Stage(Stage stage) {
        Stage = stage;
    }

    @FXML
    private void handleMouseReleased1() {
        if (MouseInside) Platform.exit();
    }

    @FXML
    private void handleMouseReleased2() {
        if (MouseInside) System.out.print("IDK");
    }

    @FXML
    private void handleMouseReleased3() {
        if (MouseInside) Stage.setIconified(true);
    }

    /**
     * Перетаскивание окна
     */
    private double xOffset;
    private double yOffset;

    @FXML
    private void handleMousePressed(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    private void handleMouseDragged(MouseEvent event) {
        rootPane.getScene().getWindow().setX(event.getScreenX() - xOffset);
        rootPane.getScene().getWindow().setY(event.getScreenY() - yOffset);
    }

    /**
     * Функционал кнопок
     */

    @FXML
    public void ME(MouseEvent event) {
        RootButtonsEN((Pane) event.getSource());
        MouseInside = true;
    }

    @FXML
    private void MX(MouseEvent event) {
        RootButtonsEX((Pane) event.getSource());
        MouseInside = false;
    }

    @FXML
    private void MRS(MouseEvent event) {
            String symbol = ((Pane)event.getSource()).getId().replace("btn","");
            if(symbol.equals("Equals")) {
                double num2 = Double.parseDouble(fieldd.getText());
                switch (operator) {
                    case "+" -> fieldd.setText((num1+num2) + "");
                    case "-" -> fieldd.setText((num1-num2) + "");
                    case "*" -> fieldd.setText((num1*num2) + "");
                    case "/" -> fieldd.setText((num1/num2) + "");
                }
                operator = ".";
            }
            else if(symbol.equals("Clear")) {
                fieldd.setText(String.valueOf(0.0));
                operator = ".";
            }
            else {
                switch (symbol) {
                    case "Plus" -> operator = "+";
                    case "Minus" -> operator = "-";
                    case "Multiply" -> operator = "*";
                    case "Divide" -> operator = "/";
                }
                num1 = Double.parseDouble(fieldd.getText());
                fieldd.setText(String.valueOf(0.0));
            }
        }

    @FXML
    private void MRN(MouseEvent event) {
        if (MouseInside) {
            int value = Integer.parseInt(((Pane) event.getSource()).getId().replace("n", ""));
            fieldd.setText(Double.parseDouble(fieldd.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(fieldd.getText())*10+value));
        }
    }
}