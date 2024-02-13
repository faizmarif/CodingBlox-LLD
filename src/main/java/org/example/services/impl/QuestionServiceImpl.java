package org.example.services.impl;

import org.example.dao.Repository;
import org.example.enums.Level;
import org.example.models.Question;
import org.example.services.QuestionService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private final Repository repository;

    public QuestionServiceImpl() {
        this.repository = Repository.getInstance();
    }
    @Override
    public void printQuestions(Level level) {
        for(Question question : repository.getIdQuestionMap().values()) {
            if(question.getLevel().equals(level)) {
                System.out.println(question.getId() + " : " + question.getLevel());
            }
        }
    }

    @Override
    public void printQuestions() {
        for(Question question : repository.getIdQuestionMap().values()) {
            System.out.println(question.getId() + " : " + question.getLevel());
        }
    }

    @Override
    public List<Question> getRandomQuestions(int count, Level level) {
        List<Question> questionList = new ArrayList<>();
        for(Question question : repository.getIdQuestionMap().values()) {
            if (question.getLevel().equals(level)) {
                questionList.add(question);
            }
        }
        Collections.shuffle(questionList);
        return questionList.subList(0, count);
    }
}
