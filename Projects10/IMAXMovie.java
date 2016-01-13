import java.text.DecimalFormat;
public class IMAXMovie extends Movie{
   
   /**The multiplier for how many times more the movie price is.*/
   private int feeMultiplier;
   
   /**Creates a new IMAX movie based on the given title, length, price, and fee multiplier.
   @param  title - the title of the movie
   @param  length - the length of the movie in minutes
   @param  price - the price of the movie
   @param  feeMultiplier - the fee multiplier of the IMAX movie
   */
   public IMAXMovie(String title, int length, double price, int feeMultipliers){
      super(title, length, price);
      feeMultiplier = feeMultipliers;
   }
   
   /**Returns the price for an IMAX movie.
   @return the IMAX movie price
   */
   public double getPrice(){
      return super.getPrice() * feeMultiplier;
   }
   
   /*public static void main(String [] args){
      IMAXMovie test = new IMAXMovie("Age", 123,10,2);
      double testPrice = test.getPrice();
      System.out.println(testPrice);
      String testPrint = test.toString();
      System.out.println(testPrint);
   }*/
}