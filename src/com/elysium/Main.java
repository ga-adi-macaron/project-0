package com.elysium;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class Main {

    public static Scanner inputScan = new Scanner(System.in);
    public static ArrayList<String> gameLog = new ArrayList<>();

    public static void main(String[] args) {

        startGame();
        cpuSelection();
    }

    //startGame

    public static void startGame() {
        System.out.println(" ***MAIN MENU***");
        System.out.println(" *  choose one *");
        System.out.println(" *     PLAY    *");
        System.out.println(" *   HISTORY   *");
        System.out.println(" *     QUIT    *");
        System.out.println(" ***************");

        // User makes menu choice

        String choice = inputScan.nextLine();

        if (choice.equals("play")) {
            play();
        } else if (choice.equals("history")) {
            gameLog();
        } else if (choice.equals("quit")) {

        }
        startGame();
    }

    private static void gameLog() {

        System.out.println("+++ Game Log +++");

        for (String result: gameLog) {
            System.out.println(result);
        }
        System.out.println();
        startGame();

    }

    public static void play() {
        System.out.println(" ###CHOOSE ONE### ");
        System.out.println(" ###   rock   ### ");
        System.out.println(" ###   paper  ### ");
        System.out.println(" ### scissors ### ");
        System.out.println(" ################ ");

        //Player chooses one of three options

        String choice = inputScan.nextLine();
        String playerTwo = cpuSelection();

        if (choice.equals("rock")) {
            if (playerTwo.equals("rock")) {
                System.out.println("Tie");
                gameLog.add("Tie");
            }else if (playerTwo.equals("paper")) {
                System.out.println("You lose. CPU has " + playerTwo);
                gameLog.add("You lost");
            }else{
                System.out.println("You win!! CPU has " +playerTwo);
                gameLog.add("You won");
            }

        } else if (choice.equals("paper")) {
            if (playerTwo.equals("paper")) {
                System.out.println("Tie");
                gameLog.add("Tie");
            }else if (playerTwo.equals("rock")) {
                System.out.println("You win!! CPU has " + playerTwo);
                gameLog.add("You won!!");
            }else{
                System.out.println("You lose. CPU has " +playerTwo);
                gameLog.add("You lost");
            }

        } else if (choice.equals("scissors")) {
            if (playerTwo.equals("rock")) {
                System.out.println("You lose. CPU has " + playerTwo);
                gameLog.add("You lost");
            }else if (playerTwo.equals("paper")) {
                System.out.println("You win!! CPU has " + playerTwo);
                gameLog.add("You win");
            }else{
                System.out.println("Tie");
                gameLog.add("Tie");

            }
        }
        startGame();
    }

    //

    //CPU random choices
    public static String cpuSelection() {
        int comp = (int) Math.round(Math.random() * 2);

        if (comp == 0) {
            return "rock";

        }
        else if (comp == 1) {
            return "paper";
        }
        else {
            return "scissors";
        }

    }

}
