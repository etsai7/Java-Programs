// Eric Tsai
// etsai7
// CS 107
// Hw 3 Task1

import java.util.Scanner;

public class ColorMix{

   public static void main(String [] args){
   
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Please enter the names of two primary colors, separated by a space: ");
      String input = keyboard.nextLine(); //Lets user input two colors separated by a space.
      input = input.toLowerCase();
      String firstColor = input.substring(0,input.indexOf(" "));
      String secondColor = input.substring(input.indexOf(" ") + 1, input.length());
      
      //Check
      //System.out.println(firstColor);
      //System.out.println(secondColor);
      
      //This is the conditions to satisfy a certain combination of colors.
      if((firstColor.equals("red") && secondColor.equals("blue")) || (firstColor.equals("blue") && secondColor.equals("red"))){
         System.out.println("Mixing " + firstColor + " with " + secondColor + " gives purple");
      }
      
      else if ((firstColor.equals("red") && secondColor.equals("yellow")) || (firstColor.equals("yellow") && secondColor.equals("red"))){
         System.out.println("Mixing " + firstColor + " with " + secondColor + " gives orange");
      }
      
      else if ((firstColor.equals("blue") && secondColor.equals("yellow")) || (firstColor.equals("yellow") && secondColor.equals("blue"))){
         System.out.println("Mixing " + firstColor + " with " + secondColor + " gives green");
      }
      
      else if (firstColor.equals(secondColor)){
         System.out.println("Mixing " + firstColor + " with " + secondColor + " gives " + firstColor);

      }
      
      else{
         System.out.println("Invalid color. The primary colors are red, blue, and yellow.");
      }
  
   }
}