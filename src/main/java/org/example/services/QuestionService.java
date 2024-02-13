package org.example.services;

import org.example.enums.Level;
import org.example.models.Question;

import java.util.List;

public interface QuestionService {
    void printQuestions(Level level);

    void printQuestions();

    List<Question> getRandomQuestions(int count, Level level);
}
