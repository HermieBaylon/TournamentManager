package edu.uw.tcss450.tournamentmanager;

public class Player {
    private String playerName;
    private int playerLosses;
    private int playerWins;

    public Player(String name) {
        name = playerName;
    }

    public void setPlayerLosses(int losses) {
        playerLosses = losses;
    }

    public void setPlayerWins(int wins) {
        playerWins = wins;
    }

    public String getRecord() {
        int totalGames = playerWins+playerLosses;
        double winPercentage = Math.round(((double)playerWins/totalGames)*10000.0)/100.0;
        String s = "Wins:     "+playerWins;
        String l = "Losses:   "+playerLosses;
        String t = "Total:    "+totalGames;
        String p = "Win Rate: "+(winPercentage)+"%";
        String record = s+"\n"+l+"\n"+t+"\n"+p;
        return record;
    }
}
