// Eric Tsai
// etsai7
// CS 107
// Hw 5 Task1

import java.util.Scanner;

public class LettersGame{

   public static void main(String [] args){
   
      String guess = "";
      String base = givesValidBase();
      int numberOfCorrectGuesses = 0;
            
      Scanner keyboard = new Scanner(System.in);
      //System.out.println("enter a word: ");
      //String input = keyboard.nextLine();
      System.out.println("I'm selecting a base word for you... done.");
      System.out.println("The base word is " + base);
      System.out.println("***Now your job is to find words you can make from those same letters, ");
      System.out.println("***without any repeated letters. Enter \"_exit\" to quit");   
         
      while(!(guess.equals("_exit"))){
         System.out.println("Give me a word using the letters in \"" +base + "\": "); 
         guess = keyboard.nextLine();
         guess = guess.toLowerCase();
         if(guess.length() < 3){ //checks if guess is greater than three or equal to 3.
            System.out.println("Sorry, that word is not long enough.");
         }
         else if(!(usesOnlySymbolsFromBase(guess,base)) && !(guess.equals("_exit"))){//Checks to see the guess has letters from base only
            System.out.println("Sorry, you used an invalid letter.");
         }
         else if(hasRepeatedSymbol(guess)){//Makes sure theres not repeat symbols in guess.
            System.out.println("Sorry, you used the same symbol more than once.");
         }
         else if(!(CS107Dictionary.isValidWord(guess))&& !(guess.equals("_exit"))){//checks if guess is in the Dictionary
            System.out.println("Sorry, that word is not in the CS107 Dictionary.");
         }
         else if(!(guess.equals("_exit"))){
            numberOfCorrectGuesses = numberOfCorrectGuesses + 1;
            System.out.println("That is valid word #" + (numberOfCorrectGuesses));
         }
      }
      
      System.out.println("Thanks for playing. You found a total of " + numberOfCorrectGuesses + " valid word(s).");
   }
   
   
   
   public static String givesValidBase(){ //This checks to see if the base is > than 3 and also no repeats
   
      int isValid = 0;
      String base = "";
      
      while(isValid == 0){
      
         base = CS107Dictionary.getRandomBaseWordCandidate();//Gets word from other java class
         
         if(base.length() >= 3 && !(hasRepeatedSymbol(base))){
            return base;
         }
     
      }
      return base;
      
   }
   
   /**
      Check if the specified string contains more than one occurrence
      of any symbol.
      @param s the string to check
      @return true exactly when argument contains at least one repeat
   */
   public static boolean hasRepeatedSymbol(String s){ //Checks to see if word has repeated symbol.
      String subStringPart = s;
      for(int i = 0; i < s.length() - 2; i++){
         subStringPart = s.substring(i,s.length());
         //System.out.println();
         for(int j = i + 1; j < subStringPart.length() + i; j++){
            if(s.charAt(i) == s.charAt(j)){
               return true;
            }
           // System.out.print(j);
         }
      }
      return false;   
   }
   
   /**
      Check if the specified candidate String contains only symbols
      that appear in the specified base String.
      @param candidate the string to check against the base
      @param base the base string which defines allowed symbols
      @return true exactly when candidate contains only symbols
      that appear in base
   */
    public static boolean usesOnlySymbolsFromBase(String candidate, String base){
      
      int index = 0;
      for(int i = 0; i < candidate.length(); i++){
         index = base.indexOf(candidate.charAt(i));
         if(index == -1){
            //System.out.println("false"); just a check
            return false;
         }
      }   
      return true;
   }
}