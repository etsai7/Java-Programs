//Eric Tsai
//etsai7
//600.107 Hw 7 Task 1 CashRegister

import java.io.*;
import java.lang.Object;
import java.util.Scanner;

public class CashRegister extends Object{

   /**The scanner for keyboard input.*/
   private static Scanner kb;
   /**The receipt object that will be used in all methods in this class.*/
   private static Receipt receipt;
   /**The MoneyConverter object that will convert doubles to int*/
   private static MoneyConverter convert;
   
   /**Constructor for CashRegister*/
   public CashRegister(){
   
   }
   /**Main method where the program asks the user for an optional filename to
   initialize the checkout and then gets user input for the menu options.*/
   public static void main(String [] args)throws IOException{
      System.out.print("Would you like to enter a file name to initialize the checkout? (y/n) ");
      kb = new Scanner(System.in);
      String answer = kb.nextLine();
      while(!((answer.equals("y")) || (answer.equals("n")) || (answer.equals("Y")) || (answer.equals("N")))){
         System.out.print("Again, would you like to enter a file name to initialize the checkout? (y/n) ");
         answer = kb.next();
      }
      if(answer.equals("y") || (answer.equals("Y"))){
         System.out.println("Please type in the file name: ");
         String file = kb.next();
         receipt = new Receipt(file);
      }
      else{
         receipt = new Receipt();
      }
      int action = 1;
      while(action != 0){//Building up the Receipt
         System.out.println("What would you like to do?");
         printMenu();
         System.out.print("Choice: -> ");
         action = kb.nextInt();
         if(action < 0 || action > 5){
            while(action < 0 || action > 5){
               System.out.println("Invalid Choice!\n");
               printMenu();
               System.out.print("Choice: -> ");
               action = kb.nextInt();
            }
         }
         if(action == 0){
            checkout();
         }
         else{
            interpretChoice(action);
         }
      }
      //Making the Payments
      convert = new MoneyConverter();
      if(receipt.getAmountOwed() > 0){
         while(receipt.getAmountOwed() > 0){  
            System.out.println("You still owe: " + convert.getStringFromPennies(receipt.getAmountOwed()));
           System.out.print("Please enter the amount you want to pay in dollar.cent format: ");
           double payment = kb.nextDouble();
           int amountEntered = convert.getPennies(payment);//Amount is in pennies
           boolean addedPayment = receipt.addAmountPaid(amountEntered);
           if(addedPayment){
              System.out.println("Paid!");
           }
           else{
              System.out.println("Payment Failed.");
           }  
         }
      
         //Make Change
         int changeInPennies = receipt.getAmountOwed();
         if(changeInPennies < 0){
            changeInPennies = -1*changeInPennies;
            String changeInDollars = convert.getStringFromPennies(changeInPennies);
            System.out.println("The change that is owed to you is: " + changeInDollars);
            System.out.println("The Cashier will give you: ");
            makeChange(changeInPennies);
         }
         else{//changeInPennies == 0 bc if its > 0 it would still be looping up there
            System.out.println("That was a perfect payment. Bye!");  
         } 
      }
      else{
         System.out.println("You don't need to pay anything!");
      } 
      System.out.println("Goodbye!");
   }
   
   /**Prints the menu options for the program.*/
   private static void printMenu(){
      System.out.println("Enter 0 to checkout.");
      System.out.println("Enter 1 to add item.");
      System.out.println("Enter 2 to remove item.");
      System.out.println("Enter 3 to add coupon.");
      System.out.println("Enter 4 to set bonus.");
      System.out.println("Enter 5 to print receipt");
      
   }
   
   /**This method is called when the user indicates he or she wants to checkout.*/
   private static void checkout(){
      System.out.println("You are ready for checkout.");
      receipt.printReceipt();
      //System.out.println("Goodbye.");
   }
   /**This takes the user's selection and performs different operations based on the choice.*/
   private static void interpretChoice(int choice){
      int action = choice;
      if (action == 1){//Add Item
         System.out.print("Enter the item price you would like to add: ");
         double newItem = kb.nextDouble();
         int newItemInPennies = convert.getPennies(newItem);
         boolean adding = receipt.addItem(newItemInPennies);
         if(adding){
            System.out.println("The item has successfully been added.\n");
         }
         else{
            System.out.println("The item has not been successfully added.\n");   
         }
      }
      else if(action == 2){//Remove Item
         System.out.print("Enter the item price you would like to remove: ");
         double removeItemPrice = kb.nextDouble();
         int removeItemPriceInPennies = convert.getPennies(removeItemPrice);
         boolean removing = receipt.removeItem(removeItemPriceInPennies);
         if(removing){
            System.out.println("The item has been succesfully removed.\n");
         }
         else{
            System.out.println("The item has not been succesfully removed.\n");
         }       
      }
      else if(action == 3){//Add coupon
         System.out.print("Please enter the coupon amount: ");
         double couponDiscount = kb.nextDouble();
         int couponDiscountInPennies = convert.getPennies(couponDiscount);
         boolean addingCoupon = receipt.addCoupon(couponDiscountInPennies);
         if(addingCoupon){
            System.out.println("The coupon has been succesfully added.\n");
         }
         else{
            System.out.println("The coupon has not been succesfully added.\n");
         }      
      }
      else if(action == 4){//Add/change bonus discount
         System.out.println("Please enter the discount value between 0 and 100: ");
         int discountValue = kb.nextInt();
         boolean setDiscountValue = receipt.setBonusPercentage(discountValue);
         if(setDiscountValue){
            System.out.println("The new bonus percentage has been set.\n");
         }
         else{
            System.out.println("The new bonus percentage has not been set.\n");
         }
      }
      else if(action == 5){//print summary
         receipt.printReceipt();
      }    
   }
   
   /**Prints the denominations of bills and coins to be given to a customer who
   is owed the specified amount in change.*/
   private static void makeChange(int changeInPennies){

      if(changeInPennies > 0){
         
         int twenties = changeInPennies / 2000;
         changeInPennies = changeInPennies - (twenties * 2000);
         if(twenties != 0){
            System.out.println(twenties + " twenty-dollar bill(s)");
         }
         
         int tens = changeInPennies / 1000;
         changeInPennies = changeInPennies - (tens * 1000);
         if(tens!=0){
            System.out.println(tens + " ten-dollar bill(s)");
         }
         
         int fives = changeInPennies / 500;
         changeInPennies = changeInPennies - (fives * 500);
         if(fives!=0){
            System.out.println(fives + " five-dollar bill(s)");
         }
         
         int ones = changeInPennies / 100;
         changeInPennies = changeInPennies - (ones * 100);
         if(ones != 0){
            System.out.println(ones + " one-dollar bill(s)");
         }
         
         int quarters = changeInPennies / 25;
         changeInPennies = changeInPennies - (quarters * 25);
         if(quarters != 0){
            System.out.println(quarters + " quarter(s)");
         }
         
         int dimes = changeInPennies / 10;
         changeInPennies = changeInPennies - (dimes * 10);
         if(dimes != 0){
            System.out.println(dimes + " dime(s)");
         }
         
         int nickels = changeInPennies / 5;
         changeInPennies = changeInPennies - (nickels * 5);
         if(nickels!=0){
            System.out.println(nickels + " nickel(s)");
         }
         
         int pennies = changeInPennies;
         if(pennies != 0){
            System.out.println(pennies + " penny(ies)");
         }
      }
      
      else{//changeInPennies == 0 bc if its > 0 it would still be looping up there
         System.out.println("That was a perfect payment. Bye!");
      }
   }
}