package org.example.models;

import org.example.enums.Level;

public class Question {
    private int id;
    private Level level;
    private int score;


    public int getId() {
        return id;
    }

    public Level getLevel() {
        return level;
    }

    public Question setLevel(Level level) {
        this.level = level;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Question setScore(int score) {
        this.score = score;
        return this;
    }

    public Question setId(int id) {
        this.id = id;
        return this;
    }
}
