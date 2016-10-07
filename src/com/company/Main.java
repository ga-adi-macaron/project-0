package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int gamesPlayed = 0;
    static List<String> currentGameList;
    static List<String> gameHistory;

    public static void main(String[] args) {
        currentGameList = new ArrayList<>();
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
                userHistory();
                mainMenuSelection();
                break;
            case "QUIT":
                System.exit(0);
                break;
            default:
                System.out.println("\nWrong selection. Please type PLAY, HISTORY or QUIT\n");
                mainMenuSelection();
                break;

        }
    }

    public static void userHistory() {
        if (gamesPlayed == 0) {
            File history = new File("/Users/serkanbal/Desktop/project-0/save-files/history.txt");
            if (history.exists()) {
                try {
                    Scanner s = new Scanner(new File("/Users/serkanbal/Desktop/project-0/save-files/history.txt"));
                    ArrayList<String> readArray = new ArrayList<>();
                    while (s.hasNextLine()) {
                        readArray.add(s.nextLine());
                    }
                    s.close();
                    for (int i = 0; i < readArray.size(); i++) {
                        gameHistory.add(readArray.get(i));
                    }
                    System.out.println("\n==GAME HISTORY FROM PREVIOUS SESSION===\n" + "\nTotal number of games played " +
                            "last session: " + gameHistory.size()/3 + "\n");
                    for (int i = 0; i < gameHistory.size()-2; i+=3) {
                        System.out.println("User Selection: " + gameHistory.get(i) + " - Computer Selection: " +
                                gameHistory.get(i+1) + " - Game Result: " + gameHistory.get(i+2));
                    }
                    gameHistory.clear();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No Game Results Yet!"); }
        } else {
            System.out.println("\n==GAME HISTORY===\n" + "\nTotal number of games played this session: " + gamesPlayed + "\n");
            for (int i = 0; i < currentGameList.size()-2; i+=3) {
                System.out.println("User Selection: " + currentGameList.get(i) + " - Computer Selection: " +
                        currentGameList.get(i+1) + " - Game Result: " + currentGameList.get(i+2));
            }
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
                currentGameList.add("ROCK");
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
                        currentGameList.add("ROCK");
                        currentGameList.add("TIE");
                        userPlay();
                        break;
                    case "PAPER":
                        System.out.println("\nComputer chooses: PAPER! You lost!\n");
                        currentGameList.add("PAPER");
                        currentGameList.add("USER LOST");
                        userPlay();
                        break;
                    case "SCISSORS":
                        System.out.println("\nComputer chooses: SCISSORS! You win!\n");
                        currentGameList.add("SCISSORS");
                        currentGameList.add("USER WON");
                        userPlay();
                        break;
                }
                break;
            case "PAPER":
                gamesPlayed++;
                currentGameList.add("PAPER");
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
                        currentGameList.add("ROCK");
                        currentGameList.add("USER WON");
                        userPlay();
                        break;
                    case "PAPER":
                        System.out.println("\nComputer chooses: PAPER! It is a tie!\n");
                        currentGameList.add("PAPER");
                        currentGameList.add("TIE");
                        userPlay();
                        break;
                    case "SCISSORS":
                        System.out.println("\nComputer chooses: SCISSORS! You lost!\n");
                        currentGameList.add("SCISSORS");
                        currentGameList.add("USER LOST");
                        userPlay();
                        break;
                }
                break;
            case "SCISSORS":
                gamesPlayed++;
                currentGameList.add("SCISSORS");
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
                        currentGameList.add("SCISSORS");
                        currentGameList.add("USER LOST");
                        userPlay();
                        break;
                    case "PAPER":
                        System.out.println("\nComputer chooses: PAPER! You win!\n");
                        currentGameList.add("PAPER");
                        currentGameList.add("USER WON");
                        userPlay();
                        break;
                    case "SCISSORS":
                        System.out.println("\nComputer chooses: SCISSORS! It is a tie\n");
                        currentGameList.add("SCISSORS");
                        currentGameList.add("TIE");
                        userPlay();
                        break;
                }
                break;
            case "QUIT":
                if (gamesPlayed != 0) {
                    //Write User selections to File1
                    // Creating a PrintStream object
                    PrintStream ps = null;

                    try {
                        ps = new PrintStream("/Users/serkanbal/Desktop/project-0/save-files/history.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    //Going through each object and writing it to file
                    for (int i = 0; i < currentGameList.size(); i++) {
                        ps.println(currentGameList.get(i));
                    }
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