//Eric Tsai
//etsai7
//600.107 Hw 7 Task 1 Receipt
import java.io.*;
import java.lang.Object;
import java.util.Scanner;

public class Receipt extends Object{

   /**The amount the user has paid for the order(stored in pennies.*/
   private int amountPaid;
   /**The bonus percentage, stored as an int, e.g..*/
   private int bonusPercent ;//THIS IS ASSUMING IT IS IN NOT %
   /**The total discount amount of the coupons (stored in pennies).*/
   private int couponsTotalDiscount;
   /**The total cost of the items (stored in pennies), not including any tax or discounts.*/
   private int itemsTotalCost;
   /**The total number of coupons.*/
   private int numCoupons;
   /**The Maryland state sales tax rate, stored as a double; this is currently six percent, or .06.*/
   private static double SALES_TAX = .06;
   /**The MoneyConverter object that converts doubles into int.*/
   private static MoneyConverter convert;
   
   /**Creates a new empty receipt with no items, no coupons, and no discount percentage.*/
   public Receipt(){
      amountPaid = 0;
      bonusPercent = 0;
      couponsTotalDiscount = 0;
      itemsTotalCost = 0;
      numCoupons = 0;
   }
   
   /**
      Creates a new receipt based on data in the file specified by filename.
      @param filename   name of the file that will contain the information for the receipt.
   */
   public Receipt (String filename) throws IOException{
      Scanner inFile = new Scanner(new FileReader(filename));
      convert = new MoneyConverter();
      String letterPair = "";
      while(inFile.hasNext()){
         letterPair = inFile.next();
         if(letterPair.charAt(0) == 'I' || letterPair.charAt(0) == 'i'){//adds item price
            //int priceToAdd = convert.getPennies(Double.parseDouble(letterPair.substring(1)));
            int priceToAdd = convert.getPennies(inFile.nextDouble());
            boolean newPrice = this.addItem(priceToAdd);
         }
         else if(letterPair.charAt(0) == 'C' || letterPair.charAt(0) == 'c'){
            //int couponToAdd = convert.getPennies(Double.parseDouble(letterPair.substring(1)));
            int couponToAdd = convert.getPennies(inFile.nextDouble());
            boolean newCoupon = this.addCoupon(couponToAdd);
         }
         else if(letterPair.charAt(0) == 'B' || letterPair.charAt(0) == 'b'){
            //int bonusToChange = convert.getPennies(Double.parseDouble(letterPair.substring(1)));
            int bonusToChange = inFile.nextInt();
            boolean newBonus = this.setBonusPercentage(bonusToChange);
         }     
      }
   }
 //Methods-------------------------------------------------------------------------  
   /**Adds an amount (represented in pennies) to the total paid by the user so far.  
   @param amountInPennies  The amount being paid
   @return        True if the amount was paid, false if it was not
   */
   public boolean addAmountPaid(int amountInPennies){
      if(amountInPennies > 0){
         amountPaid = amountPaid + amountInPennies;
         return true;
      }
      return false;
   }
   
   /**Adds a new coupon by increasing the total coupon discount and increasing the number of coupons. A  
   coupon may be only added if its discount amount is greater than 0, and less than or equal to the pre-
   tax subtotal thus far, including all other successfully-added coupons and any bonus percentage.
   @param couponDiscount   The discount of the coupon to add
   @return                 True if he coupon was added, false if it was not   
   */
   public boolean addCoupon(int couponDiscountInPennies){
      if(couponDiscountInPennies > 0 && couponDiscountInPennies <= getSubtotalBeforeTax()){
         couponsTotalDiscount = couponsTotalDiscount + couponDiscountInPennies;
         numCoupons++;
         return true;
      }
      return false;
   }
   
   
   /**Adds a new item by increasing the items total cost.
      @param itemPrice  The price of the item to add.
      @return           True if the item was added, false if it was not
   */
   public boolean addItem(int itemPriceInPennies){
      if(itemPriceInPennies > 0){
         itemsTotalCost = itemsTotalCost + itemPriceInPennies;
         return true;
      }
      return false;
   }
   

