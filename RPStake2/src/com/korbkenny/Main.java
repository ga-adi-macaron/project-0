package com.korbkenny;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~                             ~~");
        System.out.println("~~     ROCK, PAPER, SCISSORS   ~~");
        System.out.println("~~                             ~~");


            RPS();


    }


    public static void RPS() {

        int io = 1;
        List<Integer> theHistory = new ArrayList<>();

        while (io == 1) {


            //~~~~~~~~~~Menu~~~~~~~~~~
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~ play ~ history ~ rules ~ quit ~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            int results = 0;

            //~~~~~~~~~~Play~~~~~~~~~~

            if (userInput.equals("play")) {

                while (results == 0) {
                    System.out.println("          ........             ");
                    System.out.println(" Three weapons lay before you. ");
                    System.out.println("~~  Rock ~ Paper ~ Scissors  ~~");
                    System.out.println("          ........             ");
                    System.out.println("        choose wisely          ");
                    input = new Scanner(System.in);
                    userInput = input.nextLine();
                    userInput.toLowerCase();

                    int compChoice = 1 + (int) (Math.random() * 3);
                    String compChoiceWord = "";
                    switch (compChoice) {
                        case 1:
                            compChoiceWord = "scissors";
                            break;
                        case 2:
                            compChoiceWord = "paper";
                            break;
                        case 3:
                            compChoiceWord = "rock";
                            break;
                    }


                    if (userInput.equals("rock")) {
                        results = 30 + compChoice;
                        theHistory.add(results);
                    } else if (userInput.equals("paper")) {
                        results = 20 + compChoice;
                        theHistory.add(results);
                    } else if (userInput.equals("scissors")) {
                        results = 10 + compChoice;
                        theHistory.add(results);
                    } else {
                        results = 0;
                    }


                    if(results > 0) {

                        System.out.println("      The fight is over");
                        System.out.println("       The dust settles");
                        System.out.println(" You realize what just happened");
                        System.out.println(" ");
                        System.out.println("              ... ");
                        System.out.println(" ");
                        System.out.println("       " + userInput.toUpperCase() + " vs " + compChoiceWord.toUpperCase() + "\n");
                        switch (results) {
                            case 31:
                            case 23:
                            case 12:
                                System.out.println("  Your enemy has been vanquished!");
                                System.out.println("      Long live the queen!\n");
                                break;
                            case 32:
                            case 21:
                            case 13:
                                System.out.println("You lost. Your enemy lets you live...");
                                System.out.println("   ...but just barely. Shame.\n");
                                break;
                            case 33:
                            case 22:
                            case 11:
                                System.out.println("   It's a tie. Quite relieved,");
                                System.out.println("   you tell each other 'sorry'");
                                System.out.println("   then become decent friends.");
                                break;
                        }

                    }

                }

            }


            //~~~~~~~~~~History~~~~~~~~~~

            else if (userInput.equals("history")) {
                for (int i = 0; i < theHistory.size(); i++) {
                    int whoWon = theHistory.get(i);

                    switch (whoWon) {
                        case 31:
                        case 23:
                        case 12:
                            System.out.println("Brutal War #" + (i + 1) + ": You won!");
                            break;
                        case 32:
                        case 21:
                        case 13:
                            System.out.println("Brutal War #" + (i + 1) + ": You lost!");
                            break;
                        case 33:
                        case 22:
                        case 11:
                            System.out.println("Brutal War #" + (i + 1) + ": Y'all tied!");
                            break;
                    }
                }
            }
            //~~~~~~~~~~Rules~~~~~~~~~~
            else if (userInput.equals("rules")){
                System.out.println("");
            }

            //~~~~~~~~~~Quit~~~~~~~~~~
            else if (userInput.equals("quit")) {
                System.out.println("kk cya ttyl lol brb");
                io = 0;
            }

        }


    }


}






