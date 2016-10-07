package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int gamesPlayed = 0;
    static List<String> userSelections;
    static List<String> userHistory;
    static List<String> computerSelections;
    static List<String> computerHistory;
    static List<String> gameResult;
    static List<String> gameHistory;


    public static void main(String[] args) {
        computerSelections = new ArrayList<>();
        userHistory = new ArrayList<>();
        userSelections = new ArrayList<>();
        computerHistory = new ArrayList<>();
        gameResult = new ArrayList<>();
        gameHistory = new ArrayList<>();
        mainMenuSelection();
    }

    public static void mainMenuSelection() {
        System.out.println("\n=====MAIN MENU=====\n" +
                "\nWelcome to Rock, Paper, Scissors " +
                "\n1. Type PLAY to start the game" +
                "\n2. Type HISTORY to check out your game history" +
                "\n3. Type QUIT to quit the game.\n");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        switch (userInput.toUpperCase()) {
            case "PLAY":
                userPlay();
                break;
            case "HISTORY":
                System.out.println("\n==GAME HISTORY===\n" + "\nTotal number of games played: " + gamesPlayed + "\n");
                for (int i = 0; i < userSelections.size(); i++) {
                        System.out.println("User Selection: " + userSelections.get(i) + " - Computer Selection: " +
                                computerSelections.get(i) + " - Game Result: " +gameResult.get(i));
                }
                mainMenuSelection();
                break;
            case "QUIT":
                System.exit(0);
                break;
            case "PRINT":
                File history = new File("/Users/serkanbal/Desktop/project-0/save-files/history.txt");
                if (history.exists()) {
                    try {
                        Scanner s = new Scanner(new File("/Users/serkanbal/Desktop/project-0/save-files/history.txt"));
                        ArrayList<String> readArray = new ArrayList<>();
                        while (s.hasNextLine()) {
                            readArray.add(s.nextLine());
                        }
                        s.close();
                        for (int i = 0; i < readArray.size(); i+=3) {
                            userHistory.add(readArray.get(i));
                        }
                        for (int i = 1; i < readArray.size(); i+=3) {
                            computerHistory.add(readArray.get(i));
                        }
                        for (int i = 2; i < readArray.size(); i+=3) {
                            gameHistory.add(readArray.get(i));
                        }
                        for (int i = 0; i < userHistory.size(); i++) {
                            System.out.println("User Selection: " + userHistory.get(i) + " - Computer Selection: " +
                                    computerHistory.get(i) + " - Game Result: " +gameHistory.get(i));
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("File cannot be found"); }
                break;
            default:
                System.out.println("\nWrong selection. Please type PLAY, HISTORY or QUIT\n");
                mainMenuSelection();
                break;

        }
    }

    public static void userPlay() {

        System.out.println("Type in ROCK, PAPER or SCISSORS to play." +
                "\nOr type QUIT to go back to the Main Menu\n");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        switch (userInput.toUpperCase()) {
            case "ROCK":
                gamesPlayed++;
                userSelections.add("ROCK");
                String computerselection0 = "";
                int rng0 = 0 + (int)(Math.random() * ((2 - 0) + 1)); //RNG between min value 0 and max value 2; so
                //the only random numbers returning are 0,1,2.
                if (rng0 == 0) { computerselection0 = "ROCK";
                } else if (rng0 == 1) { computerselection0 = "PAPER";
                } else if (rng0 == 2) { computerselection0 = "SCISSORS";
                }
                switch (computerselection0) {
                    case "ROCK":
                        System.out.println("\nComputer chooses: ROCK! It is a tie!\n");
                        computerSelections.add("ROCK");
                        gameResult.add("TIE");
                        userPlay();
                        break;
                    case "PAPER":
                        System.out.println("\nComputer chooses: PAPER! You lost!\n");
                        computerSelections.add("PAPER");
                        gameResult.add("USER LOST");
                        userPlay();
                        break;
                    case "SCISSORS":
                        System.out.println("\nComputer chooses: SCISSORS! You win!\n");
                        computerSelections.add("SCISSORS");
                        gameResult.add("USER WON");
                        userPlay();
                        break;
                }
                break;
            case "PAPER":
                gamesPlayed++;
                userSelections.add("PAPER");
                String computerSelection1 = "";
                int rng1 = 0 + (int)(Math.random() * ((2 - 0) + 1)); //RNG between min value 0 and max value 2; so
                //the only random numbers returning are 0,1,2.
                if (rng1 == 0) { computerSelection1 = "ROCK";
                } else if (rng1 == 1) { computerSelection1 = "PAPER";
                } else if (rng1 == 2) { computerSelection1 = "SCISSORS";
                }
                switch (computerSelection1) {
                    case "ROCK":
                        System.out.println("\nComputer chooses: ROCK! You win!\n");
                        computerSelections.add("ROCK");
                        gameResult.add("USER WON");
                        userPlay();
                        break;
                    case "PAPER":
                        System.out.println("\nComputer chooses: PAPER! It is a tie!\n");
                        computerSelections.add("PAPER");
                        gameResult.add("TIE");
                        userPlay();
                        break;
                    case "SCISSORS":
                        System.out.println("\nComputer chooses: SCISSORS! You lost!\n");
                        computerSelections.add("SCISSORS");
                        gameResult.add("USER LOST");
                        userPlay();
                        break;
                }
                break;
            case "SCISSORS":
                gamesPlayed++;
                userSelections.add("SCISSORS");
                String computerSelection2 = "";
                int rng2 = 0 + (int)(Math.random() * ((2 - 0) + 1)); //RNG between min value 0 and max value 2; so
                //the only random numbers returning are 0,1,2.
                if (rng2 == 0) { computerSelection2 = "ROCK";
                } else if (rng2 == 1) { computerSelection2 = "PAPER";
                } else if (rng2 == 2) { computerSelection2 = "SCISSORS";
                }
                switch (computerSelection2) {
                    case "ROCK":
                        System.out.println("\nComputer chooses: ROCK! You lost!\n");
                        computerSelections.add("SCISSORS");
                        gameResult.add("USER LOST");
                        userPlay();
                        break;
                    case "PAPER":
                        System.out.println("\nComputer chooses: PAPER! You win!\n");
                        computerSelections.add("PAPER");
                        gameResult.add("USER WON");
                        userPlay();
                        break;
                    case "SCISSORS":
                        System.out.println("\nComputer chooses: SCISSORS! It is a tie\n");
                        computerSelections.add("SCISSORS");
                        gameResult.add("TIE");
                        userPlay();
                        break;
                }
                break;
            case "QUIT":
                //Write User selections to File1
                // Creating a PrintStream object
                PrintStream ps = null;

                try {
                    ps = new PrintStream("/Users/serkanbal/Desktop/project-0/save-files/history.txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                //Going through each object and writing it to file
                for (int i = 0; i < userSelections.size(); i++) {
                    ps.println(userSelections.get(i));
                    ps.println(computerSelections.get(i));
                    ps.println(gameResult.get(i));

                }
                mainMenuSelection();
                break;
            default:
                System.out.println("Wrong word entered.\n");
                userPlay();
                break;
        }

    }
}