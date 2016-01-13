import java.io.*;
import java.util.Scanner;
public class Testing{
   
   public static void main(String [] args) throws IOException{
      String x = "1     The Avengers: Age of Ultron,    1:30pm      12:00pm   2:34pm      2:34am 1:30am";
      int numInArray = Integer.parseInt(x.substring(0,1));
      System.out.println(numInArray);
      x = x.substring(1);
      x = x.trim();
      int indexOfComma = x.indexOf(",");
      String title = x.substring(0,indexOfComma);
      System.out.println(title);
      String times = x.substring(indexOfComma + 1);
      System.out.println(times);
      //Scanner inFile = new Scanner(("1     The Avengers: Age of Ultron,    1:30pm      12:00pm   2:34pm      2:34am 1:30am"));
      //System.out.println(inFile.nextInt());
      //System.out.println(inFile.next());
      //System.out.println(inFile.nextLine());
      /*
      int numTestsFailed = 0;
		Movie m = new Movie("Cinderella", 105, 9.7);
		String times = "    1:30pm         12:00pm        2:34pm        2:34am     1:30am   ";
		MovieShowing ms = new MovieShowing(m, times);
      */
      /*String string = "1-50  of 500+     three hundre forty nine dl";
      String[] stringArray = string.split("\\s+");

      for (String str : stringArray)
      {
          System.out.println(str);
      }*/
     /* Scanner keyboard = new Scanner(System.in);
      String input = keyboard.next();
      Scanner inFile = new Scanner(new FileReader(input));
      int numMovies = Integer.parseInt(inFile.nextLine());//Should get movie list number
      System.out.println(numMovies);
      Movie[] movies = new Movie[numMovies];
      String x = "hi";
      //System.out.println(x);
      while(inFile.hasNextLine()){
         x = inFile.nextLine();
         String letter = x.substring(0,1);//Checks the type
         x = x.substring(2);
         
         if(letter.toLowerCase().equals("t")){
            int indexComma = x.indexOf(",");
            String name = x.substring(0,indexComma);
            x = x.substring(indexComma + 2);
            indexComma = x.indexOf(","); 
            int length = Integer.parseInt(x.substring(0,indexComma));
            x = x.substring(indexComma + 2);
            indexComma = x.indexOf(",");
            double price = Double.parseDouble(x.substring(0,indexComma));
            x = x.substring(indexComma + 2);
            double ThreeD  = Double.parseDouble(x);
            ThreeDMovie tempThreeD = new ThreeDMovie(name,length,price,ThreeD);
            int i =0;
            while(movies[i]!=(null)){
               i++;
            }
            movies [i] = tempThreeD;
            System.out.println(name + " " + length + " " + price + " " + ThreeD);
         }
         
         if(letter.toLowerCase().equals("i")){
            int indexComma = x.indexOf(",");
            String name = x.substring(0,indexComma);
            x = x.substring(indexComma + 2);
            indexComma = x.indexOf(","); 
            int length = Integer.parseInt(x.substring(0,indexComma));
            x = x.substring(indexComma + 2);
            indexComma = x.indexOf(",");
            double price = Double.parseDouble(x.substring(0,indexComma));
            x = x.substring(indexComma + 2);
            int IMAX  = Integer.parseInt(x);
            IMAXMovie tempIMAX = new IMAXMovie(name, length, price, IMAX);
            int i =0;
            while(movies[i]!=(null)){
               i++;
            }
            movies [i] = tempIMAX;
            System.out.println(name + " " + length + " " + price + " " + IMAX);
         }
         
         if(letter.toLowerCase().equals("m")){
            int indexComma = x.indexOf(",");
            String name = x.substring(0,indexComma);
            x = x.substring(indexComma + 2);
            indexComma = x.indexOf(","); 
            int length = Integer.parseInt(x.substring(0,indexComma));
            x = x.substring(indexComma + 2);
            double price = Double.parseDouble(x);
            Movie tempMovie = new Movie(name,length,price);
            int i =0;
            while(movies[i]!=(null)){
               i++;
            }
            movies [i] = tempMovie;
            System.out.println(name + " " + length + " " + price);
         }
      }
      System.out.println();
      for(int i = 0; i < numMovies; i++){
         System.out.println(movies[i].toString());
      }*/
   }
}