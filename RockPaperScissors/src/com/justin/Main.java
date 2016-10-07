package com.justin;

import java.util.*;
import java.io.*;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static String playerName, playerChoice, compChoice, winner, loser, winPoke, losePoke, move;
    public static int battleNum = 0, leaderNum = 1;
    public static List<String> record = new ArrayList<>();
    public static File file = new File("/Users/justinwells/project-0/RockPaperScissors/save.txt");
    public static boolean displayGymSign = true;

    public static void main(String[] args) {

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        }catch (IOException ex) {
           ex.printStackTrace();
        }
        getPlayerName();
        greetPlayer();
        recallHistory();
        mainMenu();
    }

    public static void getPlayerName() {
        System.out.print("What is your name?:");
        playerName = input.nextLine();
        System.out.println();
    }

    public static void greetPlayer () {
        System.out.println("Welcome " + playerName + "!");
    }

    public static void mainMenu () {
        System.out.println("Please Select an Option \n*=======================*");
        System.out.println("1:Battle \n2:View Battle History \n3:Change Name \n4:Quit");

        String menuChoice = input.nextLine();

        if (menuChoice.equalsIgnoreCase("1") || menuChoice.equalsIgnoreCase("battle")) {
            displayGymSign = true;
            battle();
        }

        else if (menuChoice.equalsIgnoreCase("2") || menuChoice.equalsIgnoreCase("view history") ||
                    menuChoice.equalsIgnoreCase("history")) {
            displayHistory();
        }

        else if (menuChoice.equalsIgnoreCase("3") || menuChoice.equalsIgnoreCase("change name")) {
            changeName();
            mainMenu();
        }
        else if (menuChoice.equalsIgnoreCase("4") || menuChoice.equalsIgnoreCase("quit")) {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }

        else {
            System.out.println("Invalid Entry Please Try Again!\n");
            mainMenu();
        }
    }

    public static void changeName () {
        getPlayerName();
        greetPlayer();
    }

    public static void battle () {

        if (displayGymSign) {
            if (leaderNum < 9) {
                System.out.println("\n*=================*");
                System.out.println("Welcome to Gym #" + leaderNum);
                System.out.println("Leader: " + gymLeader());
                System.out.println("*=================*");
            }

            else if (leaderNum < 13 && leaderNum > 8) {
                System.out.println("\n*=================*");
                System.out.println("ELITE FOUR: " + gymLeader());
                System.out.println("\n*=================*");
            }

            else if (leaderNum == 13) {
                System.out.println("\n*=================*");
                System.out.println("CHAMPION: " + gymLeader());
                System.out.println("\n==================*");
            }
        }

        System.out.println("\nSelect Your Pokemon \n*===================*\n"
                +"1:CHARMANDER \n2:BULBASAUR \n3:SQUIRTLE \n");

        getPlayerPokemon();

        getComputerPokemon();

        decideWinner();

        battleNum++;

        recordHistory();

        playAgain();

    }

    public static void getPlayerPokemon () {
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("charmander") || choice.equalsIgnoreCase("1")) {
            playerChoice = "CHARMANDER";
        }

        else if (choice.equalsIgnoreCase("bulbasaur") || choice.equalsIgnoreCase("2")) {
            playerChoice = "BULBASAUR";
        }

        else if (choice.equalsIgnoreCase("squirtle") || choice.equalsIgnoreCase("3")) {
            playerChoice = "SQUIRTLE";
        }

        else {
            System.out.println("Invalid Entry");
            battle();
        }
    }

    public static void getComputerPokemon () {

       int comp = (1+ (int)(Math.random() * 3));

       switch (comp) {
           case 1: compChoice = "CHARMANDER";
               break;
           case 2: compChoice = "BULBASAUR";
               break;
           case 3: compChoice = "SQUIRTLE";
               break;

       }


    }

    public static void decideWinner () {

        System.out.println(playerName + " sent out " + playerChoice);
        System.out.println(gymLeader() + " sent out " + compChoice);

        if (playerChoice.equals("CHARMANDER")) {

            if (compChoice.equals("SQUIRTLE")) {
                compWins();
            }
            else if (compChoice.equals("BULBASAUR")) {
                playerWins();
            }
            else if (compChoice.equals("CHARMANDER")) {
                draw();
            }
        }

        else if (playerChoice.equals("SQUIRTLE")) {

            if (compChoice.equals("BULBASAUR")) {
                compWins();
            }
            else if (compChoice.equals("CHARMANDER")) {
                playerWins();
            }
            else if (compChoice.equals("SQUIRTLE")) {
                draw();
            }
        }

        else if (playerChoice.equals("BULBASAUR")) {

            if (compChoice.equals("CHARMANDER")) {
                compWins();
            }
            else if (compChoice.equals("SQUIRTLE")) {
                playerWins();
            }
            else if (compChoice.equals("BULBASAUR")) {
                draw();
            }
        }
    }

    public static void draw () {

        displayGymSign = false;
        System.out.println("Battle is a draw! Both pokemon fainted! \n" +
                "Select next pokemon!");
        battle();

    }
    public static void playerWins () {
        winner = playerName;
        loser = gymLeader();
        winPoke = playerChoice;
        losePoke = compChoice;
        displayGymSign = true;

        System.out.println(playerName + "'s " + playerChoice + " used " + pickMove(playerChoice) +
                "! \nIt's super effective!");
        System.out.println(compChoice + " fainted!");
        System.out.println(winner + " wins!");

        if (leaderNum < 14) {
            leaderNum ++;
        }

        else {
            System.out.println("Congratulations " + playerName + "! You are the new Pokemon League Champion!");
            leaderNum = 0;
            mainMenu();
        }

    }

    public static void compWins () {
        winner = gymLeader();
        loser = playerName;
        winPoke = compChoice;
        losePoke = playerChoice;
        displayGymSign = false;

        System.out.println(gymLeader() + "'s " + compChoice + " used " + pickMove(compChoice) +
                "! \nIt's super effective!");
        System.out.println(playerChoice + " fainted!");
        System.out.println(winner + " wins!");
    }

    public static String pickMove (String pokemon){

        int rand = (1+ (int)(Math.random() * 3));


        if (pokemon.equals("CHARMANDER")){
            switch (rand){
                case 1 : move = "Fire Blast";
                    break;
                case 2 : move = "Flamethrower";
                    break;
                case 3 : move = "Fire Punch";
                    break;
            }
        }
        else if (pokemon.equals("SQUIRTLE")){
            switch (rand){
                case 1 : move = "Hydro Pump";
                    break;
                case 2 : move = "Surf";
                    break;
                case 3 : move = "Bubblebeam";
                    break;
            }
        }
        else if (pokemon.equals("BULBASAUR")){
            switch (rand){
                case 1 : move = "Solar Beam";
                    break;
                case 2 : move = "Razor Leaf";
                    break;
                case 3 : move = "Giga Drain";
                    break;
            }
        }

        return move;

    }

    public static void recordHistory () {

        record.add("Battle #" + battleNum + " : " + winner + "'s " + winPoke + " defeated " + loser
                    + "'s " + losePoke + " with a " + move + " attack!");
        try {
            FileWriter writer
                    = new FileWriter("/Users/justinwells/project-0/RockPaperScissors/save.txt",true);
            writer.write(record.get(battleNum-1));
            writer.write("\n");


            writer.close();
        }   catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public static void displayHistory () {

        System.out.println(battleNum);
        if (battleNum < 1) {
            System.out.println("Oak's words echoed... Theres a time and place for everything, but not now!\n");
            mainMenu();
        }
        else {
            System.out.println("       HALL OF FAME" +
                    "\n============================");
            for (int i = 0; i < record.size(); i++) {
                System.out.println(record.get(i));
            }
        }

        System.out.println();
        mainMenu();
    }

    public static void playAgain () {
        if (!winner.equals(playerName)) {
            System.out.println("TRY AGAIN? (Y/N)");
        }
        else {
            System.out.println("CHALLENGE NEXT GYM? (Y/N)");
        }

        String choice = input.nextLine();

        if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            battle();
        }

        else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")){
            mainMenu();
        }

        else {
            System.out.println("Invalid Entry");
            playAgain ();
        }
    }


    public static void recallHistory (){
        try {
            FileReader fileReader = new FileReader ("/Users/justinwells/project-0/RockPaperScissors/save.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            int i = 0;

            while ((line = reader.readLine()) != null) {

                record.add(line);

                if (i < 9) {
                    battleNum = Integer.parseInt(Character.toString(record.get(i).charAt(8)));
                }

                else if (i > 8 && i < 99) {
                    battleNum = Integer.parseInt(record.get(i).substring(8,10));
                }

                else {
                    file.delete();
                    battleNum = 0;
                }

                i++;


            }

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static String gymLeader () {
        switch (leaderNum) {
            case 1 : return "Brock";

            case 2 : return "Misty";

            case 3 : return "Lt Surge";

            case 4 : return "Erica";

            case 5 : return "Sabrina";

            case 6 : return "Koga";

            case 7 : return "Blaine";

            case 8 : return "Giovanni";

            case 9 : return "Lorelei";

            case 10 : return "Bruno";

            case 11 : return "Agatha";

            case 12 : return "Lance";

            case 13 : return "Gary";

        }

        return "Professor Oak";
    }
}
