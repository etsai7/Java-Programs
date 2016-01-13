import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;


public class Polydivisible {

   public static void main(String[] args) throws IOException {
   
      //Set up a Scanner connected to the desired input file
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Please enter the name of the input file: ");
      String fileName = keyboard.nextLine();
      Scanner inFile = new Scanner(new FileReader(fileName));

      //Set up a PrintWriter connected to the output file
      PrintWriter outFile = new PrintWriter (new FileWriter(fileName + ".out"));

      //The loop condition is true as long as the next item in the file
      //is an int, and we haven't reached the end of the file
      int numbersChecked = 0;
      int polyDivisible = 0;
      boolean polyCheck = true;
      
      while (inFile.hasNextInt()) {
         polyCheck = true;
         int value = inFile.nextInt();
         String valueInString = value + "";
         int valueLength = valueInString.length();
         String valuePart = "hi";
         
         for(int i = 0; i < valueLength; i++){
            valuePart = valueInString.substring(0,(valueLength - i));
            int valuePartSubString = valuePart.length();
            int newValue = Integer.parseInt(valuePart);
            int mod = newValue % valuePartSubString;
            if(mod != 0){
               i = valueLength + 5;
               polyCheck = false;
            }
         }
            
         if(polyCheck){
            polyDivisible++;
            outFile.println(value);
         }
         
         numbersChecked++;
         
      }
      
      System.out.println("Read " + numbersChecked + " values from input file " + fileName + ".");
      System.out.println("Wrote " + polyDivisible + " of them to output file " + fileName + ".out.");
      
      inFile.close(); //be sure to close Scanner before program ends
      outFile.close(); //be sure to close PrintWriter before program ends
   }

}
