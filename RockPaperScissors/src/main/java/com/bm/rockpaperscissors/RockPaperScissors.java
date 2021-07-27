/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 27, 2021
 * purpose: Rock Paper Scissors game for the Java Basics assessment
 */

package com.bm.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // placeholder values for player and AI choices per round
        final int ROCK = 1;
        final int PAPER = 2;
        final int SCISSOR = 3;
        
        // placeholder values for the outcome of a round
        final int PLAYER_WIN = 1;
        final int AI_WIN = 2;
        final int TIE = 0;
        
        Random randGen = new Random();
        
        String continueString = "";
        boolean inputValid = true;
        do {
            System.out.print("How many rounds do you wish to play? ");
            System.out.println("(Min allowed: 1, Max allowed: 10)");
            int roundsRemaining = Integer.parseInt(reader.nextLine());

            if (roundsRemaining < 1 || roundsRemaining > 10) {
                inputValid = false;
            } else {
                int playerChoice;
                int aiChoice;

                int ties = 0;
                int playerWins = 0;
                int aiWins = 0;
                
                int roundStatus = 0;

                while (roundsRemaining > 0) {
                    // gather choices by the player and then the AI
                    System.out.println(roundsRemaining + " round(s) left");
                    System.out.println();
                    System.out.println("Pick your next choice");
                    System.out.println("   " + ROCK + " --- Rock");
                    System.out.println("   " + PAPER + " --- Paper");
                    System.out.println("   " + SCISSOR + " --- Scissors");
                    
                    playerChoice = Integer.parseInt(reader.nextLine());
                    
                    // generate some random number in [0, 3)
                    // so casting to int should produce a number
                    // in {0, 1, 2}
                    aiChoice = (int) (randGen.nextDouble() * 3);
                    aiChoice++;
                    
                    // evaluate round outcome and update statistics
                    switch (playerChoice) {
                        case ROCK:
                            switch (aiChoice) {
                                case SCISSOR:
                                    playerWins++;
                                    roundStatus = PLAYER_WIN;
                                    break;
                                case ROCK:
                                    ties++;
                                    roundStatus = TIE;
                                    break;
                                default:
                                    aiWins++;
                                    roundStatus = AI_WIN;
                                    break;
                            }
                            break;

                        case PAPER:
                            switch (aiChoice) {
                                case ROCK:
                                    playerWins++;
                                    roundStatus = PLAYER_WIN;
                                    break;
                                case PAPER:
                                    ties++;
                                    roundStatus = TIE;
                                    break;
                                default:
                                    aiWins++;
                                    roundStatus = AI_WIN;
                                    break;
                            }
                            break;

                        default:
                            switch (aiChoice) {
                                case PAPER:
                                    playerWins++;
                                    roundStatus = PLAYER_WIN;
                                    break;
                                case SCISSOR:
                                    ties++;
                                    roundStatus = TIE;
                                    break;
                                default:
                                    aiWins++;
                                    roundStatus = AI_WIN;
                                    break;
                            }
                    }
                    
                    System.out.println();
                    System.out.println("The player chose " + playerChoice);
                    System.out.println("The AI chose " + aiChoice);
                    switch (roundStatus) {
                        case PLAYER_WIN:
                            System.out.println("The player won this round");
                            break;
                        case AI_WIN:
                            System.out.println("The AI won this round");
                            break;
                        default:
                            System.out.println("This round is a tie");
                            break;
                    }
                    System.out.println();
                
                    System.out.println("Player wins: " + playerWins);
                    System.out.println("    AI wins: " + aiWins);
                    System.out.println("       Ties: " + ties);
                    roundsRemaining--;
                }
                
                if (playerWins > aiWins) {
                    System.out.println("The player is the winner");
                } else if (aiWins > playerWins) {
                    System.out.println("The AI is the winner");
                } else {
                    System.out.println("The player and AI are tied");
                }
                
                System.out.println("Do you wish to play again?");
                continueString = reader.nextLine();
            }
        } while (inputValid && continueString.equalsIgnoreCase("yes"));
    
        if (inputValid) {
            System.out.println("Thanks for playing!");
        } else {
            System.out.println("!! Error !!");
            System.out.println("The input must be in the range [1, 10]");
        }
    }
}
