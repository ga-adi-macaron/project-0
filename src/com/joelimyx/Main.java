package com.joelimyx;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void rockPaperScissor(String computerChoice, String user_Choice, String winCondition){
        //Rock
        System.out.println("The computer pick "+computerChoice+".");
        System.out.println("You pick "+ user_Choice+".");

        if (computerChoice.equals("Rock")){
            //Rock
            if(user_Choice.equalsIgnoreCase(computerChoice)){
                System.out.println("It is a DRAW!");
                winCondition = "Draw";
            }else if (user_Choice.equalsIgnoreCase("paper")){
                System.out.println("You WiN!");
                winCondition = "Won";
            }else{
                System.out.println("You LOST...");
                winCondition = "Lost";
            }

        }else if(computerChoice.equalsIgnoreCase("Paper")) {
            //Computer paper
            if (user_Choice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It is a DRAW!");
                winCondition = "Draw";
            } else if (user_Choice.equalsIgnoreCase("scissor")) {
                System.out.println("You WiN!");
                winCondition = "Won";
            } else {
                System.out.println("You LOST...");
                winCondition = "Lost";
            }
        }else{

            //Computer == scissor
            if(user_Choice.equalsIgnoreCase(computerChoice)){
                System.out.println("It is a DRAW!");
                winCondition = "Draw";
            }else if (user_Choice.equalsIgnoreCase("rock")){
                System.out.println("You WiN!");
                winCondition = "Won";
            }else{
                System.out.println("You LOST...");
                winCondition = "Lost";
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        ArrayList<String> historyList = new ArrayList<>();
        String mode, userChoice, computerChoice, winOrLose="";
        boolean mainMenu = true,
                inGame = true,
                inHistory = true;


        while (mainMenu){
            //Game mode
            System.out.println("Welcome to a game of ROCK PAPER SCISSOR.");
            System.out.println("Please enter a game mode: (Play or History)");
            mode = input.nextLine();
            if(mode.equalsIgnoreCase("play")){

                //Rock Paper Scissor
                while(inGame) {
                    System.out.println("Enter your choice: (Rock , Paper or Scissor) or \"Quit\" to exit");
                    userChoice = input.nextLine();

                    if(userChoice.equalsIgnoreCase("rock")
                            || userChoice.equalsIgnoreCase("paper")
                            || userChoice.equalsIgnoreCase("scissor")){

                        //Computer Random
                        int rand = (int)(Math.random()*3);
                        switch (rand){
                            case 0:
                                computerChoice ="Rock";
                                rockPaperScissor(computerChoice,userChoice,winOrLose);
                                break;
                            case 1:
                                computerChoice = "Paper";
                                rockPaperScissor(computerChoice,userChoice,winOrLose);
                                break;
                            case 2:
                                computerChoice = "Scissor";
                                rockPaperScissor(computerChoice,userChoice,winOrLose);
                                break;
                        }
                        System.out.println("Do you want to play again?: (Y/N)");
                        if (input.nextLine().equalsIgnoreCase("n")){
                            inGame = false;
                        }
                    }else if(userChoice.equalsIgnoreCase("quit")){
                        inGame = false;
                    }
                }
            }else if (mode.equalsIgnoreCase("history")){

            }
            //
        }
    }
}
