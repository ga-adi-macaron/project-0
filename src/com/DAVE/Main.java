package com.DAVE;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.lang.String;


public class Main {

    static List<String> history = new ArrayList<>();


    public static void main(String[] args) {
        // write your code here

        String option = "";

        while (!option.equals("quit")) {

            System.out.println("Welcome to Rock, Paper, Scissors!\n" +
                    "MAIN MENU\n" +
                    "=====\n" +
                    "1. Type 'play' to play\n" +
                    "2. Type 'history' to view your game history\n" +
                    "Type 'quit' to stop playing");

            Scanner plHiQu = new Scanner(System.in);
            option = plHiQu.nextLine();


            if (option.equals("play")) {
                playGame();
            } else if (option.equals("history")) {
                displayHis();
            } else if (!option.equals("quit")){
                System.out.println("Please type something.\n");
            }
        }

    }


    //computer's play
    public static int ranGen() {

        Random numGen = new Random();
        int cpuHand = numGen.nextInt(3);
        return cpuHand;

    }


    public static int userInput() {
        System.out.println("Type in 'rock' 'paper' or 'scissors' to play.\n");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.equals("rock")){
            return 0;
        } else if (input.equals("paper")){
            return 1;
        } else if (input.equals("scissors")) {
            return 2;
        } else {
            System.out.println("Pick a valid choice, please.");
            return -1;
        }

    }

    public static void playGame(){
        int cpuChoice = ranGen();
        int userChoice = -1;


        while (userChoice == -1){
            userChoice = userInput();
        }

        // rock = 0
        // paper = 1
        // scissors = 2

        //res1

        if (cpuChoice == 0 && userChoice == 2) {

            String res1 = "Computer picks: rock\n" +
                    "User picks: scissors\n" +
                    "You lose!\n";

            System.out.println(res1);

            history.add(res1);
        }

        //res2

        if (cpuChoice == 0 && userChoice == 1) {


            String res2 = ("Computer picks: rock\n" +
                    "User picks: paper\n" +
                    "You win!\n");

            System.out.println(res2);

            history.add(res2);
        }


        //res3

        if (cpuChoice == 1 && userChoice == 2) {


            String res3 = ("Computer picks: paper\n" +
            "User picks: scissors\n" +
                    "You win!\n");

            System.out.println(res3);

            history.add(res3);
        }

        //res4

        if (cpuChoice == 1 && userChoice == 0) {

            String res4 = ("Computer picks: paper\n" +
                "User picks: rock\n" +
                "You lose!\n");

            System.out.println(res4);

            history.add(res4);

        }

        //res5

        if (cpuChoice == 2 && userChoice == 0)  {

            String res5 = ("Computer picks: scissors\n" +
                    "User picks: rock\n" +
                    "You lose!\n");

            System.out.println(res5);
            history.add(res5);
        }

        //res6

        if (cpuChoice == 2 && userChoice == 1)  {

            String res6 =("Computer picks: scissors\n" +
                    "User picks: paper\n" +
                    "You lose!\n");

            System.out.println(res6);
            history.add(res6);
        }


        //res7

        if (cpuChoice == 0 && userChoice == 0)  {

            String res7 = ("Computer picks: rock\n" +
                    "User picks: rock\n" +
                    "You tie!\n");

            System.out.println(res7);
            history.add(res7);
        }


        //res8

        if (cpuChoice == 1 && userChoice == 1)  {
           String res8 =("Computer picks: paper\n" +
                    "User picks: paper\n" +
                    "You tie!\n");

            System.out.println(res8);
            history.add(res8);
        }

        //res9


        if (cpuChoice == 2 && userChoice == 2)  {
           String res9= ("Computer picks: scissors\n" +
                    "User picks: scissors\n" +
                    "You tie!\n");

            System.out.println(res9);
            history.add(res9);
        }


    }

    public static void displayHis(){
        for (int i = 0; i < history.size() ; i++) {
            System.out.println(history.get(i) + "\n");

        }
    }
}



