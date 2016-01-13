import java.text.DecimalFormat;
public class Movie extends Object implements Comparable<Object>{
   /**The length of the movie in minutes.*/
   private int length;
   /**The price of the movie.*/
   private double price;
   /**The title of the movie.*/
   private String title;
   
   /**Creates a new movie based on a given title, length in minutes, and price.
   @param title - the title of the movie
   @param length - length of the movie in minutes
   @param price - price of the movie
   */
   public Movie(String titles, int lengths, double prices){
      length = lengths;
      price = prices;
      title = titles;
   }
   /**
      Compares a Movie based on comparing the Movie's title (ignoring case).
      @param o    The object being compared
      @return  0 if the titles of the movies are the same. -1 if they are not
   */
   public int compareTo(Object o){
      if(o instanceof Movie){
         Movie p = (Movie) o;
         if(p.getTitle().toLowerCase().equals(this.getTitle().toLowerCase())){
            return 0;
         } 
         int x = this.getTitle().compareToIgnoreCase(p.getTitle());
         return x; 
      }
      Movie obj = (Movie) o;
      int x = this.getTitle().compareToIgnoreCase(obj.getTitle());
      return x;
   }
   
   /**
      Returns the length of a Movie.
      @return  returns the length of this movie
   */
   public int getLength(){
      return this.length;
   }
   
   /**
      Returns the Price of a Movie.
      @return  returns the price of this movie
   */
   public double getPrice(){
      return this.price;
   }  
   
   /**
      Returns the title of a Movie.
      @return  returns the title of this movie
   */
   public String getTitle(){
      return this.title;
   }
   
   /**
      Creates a string representation of a Movie object in the following format: 
      The Avengers: Age of Ultron - 142 minutes - $19.00
      @return  the formatted string above
   */
   public String toString(){
      DecimalFormat decim = new DecimalFormat("#.00");
      String s = decim.format(this.getPrice());
      String x = title + " - " + length + " minutes" + " - $" + s; 
      return x;
   }
    
   /*public static void main(String [] args){
      Movie test = new Movie("Age of Ultron", 148, 19.034);
      System.out.println(test.toString());
      Movie test2 = new Movie("AGE OF ULTRON" , 293, 12);
      int x = test.compareTo(test2);
      System.out.println(x);
   }*/


}