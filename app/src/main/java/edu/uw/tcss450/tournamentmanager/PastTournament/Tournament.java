package edu.uw.tcss450.tournamentmanager.PastTournament;

public class Tournament {
    private String winner;
    private String finalist;
    private String[] players;

    public Tournament() {

    }

    public void extractPlayers(String playersText) {
        players = playersText.split("\\r?\\n");
    }

    public void play() {

    }



}
