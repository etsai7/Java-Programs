// Eric Tsai
// etsai7
// CS 107
// Hw 2 Task1

import java.util.Scanner;

public class MiddleThree{

   public static void main(String [] args){
   
   //Telling users to input an odd numbered String
   Scanner keyboard = new Scanner(System.in);
   System.out.println("Please enter an odd-length String with at least three characters: ");
   String input = keyboard.nextLine();
   
   //Algorithm for finding the middle 3 substring
   int middleOfInput = input.length()/ 2;
   String middleThree = input.substring(middleOfInput - 1, middleOfInput + 2);
   System.out.println("The middle three String is " + middleThree);
   
   }
}