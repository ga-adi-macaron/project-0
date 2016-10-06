package com.korbkenny;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Integer> yourScore = new ArrayList<>();
        List<Integer> compScore = new ArrayList<>();


        rpsMenu();


    }

    public static void rpsMenu(){
        System.out.println("WELCOME TO RPS. Wanna play? Or check your game history? Or quit?");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        userInput.toLowerCase();
            switch(userInput){
                case "play":
                    rpsPlay();
                    break;
                case "history":
                    rpsHistory();
                    break;
                case "quit":
                    break;
                default:
                    System.out.println("Wait, wut?");
                    rpsMenu();
                    break;
            }

    }

    public static void rpsPlay(){
        System.out.println("There are three weapons at your disposal.");
        System.out.println("The rock, the paper, and the scissors.");
        System.out.println("Choose wisely...");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        userInput.toUpperCase();
        int theChoice;

            switch(userInput){
                case "rock":
                theChoice = 3;
                    break;
                case "paper":
                theChoice = 2;
                    break;
                case "scissors":
                theChoice = 1;
                    break;
                default:
                    System.out.println("Come again?");
                    rpsPlay();
                       break;
            }

        int compChoice = 1 + (int)(Math.random() * 3);

    }


    public static void rpsHistory(){

    }
//
//            System.out.println("Welcome to the games.\r\nLet us begin.");
//                    System.out.println("Here we have the rock, the paper, and the scissors.");
//                    System.out.println("Which brutal weapon shall you choose?");



}
