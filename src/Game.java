import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Scott Lindley on 10/6/2016.
 */
public class Game {
    private int userWins;
    private int computerWins;
    private int ties;
    private ArrayList<String> gameHistory;
    private int wrongInput;

    public Game(){
        this.userWins = 0;
        this.computerWins = 0;
        this.ties = 0;
        this.gameHistory = new ArrayList<>();
        this.wrongInput = 0;
        getFile();
        int input = -1;
        while(input==-1){
            switch (getMenuInput()){
                case 1:
                    play();
                    break;
                case 2:
                    history();
                    break;
                case 0:
                    editFile();
                    return;
                default:
                    System.out.println("That's not a valid choice");
            }
        }

    }

    public int getMenuInput(){
        System.out.println("1: Play\n2: History\n0: Quit");
        Scanner scanner = new Scanner(System.in);
        String strInput = scanner.next();
        switch (strInput.toLowerCase()){
            case "play":
                return 1;
            case "history":
                return 2;
            case "quit":
                return 0;
            default:
                try{
                    int inputInt = Integer.parseInt(strInput);
                    if((inputInt>=0)&&(inputInt<3)){
                        return inputInt;
                    }
                    return -1;
                 }catch (NumberFormatException nfe){
                    return -1;
                }
        }
    }

    public int getcomputerChoice(){
        Random random = new Random();
        return random.nextInt(3)+1;
    }

    public int getUserchoice(){
        System.out.println("Make your choice.\nRock, Paper, or Scissors?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        switch (input.toLowerCase()) {
            case "rock":
                return 1;
            case "paper":
                return 2;
            case "scissors":
                return 3;
            case "menu":case "back":case "quit":
                return 4;
            default:
                switch (this.wrongInput) {
                    case 0:
                        System.out.println("you're not being very clear...\n");
                        this.wrongInput++;
                        break;
                    case 1:
                        System.out.println("what's that supposed to mean?\n");
                        this.wrongInput++;
                        break;
                    case 2:
                        System.out.println("are you trying to be funny?\n");
                        this.wrongInput++;
                        break;
                    case 3:
                        System.out.println("I know, it's very difficult... But you do have to make a choice.\n");
                        this.wrongInput++;
                        break;
                    case 4:
                        System.out.println("I'm don't think that's how you spell 'I give up, you win, computer'.\n");
                        this.wrongInput++;
                        break;
                    case 5:
                        System.out.println("I am on an infinite loop, here... I am tireless.\nSo I can wait until you're " +
                                "ready to behave like an adult\n");
                        this.wrongInput++;
                        break;
                    case 6:
                        System.out.println("Clearly you're done. So type 'menu' to return to the Main Menu.\n");
                }
                return -1;
        }

    }

    public void play() {
        System.out.println("TYPE MENU TO RETURN TO MENU");
        boolean menu = false;
        while(!menu){
            int computerChoice = getcomputerChoice();
            int userChoice = -1;
            while (userChoice == -1) {
                userChoice = getUserchoice();
            }
            if(userChoice==4){
                return;
            }
            if (computerChoice == 1) {
                System.out.println("I chose rock");
                switch (userChoice) {
                    case 1:
                        System.out.println("Tie!\nBut you know I love to rock with you!");
                        this.ties++;
                        this.gameHistory.add("Tie");
                        printScore();
                        break;
                    case 2:
                        System.out.println("You win!\nEven though paper is softer in every way...");
                        this.userWins++;
                        this.gameHistory.add("Win");
                        printScore();
                        break;
                    case 3:
                        System.out.println("You lose!\nCouldn't quite cut it, could ya?");
                        this.computerWins++;
                        this.gameHistory.add("Loss");
                        printScore();
                        break;
                }
            } else if (computerChoice == 2) {
                System.out.println("I chose paper");
                switch (userChoice) {
                    case 1:
                        System.out.println("You lose!");
                        this.gameHistory.add("Loss");
                        this.computerWins++;
                        printScore();
                        break;
                    case 2:
                        System.out.println("Tie!\nWe both chose paper!\nWait, did you write a love note on yours?");
                        this.gameHistory.add("Tie");
                        this.ties++;
                        printScore();
                        break;
                    case 3:
                        System.out.println("You win!\nThat cuts deep... I thought we were friends...");
                        this.gameHistory.add("Win");
                        this.userWins++;
                        printScore();
                        break;
                }
            } else {
                System.out.println("I chose scissors");
                switch (userChoice) {
                    case 1:
                        System.out.println("You win!\nRock, huh? Cold and hard as your heart.");
                        this.gameHistory.add("Win");
                        this.userWins++;
                        printScore();
                        break;
                    case 2:
                        System.out.println("You lose!\nSee? I made a snowflake!");
                        this.gameHistory.add("Loss");
                        this.computerWins++;
                        printScore();
                        break;
                    case 3:
                        System.out.println("Tie!\nYou get snippy with me...\nI'll give it right back to you, buddy");
                        this.gameHistory.add("Tie");
                        this.ties++;
                        printScore();
                        break;
                }
            }
        }
    }

    public void printScore(){
        System.out.println("*********************");
        System.out.print("Wins: "+this.userWins+" | ");
        System.out.print("Losses: "+this.computerWins+" | ");
        System.out.println("Ties: "+this.ties+" | ");
        System.out.println("*********************");
    }

    public void history(){
        System.out.println("********");
        for (String s: this.gameHistory){
            System.out.println(s);
        }
        System.out.println("********");
    }

    /*THESE WEBSITES HELPED ME ALONG TO THE BONUS SOLUTION
    https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
    http://stackoverflow.com/questions/20753600/creating-writing-and-editing-same-text-file-in-java


    CHECK PAGE 447

    */

    public void editFile(){
        FileReader flrdr;
        FileWriter flw;
        try {
            flrdr = new FileReader("C:\\Users\\Scott Lindley\\Documents\\ADI Assignments\\project-0\\GameHistory.txt");
            flw = new FileWriter("C:\\Users\\Scott Lindley\\Documents\\ADI Assignments\\project-0\\GameHistory.txt");
            BufferedReader bufferedReader = new BufferedReader(flrdr);
            BufferedWriter bufferedWriter = new BufferedWriter(flw);
            if(bufferedReader.readLine()==null){
                for(String s: this.gameHistory) {
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }else{
                String line = "hi";
                bufferedReader.readLine();
                bufferedWriter.newLine();
                while(line!=null){
                    line = bufferedReader.readLine();
                    System.out.println(line);
                    bufferedWriter.newLine();
                }
                for (int i=1; i<this.gameHistory.size(); i++) {
                    bufferedWriter.write(this.gameHistory.get(i));
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }
        }catch (IOException e){
            System.out.println("NO FILE FOUND");
            return;
        }
    }

    public void getFile(){
        FileReader fileReader;
        try {
            fileReader = new FileReader("C:\\Users\\Scott Lindley\\Documents\\ADI Assignments\\project-0\\GameHistory.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "line";
            while(line!=null){
                line = bufferedReader.readLine();
                if(line!=null&&line==""){
                    this.gameHistory.add("*****");
                }
                if(line!=null){this.gameHistory.add(line);}
            }
        }catch (IOException e){
            System.out.println("NO FILE FOUND");
            return;
        }
    }
}
