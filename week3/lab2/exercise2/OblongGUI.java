import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OblongGUI extends Application {
    private final Oblong testOblong = new Oblong(0, 0);

    @Override
    public void start(Stage stage) {
        TextField lengthField = new TextField();
        lengthField.setMaxWidth(50);
        TextField heightField = new TextField();
        heightField.setMaxWidth(50);

        TextArea display = new TextArea();
        display.setEditable(false);
        display.setMinSize(210, 50);
        display.setMaxSize(210, 50);

        Label lengthLabel = new Label("Length");
        lengthLabel.setTextFill(Color.RED);
        lengthLabel.setFont(Font.font("Arial", 20));
        Label heightLabel = new Label("Height");
        heightLabel.setTextFill(Color.RED);
        heightLabel.setFont(Font.font("Arial", 20));

        Button calculateButton = new Button();
        calculateButton.setText("Calculate");
        calculateButton.setOnAction(e -> {
            String lengthText = lengthField.getText();
            String heightText = heightField.getText();

            if (lengthText.isEmpty() || heightText.isEmpty()) {
                display.setText("Length and height must be entered");
            } else if (isNumber(lengthText) && isNumber(heightText)) {
                double length = Double.parseDouble(lengthText);
                double height = Double.parseDouble(heightText);

                if (length <= 0 || height <= 0) {
                    display.setText("Length and height must be positive numbers");
                    return;
                }

                if (length == height) {
                    display.setText("Length and height must not be equal");
                    return;
                }

                testOblong.setLength(length);
                testOblong.setHeight(height);
                display.setText("The area is: " + testOblong.calculateArea()
                        + "\n" + "The perimeter is: "
                        + testOblong.calculatePerimeter());
            } else {
                display.setText("Length and height must be positive numbers");
            }
        });

        HBox inputComponents = new HBox(10);
        inputComponents.setAlignment(Pos.CENTER);
        inputComponents.getChildren().addAll(lengthLabel, lengthField, heightLabel, heightField);

        VBox root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(inputComponents, calculateButton, display);

        Scene scene = new Scene(root, 350, 250);
        stage.setScene(scene);
        stage.setTitle("Oblong GUI");
        stage.show();
    }

    private static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
