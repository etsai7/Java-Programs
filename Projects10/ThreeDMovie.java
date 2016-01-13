public class ThreeDMovie extends Movie{
   
   /**The flat fee for the 3D Movie.*/
   private double flatFee;
   
   /**
      Creates a new 3D movie based on the given title, length, price, and flat fee.
      @param titles - the title of the movie
      @param lengths - the length of the movie in minutes
      @param prices - the price of the movie
      @param flatFees - the flat fee of the 3D movie
   */
   public ThreeDMovie(String titles, int lengths, double prices, double flatFees){
      super(titles, lengths, prices);
      flatFee = flatFees;
   }
   
   
   /**
      Returns the price for an 3D movie. This is calculated by adding the movie price by the flat fee of the 3D movie.
      @return the 3D movie price
   */
   public double getPrice(){
      return super.getPrice() + flatFee;
   }
}