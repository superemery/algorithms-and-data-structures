import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class ChangingFace extends Application {
    @Override
    public void start(Stage stage) {
        Circle face = new Circle(125, 125, 80);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.RED);

        Circle rightEye = new Circle(86, 100, 10);
        rightEye.setFill(Color.YELLOW);
        rightEye.setStroke(Color.BLUE);

        Circle leftEye = new Circle(162, 100, 10);
        leftEye.setFill(Color.YELLOW);
        leftEye.setStroke(Color.BLUE);

        Arc smileMouth = new Arc(125, 150, 45, 35, 0, -180);
        smileMouth.setFill(Color.YELLOW);
        smileMouth.setStroke(Color.BLUE);
        smileMouth.setType(ArcType.OPEN);

        Line thinkMouth = new Line(80, 150, 170, 150);
        thinkMouth.setFill(Color.YELLOW);
        thinkMouth.setStroke(Color.BLUE);

        Arc frownMouth = new Arc(125, 150, 45, 35, 0, 180);
        frownMouth.setFill(Color.YELLOW);
        frownMouth.setStroke(Color.BLUE);
        frownMouth.setType(ArcType.OPEN);

        Text caption = new Text(68, 240, "Changing Face");
        caption.setFill(Color.BLUE);
        caption.setFont(Font.font("Verdana", 15));

        Group group = new Group(face, rightEye, leftEye, smileMouth, caption);

        Button smileButton = new Button("Smile");
        Button thinkButton = new Button("Think");
        Button frownButton = new Button("Frown");

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(smileButton, thinkButton, frownButton);

        VBox root = new VBox(10);
        root.setBackground(Background.EMPTY);
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(buttonBox, group);

        Scene scene = new Scene(root, 250, 275, Color.YELLOW);

        smileButton.setOnAction(e -> {
            if (group.getChildren().contains(smileMouth))
                return;

            group.getChildren().add(smileMouth);
            group.getChildren().remove(thinkMouth);
            group.getChildren().remove(frownMouth);
        });

        thinkButton.setOnAction(e -> {
            if (group.getChildren().contains(thinkMouth))
                return;

            group.getChildren().add(thinkMouth);
            group.getChildren().remove(smileMouth);
            group.getChildren().remove(frownMouth);
        });

        frownButton.setOnAction(e -> {
            if (group.getChildren().contains(frownMouth))
                return;

            group.getChildren().add(frownMouth);
            group.getChildren().remove(smileMouth);
            group.getChildren().remove(thinkMouth);
        });

        stage.setScene(scene);
        stage.setTitle("Changing Face");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}