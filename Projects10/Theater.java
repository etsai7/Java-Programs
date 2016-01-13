import java.io.*;
import java.util.Scanner;
public class Theater extends Object implements TheaterInterface{
   /**The number of movie showings.*/
   private int numShowings;
   /**The movie showings for the theater.*/
   private MovieShowing[] showings;
   
   /**Creates a new theater by initializing the showings array with the START_SIZE.*/
   public Theater(){
      showings = new MovieShowing[START_SIZE];
   }
   
   /**Adds a movie showing to the the showings array. It first checks if the array needs to be resized. 
   Then it adds the a new move showing object to the array. It then sorts the array so that the movie 
   showing are in alphabetical order according to movie showing's movie title.
   @param - the movie for the new MovieShowing object
   @param timesString - the string that contains all the movie showing times.
   */
   public void addShowing(Movie m, String timesString){
      MovieShowing newMovieShowing = new MovieShowing(m,timesString);
      if(showings[showings.length-1]!= null){
         resize();
      }
      int i = 0;
      while(showings[i] != null){
         i++;
      }
      showings[i] = newMovieShowing;
      this.sortMovieShowings();
   }
   
   /**Resizes the showings array by doubling the current size of the array.*/
   public void resize(){
      int newLengthOfTimesArray = showings.length * 2;
      MovieShowing[] subMovieShowing = new MovieShowing[newLengthOfTimesArray];
      for(int i = 0; i < showings.length; i++){
         subMovieShowing[i] = showings[i];
      }
      showings = subMovieShowing;
   }
   
   /**Sorts the times array by sorting the movie showings in alphabetical 
   order according to the movie title of the movie showing.
   */
   public void sortMovieShowings(){
      MovieShowing smallest;
      MovieShowing tempSwitch;
      MovieShowing tempSmallest;
      int j = 0;
      for(int i = 0; i < showings.length-1; i++){
         smallest = showings[i];
         j = i + 1;
         while(j < showings.length && showings[j]!= null ){
            int timeComparison = smallest.getMovie().getTitle().compareTo(showings[j].getMovie().getTitle());
            if(timeComparison > 0 ){
               tempSmallest = showings[j];
               tempSwitch = showings[i];
               showings[i] = tempSmallest;
               showings[j] = tempSwitch;
            }
            j++;
         }
         j = 0;         
      }
   }
   
   /**
      Checks if any of the movie showings is showing a particular movie
      @param m - the movie object
      @return true if there is a movie showing at this theater showing m, false if not
   */
   public boolean isShowingMovie(Movie m){
      int i = 0;
      while(i < showings.length && showings[i]!=null){
         if(showings[i].getMovie().equals(m)){
            return true;
         }
         i++;
      }
      return false;
   }
   
   /**Prints the movie showing if it has a showing time around the time passed into the method. 
   The formatting of the printing should be: 
      Cinderella - 105 minutes - $9.75
         times: 8:30am, 11:00am, 12:00pm, 11:30pm
      @param time - the approximate time
   */
   public void printShowingAroundTime(MovieTime time){
      int i = 0;
      while(i < showings.length && showings[i]!= null){
         boolean hasShowingAroundTime = showings[i].hasShowingAroundTime(time);
         if(hasShowingAroundTime){
            System.out.println(showings[i].toString());
         }
         i++;
      } 
   }
   
   /**Prints the movie showing if it has a showing time that ends around the time passed into the method. 
      The formatting of the printing should be: 
      Cinderella - 105 minutes - $9.75
         times: 8:30am, 11:00am, 12:00pm, 11:30pm
      @param time - the approximate end time
   */
   public void printShowingThatEndsAroundTime(MovieTime time){
       int i = 0;
       while(i < showings.length && showings[i]!= null){
         boolean hasShowingEndTime = showings[i].hasShowingThatEndsAroundTime(time);
         if(hasShowingEndTime){
            System.out.println(showings[i].toString());
         }
         i++;
      } 
   }
   
   /**
      Creates a string representation of a theater object. 
      @return the string for this theater object
   */
   public String toString(){
      String x = "";
      for(int i = 0 ; i < showings.length; i++){
         if(showings[i] != null){
            x = x + showings[i].toString() + "\n";
         }
      }
      return x;
   }
}