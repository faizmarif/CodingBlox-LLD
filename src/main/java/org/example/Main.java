package org.example;

import org.example.enums.Level;
import org.example.enums.SortingOrder;
import org.example.services.AppInterface;
import org.example.services.impl.AppInterfaceImpl;

public class Main {
    public static void main(String[] args) {
        AppInterface appInterface = new AppInterfaceImpl();

        appInterface.createUser("faizan");
        appInterface.createUser("monica");
        appInterface.createUser("chandler");
        appInterface.createUser("phoebe");
        appInterface.createUser("rachel");
        appInterface.createUser("joey");


        for (int i=1;i<=10;i++) {
            appInterface.createQuestion(Level.EASY, i+100);
            appInterface.createQuestion(Level.MEDIUM, i+200);
            appInterface.createQuestion(Level.HARD, i+300);
        }

        System.out.println("##########");
        appInterface.listQuestion();
        System.out.println("##########");
        appInterface.listQuestion(Level.EASY);
        System.out.println("##########");
        appInterface.listQuestion(Level.MEDIUM);
        System.out.println("##########");
        appInterface.listQuestion(Level.HARD);

        appInterface.createContest("new year contest", Level.EASY, "faizan");
        appInterface.createContest("diwali contest", Level.MEDIUM, "joey");
        appInterface.createContest("eid contest", Level.HARD, "chandler");

        System.out.println("##########");
        appInterface.listContest();
        System.out.println("##########");
        appInterface.listContest(Level.EASY);
        System.out.println("##########");
        appInterface.listContest(Level.MEDIUM);
        System.out.println("##########");
        appInterface.listContest(Level.HARD);

        System.out.println("##########");
        appInterface.showLeaderBoard(SortingOrder.ASC);

        appInterface.attendContest(1, "monica");
        appInterface.attendContest(1, "rachel");

        appInterface.logIn("faizan");
        appInterface.runContest(1, "faizan");


        System.out.println("##########");
        appInterface.showLeaderBoard(SortingOrder.ASC);



    }
}