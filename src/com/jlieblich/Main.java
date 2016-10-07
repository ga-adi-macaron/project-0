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
                    System.out.println(i + 1 + ". " + gameHistory.get(i));
                }
            }
            System.out.println("(PLAY/HISTORY/EXIT)");
        } while(true);
    }

    //List to store game results
    private static List<String> gameHistory = new ArrayList<>();

    //Returns win/loss/tie based on user and computer input
    private static void gameMain() {
        System.out.println("Type your choice (ROCK/PAPER/SCISSORS)");
        String userChoice = userInput();
        String computerChoice = randomInput();
        printResult(userChoice, computerChoice);
        //gameMain();
    }

    //Randomly selects rock/paper/scissors for the computer's input
    private static String randomInput() {
        double x = Math.round((Math.random()*3)+1);
        if(x == 1)
            return "rock";
        else if(x == 2)
            return "paper";
        else
            return "scissors";
    }

    //Represents the user's input during all stages and ensures proper format
    private static String userInput() {
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
            return "";
        }
    }

    private static void printResult(String user, String pc) {
        switch (user) {
            case "rock":
                switch (pc) {
                    case "rock":
                        System.out.println("TIE @ ROCK");
                        gameHistory.add("TIE - ROCK");
                        break;
                    case "paper":
                        System.out.println("PC WINS - PAPER COVERS ROCK");
                        gameHistory.add("PC WIN - PAPER");
                        break;
                    case "scissors":
                        System.out.println("USER WINS - ROCK CRUSHES SCISSORS");
                        gameHistory.add("USER WIN - ROCK");
                        break;
                    default:
                        System.out.println("system failure...");
                        break;
                }
                break;
            case "paper":
                switch (pc) {
                    case "rock":
                        System.out.println("USER WINS - PAPER COVERS ROCK");
                        gameHistory.add("USER WIN - PAPER");
                        break;
                    case "paper":
                        System.out.println("TIE @ PAPER");
                        gameHistory.add("TIE - PAPER");
                        break;
                    case "scissors":
                        System.out.println("PC WINS - SCISSORS CUT PAPER");
                        gameHistory.add("PC WIN - SCISSORS");
                        break;
                    default:
                        System.out.println("system failure...");
                        break;
                }
                break;
            case "scissors":
                switch (pc) {
                    case "rock":
                        System.out.println("PC WINS - ROCK CRUSHES SCISSORS");
                        gameHistory.add("PC WIN - ROCK");
                        break;
                    case "paper":
                        System.out.println("USER WINS - SCISSORS CUT PAPER");
                        gameHistory.add("USER WIN - SCISSORS");
                        break;
                    case "scissors":
                        System.out.println("TIE @ SCISSORS");
                        gameHistory.add("TIE - SCISSORS");
                        break;
                    default:
                        System.out.println("system failure...");
                        break;
                }
                break;
            default:
                System.out.println("Type your choice (ROCK/PAPER/SCISSORS)");
                String tryAgain = userInput();
                printResult(tryAgain, pc);
        }
    }
}