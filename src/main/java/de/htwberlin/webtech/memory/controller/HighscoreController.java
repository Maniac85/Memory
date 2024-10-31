package de.htwberlin.webtech.memory.controller;

import de.htwberlin.webtech.memory.model.Highscore;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/highscores")
public class HighscoreController {
    private List<Highscore> highscores = new ArrayList<>();

    @PostMapping
    public Highscore addHighscore(@RequestBody Highscore highscore) {
        highscores.add(highscore);
        Collections.sort(highscores, Comparator.comparingInt(Highscore::getScore).reversed());
        return highscore; // Gibt nur die relevanten Daten zurück
    }

    @GetMapping
    public List<Highscore> getHighscores() {
        // Gibt nur die relevanten Highscores zurück, Datum wird nicht angezeigt
        return highscores.stream()
                .map(h -> new Highscore(h.getPlayerName(), h.getScore(), null)) // Datum auf null setzen oder ignorieren
                .toList();
    }

    @PostConstruct
    public void init() {
        addHighscore(new Highscore("Alice", 150, LocalDateTime.now()));
        addHighscore(new Highscore("Bob", 200, LocalDateTime.now()));
        addHighscore(new Highscore("Charlie", 175, LocalDateTime.now()));
        addHighscore(new Highscore("David", 120, LocalDateTime.now()));
        addHighscore(new Highscore("Eve", 190, LocalDateTime.now()));
    }

}
