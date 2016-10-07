package com.joelimyx;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String mRock =
            "****************************************\n"+
                    "********************        ***    *****\n" +
                    "*************         *****           **\n" +
                    "*********            ***************  **\n" +
                    "******        ***********************  *\n" +
                    "***     ******************** *  *****  *\n" +
                    "**   **************   ******   ******  *\n" +
                    "*  *********   ****   *******  ******  *\n" +
                    "*     ******  *****  ******** *******  *\n" +
                    "*     ******  *****  ******** *******  *\n" +
                    "*    ******  ******  *******  ******** *\n" +
                    "**   ******  ******  *******  *******  *\n" +
                    "****  *****  ******  ******** *******  *\n" +
                    "****  ****** *******  *******  *****   *\n" +
                    "****   *****  ******  *****      **   **\n" +
                    "******         *****                 ***\n" +
                    "********               ****  **   ******\n" +
                    "**************   *****    ***    *******\n" +
                    "***************                *********\n" +
                    "****************************************\n";

    static String mScissor =
            "**************************************************\n" +
                    "**           *************************************\n" +
                    "*             ***************************       **\n" +
                    "*   *******    **********************            *\n" +
                    "*              ******************              ***\n" +
                    "**             **************               ******\n" +
                    "*****              ******               **********\n" +
                    "*************                      ***************\n" +
                    "*****************             ********************\n" +
                    "***************                   ****************\n" +
                    "**********                           *************\n" +
                    "****               *******               *********\n" +
                    "*      **      ******************             ****\n" +
                    "*    ******    **********************            *\n" +
                    "*             ***************************      ***\n" +
                    "***         **************************************\n" +
                    "**************************************************\n";
    static String mPaper;
    public static String rockPaperScissor(String computerChoice, String user_Choice){

        if (computerChoice.equals("Rock")){
            //Computer == Rock

            System.out.println("The computer pick \n"+mRock);

            if(user_Choice.equalsIgnoreCase(computerChoice)){

                System.out.println("You pick \n"+ mRock);
                System.out.println("It is a DRAW!");
                return "a Draw";
            }else if (user_Choice.equalsIgnoreCase("paper")){
                System.out.println("You pick \n"+ user_Choice);
                System.out.println("You WiN!");
                return  "You Won";
            }else{ // you are scissor
                System.out.println("You pick \n"+ mScissor);
                System.out.println("You LOST...");
                return  "You Lost...";
            }

        }else if(computerChoice.equalsIgnoreCase("Paper")) {
            //Computer ==  paper
            if (user_Choice.equalsIgnoreCase(computerChoice)) {
                System.out.println("You pick \n"+ user_Choice);
                System.out.println("It is a DRAW!");
                return  "a Draw";
            } else if (user_Choice.equalsIgnoreCase("scissor")) {
                System.out.println("You pick \n"+ mScissor);
                System.out.println("You WiN!");
                return  "You Won";
            } else { // you are rock
                System.out.println("You pick \n"+ mRock);
                System.out.println("You LOST...");
                return  "You Lost...";
            }

        }else{
            //Computer == scissor

            System.out.println("The computer pick \n"+mScissor);

            if(user_Choice.equalsIgnoreCase(computerChoice)){
                System.out.println("You pick \n"+ mScissor);
                System.out.println("It is a DRAW!");
                return  "a Draw";
            }else if (user_Choice.equalsIgnoreCase("rock")){
                System.out.println("You pick \n"+ mRock);
                System.out.println("You WiN!");
                return  "You Won";
            }else{ // you are paper
                System.out.println("You pick \n"+ user_Choice);
                System.out.println("You LOST...");
                return  "You Lost...";
            }
        }
    }
    public static void writeToFile(BufferedWriter fileToWrite, String phrase) throws IOException {
        fileToWrite.write(phrase+"\r");
        fileToWrite.newLine();
    }

    public static void main(String[] args){
        //******************************************************************************************
//        ________  ________  ________  ___  ___                ________  ________  _________
//       |\   __  \|\   ____\|\   ____\|\  \|\  \              |\   __  \|\   __  \|\___   ___\
//        \ \  \|\  \ \  \___|\ \  \___|\ \  \ \  \             \ \  \|\  \ \  \|\  \|___ \  \_|
//         \ \   __  \ \_____  \ \  \    \ \  \ \  \             \ \   __  \ \   _  _\   \ \  \
//          \ \  \ \  \|____|\  \ \  \____\ \  \ \  \             \ \  \ \  \ \  \\  \|   \ \  \
//           \ \__\ \__\____\_\  \ \_______\ \__\ \__\             \ \__\ \__\ \__\\ _\    \ \__\
//            \|__|\|__|\_________\|_______|\|__|\|__|              \|__|\|__|\|__|\|__|    \|__|
//                      \|_________|
//
        //******************************************************************************************


       /* String newScissor="";
        newScissor=scissor.replaceAll(" ","*");
        for (int i = 0; i < newScissor.length(); i++) {
            if (newScissor.charAt(i) != '*' && newScissor.charAt(i) != '\n') {
                newScissor = newScissor.replace(newScissor.charAt(i), ' ');
            }
        }
        System.out.println(scissor);*/
        //******************************************************************************************
//        _______   ________   ________
//        |\  ___ \ |\   ___  \|\   ___ \
//        \ \   __/|\ \  \\ \  \ \  \_|\ \
//         \ \  \_|/_\ \  \\ \  \ \  \ \\ \
//          \ \  \_|\ \ \  \\ \  \ \  \_\\ \
//           \ \_______\ \__\\ \__\ \_______\
//            \|_______|\|__| \|__|\|_______|

        //******************************************************************************************
        //Beginning of MAIN
        //Variables
        //******************************************************************************************
        Scanner input = new Scanner(System.in);
        ArrayList<String> readList = new ArrayList<>();
        int numOfGamePlayed = 0;
        String mode, userChoice, computerChoice="";
        boolean mainMenu = true,
                inGame;
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd: hh:mm:ssa");

        //******************************************************************************************
        //FileReader
        //******************************************************************************************
        BufferedReader reader;
        String fileName = "history.txt";
        BufferedWriter writer;
        String temp;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            writer = new BufferedWriter(new FileWriter(fileName,true));

            //******************************************************************************************
            //MainMenu
            //******************************************************************************************
            while (mainMenu) {

                //******************************************************************************************
                //Game mode
                //******************************************************************************************
                System.out.println("+====================================+\n" +
                        "Welcome to a game of ROCK PAPER SCISSOR.");
                System.out.println("Choose a selection: (Play, History or Quit)");
                mode = input.nextLine();

                //******************************************************************************************
                //Rock Paper Scissor play mode
                //******************************************************************************************
                if (mode.equalsIgnoreCase("play")) {
                    writeToFile(writer,"Session start:");
                    writeToFile(writer,currentDateTime.format(formatter));

                    inGame = true;

                    while (inGame) {
                        System.out.println("*********************************************************\n" +
                                "Enter your choice: " +
                                "\nRock, " +
                                "\nPaper," +
                                "\nScissor " +
                                "\n(or \"Quit\" to exit)");
                        userChoice = input.nextLine();

                        if (userChoice.equalsIgnoreCase("rock")
                                || userChoice.equalsIgnoreCase("paper")
                                || userChoice.equalsIgnoreCase("scissor")) {

                            String winOrLose = "never";

                            //******************************************************************************************
                            //Computer Random generator
                            //******************************************************************************************
                            int rand = (int) (Math.random() * 3);
                            switch (rand) {
                                case 0:
                                    computerChoice = "Rock";
                                    winOrLose = rockPaperScissor(computerChoice, userChoice);
                                    break;
                                case 1:
                                    computerChoice = "Paper";
                                    winOrLose = rockPaperScissor(computerChoice, userChoice);
                                    break;
                                case 2:
                                    computerChoice = "Scissor";
                                    winOrLose = rockPaperScissor(computerChoice, userChoice);
                                    break;
                            }

                            //******************************************************************************************
                            //Storing History
                            //******************************************************************************************
                            numOfGamePlayed++;
                            writeToFile(writer,numOfGamePlayed + ". Computer played: " +
                                    computerChoice + ". You played: " + userChoice +
                                    ". The result was " + winOrLose);

                            String decision = "i";
                            while (inGame && !decision.equalsIgnoreCase("y")) {
                                System.out.println("Do you want to play again?: (Y/N)");
                                decision = input.nextLine();
                                if (decision.equalsIgnoreCase("n")) {
                                    inGame = false;
                                    writeToFile(writer,currentDateTime.format(formatter));
                                    writeToFile(writer,"Session ended.\r");
                                }
                            }
                        } else if (userChoice.equalsIgnoreCase("quit")) {
                            //Quit input
                            inGame = false;
                            writeToFile(writer,currentDateTime.format(formatter));
                            writeToFile(writer,"Session ended.\r");
                        }
                    }
                    //******************************************************************************************
                    // Print out History
                    //******************************************************************************************
                    writer.close();
                } else if (mode.equalsIgnoreCase("history")) {
                    System.out.println("Your history of play: ");
                    while ((temp = reader.readLine()) != null) {
                        readList.add(temp);
                    }
                    for (String line :
                            readList) {
                        System.out.println(line);
                    }

                    //******************************************************************************************
                    // Quit Game
                    //******************************************************************************************
                } else if (mode.equalsIgnoreCase("quit")) {
                    System.out.println("Thanks for playing. Have a nice day.");
                    mainMenu = false;
                }
            }
            //******************************************************************************************
            //Close out writer
            //******************************************************************************************
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.getMessage();
        }
    }
}

