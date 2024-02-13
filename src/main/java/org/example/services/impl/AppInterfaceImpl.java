package org.example.services.impl;

import org.example.dao.Repository;
import org.example.enums.Level;
import org.example.enums.SortingOrder;
import org.example.models.Contest;
import org.example.models.Question;
import org.example.models.User;
import org.example.services.AppInterface;
import org.example.services.ContestService;
import org.example.services.QuestionService;
import org.example.services.UserService;

public class AppInterfaceImpl implements AppInterface {
    private final Repository repository;
    private final UserService userService;
    private final QuestionService questionService;
    private final ContestService contestService;
    private User currentUser;

    public AppInterfaceImpl() {
        this.repository = Repository.getInstance();
        this.userService = new UserServiceImpl();
        this.questionService = new QuestionServiceImpl();
        this.contestService = new ContestServiceImpl();
        this.currentUser = null;
    }

    @Override
    public void logIn(String userName) {
        User user = repository.getUserNameUserMap().get(userName);
        if(user != null) {
            currentUser = user;
        }
    }

    @Override
    public void createUser(String userName) {
        User user = new User().setUserName(userName).setScore(1500);
        repository.addUser(user);
    }

    @Override
    public void createQuestion(Level level, int score) {
        Question question = new Question().setLevel(level).setScore(score);
        repository.addQuestion(question);
    }

    @Override
    public void listQuestion() {
        questionService.printQuestions();
    }

    @Override
    public void listQuestion(Level level) {
        questionService.printQuestions(level);
    }

    @Override
    public void createContest(String contestName, Level contestLevel, String creatorUserName) {
        User creator = repository.getUserNameUserMap().get(creatorUserName);
        if(creator != null) {
            Contest contest = new Contest().setContestName(contestName).setLevel(contestLevel).setContestCreator(creator);
            repository.addContest(contest);
        }
    }

    @Override
    public void listContest() {
        contestService.printContests();
    }

    @Override
    public void listContest(Level level) {
        contestService.printContests(level);
    }

    @Override
    public void attendContest(int contestId, String userName) {
        Contest contest = repository.getIdContestMap().get(contestId);
        if(contest != null) {
            User participant = repository.getUserNameUserMap().get(userName);
            if(participant != null) {
                contest.addParticipant(participant);
            }
        }
    }

    @Override
    public void runContest(int contestId, String creatorUserName) {
        if(currentUser == null) {
            System.out.println("Please log in");
            return;
        }
        User userNameProvided = repository.getUserNameUserMap().get(creatorUserName);
        Contest contest = repository.getIdContestMap().get(contestId);
        if(userNameProvided != null && contest != null && userNameProvided.equals(currentUser) && contest.getContestCreator().equals(userNameProvided)) {
            contestService.runContest(contestId);
        } else {
            System.out.println("Only creator can start contest");
        }
    }

    @Override
    public void showLeaderBoard(SortingOrder sortingOrder) {
        userService.showLeaderBoard(sortingOrder);
    }
}
