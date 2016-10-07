package com.bleh;

import java.util.*;

public class Main {
    private static List<Integer> wins = new ArrayList<>();
    private static List<Integer> losses = new ArrayList<>();
    private static List<Integer> ties = new ArrayList<>();
    public static String getInput(String context){
        System.out.print(context+": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        System.out.println("Hello! :) Welcome to Rock Paper Scissors");
        mainMenu();
    }

    public static void mainMenu(){
        String choice = getInput("Choose an what you want to do: \n*PLAY\n*HISTORY\n*QUIT\n");
        String choiceLow = choice.toLowerCase();

        if (choiceLow.equals("play"))
            play();
        else if (choiceLow.equals("history"))
            history();
        else if (choiceLow.equals("quit"))
            quit();
        else {
            System.out.println("Sorry :/ That's not a valid response");
            mainMenu();
        }
    }

    public static void play(){
        System.out.println("Cool let's play :) You can always type 'BACK' to go to the Main Menu");
        String choice = getInput("Pick ROCK, PAPER, or SCISSORS");
        String choiceLow = choice.toLowerCase();

        if (choiceLow.equals("rock"))
            comChoiceR();
        else if (choiceLow.equals("paper"))
            comChoiceP();
        else if (choiceLow.equals("scissors"))
            comChoiceS();
        else if (choiceLow.equals("back"))
            mainMenu();
        else {
            System.out.println("Sorry :/ That's not a valid response");
            play();}
    }

    public static void comChoiceR(){
        Random rand = new Random();
        int comPick = rand.nextInt(3) +1;
        if (comPick == 1){
            System.out.println("I chose ROCK and you chose ROCK...we tied :/");
            resultsT();
        }
        else if (comPick == 2){
            System.out.println("I chose PAPER and you chose ROCK...I win :p");
            resultsL();
        }
        else if (comPick == 3){
            System.out.println("I chose SCISSORS and you chose ROCK...I guess you win :(");
            resultsW();
        }
    }

    public static void comChoiceP(){
        Random rand = new Random();
        int comPick = rand.nextInt(3) +1;
        if (comPick == 1){
            System.out.println("I chose ROCK and you chose PAPER...I guess you win :(");
            resultsW();
        }
        else if (comPick == 2){
            System.out.println("I chose PAPER and you chose PAPER...We tied :/");
            resultsT();
        }
        else if (comPick == 3){
            System.out.println("I chose SCISSORS and you chose PAPER...I win :p");
            resultsL();
        }
    }

    public static void comChoiceS(){
        Random rand = new Random();
        int comPick = rand.nextInt(3) +1;
        if (comPick == 1){
            System.out.println("I chose ROCK and you chose SCISSORS...I win :p");
            resultsL();
        }
        else if (comPick == 2){
            System.out.println("I chose PAPER and you chose SCISSORS...I guess you win :(");
            resultsW();
        }
        else if (comPick == 3){
            System.out.println("I chose SCISSORS and you chose SCISSORS...We tied :/");
            resultsT();
        }
    }

    public static void resultsW(){
        wins.add(1);
        play();
    }

    public static void resultsL(){
        losses.add(1);
        play();
    }

    public static void resultsT(){
        ties.add(1);
        play();
    }

    public static void history(){
        System.out.println("You Have Won: " + wins.size());
        System.out.println("I Have Won: " + losses.size());
        System.out.println("We Have Tied: " + ties.size());
        if (losses.size() < wins.size()){
            System.out.println("You are in the lead!");
        }
        else if (wins.size() < losses.size()){
            System.out.println("I am in the lead!");
        }
        else if (wins.size() == losses.size()){
            System.out.println("We are tied!");
        }
        mainMenu();
    }

    public static void quit(){
        System.out.println("Thanks for Playing :) \n Have a Great Day!");
    }
}
