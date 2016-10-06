package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Rock, Paper, Scissors " +
                "\n1. Type PLAY to start the game" +
                "\n2. Type HISTORY to check out your game history" +
                "\n3. Type QUIT to quit the game.");
        mainMenuSelection();

    }

    public static void mainMenuSelection() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        switch (userInput.toUpperCase()) {
            case "PLAY":
                userPlay();
                break;
            case "HISTORY":
            case "QUIT":
                System.exit(0);
                break;
            default:
                System.out.println("Wrong selection. Please type PLAY, HISTORY or QUIT");
                mainMenuSelection();
                break;

        }
    }

    public static void userPlay() {
        System.out.println("\nType in ROCK, PAPER or SCISSORS to play." +
                "\nOr type QUIT to go back to the Main Menu\n");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        switch (userInput.toUpperCase()) {
            case "ROCK":
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
                        userPlay();
                        break;
                    case "PAPER":
                        System.out.println("\nComputer chooses: PAPER! You lost!\n");
                        userPlay();
                        break;
                    case "SCISSORS":
                        System.out.println("\nComputer chooses: SCISSORS! You win!\n");
                        userPlay();
                        break;
                }
                break;
            case "PAPER":
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
                        userPlay();
                        break;
                    case "PAPER":
                        System.out.println("\nComputer chooses: PAPER! It is a tie!\n");
                        userPlay();
                        break;
                    case "SCISSORS":
                        System.out.println("\nComputer chooses: SCISSORS! You lost!\n");
                        userPlay();
                        break;
                }
                break;
            case "SCISSORS":
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
                        userPlay();
                        break;
                    case "PAPER":
                        System.out.println("\nComputer chooses: PAPER! You win!\n");
                        userPlay();
                        break;
                    case "SCISSORS":
                        System.out.println("\nComputer chooses: SCISSORS! It is a tie\n");
                        userPlay();
                        break;
                }
                break;
            case "QUIT":
                System.exit(0);
                break;
            default:
                System.out.println("Wrong word entered.");
                userPlay();
                break;
        }

    }
}
