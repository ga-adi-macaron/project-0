import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by drewmahrt on 4/22/16.
 */
public class Main {

    private static final String GAME_HISTORY_FILE_NAME = "game_history.txt";

    private static List<String> mGameHistory;
    private static Path mGameHistoryFilePath;
    private static boolean mGameHistoryFileAvailable = false;

    public static void main(String[] args) {

        System.out.println("\nWelcome to Rock Paper Scissors!");

        // Initialize to a new empty ArrayList
        mGameHistory = new ArrayList<>();

        // Create the game history file if it doesn't already exist
        mGameHistoryFilePath = Paths.get(GAME_HISTORY_FILE_NAME);

        if (Files.exists(mGameHistoryFilePath)) {
            mGameHistoryFileAvailable = true;
        } else {
            try {
                mGameHistoryFilePath = Files.createFile(mGameHistoryFilePath);
                mGameHistoryFileAvailable = true;
            } catch (IOException e) {
                e.printStackTrace();
                mGameHistoryFileAvailable = false;
            }
        }

        // Add history from file to mGameHistory (if file is available)
        if (mGameHistoryFileAvailable) {
            try {
                mGameHistory = Files.readAllLines(Paths.get(GAME_HISTORY_FILE_NAME), Charset.defaultCharset());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Show the main menu
        mainMenu();
    }

    private static void mainMenu() {
        System.out.println("\nMAIN MENU\n=====\n- Type 'play' to play");
        System.out.println("- Type 'history' to view your game history\n- Type 'quit' to stop playing\n");

        Scanner scanner = new Scanner(System.in);

        // Convert to lower case to ignore any capitalization by the user
        String input = scanner.nextLine().toLowerCase();

        switch (input) {
            case "play":
                playGame();
                break;
            case "history":
                System.out.println("=== GAME HISTORY ===");
                for (String gameResult : mGameHistory) {
                    System.out.println(gameResult);
                }
                mainMenu();
                break;
            case "quit":
                return;
            default:
                System.out.println("Invalid input, please try again.\n");
                mainMenu();
                break;
        }

    }

    private static void playGame(){
        String playerChoice = getPlayerChoice();
        String computerChoice = getComputerChoice();

        switch (playerChoice) {
            case "rock":
                System.out.println("Computer picks: "+computerChoice+"\nUser picks: "+playerChoice);
                if (computerChoice.equals("paper")) {
                    System.out.println("You lose!");
                    addResultToHistory("LOSS: Player-"+ playerChoice +" computer-"+computerChoice);
                } else if (computerChoice.equals("scissors")){
                    System.out.println("You win!");
                    addResultToHistory("WIN: Player-"+ playerChoice +" computer-"+computerChoice);
                } else {
                    System.out.println("Tie!");
                    addResultToHistory("TIE: Player-"+ playerChoice +" computer-"+computerChoice);
                }
                break;

            case "paper":
                System.out.println("Computer picks: "+computerChoice+"\nUser picks: "+playerChoice);
                if (computerChoice.equals("scissors")) {
                    System.out.println("You lose!");
                    addResultToHistory("LOSS: Player-"+ playerChoice +" computer-"+computerChoice);
                } else if (computerChoice.equals("rock")){
                    System.out.println("You win!");
                    addResultToHistory("WIN: Player-"+ playerChoice +" computer-"+computerChoice);
                } else {
                    System.out.println("Tie!");
                    addResultToHistory("TIE: Player-"+ playerChoice +" computer-"+computerChoice);
                }
                break;

            case "scissors":
                System.out.println("Computer picks: "+computerChoice+"\nUser picks: "+playerChoice);
                if (computerChoice.equals("rock")) {
                    System.out.println("You lose!");
                    addResultToHistory("LOSS: Player-"+ playerChoice +" computer-"+computerChoice);
                } else if (computerChoice.equals("paper")) {
                    System.out.println("You win!");
                    addResultToHistory("WIN: Player-"+ playerChoice +" computer-"+computerChoice);
                } else {
                    System.out.println("Tie!");
                    addResultToHistory("TIE: Player-" + playerChoice + " computer-" + computerChoice);
                }
                break;

            case "quit":
                break;

            default:
                break;
        }

        mainMenu();
    }

    private static String getPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        String playerChoice = "";

        // Keep looping until the user provides a valid choice
        while(!playerChoice.equals("rock") && !playerChoice.equals("paper") &&
                !playerChoice.equals("scissors") && !playerChoice.equals("quit")) {

            System.out.println("\n\nType in 'rock' 'paper' or 'scissors' to play.");
            System.out.println("Type 'quit' to go back to the Main Menu\n");

            // Convert to lower case to ignore any capitalization by the user
            playerChoice = scanner.nextLine().toLowerCase();
        }

        return playerChoice;
    }

    private static String getComputerChoice(){
        Random r = new Random(System.currentTimeMillis());
        int choice = r.nextInt(3);

        switch (choice) {
            case 0:
                return "rock";
            case 1:
                return "scissors";
            case 2:
                return "paper";
            default:
                return "";
        }
    }

    private static void addResultToHistory(String result) {
        // Add to the array list
        mGameHistory.add(result);

        // Write to the game history file
        if (mGameHistoryFileAvailable) {
            try {
                Files.write(mGameHistoryFilePath, result.concat("\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
