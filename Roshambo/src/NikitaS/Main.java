package NikitaS;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static String ANSI_RESET = "\u001B[0m";///Color list retrieved off: http://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    static String ANSI_BLACK = "\u001B[30m";
    static String ANSI_RED = "\u001B[31m";
    static String ANSI_GREEN = "\u001B[32m";
    static String ANSI_YELLOW = "\u001B[33m";
    static String ANSI_BLUE = "\u001B[34m";
    static String ANSI_PURPLE = "\u001B[35m";
    static String ANSI_CYAN = "\u001B[36m";
    static String ANSI_WHITE = "\u001B[37m";

    static ArrayList<String> results = new ArrayList<>();
    static String header = ANSI_GREEN+"============Welcome to Roshambo-2000=============="+ANSI_RESET;//FixMe: Get title
    static String mainPrompt = "Type in one of the following: \n \"Play\" \n \"History\" \n \"Option\" \n \"Quit\" \n";
    static String[] validEntries = {"fire", "grass", "water", "f", "g", "w"}; // 0 beats 1, 1 beats 2, 2 beats 0 Keep that dynamic or everything falls apart.
    static String playerActionMessage = "Enter \"" + validEntries[0] + "\", \"" + validEntries[1] + "\" or \"" + validEntries[2] + "\" or just the first letter:";
    static String optionsMessage = "Choose which set you wish to play with from below: \n 1.(default) Elemental set \n 2. Classic set \n 3. Political set \n 4. Custom set \n 5. Keep current settings and exit.\n 6.Delete save file(No going back)\n";

    static String customPromptMessage = "Go ahead and put in your own variables. The order is:\n1st beats 2nd, 2nd beats 3rd, 3rd beats 1st.\n(Also keep in mind, for the time being, they each have to start with a different letter.)\n \n ";
    static String firstCustomMessage = "What is your first variable?\n";
    static String secondCustomMessage = "Enter your second variable, this one loses to the first\n";
    static String thirdCustomMessage = "Now your last variable, this one loses to the previous but beats the first\n";

    static String saveFileSeshDivison= "\n--------------------Start of a new Session------------------------------------\n";


    static String[] classicSet= {"rock", "scissors", "paper"};
    static String[] elementalSet= {"fire", "grass", "water"};
    static String[] politicalSet= {"bernie","trump","hillary"};

    static String[] cpuMemory = {"Sweet", "Christmas", "Diamondback"};

    static int gameUpperLimit=21;

    static String currentDirectory;
    static boolean loggedStartSesh = false;

    static String fire = ANSI_RED + "fire" + ANSI_RESET;
    static String water = ANSI_BLUE + "water" + ANSI_RESET;
    static String grass = ANSI_CYAN + "grass" + ANSI_RESET;






    static int playerScore;
    static int cpuScore;

    static String player = "Player";
    static String cpu = "CPU";

    static String bestOfPrompt = "Best of how many rounds do you want to play? (It must be an odd number between 1-21";


    static int round;
    static int bestOf;
    static PrintWriter writer;




