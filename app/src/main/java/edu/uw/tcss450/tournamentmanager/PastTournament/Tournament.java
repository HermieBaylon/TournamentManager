package edu.uw.tcss450.tournamentmanager.PastTournament;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import edu.uw.tcss450.tournamentmanager.Player;

public class Tournament {
    private String winner;
    private String finalist;
    private int winnerScore;
    private int finalistScore;
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
        int min = 1;
        int max = 10;

        int score1 = 0;
        int score2 = 0;
        int goal = 10;

        while (score1 != goal && score2 != goal) {
            int game1 = r.nextInt(max - min + 1) + min + p1.getPower();
            int game2 = r.nextInt(max - min + 1) + min + p2.getPower();
            int coinFlip = r.nextInt(1 - 0 + 1) + 0;
            if (game1 > game2) {
                score1++;
            } else if (game1 < game2) {
                score2++;
            } else {
                if (coinFlip == 1) {
                    score1++;
                } else if (coinFlip == 0) {
                    score2++;
                }
            }
        }

        if (score1 == goal) {
            //p1.addWin(p2);
            this.winner = p1.toString();
            this.finalist = p2.toString();
            this.winnerScore = score1;
            this.finalistScore = score2;
//            Log.d("TAG", winner);
//            Log.d("TAG", finalist);
            return p1;
        }
        if (score2 == goal) {
            //p2.addLoss(p1);
            this.winner = p2.toString();
            this.finalist = p1.toString();
            this.winnerScore = score2;
            this.finalistScore = score1;
//            Log.d("TAG", winner);
//            Log.d("TAG", finalist);
            return p2;
        }
        return null;
    }

    public String getWinner() {
        return winner;
    }

    public String getFinalist() {
        return finalist;
    }

    public int getWinnerScore() {
        return winnerScore;
    }

    public int getFinalistScore() {
        return finalistScore;
    }





}
