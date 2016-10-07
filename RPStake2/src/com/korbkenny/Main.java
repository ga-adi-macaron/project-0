package com.korbkenny;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            RPS();


    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";


    public static void RPS() {


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~                             ~~");
        System.out.println("~~     ROCK, PAPER, SCISSORS   ~~");
        System.out.println("~~                             ~~");

        int io = 1;
        List<Integer> theHistory = new ArrayList<>();

        while (io == 1) {

            if (theHistory.size() < 7) {
                //~~~~~~~~~~Menu~~~~~~~~~~
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("~   play  ~  history  ~  quit   ~");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            } else {
                if(theHistory.size()==7) {
                    System.out.println(ANSI_RED +"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
                    System.out.println(ANSI_RED +"~~                               ~~" + ANSI_RESET);
                    System.out.println(ANSI_RED +"~~   YOU'VE UNLOCKED HARD MODE   ~~" + ANSI_RESET);
                    System.out.println(ANSI_RED +"~~                               ~~" + ANSI_RESET);
                    System.out.println(ANSI_RED +"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
                }

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("~ play ~ history ~ "+ANSI_RED + "HARD MODE" + ANSI_RESET +" ~ quit ~");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


            }
                Scanner input = new Scanner(System.in);
                String userInput = input.nextLine().toLowerCase();
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
                        userInput = input.nextLine().toLowerCase();


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

                        userInput.toLowerCase();

                        switch(userInput){
                            case "rock": results = 30 + compChoice;
                                theHistory.add(results);
                                break;
                            case "paper": results = 20 + compChoice;
                                theHistory.add(results);
                                break;
                            case "scissors": results = 10 + compChoice;
                                theHistory.add(results);
                                break;
                            default: results = 0;
                            }

//
//                        if (userInput.equals("rock")) {
//                            results = 30 + compChoice;
//                            theHistory.add(results);
//                        } else if (userInput.equals("paper")) {
//                            results = 20 + compChoice;
//                            theHistory.add(results);
//                        } else if (userInput.equals("scissors")) {
//                            results = 10 + compChoice;
//                            theHistory.add(results);
//                        } else {
//                            results = 0;
//                        }


                        if (results > 0) {

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
                                    System.out.println("      You must live with this");
                                    System.out.println("     For the rest of your life.\n");
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


                //~~~~~~~~~~HARDMODE~~~~~~~~~~~
                else if(userInput.equals("hard mode")){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(ANSI_RED +"           choose:               " + ANSI_RESET);
            System.out.println(ANSI_RED +"~  ROCK  ~  PAPER  ~  SCISSORS  ~" + ANSI_RESET);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            input = new Scanner(System.in);
            userInput = input.nextLine();

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~                             ~~");
            System.out.println("~~          "+ANSI_RED+"YOU LOST"+ANSI_RESET+"           ~~");
            System.out.println("~~                             ~~");
            System.out.println("~~                             ~~");
            System.out.println("~~  "+ANSI_RED+"runProgram: autoQuit.exe"+ANSI_RESET+"   ~~");
            System.out.println("~~  "+ANSI_RED+"runProgram: rm_everything"+ANSI_RESET+"  ~~");
            System.out.println("~~                             ~~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            io = 0;
            return;}

                //~~~~~~~~~~Quit~~~~~~~~~~
                else if (userInput.equals("quit")) {
                    System.out.println("kk cya ttyl lol brb");
                    io = 0;
                }

                else{
                    System.out.println("wait, wut?");
                }


            }

        }

    }









