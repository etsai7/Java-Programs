
public class Lot{
   /** The object that is located at a specific Parking slot*/
   private String lotObject;
   /**The position x (columns) the object is in*/
   private int xCoord;
   /**The position y (rows) the object is in*/
   private int yCoord;
   
   /**Creates a parking lot object, indicating what type it is
   @param typeOfObject  Indicates if it is a user, car, boundary, space, or travelled path
   */
   public Lot(String typeOfObject, int x, int y){
      lotObject = typeOfObject;
      xCoord = x;
      yCoord = y;
   }
   /**
   Gets the Name/Symbol of the Object
   @return lotObject The name of the Object
   */
   public String getName(){
      return lotObject;
   }
   /**
   Gets the X coordinate of the Object
   @return xCoord The X coord of the Object
   */
   public int getXCoord(){
      return xCoord;
   }
   /**
   Gets the Y coordinate of the Object
   @return yCoord The Y coord of the Object
   */
   public int getYCoord(){
      return yCoord;
   }
}