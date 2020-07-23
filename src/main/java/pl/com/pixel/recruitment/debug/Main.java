package pl.com.pixel.recruitment.debug;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage window;

    public void refreshMainMenu() {

        Button c4button = new Button("Connect Four");
        Button othelloButton = new Button("Othello");
        Button addPlayerButton = new Button("Add New Player");
        Button quitButton = new Button("Quit");

        GridPane scoreboard = new GridPane();
        if(!Player.loadPlayers()) {
            Label label = new Label("No Players Yet");
            scoreboard.add(label, 0, 0);
        }
        else {
            Label label = new Label("Scoreboard:\n");
            Label temp1 = new Label("Name\t");
            Label temp2 = new Label("Othello Wins\t");
            Label temp3 = new Label("Connect Four Wins\t");
            Label temp4 = new Label("Total Wins\t");
            scoreboard.add(label, 0, 0);
            scoreboard.add(temp1, 0, 1);
            scoreboard.add(temp2, 1, 1);
            scoreboard.add(temp3, 2, 1);
            scoreboard.add(temp4, 3, 1);

            for(int i = 0; i < Player.getPlayerList().size(); i++) {
                Label temp5 = new Label(Player.getPlayerList().get(i).getName());
                Label temp6 = new Label(Integer.toString(Player.getPlayerList().get(i).getOthelloWins()));
                Label temp7 = new Label(Integer.toString(Player.getPlayerList().get(i).getConnectFourWins()));
                Label temp8 = new Label(Integer.toString(Player.getPlayerList().get(i).getTotalWins()));

                scoreboard.add(temp5, 0, i+2);
                scoreboard.add(temp6, 1, i+2);
                scoreboard.add(temp7, 2, i+2);
                scoreboard.add(temp8, 3, i+2);
            }
        }
        scoreboard.setAlignment(Pos.CENTER);

        HBox buttons = new HBox(20);
        buttons.getChildren().addAll(c4button, othelloButton, addPlayerButton, quitButton);
        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(scoreboard, buttons);
        layout.setAlignment(Pos.CENTER);

        Scene mainMenu = new Scene(layout, 600, 300);

        window.setScene(mainMenu);
        window.show();

        c4button.setOnAction(e -> {
//            try {
//                ConnectFour.playConnectFour();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
        });
        othelloButton.setOnAction(e -> {
//            try {
//                Othello.playOthello();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
        });
        addPlayerButton.setOnAction(e -> {
            try {
                String newPlayer = TextBox.display("Add Player", "Enter Player Name:");
                Player.addNewPlayer(newPlayer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            refreshMainMenu();
        });
        quitButton.setOnAction(e -> {
            boolean response = ConfirmBox.display("Exit Board Master","Are you sure?");
            if(response) {
                window.close();
            }
        });
        window.setOnCloseRequest(e -> {
            e.consume();
            boolean response = ConfirmBox.display("Exit Board Master","Are you sure?");
            if(response) {
                window.close();
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Board Master");
        refreshMainMenu();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}
