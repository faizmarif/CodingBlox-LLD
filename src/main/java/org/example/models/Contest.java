package org.example.models;

import org.example.enums.Level;

import java.util.ArrayList;
import java.util.List;

public class Contest {
    private int id;
    private String contestName;
    private Level level;
    private List<Question> questions;
    private User contestCreator;
    private List<User> participants;

    public int getId() {
        return id;
    }

    public String getContestName() {
        return contestName;
    }

    public Contest setContestName(String contestName) {
        this.contestName = contestName;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public Contest setLevel(Level level) {
        this.level = level;
        return this;
    }

    public List<Question> getQuestions() {
        if(questions == null) {
            questions = new ArrayList<>();
        }
        return questions;
    }

    public Contest addQuestion(Question question) {
        if(questions == null) {
            questions = new ArrayList<>();
        }
        this.questions.add(question);
        return this;
    }

    public User getContestCreator() {
        return contestCreator;
    }

    public Contest setContestCreator(User contestCreator) {
        this.contestCreator = contestCreator;
        return this;
    }

    public List<User> getParticipants() {
        if(participants == null) {
            participants = new ArrayList<>();
        }
        return participants;
    }

    public Contest addParticipant(User user) {
        if(participants == null) {
            participants = new ArrayList<>();
        }
        this.participants.add(user);
        return this;
    }

    public Contest setId(int id) {
        this.id = id;
        return this;
    }
}
