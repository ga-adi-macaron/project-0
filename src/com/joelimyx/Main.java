package com.joelimyx;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String rockPaperScissor(String computerChoice, String user_Choice){
        //Rock
        System.out.println("The computer pick "+computerChoice+".");
        System.out.println("You pick "+ user_Choice+".");

        if (computerChoice.equals("Rock")){
            //Rock
            if(user_Choice.equalsIgnoreCase(computerChoice)){
                System.out.println("It is a DRAW!");
                return "a Draw";
            }else if (user_Choice.equalsIgnoreCase("paper")){
                System.out.println("You WiN!");
                return  "You Won";
            }else{ // you are scissor
                System.out.println("You LOST...");
                return  "You Lost...";
            }

        }else if(computerChoice.equalsIgnoreCase("Paper")) {
            //Computer ==  paper
            if (user_Choice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It is a DRAW!");
                return  "a Draw";
            } else if (user_Choice.equalsIgnoreCase("scissor")) {
                System.out.println("You WiN!");
                return  "You Won";
            } else { // you are rock
                System.out.println("You LOST...");
                return  "You Lost...";
            }

        }else{
            //Computer == scissor
            if(user_Choice.equalsIgnoreCase(computerChoice)){
                System.out.println("It is a DRAW!");
                return  "a Draw";
            }else if (user_Choice.equalsIgnoreCase("rock")){
                System.out.println("You WiN!");
                return  "You Won";
            }else{ // you are paper
                System.out.println("You LOST...");
                return  "You Lost...";
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        ArrayList<String> historyList = new ArrayList<>();
        int numOfGamePlayed = 0;
        String mode, userChoice, computerChoice="";
        boolean mainMenu = true,
                inGame,
                inHistory = true;


        while (mainMenu){
            //Game mode
            System.out.println("Welcome to a game of ROCK PAPER SCISSOR.");
            System.out.println("Please enter a game mode: (Play or History)");
            mode = input.nextLine();
            if(mode.equalsIgnoreCase("play")){

                inGame = true;

                //Rock Paper Scissor
                while(inGame) {
                    System.out.println("Enter your choice: (Rock , Paper or Scissor) or \"Quit\" to exit");
                    userChoice = input.nextLine();

                    if(userChoice.equalsIgnoreCase("rock")
                            || userChoice.equalsIgnoreCase("paper")
                            || userChoice.equalsIgnoreCase("scissor")){

                        String winOrLose="never";

                        //Computer Random
                        int rand = (int)(Math.random()*3);
                        switch (rand){
                            case 0:
                                computerChoice ="Rock";
                                winOrLose = rockPaperScissor(computerChoice,userChoice);
                                break;
                            case 1:
                                computerChoice = "Paper";
                                winOrLose = rockPaperScissor(computerChoice,userChoice);
                                break;
                            case 2:
                                computerChoice = "Scissor";
                                winOrLose = rockPaperScissor(computerChoice,userChoice);
                                break;
                        }
                        //Storing History
                        numOfGamePlayed++;
                        historyList.add(numOfGamePlayed+". Computer played: "+
                                computerChoice+". You played: "+userChoice+
                                ". The result was "+winOrLose);

                        while (inGame){
                            System.out.println("Do you want to play again?: (Y/N)");
                            if (input.nextLine().equalsIgnoreCase("n")){
                                inGame = false;
                            }
                        }
                    }else if(userChoice.equalsIgnoreCase("quit")){
                        //Quit input
                        inGame = false;
                    }
                }
            }else if (mode.equalsIgnoreCase("history")){
                for (String history :
                        historyList) {
                    System.out.println(history);
                }

            }
            //
        }
    }
}
