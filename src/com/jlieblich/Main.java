package com.jlieblich;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        final String OPTIONS = "=======OPTIONS=======";
        final String MENU = "======MAIN MENU======";
        final String MENUBAR = "=====================";
        //Displays opening dialogue and initial menu
        System.out.println("Welcome to Rock. Paper, Scissors!" +
                "\nPlease note: we cannot guarantee that this game is not rigged.");
        System.out.println(MENUBAR + MENUBAR);
        System.out.println(MENU + OPTIONS);
        System.out.println(MENUBAR + MENUBAR + "\n");
        System.out.println("\'Play\' to start new game");
        System.out.println("\'History\' to view past games");
        System.out.println("***NOTE: you may quit any time by typing \'EXIT\' or \'QUIT\' (case sensitive)***\n\n");
        do {
            String getInput = userInput();
            if(getInput.equals("play")) {
                gameMain();
            } else if(getInput.equals("history")) {
                for (int i = 0; i < gameHistory.size(); i++) {
                    System.out.println(i+1 + ". " + gameHistory.get(i));
                }
                System.out.println("(PLAY/HISTORY/EXIT");
            } else {
                System.out.println("(PLAY/HISTORY/EXIT)");
            }
        } while(true);
    }

    public static List<String> gameHistory = new ArrayList<>();

    //Returns win/loss/tie based on user and computer input
    public static void gameMain() {
        final String cRock = "PC: ROCK";
        final String cPaper = "PC: PAPER";
        final String cScissors = "PC: SCISSORS";
        System.out.println("Type your choice (ROCK/PAPER/SCISSORS)");
        String userChoice = userInput();
        String computerChoice = randomInput();
        switch (computerChoice) {
            case "rock":
                if (userChoice.equals("paper")) {
                    System.out.println(cRock + "\nYOU: " + userChoice
                    + "\nYou win!\n(PLAY/HISTORY/EXIT)");
                    gameHistory.add("User win\nUSER CHOICE: " + userChoice
                    + " PC CHOICE: " + computerChoice);
                } else if (userChoice.equals("rock")) {
                    System.out.println(cRock + "\nYOU: " + userChoice
                    + "\nIt's a tie.\n(PLAY/HISTORY/EXIT)");
                    gameHistory.add("TIE: ROCK v ROCK");
                } else if (userChoice.equals("scissors")) {
                    System.out.println(cRock + "\nYOU: " + userChoice
                    + "\nYou lost...\n(PLAY/HISTORY/EXIT)");
                    gameHistory.add("Computer win\nUSER CHOICE: " + userChoice
                    + " PC CHOICE: " + computerChoice);
                }
                break;
            case "paper":
                if (userChoice.equals("paper")) {
                    System.out.println(cPaper + "\nYOU: " + userChoice
                    + "\nIt's a tie.\n(PLAY/HISTORY/EXIT)");
                    gameHistory.add("TIE: PAPER v PAPER");
                } else if (userChoice.equals("rock")) {
                    System.out.println(cPaper + "\nYOU: " + userChoice
                    + "\nYou lost...\n(PLAY/HISTORY/EXIT)");
                    gameHistory.add("Computer win\nUSER CHOICE: " + userChoice
                    + " PC CHOICE: " + computerChoice);
                } else if (userChoice.equals("scissors")) {
                    System.out.println(cPaper + "\nYOU: " + userChoice
                    + "\nYou win!\n(PLAY/HISTORY/EXIT)");
                    gameHistory.add("User win\nUSER CHOICE: " + userChoice
                    + " PC CHOICE: " + computerChoice);
                }
                break;
            case "scissors":
                if(userChoice.equals("paper")) {
                    System.out.println(cScissors + "\nYOU: " + userChoice
                    + "\nYou lost...\n(PLAY/HISTORY/EXIT)");
                    gameHistory.add("Computer win\nUSER CHOICE: " + userChoice
                    + " PC CHOICE: " + computerChoice);
                } else if(userChoice.equals("rock")) {
                    System.out.println(cScissors + "\nYOU: " + userChoice
                    + "\nYou win!\n(PLAY/HISTORY/EXIT)");
                    gameHistory.add("User win\nUSER CHOICE: " + userChoice
                    + " PC CHOICE: " + computerChoice);
                } else if(userChoice.equals("scissors")) {
                    System.out.println(cScissors + "\nYOU: " + userChoice
                    + "\nIt's a tie.\n(PLAY/HISTORY/EXIT)");
                    gameHistory.add("TIE: SCISSORS v SCISSORS");
                }
                break;
            default:
                System.out.println("Your opponent is a sore loser and has left the game");
                System.exit(0);
        }
    }

    //Randomly selects rock/paper/scissors for the computer's input
    public static String randomInput() {
        double x = Math.round((Math.random()*3)+1);
        if(x == 1)
            return "rock";
        else if(x == 2)
            return "paper";
        else
            return "scissors";
    }

    //Represents the user's input during all stages
    public static String userInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("ACTION: ");
        String input = s.nextLine();
        if(input.equalsIgnoreCase("paper")) {
            return "paper";
        } else if(input.equalsIgnoreCase("rock")) {
            return "rock";
        } else if(input.equalsIgnoreCase("scissors")) {
            return "scissors";
        } else if(input.equalsIgnoreCase("play")){
            return "play";
        } else if(input.equalsIgnoreCase("history")) {
            return "history";
        } else if(input.equals("EXIT")||input.equals("QUIT")){
            System.exit(0);
            return "";
        } else {
            return "INVALID INPUT";
        }
    }
}