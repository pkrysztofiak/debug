package pl.com.pixel.recruitment.debug;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private int totalWins = 0;
    private int othelloWins = 0;
    private int connectFourWins = 0;

    private static ArrayList<Player> playerList = new ArrayList<>(1);

    private Player(String input) {
        name = input;
    }
    private Player(String input, int othello, int connectFour, int total) {
        name = input;
        othelloWins = othello;
        connectFourWins = connectFour;
        totalWins = total;
    }

    void addOthelloWin() {
        othelloWins++;
        totalWins++;
    }
    void addConnectFourWin() {
        connectFourWins++;
        totalWins++;
    }
    void changeName(String input) {
        name = input;
    }

    static ArrayList<Player> getPlayerList() {
        return playerList;
    }
    static Player getPlayer(String input) {
        for(int i = 0; i < playerList.size(); i++) {
            if(playerList.get(i).name.equals(input)) {
                return playerList.get(i);
            }
        }
        return null;
    }
    String getName() {
        return name;
    }
    int getOthelloWins() {
        return othelloWins;
    }
    int getConnectFourWins() {
        return connectFourWins;
    }
    int getTotalWins() {
        return totalWins;
    }

    static void printWins() {
        System.out.println("Names\t\tOthello\t\tConnect4\t\tTotal" + "\n");
        for(int i = 0; i < playerList.size(); i++) {
            System.out.println(playerList.get(i).name + "\t\t\t" + playerList.get(i).othelloWins + "\t\t\t" +
                    playerList.get(i).connectFourWins + "\t\t\t" + playerList.get(i).totalWins);
        }
        System.out.println();
    }

    static void addNewPlayer(String name) throws IOException {
        Player newPlayer = new Player(name);
        playerList.add(newPlayer);

        File file = new File("player_Data.txt");
        FileWriter writer = new FileWriter(file, true);
        writer.write(newPlayer.name + "\t\t" + newPlayer.othelloWins + "\t\t" + newPlayer.connectFourWins + "\t\t" + newPlayer.totalWins + System.lineSeparator());
        writer.close();
    }

    static boolean loadPlayers(){
        Scanner input;

        try {
            File file = new File("player_Data.txt");
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            return false;
        }

        while (input.hasNextLine()) {
            try {
                String line = input.nextLine();
                String[] lineArray = line.split("\t\t");
                Player newPlayer = new Player(lineArray[0], Integer.parseInt(lineArray[1]), Integer.parseInt(lineArray[2]), Integer.parseInt(lineArray[3]));
                playerList.add(newPlayer);
            } catch (Exception e) {
                System.out.println("Player data incorrectly formatted.");
                break;
            }
        }
        return true;
    }

    static void recordWins() throws IOException {
        File file = new File("player_Data.txt");
        FileWriter writer = new FileWriter(file);

        for(int i = 0; i < playerList.size(); i++) {
            writer.write(playerList.get(i).name + "\t\t" + playerList.get(i).othelloWins + "\t\t" + playerList.get(i).connectFourWins + "\t\t" + playerList.get(i).totalWins + System.lineSeparator());
        }
        writer.close();
    }
}