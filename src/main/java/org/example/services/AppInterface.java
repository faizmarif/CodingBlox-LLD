package org.example.services;

import org.example.enums.Level;
import org.example.enums.SortingOrder;
import org.example.models.User;

public interface AppInterface {
    void logIn(String userName);
    void createUser(String userName);
    void createQuestion(Level level, int score);
    void listQuestion();
    void listQuestion(Level level);
    void createContest(String contestName, Level contestLevel, String creatorUserName);
    void listContest();
    void listContest(Level level);
    void attendContest(int contestId, String userName);
    void runContest(int contestId, String creatorUserName);
    void showLeaderBoard(SortingOrder sortingOrder);
}
