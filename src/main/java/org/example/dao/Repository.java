package org.example.dao;

import org.example.models.Contest;
import org.example.models.Question;
import org.example.models.User;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private static Repository repository = null;
    private Map<String, User> userNameUserMap;
    private Map<Integer, Question> idQuestionMap;
    private Map<Integer, Contest> idContestMap;

    private Repository() {}

    public static Repository getInstance() {
        if(repository == null) {
            repository = new Repository();
    }
        return repository;
    }

    public Map<String, User> getUserNameUserMap() {
        return userNameUserMap;
    }

    public Map<Integer, Question> getIdQuestionMap() {
        return idQuestionMap;
    }

    public Map<Integer, Contest> getIdContestMap() {
        return idContestMap;
    }

    public Repository addUser(User user) {
        if(userNameUserMap == null) {
            userNameUserMap = new HashMap<>();
        }
        if(!userNameUserMap.containsKey(user.getUserName())) {
            userNameUserMap.put(user.getUserName(), user);
        } else {
            System.out.println("Username already exists");
        }
        return this;
    }

    public Repository addQuestion(Question question) {
        if(idQuestionMap == null) {
            idQuestionMap = new HashMap<>();
        }
        int nextIndex = idQuestionMap.size() + 1;
        question.setId(nextIndex);
        idQuestionMap.put(nextIndex, question);
        return this;
    }

    public Repository addContest(Contest contest) {
        if(idContestMap == null) {
            idContestMap = new HashMap<>();
        }
        int nextIndex = idContestMap.size() + 1;
        contest.setId(nextIndex);
        idContestMap.put(nextIndex, contest);
        return this;
    }

}
