package pl.com.pixel.recruitment.debug;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class TextBox {

    private static String response;

    static String display(String title, String message) {
        Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label(message);
        TextField input = new TextField();
        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e -> {
             response = input.getText();
             window.close();
        });

        VBox layout = new VBox(5);
        layout.getChildren().addAll(label, input, confirmButton);

        Scene textBox = new Scene(layout, 250, 80);
        window.setScene(textBox);
        window.showAndWait();

        return response;
    }
}