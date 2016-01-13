import java.util.Scanner;

/**
 * Intro to Java (600.107) - Spring 2015 - HW8
 *
 * @author Katie Calabro - kcalabr1@jhu.edu
 *
 */
public class Restaurant {

	/** The menu for the restaurant. */
	private static Menu menu;
	/** Scanner for user input. */
	private static Scanner kb;


	/**
	 * Main method that creates a menu and asks user for input from the menu of
	 * choices.
	 *
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		kb = new Scanner(System.in);
		menu = new Menu();

        //Repeatedly collect choices and interpret them, until user asks to quit
		int choice = 0;
		do {
			printMenu();
			choice = kb.nextInt();
			interpretChoice(choice);
			System.out.println();
		} while (choice != 0);
	}


	/**
	 * Prints the menu of options that the user can choose from. <br>
	 * 0) Quit <br>
	 * 1) Add item <br>
	 * 2) Remove item <br>
	 * 3) Print items in a calorie range<br>
	 * 4) Print items under a certain price<br>
	 * 5) Print the most expensive item<br>
	 * 6) Print the item with the fewest calories<br>
	 * 7) Print the entire menu<br>
	 * Choice -&gt; 
	 */
	private static void printMenu() {
		System.out.println("0) Quit");
		System.out.println("1) Add item");
		System.out.println("2) Remove item");
		System.out.println("3) Print items in a calorie range");
		System.out.println("4) Print items under a certain price");
		System.out.println("5) Print the most expensive item");
		System.out.println("6) Print the item with the fewest calories");
		System.out.println("7) Print the entire menu");
		System.out.print("Choice -> ");
	}


	/**
	 * Performs different operations based on the user's input from the menu,
	 * validating input in many cases.
	 *
	 * @param choice
	 *            the user's choice from the menu.
	 */
	private static void interpretChoice(int choice) {

		String name = "";
		double price = 0;

		switch (choice) {
		case 0: // quit
			System.out.println("Goodbye.");
			break;
            
		case 1: // ADD AN ITEM
        
			// skip over the newline character left over from choice number
			kb.nextLine();
            
			// get the name of the item
			// the length of the name has to be > 0
			do {
				System.out.print("Enter the name of the item -> ");
				name = kb.nextLine();
			} while (name.length() == 0);

			// get the price of the item
			// the price must be positive
			do {
				System.out.print("Enter the price of the item -> ");
				price = kb.nextDouble();
			} while (price <= 0);

			// get the calories from the user
			// the calories must be nonnegative
			int calories = 0;
			do {
				System.out.print("Enter number of calories for the item -> ");
				calories = kb.nextInt();
			} while (calories < 0);

			// add the item to the menu, if it does not already exist
			MenuItem conflictingItem = menu.addItem(name, price, calories);
            if (conflictingItem == null)
                System.out.println("Item added successfully.");
            else 
                System.out.println("Couldn't add new item " + name + "\n" +
                    "due to the following existing menu item: \n" + conflictingItem);
			break;


		case 2: // REMOVE AN ITEM

			// skip over the newline character left over from choice number
			kb.nextLine();
            
			// get the name of the item
			// the length of the name has to be > 0
			do {
				System.out.print("Enter the name of the item -> ");
				name = kb.nextLine();
			} while (name.length() == 0);

            // remove the item
 			MenuItem removedItem = menu.removeItem(name);
            // report result
            if (removedItem != null)
                System.out.println("The following item was removed:\n" + removedItem);
            else
                System.out.println("That item was not present on the menu.");
            break;
            
           
		case 3: // PRINT ITEMS IN A SPECIFIED CALORIE RANGE
                
			// get the min range from the user
			// the min value must be nonnegative
			int min = 0;
			do {
				System.out.print("Enter min value -> ");
				min = kb.nextInt();
			} while (min < 0);

			// get the max range from the user
			// the max value has to be positive && also greater than the min
			int max = 0;
			do {
				System.out.print("Enter max value -> ");
				max = kb.nextInt();
			} while (max <= 0 || max < min);

			// print all the items in that range, including those that match max and min
			menu.printItemsInCalorieRange(min, max);
			break;
            
            
		case 4: // PRINT ALL ITEMS COSTING LESS THAN A GIVEN PRICE

			// get the price from the user
			// the price has to be positive
			do {
				System.out.print("Enter price -> ");
				price = kb.nextDouble();
			} while (price <= 0);

			// print the items under this price
			menu.printItemsUnderPrice(price);
			break;
            
            
		case 5: // PRINT MOST EXPENSIVE ITEM ON MENU

			MenuItem maxItem = menu.getMostExpensiveItem();
			if (maxItem == null) {
				System.out.println("There are no items in the menu");
			} else {
				System.out.println(maxItem);
			}
			break;


		case 6: // PRINT ITEM WITH FEWEST CALORIES
        
			MenuItem minItem = menu.getItemWithFewestCalories();
			if (minItem == null) {
				System.out.println("There are no items in the menu");
			} else {
				System.out.println(minItem);
			}
			break;


		case 7: // PRINT ENTIRE MENU
        
			menu.printMenu();
			break;
            
            
		default: // INVALID CHOICE
			System.out.println("Invalid choice");
			break;
		}
	}

}
