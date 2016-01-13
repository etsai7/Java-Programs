import java.io.*;
import java.util.Scanner;
public class Town extends Object implements TownInterface{
   /**The theaters in the town.*/
   private Theater[] theaters;
   /**The number of theaters.*/
   private int numTheaters;
   
   /**
      Creates a new town based on information in a file. The file will start with a number of the first 
      line. This represents the number of theaters in the town. The next lines of the file will contain 
      the movie title, movie times, and which theater the movie should be added to
      @param filename - the name of the file with all the information
   */
   public Town(String filename) throws IOException{
      Scanner inFile = new Scanner(new FileReader(filename));
      numTheaters = inFile.nextInt();
      inFile.nextLine();
      theaters = new Theater[numTheaters];
      Theater newTheater;
      for(int i = 0; i < numTheaters; i++){
         newTheater = new Theater();
         theaters[i] = newTheater;
      }
      while(inFile.hasNextLine()){
         String x = inFile.nextLine();
         int numInArray = Integer.parseInt(x.substring(0,1));//Which Theater it goes in
         x = x.substring(1);//Rest of String of Title and times
         x = x.trim();//Cuts of spaces at beginning and end
         int indexOfComma = x.indexOf(",");
         String title = x.substring(0,indexOfComma);//Title
         String times = x.substring(indexOfComma + 1);//Times
         Movie stringMovie = MovieList.getMovieWithSimilarTitle(title);
         theaters[numInArray].addShowing(stringMovie,times); 
      }   
   }
   
   /**
      Adds a new movie showing to a particular theater.
      @param theaterNum - the theater number that the movie showing should be added
      @param m - the movie for the showing
      @param timesString - the string with all the movie times
   */
   public void addMovieShowingToTheater(int theaterNum,Movie m, String timesString){
      theaters[theaterNum].addShowing(m,timesString);
   }
   
   /**
      Gets the number of theaters in the town
      @return the number of theaters.
   */
   public int getNumTheaters(){
      return this.numTheaters;
   }
   
   /**
      Prints all the movies that are only playing at one theater. If the movie "Cinderella" was only at 
      theater 1 and no other theaters, this method should print the movie object associated with 
      "Cinderella". If there is more than one theater playing "The Avengers: Age of Ultron", this method
      should not print the movie object associated with "The Avengers: Age of Ultron". If a movie with 
      the title "Home" was playing at no theaters, this method should not print the movie object 
      associated with "Home"
   */
   public void printMoviesThatAppearAtOneTheater(){
      int times = 0;
      Movie tempMovie = new Movie("hi",0,0);
      int numberOfMoviesToCompare = MovieList.getNumMovies();
      for(int i = 0; i<numberOfMoviesToCompare; i++){
         if(MovieList.getMovieAtIndex(i)!= null){
            tempMovie = MovieList.getMovieAtIndex(i);
            for(int j = 0; j < theaters.length; j++){
               if(theaters[j] != null){
                  boolean answer = theaters[j].isShowingMovie(tempMovie);
                  if(theaters[j].isShowingMovie(tempMovie)){
                     times = times + 1;
                  }
               }
            }
            if(times == 1){
               System.out.println(tempMovie.toString());
            }
            times = 0;
         }
      }
   }
   
   /**
      Prints the theaters and the movie showing that have a showing around a certain time. 
      The output should be formated like:
      Theater 0:
      The Avengers: Age of Ultron - 142 minutes - $19.00
         times: 8:00am, 4:00pm, 10:00pm
      @param time - the approximate time
   */
   public void printShowingAroundTime(MovieTime time){
      for(int i = 0; i < numTheaters; i++){
         System.out.println("Theater " + i + ":");
         theaters[i].printShowingAroundTime(time);
         System.out.println();
      }
   }
   
   /**
      Prints the theaters and the movie showing that have a showing that ends around a certain time.
      @param time - the approximate end time
   */
   public void printShowingThatEndAroundTime(MovieTime time){
      for(int i = 0; i < theaters.length; i++){
         System.out.println("Theater " + i + ":");
         theaters[i].printShowingThatEndsAroundTime(time);
         System.out.println();
      }     
   }
   
   /**
      Creates a string representation of a town. 
      @return the string representing a town object
   */
   public String toString(){
      String x ="";
      for(int i = 0; i < theaters.length; i++){
         x = x + "Theater " + i + ":" + "\n" + theaters[i].toString() + "\n";   
      }
      return x;
   }
}