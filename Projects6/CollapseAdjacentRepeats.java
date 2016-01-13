// Eric Tsai
// etsai7
// CS 107
// Hw 6 Task1

import java.util.Scanner;

public class CollapseAdjacentRepeats{
   
   public static void main(String [] arg){
   
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter a line you would like to collapse: ");
      String input = keyboard.nextLine();
      String compressedInput = collapse(input);
      System.out.println(compressedInput);
   }
   
   /**
     Recursively remove the adjacent duplicate characters in a String.
     @param original the String from which duplicates will be removed
     @return         the original but with adjacent duplicates removed
   */
  
   public static String collapse(String original){
      
      if(original.length() == 1){
         return original;
      }
      
      if(original.charAt(0)==(original.charAt(1))){
         return  collapse(original.substring(1));
      }
      else{
         return original.charAt(0) + collapse(original.substring(1));
      }
   }
}