package org.example.services.impl;

import org.example.dao.Repository;
import org.example.enums.SortingOrder;
import org.example.models.User;
import org.example.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final Repository repository;

    public UserServiceImpl() {
        this.repository = Repository.getInstance();
    }

    @Override
    public void showLeaderBoard(SortingOrder sortingOrder) {
        List<User> users = repository
                .getUserNameUserMap()
                .values()
                .stream()
                .sorted(sortingOrder.equals(SortingOrder.ASC) ? (u,v) -> u.getScore() - v.getScore() : (u,v) -> v.getScore() - u.getScore())
                .toList();

        for(User user : users) {
            System.out.println(user.getUserName() + " : " + user.getScore());
        }
    }
}
