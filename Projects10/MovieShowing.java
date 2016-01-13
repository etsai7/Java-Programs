import java.util.Scanner;
import java.io.*;
public class MovieShowing implements Comparable<Object>,  MovieShowingInterface{
   
   /**The movie associated with this showing.*/
   private Movie movie;
   /**The number of showing times.*/
   private int numTimes;
   /**The movie times for the showing.*/
   private MovieTime[] times;
   
   /**Creates a new MovieShowing based on a movie and a string that contains all the showing times.
   @param movie - the movie object for this showing
   @param timesString - the string will all the showing times.
   */
   public MovieShowing(Movie movies, String timesString)/*throws IOException*/{
      
      movie = movies;
      times = new MovieTime[START_SIZE];
      Scanner inFile = new Scanner((timesString));
      int i = 0;
      while(inFile.hasNext()){
         if(times[times.length-1]!= null){
            resize();
         }
         times[i] = new MovieTime(inFile.next());
         i++;
      }
      sortMovieTimes();
   }
   
   /**
      Adds a movie time to the times array. It checks if the times array needs to be resized.
      @param time - the string representing a movie time.
   */
   private void addMovieTime(String time){
      if(times[times.length-1]!= null){
            resize();
         }
      int j = 0;
      while(times[j]!= null){
         j++;
      } 
      times[j] = new MovieTime(time); 
      this.sortMovieTimes();
   }  
   
   /**Sorts the times array by sorting the times in ascending order,
    where the earliest time is first and the latest time is last.*/
   public void sortMovieTimes(){
   
    MovieTime temp;
      for (int end = times.length-1; end > 0; end--){
         for (int i=0; i < end; i++){
            if(times[i] != null || times[i+1] != null){
               if (times[i].compareTo(times[i+1]) > 0 ) {  // swap
                  temp = times[i];
                  times[i] = times[i+1];
                  times[i+1] = temp;
               }
            }
         }
      }
   }
   
   private void resize(){
      int newLengthOfTimesArray = times.length * 2;
      MovieTime[] subMovieTime = new MovieTime[newLengthOfTimesArray];
      for(int i = 0; i < times.length; i++){
         subMovieTime[i] = times[i];
      }
      times = subMovieTime;
   } 
   
   /**
      Gets the movie associated with this movie showing.
      @return the movie
   */
   public Movie getMovie(){
      return this.movie;
   }
   
   /**
      Goes through the times and checks if there is a movie around the time passed into the method.
      A time is "around" a movie time if it is between plus or minus TIME_THRESHOLD, inclusive.
      For example, if TIME_THRESHOLD is 15 minutes and the time passed into the method is 1:30pm 
      and the movie times are 1:14pm, 1:15pm, 1:45pm, and 1:46pm; the movie times that are within 
      the TIME_THRESHOLD are 1:15pm and 1:45pm because they are within plus or minus TIME_THRESHOLD
      of the time passed into the method. 
      @param time - the approximate time
      @return true if this movie showing has a time around the given time
   */
   public boolean hasShowingAroundTime(MovieTime time){
      int i = 0;
      while(i < times.length && times[i] != null){
         int timeRange = times[i].compareTo(time);
         if(Math.abs(timeRange) <= TIME_THRESHOLD){
            return true;
         }
         i++;
      }
      return false;
   }
   
   /**
      Goes through the times and checks if there is a movie that ends around the time passed into the 
      method. A time is "around" a movie time if it is between plus or minus TIME_THRESHOLD, inclusive.
       For example, if TIME_THRESHOLD is 15 minutes and the time passed into the method is 1:30pm, the 
       movie would have to end between 1:15pm and 1:45pm inclusively for it to be and acceptable movie 
       showing.
       @param time - the approximate end time
       @return true if this movie showing has an end time around the given time
   */
   public boolean hasShowingThatEndsAroundTime(MovieTime time){
      int i = 0;
      int timeRange;
      int movieLength = movie.getLength();
      while(i < times.length && times[i] != null ){
         timeRange = time.compareTo(times[i]);
         if(Math.abs(movieLength - timeRange)  <= (TIME_THRESHOLD)){
            return true;
         }
         i++;
      }
      return false;
   }
   
   /**
      Compares a MovieShowing by comparing the Movie objects that is associated with MovieShowing object.
      This method will return -1 if o is not of type MovieShowing.
      @param o Object to compare
      @return 0 if the movies objects are the same, negative if this movie object is less than o,
      positive if this movie object is greater than o.
   */
   public int compareTo(Object o){
      if(o instanceof MovieShowing){
         MovieShowing p = (MovieShowing) o;
         if(this.movie.equals(p)){
            return 0;
         } 
         int x = this.movie.getTitle().compareToIgnoreCase(p.getMovie().getTitle());
         return x; 
      }
      return -1;
   }
   
   /**
      Creates a string representation of a movie showing object. It should be formatted like:
      The Avengers: Age of Ultron - 142 minutes - $19.00
         times: 1:30am, 2:34am, 12:00pm, 1:30pm, 2:34pm
         @return the string representing this movie showing object. 
   */
   public String toString(){
      String x = movie.toString();
      String y = "";
      for(int i = 0; i < times.length;i++){
         if(times[i]!= null){
            y = y + times[i].toString() + ", ";
         }
      }
      String z =  x + "\n" + "\t" +"times: " + y;
      String t = z.substring(0,z.length()-2);
      return t;
   }
}