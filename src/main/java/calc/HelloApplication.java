package calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/stage.fxml")));
        primaryStage.setTitle("Flanty Control Panel");
        Scene scene = new Scene(root, Color.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource("/Dark.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(false);
        HelloController.Stage(primaryStage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
