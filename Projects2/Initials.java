// Eric Tsai
// etsai7
// CS 107
// Hw 2 Task2

import java.util.Scanner;

public class Initials{

   public static void main(String [] args){
   
   //Tell user to input three part name
   Scanner keyboard = new Scanner(System.in);
   System.out.println("Please enter your full name (all three parts): ");
   String input = keyboard.nextLine();
   input = input.toUpperCase();
   System.out.println(input);
   String whiteSpace =" " ;
   
   //Finds white space and told to find the character at position 0.
   int space = input.indexOf(whiteSpace);
   //System.out.println(space1);
   char initial1 = input.charAt(0);
   
   //Cuts the name so that only middle and last name left, then told to find character at position 0
   input = input.substring(space + 1);
   space = input.indexOf(whiteSpace);
   char initial2 = input.charAt(0);
   
   //Cuts the name so that only last name left, then finds character at position 0.
   input = input.substring(space + 1);
   char initial3 = input.charAt(0);
   
   //Prints the Initials in Capital Letters.
   System.out.println("Your initials are " + initial1 + initial2 + initial3);
   
   }
}