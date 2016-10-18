package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static List<String> gameRecords = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissors! \nCheck out the Shirt!");
        mainMenuLoop();
    }

    public static String userInput(){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String inputLowerCase = input.toLowerCase();
        System.out.println(inputLowerCase); // Bonus: Handles Capitalization of userInput
        return inputLowerCase;
    }

    public static void mainMenuLoop(){
        System.out.println("\n** Main Menu ** \n:Enter 'play' to Play Game");
        System.out.println(":Enter 'quit' to Exit\n:Enter 'history' to view your Game History");
        String option = userInput();
        if (option.equals("play")){
            gameLoop();
        } else if (option.equals("quit")){
            System.out.println("Thanks for playing!");
            return;
        } else if (option.equals("history")){
            gameHistory();
        } else {
            System.out.println("Invalid input");
            mainMenuLoop();
        }
    }

    public static void gameLoop(){
        System.out.println("** CHOOSE WISELY **");
        System.out.println(":Enter 'rock' 'paper' or 'scissors' \n:Enter 'back' for Main Menu");
        String option = userInput();
        if (option.equals("back")) {
            mainMenuLoop();
        } else {
            System.out.println("Invalid input");
            gameLoop();
        }

    }

    // Computer
    public static int com(){
        Random comPick = new Random();
        int comChoice = comPick.nextInt(3);
        return comChoice;
    }

    // Unaccessable Method
    public static void gameTime(){
        int comChoice = com();
        int userChoice = -1;

        while (userChoice == -1){
            //userChoice = userInput(); //Error
        }

        // Rock = 0
        // Paper = 1
        // Scissors = 2

        if (comChoice == 0 && userChoice == 2){
            String pick1 = ("Computer Picks: rock" +
                    "\nUser picks: scissors" +
                    "\nYou lose!");
            System.out.println(pick1);
            gameRecords.add(pick1);
        }

        if (comChoice == 0 && userChoice == 1){
            String pick2 = ("Computer Picks: rock\n" +
                    "\nUser Picks: paper" +
                    "\nYou Win!");
            System.out.println(pick2);
            gameRecords.add(pick2);
        }

        if (comChoice == 1 && userChoice == 2){
            String pick3 = ("Computer Picks: paper" +
            "\nUser Picks: scissors"+
            "\nYou Win!");
            System.out.println(pick3);
            gameRecords.add(pick3);
        }
    }

    public static void gameHistory(){
        for (int i = 0; i < gameRecords.size(); i++) {
            System.out.println(gameRecords.get(i) + "\n");
        } mainMenuLoop();
    }
}
