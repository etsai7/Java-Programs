// Eric Tsai
// etsai7
// CS 107
// Hw 4 Task2

import java.util.Scanner;

public class NumberConverter{
   
   public static void main(String [] args){
   
      String conversion = "";
      Scanner keyboard = new Scanner(System.in);
      int base = 0;
      int number = -1;
      System.out.println("This program converts integers from the base 10 number system to");
      System.out.println("a number system using another base. Only integer bases 2-9 are valid.");
      
      while(!(base >= 2) || !(base <= 9)){//Makes sure the user inputs the correct range for base.
         System.out.print("To which base would you like me to convert? ");
         base = keyboard.nextInt();
      }
      System.out.println("Okay, in this program, weÕll be converting to base " + base);
      
      System.out.print("Please enter a positive integer in base 10, or 0 to quit: ");
      number = keyboard.nextInt();
      
      if(number == 0){
         System.out.println("Goodbye");
      }
      
      else if(number < 0){
         System.out.println("That number is not positive.");
      }
      
      else{
         int mod = 0;
         int quotient = 1;
         int counter = 0;
         int decimal = 1;
         String modConvert = "";
 
         while(number > 0){ //This is the base conversion algorithm.
         
            mod = number % base;   
               modConvert = mod + "";     
            conversion = modConvert + conversion;
            number = number / base;
            counter++;
         }
         System.out.println("In base " + base + " that's "+ conversion);
      }
   
   }
}