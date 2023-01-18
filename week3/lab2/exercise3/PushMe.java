import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PushMe extends Application {
    @Override
    public void start(Stage stage) {
        TextField pushMeTextField = new TextField();
        pushMeTextField.setMaxWidth(250);

        Label pushMeLabel = new Label();
        pushMeLabel.setTextFill(Color.RED);
        pushMeLabel.setFont(Font.font("Arial", 20));

        Button toUpperButton = new Button();
        toUpperButton.setText("Show the text in upper case");
        toUpperButton.setOnAction(e -> pushMeLabel.setText("You entered: " + pushMeTextField.getText().toUpperCase()));

        Button showLengthButton = new Button();
        showLengthButton.setText("Show the number of letters");
        showLengthButton.setOnAction(
                e -> pushMeLabel.setText("You entered: " + pushMeTextField.getText().length() + " letters"));

        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(pushMeTextField, toUpperButton, showLengthButton, pushMeLabel);

        Scene scene = new Scene(root, 350, 150);

        stage.setScene(scene);
        stage.setTitle("Push Me");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