   /**Sets the bonus percentage of the order. A bonus is set when it is greater than the current bonus, the 
      bonus is greater than or equal to zero, and the bonus is less than or equal to 100;
      @param bonus   the value of the bonus percentage
      @return        true if the bonus was set, false if it was not
   */
   public boolean setBonusPercentage(int bonus){//THIS IS ASSUMING BONUS IS NOT A %
      if(bonus > bonusPercent && bonus >= 0 && bonus <= 100){
         bonusPercent = bonus;
         return true;
      } 
      return false;
   }
   
   /**Removes an item by decreasing the number of items and decreasing the total item cost by the item
   price. An item can be removed only if the total costof the items is greater than or equal the given price
   after it is removed (or, in other words, the total item cost will not be negative once the item is
   removed). There is no attempt to verify whether anitem added earlier had exactly the given price.
   @param itemPrice  The price of the item to remove
   @return           true if the item was removed, false if it was not
   */
   public boolean removeItem(int itemPriceInPennies){
      if(itemsTotalCost - itemPriceInPennies >= 0){
         itemsTotalCost = itemsTotalCost - itemPriceInPennies;
         return true;
      }
      return false;
   }
   
   /**Gets the order subtotal (net cost, stored in pennies) before tax is applied. The order subtotal is
   calculated by first subtracting the coupon discount from the total cost of all items, and then reducing
   that amount by the bonus percentage, and finally rounding the resulting value to the nearest int.
   (Note that rounding to the nearest int is not the same as truncating the double value!)
   @return  The subtotal (net cost) of the order before tax
   */
   public int getSubtotalBeforeTax(){
      int costWithCoupons = (itemsTotalCost - couponsTotalDiscount);
      int bonusPercentage = (int) (costWithCoupons*(1.0 - (bonusPercent / 100.0))+.5);
      return bonusPercentage;
   }
   
   /**Computes the tax for the order, represented in pennies. The tax is typically computed by taking the
   subtotal before tax and multiplying it by the state tax rate for Maryland, then rounding the resulting
   amount to the nearest int. (Note that rounding to the nearest int is not the same as truncating the
   double value!) However, if the subtotal is negative, the tax amount returned should be zero.
   @return The amount of tax for the order
   */
   public int getTax(){
      int preTaxy = getSubtotalBeforeTax();
      double tax1 = (double)this.getSubtotalBeforeTax()*.06; 
      int tax2 = (int) (tax1 + .5);
      int taxed = convert.getPennies(tax1);
      if(tax2 >= 0){
         return tax2;
      }
      else{
         return 0;
      }
   }  
   
   /**Computes the total cost of the order after tax by adding the subtotal before tax and the tax for the
   order. The cost is represented in pennies.   
   @return  Total cost of the order with tax
   */
   public int getTotalCostAfterTax(){
      return getSubtotalBeforeTax() + getTax();
   }
   
   
   /**Gets the amount of money (in pennies) still owed for the order. This is calculated by deducting the
   amount already paid by the user from the total cost after tax.   @return The amount owed for this order
   */
   public int getAmountOwed(){
      return getTotalCostAfterTax() - amountPaid;
   }
   
   /**Prints the receipt for the order. All values of money should be printed to two decimal places. And
   any values of percent should be printed to 1 decimal place. 
   */
   public void printReceipt(){
   System.out.println("Cost of items: " + " " + (convert.getStringFromPennies(itemsTotalCost)));
   System.out.println("Coupons: " + "       " + numCoupons);
   System.out.println("Coupon savings: " + (convert.getStringFromPennies(couponsTotalDiscount)));
   System.out.println("Bonus discount: " + bonusPercent+"%");
   System.out.println("Subtotal: " + "      " + (convert.getStringFromPennies(getSubtotalBeforeTax())));
   System.out.println("Tax: " + "           " + (convert.getStringFromPennies(getTax())));
   System.out.println("Total owed: " + "    " + (convert.getStringFromPennies(getTotalCostAfterTax())) + "\n");
   }
}