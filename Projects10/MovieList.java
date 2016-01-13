import java.io.*;
import java.util.Scanner;
public class MovieList extends Object{

   /**The list of movies.*/
   private static Movie[] movies;
   /**The number of movies.*/
   private static int numMovies;
   
   public MovieList(){
   
   }
   
   /**
      Adds new movies to the movie list based on the movies from a file. The file will be in the format: 
      # of movies 
      M movie title, length in minutes, ticket price 
      T movie title, length in minutes, ticket price, flat fee 
      I movie title, length in minutes, ticket price, fee multiplier 
      An example: 
      T The Avengers: Age of Ultron, 142, 13.5, 5.5 
      m Cinderella, 105, 9.75 
      I Furious 7, 137, 10, 2 
      The first line in the file will be the number of movies in the file. The first character on the following lines will be 'M', 'm', 'T', 't', 'I', or 'i'. A 'M' or 'm' movies that the rest of the information on the line is associated with a Movie. A 'T' or 't'
      means the rest of the information on the line is associated with a 3D Movie. A 'I' or 'i' means the rest of the information on the line is associated with an IMAX Movie.
      @param filename - the name of the file
   */
   public static void addMovies(String filename)throws IOException{
      
      Scanner inFile = new Scanner(new FileReader(filename));
      numMovies = Integer.parseInt(inFile.nextLine());//Should get movie list number
      movies = new Movie[numMovies];
      String x = "hi";
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
            //System.out.println(name + " " + length + " " + price + " " + ThreeD);
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
         }
      }
   } 
   
   /**
      Given a particular index, it returns the movie at that index.
      @param index - the index of the array
      @return the movie object at the index
   */
   public static Movie getMovieAtIndex(int index){
      if(index>=0 && index < numMovies){
         Movie temp = (Movie) movies[index];
         return temp;
      }
      return null;
   }  
   /**
      This will find a movie that contains a similar title to the given title. This means that the title
      passed to the method has to be contained in one of the movies titles, ignoring case. For example, 
      if there was a movie called "The Avengers: Age of Ultron" and the title passed to this method was 
      "The Avengers", then this method should return the movie object associated with "The Avengers: Age
      of Ultron". If this movie list contained the movie "Cinderella" and the title passed to this method
      was "cin", then this method should return the movie object associated with "Cinderella". 
      If there are multiple movies that the title is similar to, this method just returns the first 
      one it sees. If there are no movies with a similar title, it returns null.
      @param title - the possible title of a movie
      @return the movie with a similar title to the parameter title.
   */
   public static Movie getMovieWithSimilarTitle(String title){
      String tempTitle;
      for(int i = 0; i < movies.length; i++){
         tempTitle = movies[i].getTitle();
         if(tempTitle.toLowerCase().contains(title.toLowerCase())){//should see if search word is in Title
            return movies[i];
         }
      }
      return null;
   }
   
   /**
   Gets the movie object that is associated with a particular movie title, ignoring case. 
   This method will return null if there is not movie with the given title.
   @param title - the movie title
   @return the movie with the given title   
   */
   public static Movie getMovieWithTitle(String title){
      String tempTitle;
      for(int i = 0; i < movies.length; i++){
         tempTitle = movies[i].getTitle();
         if(title.toLowerCase().equals(tempTitle.toLowerCase())){//should see if search movie is in List
            return movies[i];
         }
      }
      return null;
   }
   
   /**
      Gets the number of movies in the movie list
      @return the number of movies
   */
   public static int getNumMovies(){
      return numMovies;
   }
   
   /**Prints the movies in this list by category. 
   In other words, it prints the IMAX movies in group, the 3D movies in a group, 
   and the movies in a group. */
   public static void printMoviesByCategory(){
      IMAXMovie[] IMAX = new IMAXMovie[numMovies];
      ThreeDMovie[] ThreeD = new ThreeDMovie[numMovies];
      Movie[] Regular = new Movie[numMovies];
   
      for(int i =0; i <movies.length; i++){
         if(movies[i]instanceof Movie){
            if(movies[i] instanceof IMAXMovie){
               IMAX[i] = (IMAXMovie)movies[i];
            } 
            else if(movies[i] instanceof ThreeDMovie){
               ThreeD[i] = (ThreeDMovie)movies[i];
            }
            else{
               Regular[i] = movies[i];
            }
         }
      }
      
      System.out.println("Movies:");
      for(int i = 0; i<Regular.length; i++){
         if(Regular[i]!=(null)){
            System.out.println(Regular[i].toString());
         }
      }    
      System.out.println();
      System.out.println("3D Movies:");
      for(int i = 0; i < ThreeD.length; i++){
         if(ThreeD[i]!=(null)){
            System.out.println(ThreeD[i].toString());
         }
      }
      System.out.println();
      System.out.println("IMAX Movies:");
      for(int i = 0; i < IMAX.length; i++){
         if(IMAX[i]!=(null)){
            System.out.println(IMAX[i].toString());
         }
      }
   }
}