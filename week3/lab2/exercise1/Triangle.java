import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Triangle extends Application {
    @Override
    public void start(Stage stage) {
        Group root = new Group(
                new Line(100, 70, 100, 250),
                new Line(100, 250, 400, 250),
                new Line(400, 250, 100, 70));

        Scene scene = new Scene(root, 500, 300);
        stage.setTitle("Triangle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}