// Eric Tsai
// etsai7
// CS 107
// Hw 6 Task2

import java.util.Scanner;

public class ColumnFitter{
   
   public static void main(String [] args){
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter a line of text: ");
      String input = keyboard.nextLine();
      System.out.print("Enter column width: ");
      int columns = keyboard.nextInt();
      String fitted = fit(input, columns);
      System.out.println(fitted);
   }
   
   /**
      Recursively fit a String into a column of a given width by wrapping 
      where necessary.
      @param original the String that should be wrapped into column format
      @paramd width   the width of the column into which the String must fit
      @return         the fitted String, which likely contains\n characters
   */
   
   public static String fit(String original, int width){
      if(original.length() <= width){
         return original;
      }
      
      String part = original.substring(0,width); // this is the first n characters
      
      if(part.lastIndexOf(" ") == -1){//If chunk does not have a space. Also basically if bigger than width
         return part.substring(0,width - 1) + "&\n" + fit(original.substring(width-1),width);
      }
      
      String partTruncated = part.substring(0,part.lastIndexOf(" ")+1);//collects complete words up to and within width
      String restOfOriginal = original.substring(part.lastIndexOf(" ")+1);//rest of original
      int nextWordAfterPartLength = restOfOriginal.substring(0,restOfOriginal.indexOf(" ") + 1).length();
      
      if((partTruncated.length() + nextWordAfterPartLength) - width == 1){//This is if it goes over by one due to space
         return partTruncated + restOfOriginal.substring(0,restOfOriginal.indexOf(" ")) + "\n" + fit(restOfOriginal.substring(restOfOriginal.indexOf(" ") + 1),width);
      }
      
      if(nextWordAfterPartLength == width){//If next word is perfect including space
         return partTruncated + "\n" + restOfOriginal.substring(0,restOfOriginal.indexOf(" ") + 1) + "\n" + fit(restOfOriginal.substring(restOfOriginal.indexOf(" ") + 1),width);
      }
      if(nextWordAfterPartLength == width + 1){//If next word is only bigger by one space
         return partTruncated + "\n" + restOfOriginal.substring(0,restOfOriginal.indexOf(" ")) + "\n" + fit(restOfOriginal.substring(restOfOriginal.indexOf(" ") + 1),width);
      }
      if(nextWordAfterPartLength > width /*&& nextWordAfterPartLength < width*2*/){
         return partTruncated + "\n" + fit(original.substring(part.lastIndexOf(" ")+1),width);
      }
      else{//If the next word is less than width
         return partTruncated + "\n" + fit(restOfOriginal,width);
      }
      
   }
}

/*
   1. Get first 'width' letters of the original string
   2. get the LastIndexOf ' ' to find all completed words that is <= width
   3. Find the next word after LastIndexOf ' ' to see if you need to split that word
   4. If need to split and is less than double of width, then its \n+substring(0,width) +  \n +fit(substring(width),width)
   5. If not, then /n fit(original.substring(width)
   6.If there is no last space (this is on top) 
      if bigger then split
      if not then return original
*/