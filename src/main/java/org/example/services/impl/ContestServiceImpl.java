package org.example.services.impl;

import org.example.dao.Repository;
import org.example.enums.Level;
import org.example.models.Contest;
import org.example.models.Question;
import org.example.models.User;
import org.example.services.ContestService;
import org.example.services.QuestionService;

import java.util.List;

public class ContestServiceImpl implements ContestService {
    private final Repository repository;
    private final QuestionService questionService;

    public ContestServiceImpl() {
        this.repository = Repository.getInstance();
        this.questionService = new QuestionServiceImpl();
    }
    @Override
    public void printContests(Level level) {
        for(Contest contest : repository.getIdContestMap().values()) {
            if(contest.getLevel().equals(level)) {
                System.out.println(contest.getId() + " : " + contest.getLevel() + " : " + contest.getContestName());
            }
        }
    }

    @Override
    public void printContests() {
        for(Contest contest : repository.getIdContestMap().values()) {
            System.out.println(contest.getId() + " : " + contest.getLevel() + " : " + contest.getContestName());
        }

    }

    @Override
    public void runContest(int contestId) {
        Contest contest = repository.getIdContestMap().get(contestId);
        if (contest != null) {
            List<User> participants = contest.getParticipants();
            participants.add(contest.getContestCreator());
            Level level = contest.getLevel();
            for (User participant : participants) {
                List<Question> questions = questionService.getRandomQuestions(3, level);
                int currentContestPoints = calculateContestPoints(questions);
                int totalScore = calculateScore(participant.getScore(), currentContestPoints, level);
                participant.setScore(totalScore);
            }
        }
    }

    private int calculateScore(int currentScore, int currentContestPoints, Level level) {
        int scoreDeduction = 0;
        if(level.equals(Level.EASY)) {
            scoreDeduction = 50;
        } else if(level.equals(Level.MEDIUM)) {
            scoreDeduction = 30;
        }
        return currentScore + currentContestPoints - scoreDeduction;
    }

    private int calculateContestPoints(List<Question> questions) {
        int points = 0;
        for(Question question : questions) {
            points += question.getScore();
        }
        return points;
    }
}
