package edu.uw.tcss450.tournamentmanager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    private String playerName;
    private ArrayList<String> playerLosses;
    private ArrayList<String> playerWins;
    private int playerPower;

    public Player(String name) {
        playerName = name;
    }

    public Player(String name, int power) {
        playerName = name;
        playerPower = power;
    }

    public int getPower() {
        return playerPower;
    }

    public String toString() {
        return playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void addWin(Player player) {
        playerWins.add(player.toString());
    }

    public void addLoss(Player player) {
        playerLosses.add(player.toString());
    }

//    public String getRecord() {
//        int totalGames = playerWins+playerLosses;
//        double winPercentage = Math.round(((double)playerWins/totalGames)*10000.0)/100.0;
//        String s = "Wins:     "+playerWins;
//        String l = "Losses:   "+playerLosses;
//        String t = "Total:    "+totalGames;
//        String p = "Win Rate: "+(winPercentage)+"%";
//        String record = s+"\n"+l+"\n"+t+"\n"+p;
//        return record;
//    }
}
