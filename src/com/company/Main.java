package com.company;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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
            default:
                System.out.println("Wrong selection. Please type PLAY, HISTORY or QUIT");
                mainMenuSelection();
                break;

        }
    }

    public static void userPlay() {
        System.out.println("Type in ROCK, PAPER or SCISSORS to play." +
                "\nOr type QUIT to go back to the Main Menu");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        switch (userInput.toUpperCase()) {
            case "ROCK":
                String computerSelection = "";
                int rng = 0 + (int)(Math.random() * ((2 - 0) + 1)); //RNG between min value 0 and max value 2; so
                //the only random numbers returning are 0,1,2.
                if (rng == 0) { computerSelection = "ROCK";
                } else if (rng == 1) { computerSelection = "PAPER";
                } else if (rng == 2) { computerSelection = "SCISSORS";
                }
                switch (computerSelection) {
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

            case "PAPER":
            case "SCISSORS":
        }

    }
}
