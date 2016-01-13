public class MenuItem extends Object{

   /**The number of calories in the item.*/
   private int calories;
   /**The name of the menu item.*/
   private String name;
   /**The price of the item.*/
   private double price;
   
   /**
   Creates a new menu item given a name, price, and number of calories in that item
   @param names       name of the menu item.
   @param prices      price of the item.
   @param calorie   amount of calories in item. 
   */
   public MenuItem(String names, double prices, int calorie){
      this.name = names;
      this.price = prices;
      this.calories = calorie;
   }
   
   /**
   Gets the calorie count for the item.
   @return Amount of calories
   */
   public int getCalories(){
      return this.calories;
   }
   
   /**
   Gets the calorie count for the item.
   @return The name of the item.
   */
   public String getName(){
      return this.name;
   }
   
   /**
   Gets the price of the item.
   @return The price of the item.
   */
   public double getPrice(){
      return this.price;
   }
   
   /**
   Creates a string representation of a MenuItem, containing name, cost, and calorie count
   @return Menuitem with its name, cost, and calorie count
   */
   public String toString(){
      return (this.getName() + ": "+ "$" + this.getPrice() + " - " + this.getCalories() + " calories");
   }

}