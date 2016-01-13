// Eric Tsai
// etsai7
// EN.600.107.01
// Homework 1 Task 1

import java.util.Scanner;

public class WindChill {
   
   public static void main(String [] args){
   
      Scanner keyboard = new Scanner(System.in);
      
      //User is now inputting the temperature will be within |50|
      System.out.print("Enter Fahrenheit temperature: ");
      double temperature = keyboard.nextDouble();
      
      //User is now inputting the windspeed
      System.out.print("Enter wind speed in miles per hour: ");
      double windSpeed = keyboard.nextDouble();
      
      //Takes user input and plugs into the given equation
      double windChill = 35.74 + (0.6215 * temperature) + ((.4275 * temperature)- 35.75)*Math.pow(windSpeed,.16);
      System.out.println("The effective temperature is " + windChill + " degrees Fahrenheit"); 
   }
}
      