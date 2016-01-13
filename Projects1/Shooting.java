// Eric Tsai
// etsai7
// EN.600.107.01
// Homework 1 Task 2

import java.util.Scanner;

public class Shooting{
   
   public static void main(String [] args){
      
      Scanner keyboard = new Scanner(System.in);
      
      //User input
      System.out.print("Please enter number of shots taken: ");
      int shots = keyboard.nextInt();
      System.out.print("Please enter the number of shots made: ");
      int shotsMade = keyboard.nextInt();
      double percentage = (double) (shotsMade) / (double) (shots) * 100;
      System.out.printf("Making " + shotsMade + " out of " + shots + ", the player's shooting percentage was: %.1f", percentage);
      System.out.print("%");
   }
}
