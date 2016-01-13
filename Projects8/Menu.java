import java.util.Arrays;
public class Menu{
   
   /**The list of menu items for the restaurant*/
   private MenuItem[] menuItems;
   /**The number of items in the menu.*/
   private int numMenuItems;
   /**The starting size of the array, set to the value 5.*/
   private static int START_SIZE = 5;
   
   /**
   Creates a new empty Menu by initializing the menuItems reference with an array of MenuItems of
   size START_SIZE, and setting numMenuItems appropriately.
   */
   public Menu(){
      menuItems = new MenuItem[START_SIZE];
      numMenuItems = menuItems.length;
   }
   
   /**
   Adds a new item to the menu, if the new item does not have the same name.
   @param name       name of the item
   @param price      price of the item
   @param calories   calories of item
   return            An MenuItem Object
   */
   public MenuItem addItem(String name, double price, int calories){      
      MenuItem menuItemInput = new MenuItem(name, price, calories);
      if(menuItems[menuItems.length-1] != null){
         this.resize();
      }
      for(int i = 0; i < menuItems.length;i++){
         if(!this.containsItem(name) && menuItems[i] == null){
            menuItems[i] = menuItemInput;
            numMenuItems++;
            return null;
         }
         if(this.containsItem(name) && menuItems[i] != null && name.toLowerCase().equals(menuItems[i].getName().toLowerCase())){
            menuItemInput  = menuItems[i];
         }
      }
      return menuItemInput;
   }
   
   /**
   Checks if the menu already contains an item containing the same name, ignoring case.
   @param name    name of the item if it in the MenuList array
   @return        true if there is an object with same name
   */
   public boolean containsItem(String name){
      if(menuItems[0] == null){
         return false;
      }
      int j = 0;
      while(menuItems[j] != null && j < menuItems.length){
         if((name.toLowerCase()).equals((menuItems[j].getName()).toLowerCase())){
            return true;
         }
         j++;
      }
      return false;
   }
   
   /**
   Returns the menu item with the fewest calories
   @return  The Object MenuItem with smallest calories.
   */
   public MenuItem getItemWithFewestCalories(){
      if(menuItems[0]==null){
         return null;
      }
      
      if(menuItems[1] == null){
         return menuItems[0];
      }
      
      int positionLowestSoFar = 0;//Initially the first position
      int highestCalorieSoFar = menuItems[0].getCalories();
      int comparison; 
      
      
      int j = 1;
      while(menuItems[j]!=null && j < menuItems.length){
         comparison = menuItems[j].getCalories();
         if(comparison<highestCalorieSoFar){
            highestCalorieSoFar = comparison;
            positionLowestSoFar = j;
         }
         j++;
      }
      return menuItems[positionLowestSoFar];
   }
   
   /**
   Returns the most expensive item on the menu
   @return  Returns the most expensive item
   */
   public MenuItem getMostExpensiveItem(){
   
      if(menuItems[0] == null){
         return null;
      }
      int positionHighestSoFar = 0;//Initially the first position
      double highestPriceSoFar = menuItems[0].getPrice();
      double priceComparison;
      
      int j =1;
      while(menuItems[j]!=null && j < menuItems.length){
         priceComparison = menuItems[j].getPrice();
         if(priceComparison>highestPriceSoFar){
            highestPriceSoFar = priceComparison;
            positionHighestSoFar = j;
         }
         j++;
      }
      return menuItems[positionHighestSoFar];
   }
   
   /**
   Prints all the items on the menu that are in the calorie range [min,max] (inclusive)
   @param min  minimum
   @param max  maximum
   */
   public void printItemsInCalorieRange(int min, int max){
      if(menuItems[0] == null){
      
      }
      else{
         int j = 0;
         while(menuItems[j]!= null && j < menuItems.length){
            if(menuItems[j].getCalories() <= max && menuItems[j].getCalories() >= min){
               System.out.println(menuItems[j].toString());
            }
            j++;
         }   
      }
   }  
   
   /**
   Prints the menu items strictly less than the specified price
   @param price   The price that determines maximum price
   */
   public void printItemsUnderPrice(double price){
      if(menuItems[0] == null){
      }
      else{
         int j = 0;
         double priceBelow;
         while(menuItems[j]!= null && j<menuItems.length){
            priceBelow = menuItems[j].getPrice();
            if(priceBelow < price){
               System.out.println(menuItems[j].toString());
            }
            j++;
         }
      }
   }
   
   /**
   Prints all the items in the menu
   */
   public void printMenu(){
      if(menuItems[0]==(null)){
         System.out.println("No Items on the Menu!");
      }
      for(int i = 0; i < menuItems.length;i++){
         if(!(menuItems[i]==null)){ 
            System.out.println(menuItems[i].toString());
         }
      }
   }
   
   /**
   Given an item's name, removes that item from the menu, if it exists
   @param name name of the item to be removed
   */
    public MenuItem removeItem(String name){
      if(menuItems[0] == null){
         return null;
      }
      
         int j = 0;
         boolean containsThatItem;
         while(menuItems[j] != null && j<menuItems.length){
            containsThatItem = containsItem(name);
            if(containsThatItem){
               int indexOfRepeat = 0;;
               int x = 0;
               while(menuItems[x] != null && x < menuItems.length){
                  
                     if(name.equals(menuItems[x].getName())){
                        indexOfRepeat = x;
                     }
                  x++;
               }
               MenuItem thingRemoved = new MenuItem(menuItems[indexOfRepeat].getName(),menuItems[indexOfRepeat].getPrice(),menuItems[indexOfRepeat].getCalories());
               for(int i = indexOfRepeat;i<menuItems.length-1;i++){
                  menuItems[i] = menuItems[i+1];
               }
               menuItems[menuItems.length-1] = null;
               numMenuItems--;
               return thingRemoved;
            }
            j++;
         return null;
      }
      return null;
    } 
    
    /**
    Resizes the array to double its size so that more items can be added to the menu.
    */ 
    private void resize(){
      int newLengthOfItemsArray = menuItems.length * 2;
      MenuItem[] subMenuItems1 = new MenuItem[newLengthOfItemsArray];
      for(int i = 0; i < menuItems.length; i++){
         subMenuItems1[i] = new MenuItem(menuItems[i].getName(),menuItems[i].getPrice(),menuItems[i].getCalories());
      }//Storing current menuItems into a new array to be copied over
      for( int i =0; i<subMenuItems1.length;i++){
         menuItems[i] = subMenuItems1[i];
      }
    } 
}