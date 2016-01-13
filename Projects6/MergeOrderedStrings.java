// Eric Tsai
// etsai7
// CS 107
// Hw 6 Task3
import java.util.Scanner;
import java.lang.Character;

public class MergeOrderedStrings{

   public static void main(String [] args){
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter your first alphabetized string of lower case letters: ");
      String inputOne = keyboard.nextLine();
      while(!(containsAlphabetizedLowerCase(inputOne))){
         System.out.print("Sorry, please try again: ");
         inputOne = keyboard.nextLine();
      }
      System.out.println("Enter your second alphabetized string of lower case letters: ");
      String inputTwo = keyboard.nextLine();
      while(!(containsAlphabetizedLowerCase(inputTwo))){
         System.out.print("Sorry, please try again: ");
         inputTwo = keyboard.nextLine();
      }
      String mergedStrings = merge(inputOne,inputTwo);
      System.out.println(mergedStrings);

   }
   
   /**
      Check whether the given String contains only lower-case letters in
      alphabetical order, and no additional symbols, digits, or space.
      @ param s the String to be checked
      @return   true exactly when the String contains only an alphabetized
                list of lower-case letters
   */
   
   public static boolean containsAlphabetizedLowerCase(String s){
   
      for(int i = 0; i<s.length();i++){//checks if all the characters are indeed lowercase letters
         if(!(s.charAt(i) >= 97 && s.charAt(i) <= 122)){
            return false;
         }
      }
      
      for(int i = 0; i<s.length()-1; i++){//checks if the characters are in order
         if(!(s.charAt(i) <= s.charAt(i+1))){
            return false;
         }
      }

      return true;//If it passes both for loops, then String is all lowercase and in order.
   }
   
   /**
      Merge two strings of lower case lettes that are ordered alphabetically,
      so that the result is also alphabetically ordered.
      @param first  the 1st alphabetically ordered String of lower-case letters
      @param second the 2nd alphabetically ordered String of lower-case letters
      @return       the joinged String, also ordered alphabetically.
   */
   
   public static String merge(String first, String second){
      
      if(first.length() == 0){
         return second;
      }
      if(second.length() == 0){
         return first;
      }
      if(first.charAt(0) <= second.charAt(0)){
         return first.charAt(0) + merge(first.substring(1), second);
      }
      else{
         return second.charAt(0) + merge(first,second.substring(1));
      }
   }
   
}