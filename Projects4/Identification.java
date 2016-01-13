// Eric Tsai
// etsai7
// CS 107
// Hw 4 Task1

import java.util.Scanner;

public class Identification{

   public static void main (String [] args){
   
      //named constant representing desired PIN value
      final String TARGET_PIN = "1234";
      
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Please enter your PIN number: ");
      String input = keyboard.nextLine(); //user input for the PIN code.
      int counter = 1;
      
      while(counter < 3 && !(input.equals( TARGET_PIN))){
         System.out.print("Please enter your PIN number: ");
         input = keyboard.nextLine();
         counter++;
      }
      
      if(input.equals(TARGET_PIN)){
         System.out.println("You are successfully logged in.");
      }
      else{
         System.out.println("You made 3 unsuccessful login attempts.");
         System.out.println("Your account is locked. Please contact the bank.");
      }
      
       System.out.println("Goodbye.");
   }
}