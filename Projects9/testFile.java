import java.util.Scanner;
import java.io.*;

public class testFile{
   /**The Parking Lot in Double Array Format*/
   private static Lot[][] spots;
   /**The current X position of the User Car*/
   private static int currentPositionX;
   /**The current Y position of the User Car*/
   private static int currentPositionY;
   /**The amount of rows in this parking lot*/
   private static int rows;
   /**The amount of columns in thie parking lot*/
   private static int columns;
   /**The user Car*/
   private static Lot user;
   /**Amount of moves actually made so far*/
   private static int numMoves;
   
   /**
	 * Main method that creates a parking lot and asks user for input to move the User's Car.
	 * 
	 *
	 * @param args
	 *            command line arguments
	 */
   public static void main(String [] args) throws IOException{
      Scanner kb = new Scanner(System.in);
      
      System.out.println("Drive: Parking Lot Navigation!  :)");
      System.out.println("This game requires the name of a text file describing the lot.");
      System.out.print("Enter filename ->: "); 
      String filename = kb.next();
      System.out.println("Your car will be represented by a U on the lot.  Your goal is to get your car down to");
      System.out.println("the bottom row.For the rest of the game, use the following keys to navigate your car:");
      System.out.println("w or W: move up");
      System.out.println("s or S: move down");
      System.out.println("a or A: move left");
      System.out.println("d or D: move right");
      System.out.println();
      System.out.println("Here we go...");

      Scanner inFile = new Scanner(new FileReader(filename));
      rows = inFile.nextInt();
      columns = inFile.nextInt();
      spots = new Lot[rows][columns];
      System.out.println(inFile.nextLine() +"This is part one");
      
      String inputLine;
//--------------------------------------------------------------------
//Initializes the initial Parking lot            
      for(int i = 0; i < rows; i++){        
         inputLine = inFile.nextLine();
         for(int j = 0; j < columns; j++){
               spots[i][j] = new Lot(inputLine.substring(j,j+1),j,i);
         }
      }
//--------------------------------------------------------------------
      getUserPosition();//tells us the place the user is at/sets the coordinates
      
      while(!spots[rows-1][currentPositionX].getName().equals("U")){
         printMap();
         System.out.println("User is at x: " + currentPositionX + "y: " + currentPositionY);
         System.out.print("direction (w/s/a/d) -> ");//This is going to be case sensitive
         String move = kb.nextLine();
         while(!(move.equals("w") || move.equals("s") || move.equals("a") || move.equals("d"))){
            System.out.print("direction (w/s/a/d) -> "); 
            move = kb.nextLine();
         }
         boolean movement = canMove(move);
         System.out.println(movement);
         if(movement){
            makeTheMove(move);
         }
         getUserPosition();//Updates user location
      }
      printMap();
      System.out.println("You made it in " + numMoves + " moves!");
      inFile.close();
            
   }
   /**Prints the current Parking Lot*/
   public static void printMap(){
      for(int i =0; i < rows;i++){
         for(int j = 0; j < columns; j++){
            System.out.print(spots[i][j].getName());
         }
         System.out.println();
      }
   }
   
   /**Says if the User can make the next move
   @param String move   the user's next hopeful movement
   @return true or false if the user can make the next move
   */
   public static boolean canMove(String move){
      if(move.equals("w")){    
         if(spots[currentPositionY-1][currentPositionX].getName().equals(" ") || spots[currentPositionY-1][currentPositionX].getName().equals(".")){
            return true;
         }
      }
      if(move.equals("a")){
         if(spots[currentPositionY][currentPositionX-1].getName().equals(" ") || spots[currentPositionY-1][currentPositionX].getName().equals(".")){
            return true;
         }
      }
      if(move.equals("s")){
         if(spots[currentPositionY+1][currentPositionX].getName().equals(" ") || spots[currentPositionY-1][currentPositionX].getName().equals(".")){
            return true;
         }
      }
      if(move.equals("d")){
         if(spots[currentPositionY][currentPositionX+1].getName().equals(" ") || spots[currentPositionY-1][currentPositionX].getName().equals(".")){
            return true;
         }
      }
      return false;
   }
   
   /**Updates the map after the user moves the his/her car
   @param movement   Where the user wants to move 
   */
   public static void makeTheMove(String movement){
      if(movement.equals("w")){
         spots[currentPositionY-1][currentPositionX] = new Lot("U",currentPositionX,currentPositionY-1);
         spots[currentPositionY][currentPositionX] = new Lot(".",currentPositionX,currentPositionY);
         numMoves++;
      }
      if(movement.equals("a")){
         spots[currentPositionY][currentPositionX-1] = new Lot("U",currentPositionX,currentPositionY-1);
         spots[currentPositionY][currentPositionX] = new Lot(".",currentPositionX,currentPositionY);
         numMoves++;
      }
      if(movement.equals("s")){
         spots[currentPositionY+1][currentPositionX] = new Lot("U",currentPositionX,currentPositionY-1);
         spots[currentPositionY][currentPositionX] = new Lot(".",currentPositionX,currentPositionY);
         numMoves++;
      }
      if(movement.equals("d")){
         spots[currentPositionY][currentPositionX+1] = new Lot("U",currentPositionX,currentPositionY-1);
         spots[currentPositionY][currentPositionX] = new Lot(".",currentPositionX,currentPositionY);
         numMoves++;
      }
   }
   
   /**Finds the user's coordinate location and sets the instance variables*/
   public static void getUserPosition(){
      user = new Lot("x",0,0);
      for(int i = 0; i < rows; i++){        
         for(int j = 0; j < columns; j++){
            if(spots[i][j].getName().equals("U")){
               user =  spots[i][j];
               currentPositionX = j;//Columns are x coordinates
               currentPositionY = i;//Rows are y coordinates
            }
         }
      }
   }

}