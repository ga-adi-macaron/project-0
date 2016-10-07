package com.jlieblich;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("\'Play\' to start new game (recommended for first time users)");
        System.out.println("\'Regular\' to play a regular game");
        System.out.println("\'Advanced\' to play an advanced game");
        System.out.println("\'History\' to view past games");
        System.out.println("***NOTE: you may quit any time by typing \'EXIT\' or \'QUIT\' (case sensitive)***");
        do {
            System.out.println("Awaiting user selection (play, get history, or quit)");
            String getInput = userInput();
            switch (getInput) {
                case "play":
                    System.out.println("Regular Game:\nROCK > SCISSORS > PAPER > ROCK");
                    System.out.println("====================================================");
                    System.out.println("Advanced Rules:");
                    System.out.println("Two additional choices (LIZARD/SPOCK)");
                    System.out.println("LIZARD: wins v SPOCK/PAPER loses v ROCK/SCISSORS");
                    System.out.println("SPOCK: wins v ROCK/SCISSORS loses v LIZARD/PAPER");
                    System.out.println("=====================================================");
                    System.out.println("Choose a game type, display history, or quit the game");
                    break;
                case "advanced":
                    gameMainAdv();
                    break;
                case "regular":
                    gameMainReg();
                    break;
                case "history":
                    getHistory();
                    break;
                default:
                    System.out.println("Play, get history, or quit the game");
                    break;
            }
        } while(true);
    }

    private static List<String> gameHistory = new ArrayList<>();

    private static void getHistory() {
        for(int i=0;i<gameHistory.size();i++) {
            System.out.println(i+1 + ". " + gameHistory.get(i));
        }
    }

    private static void gameMainAdv() {
        System.out.println("(ROCK/PAPER/SCISSORS/LIZARD/SPOCK)");
        String userChoice = userInput();
        advancedGameResult(userChoice, randomInputAdvanced());
        System.out.println("Play again?");
        if(userInput().equals("Y"))
            gameMainAdv();
    }

    private static void gameMainReg() {
        System.out.println("(ROCK/PAPER/SCISSORS)");
        String userChoice = userInput();
        printResult(userChoice, randomInput());
        System.out.println("Play again?");
        if(userInput().equals("Y"))
            gameMainReg();
    }

    private static void advancedGameResult(String user, String pc) {
        switch(user) {
            case "rock":
                switch(pc) {
                    case "rock":
                        System.out.println("TIE: ROCK");
                        gameHistory.add("(a)TIE - ROCK");
                        break;
                    case "paper":
                        System.out.println("PC WINS: PAPER V ROCK");
                        gameHistory.add("(a)PC WIN - PAPER|ROCK");
                        break;
                    case "scissors":
                        System.out.println("USER WINS: ROCK V SCISSORS");
                        gameHistory.add("(a)USER WIN - ROCK|SCISSORS");
                        break;
                    case "lizard":
                        System.out.println("USER WINS: ROCK V LIZARD");
                        gameHistory.add("(a)USER WIN - ROCK|LIZARD");
                        break;
                    case "spock":
                        System.out.println("PC WINS: SPOCK V ROCK");
                        gameHistory.add("(a)PC WIN - SPOCK|ROCK");
                        break;
                }
                break;
            case "paper":
                switch(pc) {
                    case "rock":
                        System.out.println("USER WINS: PAPER V ROCK");
                        gameHistory.add("(a)USER WIN - PAPER|ROCK");
                        break;
                    case "paper":
                        System.out.println("TIE: PAPER");
                        gameHistory.add("(a)TIE - PAPER");
                        break;
                    case "scissors":
                        System.out.println("PC WINS: SCISSORS V PAPER");
                        gameHistory.add("(a)PC WIN - SCISSORS|PAPER");
                        break;
                    case "lizard":
                        System.out.println("PC WINS: LIZARD V PAPER");
                        gameHistory.add("(a)PC WIN - LIZARD|PAPER");
                        break;
                    case "spock":
                        System.out.println("USER WINS: PAPER V SPOCK");
                        gameHistory.add("(a)USER WIN - PAPER|SPOCK");
                        break;
                }
                break;
            case "scissors":
                switch(pc) {
                    case "rock":
                        System.out.println("PC WINS: ROCK V SCISSORS");
                        gameHistory.add("(a)PC WIN - ROCK|SCISSORS");
                        break;
                    case "paper":
                        System.out.println("USER WINS: SCISSORS V PAPER");
                        gameHistory.add("(a)USER WIN - SCISSORS|PAPER");
                        break;
                    case "scissors":
                        System.out.println("TIE: SCISSORS");
                        gameHistory.add("(a)TIE - SCISSORS");
                        break;
                    case "lizard":
                        System.out.println("USER WINS: SCISSORS V LIZARD");
                        gameHistory.add("(a)USER WIN - SCISSORS|LIZARD");
                        break;
                    case "spock":
                        System.out.println("PC WINS: SPOCK V SCISSORS");
                        gameHistory.add("(a)PC WIN - SPOCK|SCISSORS");
                        break;
                }
                break;
            case "lizard":
                switch(pc) {
                    case "rock":
                        System.out.println("PC WINS: ROCK V LIZARD");
                        gameHistory.add("(a)PC WIN - ROCK|LIZARD");
                        break;
                    case "paper":
                        System.out.println("USER WINS: PAPER V LIZARD");
                        gameHistory.add("(a)USER WIN - PAPER|LIZARD");
                        break;
                    case "scissors":
                        System.out.println("PC WINS: SCISSORS V LIZARD");
                        gameHistory.add("(a)PC WIN - SCISSORS|LIZARD");
                        break;
                    case "lizard":
                        System.out.println("TIE: LIZARD");
                        gameHistory.add("(a)TIE - LIZARD");
                        break;
                    case "spock":
                        System.out.println("USER WINS: LIZARD V SPOCK");
                        gameHistory.add("(a)USER WIN - LIZARD|SPOCK");
                        break;
                }
                break;
            case "spock":
                switch(pc) {
                    case "rock":
                        System.out.println("USER WINS: SPOCK V ROCK");
                        gameHistory.add("(a)USER WIN - SPOCK|ROCK");
                        break;
                    case "paper":
                        System.out.println("PC WINS: PAPER V SPOCK");
                        gameHistory.add("(a)PC WIN - PAPER|SPOCK");
                        break;
                    case "scissors":
                        System.out.println("USER WINS: SPOCK V SCISSORS");
                        gameHistory.add("(a)USER WIN - SPOCK|PAPER");
                        break;
                    case "lizard":
                        System.out.println("PC WINS: LIZARD V SPOCK");
                        gameHistory.add("(a)PC WIN - LIZARD|SPOCK");
                        break;
                    case "spock":
                        System.out.println("TIE: SPOCK");
                        gameHistory.add("(a)TIE - SPOCK");
                        break;
                }
                break;
            case "history":
                getHistory();
            default:
                System.out.println("Type your choice (ROCK/PAPER/SCISSORS/LIZARD/SPOCK)");
                String tryAgain = userInput();
                advancedGameResult(tryAgain, randomInput());
        }
    }

    //Randomly selects rock/paper/scissors for the computer's input
    private static String randomInput() {
        double pcChoice = Math.round((Math.random()*3)+1);
        if(pcChoice == 1)
            return "rock";
        else if(pcChoice == 2)
            return "paper";
        else
            return "scissors";
    }

    private static String randomInputAdvanced() {
        double pcChoice = Math.round(Math.random()*5)+1;
        if(pcChoice == 1)
            return "rock";
        else if(pcChoice == 2)
            return "paper";
        else if(pcChoice == 3)
            return "scissors";
        else if(pcChoice == 4)
            return "lizard";
        else
            return "spock";
    }

    //Represents the user's input during all stages and ensures proper format
    private static String userInput() {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        if (input.equalsIgnoreCase("paper")) {
            return "paper";
        } else if (input.equalsIgnoreCase("rock")) {
            return "rock";
        } else if (input.equalsIgnoreCase("scissors")) {
            return "scissors";
        } else if(input.equalsIgnoreCase("spock")) {
            return "spock";
        } else if(input.equalsIgnoreCase("lizard")) {
            return "lizard";
        } else if (input.equalsIgnoreCase("play")) {
            return "play";
        } else if(input.equalsIgnoreCase("regular")) {
            return "regular";
        } else if(input.equalsIgnoreCase("advanced")) {
            return "advanced";
        } else if(input.equalsIgnoreCase("history")) {
            return "history";
        } else if(input.equalsIgnoreCase("y")||input.equalsIgnoreCase("yes")) {
            return "Y";
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
                        System.out.println("TIE: ROCK");
                        gameHistory.add("TIE - ROCK");
                        break;
                    case "paper":
                        System.out.println("PC WINS: PAPER V ROCK");
                        gameHistory.add("PC WIN - PAPER");
                        break;
                    case "scissors":
                        System.out.println("USER WINS: ROCK V SCISSORS");
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
                        System.out.println("USER WINS: PAPER V ROCK");
                        gameHistory.add("USER WIN - PAPER");
                        break;
                    case "paper":
                        System.out.println("TIE: PAPER");
                        gameHistory.add("TIE - PAPER");
                        break;
                    case "scissors":
                        System.out.println("PC WINS: SCISSORS V PAPER");
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
                        System.out.println("PC WINS: ROCK V SCISSORS");
                        gameHistory.add("PC WIN - ROCK");
                        break;
                    case "paper":
                        System.out.println("USER WINS: SCISSORS V PAPER");
                        gameHistory.add("USER WIN - SCISSORS");
                        break;
                    case "scissors":
                        System.out.println("TIE: SCISSORS");
                        gameHistory.add("TIE - SCISSORS");
                        break;
                    default:
                        System.out.println("system failure...");
                        break;
                }
                break;
            case "history":
                getHistory();
            default:
                System.out.println("Type your choice (ROCK/PAPER/SCISSORS)");
                String tryAgain = userInput();
                printResult(tryAgain, pc);
        }
    }
}