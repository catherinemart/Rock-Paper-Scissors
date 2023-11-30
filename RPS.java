/* Catherine Martin
AP CSA
Project 2
Rock, Paper, Scissors Game
*/

import java.util.Scanner;
import java.util.Random;

public class RPS {
   
   //fields
   static int gamemode;
   static int rounds = 0;
   static int p1Move;
   static int p1Score = 0;
   static int p2Move;
   static int p2Score = 0;
   static int endChoice;
   static String StringMoves[] = new String[]{"", "Rock", "Paper", "Scissors"}; 
   static String initialInput = "";
   static boolean validInput = false;
   
   public static void main (String[] args) {
      
      //loop to play game repeatedly
      while (true) {
         
         //resetting fields
         rounds = 0;
         p1Score = 0;
         p2Score = 0;
         
         //creating Scanner
         Scanner scan = new Scanner(System.in); 
         
         //while loop to check input for gamemode is valid
         while (!validInput) {
            
            //prompting user for input + consuming as a String
            System.out.println("Choose your gamemode: Enter 1 to play against a computer or 2 to play against another person.");
            initialInput = scan.nextLine();
            
            //checking input is an int
            if (isInt(initialInput)) {
               gamemode = Integer.parseInt(initialInput); 
               
               //checking input is in range
               if (gamemode >= 1 && gamemode <= 2) {
                  validInput = true; //exit loop
                  initialInput = ""; //resetting initialInput so it can be reused
               
               //error messages in case of invalid input
               } else {
                  System.out.println("Invalid input. Please try again.");
                  validInput = false;
               
               }
            
            } else {
               System.out.println("Invalid input. Please try again.");
               validInput = false;
            
            }
         
         }
         
         playGame(); //calling method to play game
         
         //asking user if they would like to play again
         System.out.println("Enter 1 if you would like to play again and 2 if you want to exit.");
         endChoice = scan.nextInt();
         
         if (endChoice == 2) {  //options to quit game or continue playing
            System.exit(0);
         
         } else {
            validInput = false; //resetting validInput to be reused
            continue;
         
         }
         
      }
   
   }
   
   //method to ask for input and check that it is valid
   public static int[] getInput() {
      
      //creating Scanner
      Scanner scan = new Scanner(System.in);
      validInput = false;  //resetting validInput
      
      if (gamemode == 1) {
      
         Random r = new Random();      //getting random computer move
         p2Move = r.nextInt(StringMoves.length);
         
         //loops until valid input is recieved
         while (!validInput) {
            
            //asking user for input + consuming as String
            System.out.println("Choose your move. Enter 1 for rock, 2 for paper, or 3 for scissors.");
            initialInput = scan.nextLine();
            
            //checking input is int
            if (isInt(initialInput)) {
               p1Move = Integer.parseInt(initialInput);
               
               //checking input is within
               if (p1Move >= 1 && p1Move <= 3) {
                  validInput = true; //exit loop
                  initialInput = "";   //resetting initialInput so it can be used again
               
               //error messages for invalid input
               } else {
                  System.out.println("Invalid input. Please try again.");
                  validInput = false;
               
               }
            
            } else {
               System.out.println("Invalid input. Please try again.");
               validInput = false;
            
            }
            
         } 
         
      }
      
      else if (gamemode == 2) {
         
         //loops until valid input is recieved
         while (!validInput) {
                                    //getting user input + consuming as a String
            System.out.println("Player 1, choose your move. Enter 1 for rock, 2 for paper, or 3 for scissors.");
            initialInput = scan.nextLine();
            
            //checking input is an int
            if (isInt(initialInput)) {
               p1Move = Integer.parseInt(initialInput);
               
               //checking input is within range
               if (p1Move >= 1 && p1Move <= 3) {
                  validInput = true;  //exit loop
                  initialInput = "";  //resetting initialInput so it can be used again
               
               //error messages for invalid input
               } else {
                  System.out.println("Invalid input. Please try again.");
                  validInput = false;
               
               }
            
            } else {
               System.out.println("Invalid input. Please try again.");
               validInput = false;
            
            }
         
         }
         
         validInput = false;  //resetting validInput so it can be used again
         
         //loops until valid input is recieved
         while (!validInput) {
                        
            //getting other user's move + consuming as a String
            System.out.println("Player 2, choose your move. Enter 1 for rock, 2 for paper, or 3 for scissors.");
            initialInput = scan.nextLine();
            
            //checking input is an int
            if (isInt(initialInput)) {
               p2Move = Integer.parseInt(initialInput);
               
               //checking input is within range
               if (p2Move >= 1 && p2Move <= 3) {
                  validInput = true;  //exit loop
                  initialInput = "";  //resetting initialInput
               
               //error messages for invalid input
               } else {
                  System.out.println("Invalid input. Please try again.");
                  validInput = false;
               
               }
            
            } else {
               System.out.println("Invalid input. Please try again.");
               validInput = false;
            
            }
         
         
         }
         
      }
      
      //creating array of moves and returning it
      int moves[] = {p1Move, p2Move};
      return moves;
      
   }
   
   
   //method to check input is an int
   public static boolean isInt(String initialInput) {
      
      try { 
         Integer.parseInt(initialInput);
         return true;
      
      }  catch (Exception e) {
         return false;
      
      }
   } 
   
   //method play through game logic
   public static void playGame() {
      
      //loop to go through the game until there have been 3 points scored
      while (rounds < 3) {
         
         //getting players' moves
         int moves[] = getInput();
         p1Move = moves[0];
         p2Move = moves[1];
         
         //printing move
         System.out.println("Player 1 played " + StringMoves[p1Move]);
         System.out.println("Player 2 played " + StringMoves[p2Move]);
         
         //switch statement to determine winner
         switch (p1Move - p2Move) {
            
            //Player 1 wins
            case (-2):
               case (1):
               
               p1Score++;
               rounds++;
               System.out.println("Player 1 wins! \n\n Score: \n Player 1: " + p1Score + "\t Player 2: " + p2Score);
               
               break;
            
            //player 2 wins
            case (2):
               case (-1):
               
               p2Score++;
               rounds++;
               System.out.println("Player 2 wins! \n\n Score: \n Player 1: " + p1Score + "\t Player 2: " + p2Score);
               
               break;
            
            //if there is a tie 
            default:
            
               System.out.println("Tie!\n\n Score: \n Player 1: " + p1Score + "\t Player 2: " + p2Score);
         
         }
      
      }
      
      //determining overall winner + printing win message
      if (p1Score > p2Score) {
         System.out.println("Player 1 wins!");
      
      } else {
         System.out.println("Player 2 wins!");
      
      }
   
   
   }

}