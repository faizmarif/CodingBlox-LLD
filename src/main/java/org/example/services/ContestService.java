package org.example.services;

import org.example.enums.Level;
import org.example.models.Question;

import java.util.List;

public interface ContestService {
    void printContests(Level level);

    void printContests();

    void runContest(int contestId);


}
