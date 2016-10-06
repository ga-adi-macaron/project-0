package com.joelimyx;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        ArrayList<String> historyList = new ArrayList<>();
        String mode, choice, computerChoice;

        while (true){
            //Game mode
            System.out.println("Welcome to a game of ROCK PAPER SCISSOR.");
            System.out.println("Please enter a game mode: (Play or History)");
            mode = input.nextLine();
            if(mode.equalsIgnoreCase("play")){
                while(true) {
                    System.out.println("Enter your choice: (Rock , Paper or Scissor) or \"Quit\" to exit");
                    choice = input.nextLine();
                    int rand = (int)Math.random()*3;
                    switch (rand){
                        case 1:
                            computerChoice ="Rock";
                            break;
                        case 2:
                            computerChoice = "Paper";
                            break;
                        case 3:
                            computerChoice = "Scissor";
                            break;
                    }

                }
            }else if (mode.equalsIgnoreCase("history")){

            }
            //
        }
    }
}
