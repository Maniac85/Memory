package de.htwberlin.webtech.memory.model;


import java.time.LocalDateTime;

public class Highscore {
    private String playerName;
    private int score;
    private LocalDateTime date; // Behalten für interne Verwendung

    public Highscore(String playerName, int score, LocalDateTime date) {
        this.playerName = playerName;
        this.score = score;
        this.date = date;
    }

    // Getter und Setter, ohne das Datum zurückzugeben
    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    // Optional: Datum nur für interne Zwecke
    public LocalDateTime getDate() {
        return date;
    }
}
