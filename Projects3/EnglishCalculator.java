// Eric Tsai
// etsai7
// CS 107
// Hw 3 Task3

import java.util.Scanner;

public class EnglishCalculator{

   public static void main(String [] args){
   
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Please enter an operation. The format should be single digit, space, operand, space, single digit: ");
      String input = keyboard.nextLine();
      
      char firstDigit = input.charAt(0);
      char operation  = input.charAt(2);
      char secondDigit = input.charAt(4);
      
      int firstNum = 0;
      int secondNum =  0;
      String operationName = "Initial";
      double total= 0;
      
      String firstNumberName = "First";
      String secondNumberName = "Second";
      
      /*System.out.println(firstDigit);
      System.out.println(operation);
      System.out.println(secondDigit);*/
     
      switch(firstDigit){
         case '0':
            firstNum = 0;
            firstNumberName = "zero";
            break;
         case '1':
            firstNum = 1;
            firstNumberName = "one";
            break;
         case '2':
            firstNum = 2;
            firstNumberName = "two";
            break;
         case '3':
            firstNum = 3;
            firstNumberName = "three";
            break;
         case '4':
            firstNum = 4;
            firstNumberName = "four";
            break;
         case '5':
            firstNum = 5;
            firstNumberName = "five";
            break;
         case '6':
            firstNum = 6;
            firstNumberName = "six";
            break;
         case '7':
            firstNum = 7;
            firstNumberName = "seven";
            break;
         case '8':
            firstNum = 8;
            firstNumberName = "eight";
            break;
         case '9':
            firstNum = 9;
            firstNumberName = "nine";
            break;
         default :
            firstNum = -1;
            break;
  
      }
      
      switch(secondDigit){
         case '0':
            secondNum = 0;
            secondNumberName = "zero";
            break;
         case '1':
            secondNum = 1;
            secondNumberName = "one";
            break;
         case '2':
            secondNum = 2;
            secondNumberName = "two";
            break;
         case '3':
            secondNum = 3;
            secondNumberName = "three";
            break;
         case '4':
            secondNum = 4;
            secondNumberName = "four";
            break;
         case '5':
            secondNum = 5;
            secondNumberName = "five";
            break;
         case '6':
            secondNum = 6;
            secondNumberName = "six";
            break;
         case '7':
            secondNum = 7;
            secondNumberName = "seven";
            break;
         case '8':
            secondNum = 8;
            secondNumberName = "eight";
            break;
         case '9':
            secondNum = 9;
            secondNumberName = "nine";
            break;
         default:
            secondNum = -1;
            break;
      }
      
         switch(operation){
         case '+':
            operationName = "plus";
            total = firstNum + secondNum;
            break;
         case '-':
            operationName = "minus";
            total = firstNum - secondNum;
            break;
         case '*':
            operationName = "multiplied by";
            total = firstNum * secondNum;
            break;
         case '/':
            operationName = "divided by";
            if( secondNum ==0){
               break;
            }
            else{
               total = firstNum / secondNum;
               break;
            }
         case '^':
            operationName = "to the power";
            total = Math.pow(firstNum, secondNum);
            break;
         default:
            operationName = "Nothing";
            break;
      }
      
      if(secondNum == 0 && operationName.equals("divided by")){
         System.out.println("Division by zero is not allowed.");
      }
      else if(firstNum == -1 || secondNum == -1){
         System.out.println("Invalid Digit");
      }
      else if(operationName.equals("Nothing")){
         System.out.println("Invalid operator");
      }
      else{
         System.out.println(firstNumberName +" " + operationName + " " + secondNumberName + " is " + (total)); 
      }
    
   }
}