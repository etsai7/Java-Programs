// Eric Tsai
// etsai7
// EN.600.107.01
// Homework 1 Task 3

import java.util.Scanner;

public class Mortgage{

   public static void main(String [] args){
   
      Scanner keyboard = new Scanner(System.in);
      
      //user input
      System.out.print("Please enter the outstanding balance (no commas, please): ");
      double balance = keyboard.nextDouble();
      System.out.print("Please enter the monthly payment (again, no commas): ");
      double monthlyPayment = keyboard.nextDouble();
      System.out.println("Next. you will need to enter the annual interest rate. For example, you will enter 4.98% as .0498.");
      System.out.print("Please enter the rate: ");
      double interestRate = keyboard.nextDouble();
      
      //Calculation for First monthly payments
      System.out.println("\nFirst Month");
      double interest = balance * (interestRate / 12);
      System.out.printf("Amount going to interest: $%.2f", interest); 
      double principal = monthlyPayment - interest;
      System.out.printf("\nAmount going to principal: $%.2f\n", principal);
      balance = balance - principal;
      
      //Calculation for Second monthly payments
      System.out.println("\nSecond Month");
      interest = balance * (interestRate / 12);
      System.out.printf("Amount going to interest: $%.2f",interest);
      principal = monthlyPayment - interest; 
      System.out.printf("\nAmount going to principal: $%.2f", principal);
      
  }
}