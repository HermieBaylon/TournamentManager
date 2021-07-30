package edu.uw.tcss450.tournamentmanager.PastTournament;

import java.util.ArrayList;
import java.util.Random;

import edu.uw.tcss450.tournamentmanager.Player;

public class Tournament {
    private String winner;
    private String finalist;
    private String[] players;

    public Tournament() {

    }

    public void extractPlayers(String playersText) {
        players = playersText.split("\\r?\\n");
    }

    public void shuffflePlayers() {

    }

    // two players playing
    public Player play(Player p1, Player p2) {
        Random r = new Random();
        int low = 1;
        int high = 10;

        int score1 = 0;
        int score2 = 0;
        int goal = 10;

        while (score1 != goal && score2 != goal) {
            int game1 = r.nextInt(high-low) + low + p1.getPower();
            int game2 = r.nextInt(high-low) + low + p2.getPower();
            int coinFlip = r.nextInt(1-0) + 0;
            if (game1 > game2) {
                score1++;
            } else if (game1 < game2) {
                score2++;
            } else {
                if (coinFlip == 1) {
                    score1++;
                } else {
                    score2++;
                }
            }
        }

        if (score1 == goal) {
            p1.addWin(p2);
            return p1;
        }
        if (score2 == goal) {
            p2.addLoss(p1);
            return p2;
        }
        return null;
    }





}