//ToDo: Make a basic AI
    /*
    Create array of players past 3 moves.
    -If all moves are the same assume the player is spamming so computer anticipates
     the next move to be the same and plays the counter to it.
     -If all moves are different, assume that the player is cycling through the list, so play the counter to the next anticipated one.
     */
    //ToDo: Audio? Graphics?
    //

    public static void main(String[] args) {
        round = 0;//ToDo: change this value to get the value from load if I'm going to do that.
        cpuScore = 0;
        playerScore = 0;

        loadHistory();

        currentDirectory =System.getProperty("user.dir");

        displayMainMenu();
    }

    public static void loadHistory(){
        String line;
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("saveFile.txt"));
            while((line =buffReader.readLine())!= null ){
                results.add(line);
            }
            buffReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayMainMenu() {
        playerScore =0;
        cpuScore=0;
        System.out.println(header);
        userMainEntry(removeCaseSensitive(getInput(mainPrompt)));
    }

    public static void userMainEntry(String userInput) {
        if (userInput.equals("play") || userInput.equals("p")) {
            askBestOf();
            playRound();
        } else if (userInput.equals("history") || userInput.equals("h")) {
            displayHistory();
        } else if (userInput.equals("quit") || userInput.equals("q")) {
            endGame();
        } else if (userInput.equals("option") || userInput.equals("o")){
            openOptions();
        }
        else {
            System.out.println("That is not a valid entry.\n");
            displayMainMenu();
        }
    }

    public static void openOptions(){
        String userChoice = getInput(optionsMessage);
        try{
            int set = Integer.valueOf(userChoice);
            if (set>6){
                System.out.println("That's not a valid choice");
            }else{
                switch (set){
                    case 1:
                        changeSet(elementalSet);
                        break;
                    case 2:
                        changeSet(classicSet);
                        break;
                    case 3:
                        changeSet(politicalSet);
                        break;
                    case 4:
                        makeCustom();
                        break;
                    case 5:
                        displayMainMenu();
                        break;
                    case 6:
                        deleteSaveFile();
                        break;
                }
            }

        }catch(Exception e) {
            System.out.println("That's not an integer.");
            openOptions();
        }

    }

    public static void deleteSaveFile(){
        try {
            PrintWriter pw =  new PrintWriter("saveFile.txt");
            pw.print("");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        displayMainMenu();

    }
    public static void makeCustom(){//ToDO: Make a check for null input.
        System.out.println(customPromptMessage);
        String[] customSet= new String[3];
        customSet[0] = removeCaseSensitive(getInput(firstCustomMessage));
        String secondTemp=removeCaseSensitive(getInput(secondCustomMessage));
        boolean secondAllowed= checkIfAllowed(customSet[0],secondTemp);
        while(!secondAllowed){//If not allowed, prompt player until they give an allowed value.
            secondTemp = removeCaseSensitive(getInput(secondCustomMessage));
            secondAllowed = checkIfAllowed(customSet[0],secondTemp);
        }
        customSet[1] = secondTemp;
        String thirdTemp = removeCaseSensitive(getInput(thirdCustomMessage));
        boolean thirdAllowed = (checkIfAllowed(customSet[0], customSet[1],thirdTemp));
        while(!thirdAllowed){
            thirdTemp = removeCaseSensitive(getInput(thirdCustomMessage));
            thirdAllowed = checkIfAllowed(customSet[0], customSet[1],thirdTemp);
        }
        customSet[2] = thirdTemp;
        changeSet(customSet);
    }

    public static boolean checkIfAllowed(String... strings){
        ArrayList<String> firstLetters= new ArrayList();
        for (String s:strings){
            if (firstLetters.contains(s.substring(0,1))){ //Is there a duplicate? Stop and return notAllowed.
                System.out.println("\nThat entry has the same first letter as a previous one you entered.\n");
                return false;
            }else{
                firstLetters.add(s.substring(0,1)); //No duplicates? Add this value to the arraylist.
            }
        }
        return true; //Went through all the iterations, no duplicates were found, return true.

    }

    public static void changeSet(String[] newSet){//FixMe: If first letters are the same for multiple words I would need to take first 2 or more.
        String firstTrans = newSet[0].substring(0,1);//First letter of first word.
        String secondTrans = newSet[1].substring(0,1);//First letter of second word.
        String thirdTrans = newSet[2].substring(0,1);//First letter of third word.

        validEntries[0]=newSet[0];
        validEntries[1]=newSet[1];
        validEntries[2]=newSet[2];
        validEntries[3]= firstTrans;
        validEntries[4]= secondTrans;
        validEntries[5]=thirdTrans;
        String message = "The new set list is: "+validEntries[0]+", "+ validEntries[1]+ ", "+ validEntries[2]+ ".";
        message = adjustColor(message);
        System.out.println(message);
        playerActionMessage = "Enter \"" + validEntries[0] + "\", \"" + validEntries[1] + "\" or \"" + validEntries[2] + "\" or just the first letter:";
        displayMainMenu();

    }

    public static String getInput(String message) {//Taken from integer calculator
        System.out.println(message + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String removeCaseSensitive(String string) {
        return string.toLowerCase();
    }

    public static void displayHistory() {
        if (results.size() == 0) {
            System.out.println("There is no history to display yet. \nWhy don't you play a few rounds?");
        } else {
            for (String s : results) {
                System.out.println(s);
            }
        }
        displayMainMenu();
    }

    public static void endGame() {
        System.out.println("Thanks for playing");
    }

    public static void playRound() {
        if (playerScore < (bestOf/2)+1 && cpuScore <(bestOf/2)+1) {//Checks that both players have less than required score. e.g. 2 of 3, 3 of 5, 4 of 7
            round++;
            playerActionMessage = adjustColor(playerActionMessage);
//            if (validEntries[0].equals("fire") && validEntries[1].equals("grass") && validEntries[2].equals("water")){
//                playerActionMessage = "Enter \"" + fire + "\", \"" + grass + "\" or \"" + water + "\" or just the first letter:";
//
//            }else{
//                playerActionMessage = "Enter \"" + validEntries[0] + "\", \"" + validEntries[1] + "\" or \"" + validEntries[2] + "\" or just the first letter:";
//
//            }

            String playerThrow = removeCaseSensitive(getInput(playerActionMessage));
            boolean validInput = false;
            if (!loggedStartSesh){
                loggedStartSesh=true;
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt",true));
                    bw.write(saveFileSeshDivison);
                    bw.newLine();
                    bw.flush();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < validEntries.length; i++) {
                if (playerThrow.equals(validEntries[i])) {
                    validInput = true;
                    break;
                }
            }

            if (validInput) { //Changes shorthand entry into full word. ToDO: Simplify this if statement by just decreasing index value by 3.
                if (validEntries[3].equals(playerThrow)){
                    playerThrow = validEntries[0];
                }else if (validEntries[4].equals(playerThrow)){
                    playerThrow = validEntries[1];
                }else if(validEntries[5].equals(playerThrow)){
                    playerThrow=validEntries[2];
                }
                System.out.println(checkOutcome(playerThrow));
                playRound();
            } else {
                System.out.println("Not a valid option");
                playRound();
            }
        } else{
            System.out.println("Match is over");
            String matchResultMessage;
            if (playerScore>cpuScore){
                matchResultMessage= String.format("The player won the match with a score of %s : %s \n", String.valueOf(playerScore), String.valueOf(cpuScore));
            }else{
                matchResultMessage= String.format("The computer won the match with a score of %s : %s \n",String.valueOf(cpuScore), String.valueOf(playerScore));
            }
            results.add(matchResultMessage);
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt",true));
                bw.write(matchResultMessage);
                bw.newLine();
                bw.flush();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            displayMainMenu();
        }
    }

    public static String adjustColor(String input) {
        String newInput = "";
        if (validEntries[0].equals("fire") && validEntries[1].equals("grass") && validEntries[2].equals("water")) {
            for (String word : input.split(" ")) {
                switch (word) {
                    case "\"fire\",":
                    case "fire":
                    case "fire,":
                        newInput += fire+ " ";
                        break;
                    case "\"grass\"":
                    case "grass":
                    case "grass,":
                        newInput += grass+ " ";
                        break;
                    case "\"water\"":
                    case "water":
                    case "water.":
                        newInput += water+ " ";
                        break;
                    default:
                        newInput += word+ " ";
                        break;
                }

            }

        }
        else{
            newInput= input;
        }
        return newInput;
    }


    public static String checkOutcome(String playerThrows) {
        String winner;
        Random randomGen = new Random();
        int compThrowIndex;
        //Begin My exploitable strategy (bare minimum AI)
        if (round>3 &&(cpuMemory[0].equals(cpuMemory[1]) && cpuMemory[0].equals(cpuMemory[2]))){
            //If player is spamming the same move. AI counters with the move that beats it.
            ArrayList<String> temp = new ArrayList();
            temp.add(validEntries[0]);
            temp.add(validEntries[1]);
            temp.add(validEntries[2]);
            int indexOfpSpam = temp.indexOf(cpuMemory[0]);//All are the same so doesn't matter which move to take out of memory.
            compThrowIndex=cpuCounterPlay(indexOfpSpam);


        }else if (round>3 &&(!cpuMemory[0].equals(cpuMemory[1])&&!cpuMemory[1].equals(cpuMemory[2])&&!cpuMemory[0].equals(cpuMemory[2]))){
            //If all the past 3 moves are different,
            // assume that player is cycling through moves
            // and return the counter to next move in cycle.
            ArrayList<String> temp = new ArrayList();
            temp.add(validEntries[0]);
            temp.add(validEntries[1]);
            temp.add(validEntries[2]);
            int indexOfpCycle = temp.indexOf(cpuMemory[2]);
            compThrowIndex = cpuCounterPlay(indexOfpCycle);
            }
        else{//The cpu doesn't recognize an opponent strategy so it plays an unexploitable game; pure random.
            compThrowIndex = randomGen.nextInt(3);
        }


        if (playerThrows.equals(validEntries[compThrowIndex])) {
            winner = "No one";
        } else if (playerThrows.equals(validEntries[1])) {
            if (compThrowIndex == 0) {
                winner = cpu;
                cpuScore ++;
            } else {
                winner = player;
                playerScore++;
            }
        } else if (playerThrows.equals(validEntries[2])) {
            if (compThrowIndex == 0) {
                winner = player;
                playerScore++;
            } else {
                winner = cpu;
                cpuScore++;
            }
        } else {
            if (compThrowIndex == 1) {
                winner = player;
                playerScore++;
            } else {
                winner = cpu;
                cpuScore++;
            }
        }
        String message = "CPU threw: " + validEntries[compThrowIndex] + "  Player threw: " + playerThrows + " \n " + winner + " wins!\n";
        message = adjustColor(message);
        message+= "\n Current Score \n CPU: "+ cpuScore + "\nPlayer: "+ playerScore;
        cpuMemorizes(playerThrows);
        if (winner.equals("No one")) {
            winner = "Tie";
        }
        logResults(winner, validEntries[compThrowIndex], playerThrows);
        return message;
    }

    public static int cpuCounterPlay(int anticipatedPlayIndex) { //CPU counters the anticipated move by playing the move in the index before.
        int compThrowIndex=0;
        switch (anticipatedPlayIndex) {
            case 0:
                compThrowIndex = 3;
                break;
            case 1:
                compThrowIndex = 0;
                break;
            case 2:
                compThrowIndex = 1;
                break;
        }
        return compThrowIndex;
    }




    public static void cpuMemorizes(String pMove){
        cpuMemory[2]=cpuMemory[1];
        cpuMemory[1]=cpuMemory[0];
        cpuMemory[0]=pMove;
    }

    public static void logResults(String winner, String computersThrow, String playersThrow) {
        String logMessage = String.format("Round#%s|| Win went to: %s | Player threw: %s | Computer threw: %s",String.valueOf(round), winner, playersThrow, computersThrow);
        results.add(logMessage);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt",true));
            bw.write(logMessage);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void askBestOf() {
        String userInput = getInput(bestOfPrompt);
        try {
            Integer.valueOf(userInput);
            if (Integer.valueOf(userInput) > gameUpperLimit) {
                System.out.println("For arbitrary reasons that I made up, you can't play that many games. Please enter a valid number\n");
                askBestOf();
            } else if (Integer.valueOf(userInput) % 2 == 0) {
                System.out.println("That is an even number. \n(The reason for it being odd is to prevent matches ending in ties.)\n");
                askBestOf();
            } else{
                bestOf = Integer.valueOf(userInput);
            }
        } catch (Exception e) {
            System.out.println("That is not an integer. Please input an integer");
            askBestOf();
        }
    }
}
