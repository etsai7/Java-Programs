// Eric Tsai
// etsai7
// CS 107
// Hw 3 Task2

import java.util.Scanner;

public class Triangles{

   public static void main(String [] args){
   
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Please enter lengths of three sides of a triangle, separated by spaces: ");
      String input = keyboard.nextLine();
      //System.out.println(input.indexOf(" ")); 
      int firstNumber = Integer.parseInt(input.substring(0,input.indexOf(" ")));
      input = input.substring(input.indexOf(" ") + 1);
      int secondNumber = Integer.parseInt(input.substring(0,input.indexOf(" ")));
      input = input.substring(input.indexOf(" ") + 1);
      int thirdNumber = Integer.parseInt(input);
      
      //combinations for the triangle Inequality
      int firstCombo = firstNumber + secondNumber;
      int secondCombo = firstNumber + thirdNumber;
      int thirdCombo = secondNumber + thirdNumber;
      
      //Conditions for a certain type of Triangle.
      if((firstNumber <= 0) || (secondNumber <= 0) || (thirdNumber <= 0)){
         System.out.println("Invalid input: At least one of the lengths was not positive.");
      }
      else if ((firstNumber == secondNumber) && (secondNumber == thirdNumber)){
         System.out.println("The triangle is equilateral.");
      }
      
      else if((firstNumber == secondNumber) || (secondNumber == thirdNumber) || (firstNumber == thirdNumber)){
         System.out.println("The triangle is isosceles.");
      }
      else if(((firstCombo) > thirdNumber) && ((thirdCombo) > firstNumber) && ((secondCombo) > secondNumber)){
         System.out.println("This triangle is scalene.");
      }
      else{
         System.out.println("Invalid input: Those lengths do not form a triangle.");
      }
   
   }
}