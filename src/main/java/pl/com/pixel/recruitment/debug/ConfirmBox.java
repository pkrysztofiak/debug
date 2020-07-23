package pl.com.pixel.recruitment.debug;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ConfirmBox {

    private static boolean response;

    static boolean display(String title, String message) {
        Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setOnAction(e -> {
            response = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            response = false;
            window.close();
        });

        Label label = new Label(message);
        StackPane toplayout = new StackPane(label);

        HBox centerlayout = new HBox(10);
        centerlayout.getChildren().addAll(yesButton, noButton);
        centerlayout.setAlignment(Pos.CENTER);

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(5,5,5,5));
        layout.setTop(toplayout);
        layout.setCenter(centerlayout);

        Scene alertBox = new Scene(layout, 250, 60);
        window.setScene(alertBox);
        window.showAndWait();

        return response;
    }
}
