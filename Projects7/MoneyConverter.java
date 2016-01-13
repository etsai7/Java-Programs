import java.text.DecimalFormat;

/**
 * Intro to Java (600.107) - Spring 2015 - HW7 <b>REVISED SAT 2PM</b>
 *
 * @author Katie Calabro - kcalabr1@jhu.edu
 *
 */
public class MoneyConverter {

	/** Formats cents so that is has exactly two decimal places. */
	private static final DecimalFormat FORMATTER = new DecimalFormat("00");
	/** Cent value of a twenty-dollar bill. */
	public static final int TWENTY_DOLLARS = 2000;
	/** Cent value of a ten-dollar bill. */
	public static final int TEN_DOLLARS = 1000;
	/** Cent value of a five-dollar bill. */
	public static final int FIVE_DOLLARS = 500;
	/** Cent value of a one-dollar bill. */
	public static final int ONE_DOLLAR = 100;
	/** Cent value of a quarter. */
	public static final int QUARTER = 25;
	/** Cent value of a dime. */
	public static final int DIME = 10;
	/** Cent value of a nickel. */
	public static final int NICKEL = 5;
	/** Cent value of a penny. */
	public static final int PENNY = 1;


    /**
     *  Given a double representing a monetary amount, converts this 
     *  amount to an integer number of cents for convenient
     *  internal storage.  Any double amount with more than two
     *  decimal places is considered invalid, and so is converted
     *  to a negative value.
     *  
     *  @param price
     *      the monetary amount in double format
     *  @return
     *      an equivalent monetary amount in cents, or -1 if the
     *          original amount contains more than two decimal places
     */
	public static int getPennies(double price) {
		String priceStr = Double.toString(price);
		// a double will always have a decimal point
		int dotIndex = priceStr.indexOf('.');
		String cents = priceStr.substring(dotIndex + 1);
		if (cents.length() > 2) {
			return -1;
		}
		return (int) Math.round(price * 100);
	}

    /**
     *  Given an integer amount of cents, returns the same
     *  amount represented in dollars as a String. The String
     *  representation contains exactly two decimal places,
     *  and begins with a dollar sign.
     *
     *  @param pennies
     *      the monetary amount in cents
     *  @return
     *      a String representation of the amount in dollars
     */
	public static String getStringFromPennies(int pennies) {
		int dollars = pennies / 100;
		int cents = pennies % 100;
		return "$" + dollars + "." + FORMATTER.format(cents);
	}

}
