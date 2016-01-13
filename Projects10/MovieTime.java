import java.text.DecimalFormat;

/**
 * Intro to Java (600.107) - Spring 2015 - HW10
 *
 * @author Katie Calabro - kcalabr1@jhu.edu
 *
 */
public class MovieTime implements Comparable<Object> {

	/** Minutes in military time. [0,59] */
	private int minutes;
	/** Hours in military time. [0,23] */
	private int hours;
	/** The formater to format the time with two zeros. */
	private static final DecimalFormat FORMATTER = new DecimalFormat("00");

	/**
	 * Creates a new MovieTime object based on a particular string. The string
	 * is assumed to have the format: <br>
	 * 1:30pm or 12:00am or 4:44pm
	 *
	 * @param time
	 *            the string with the time
	 */
	public MovieTime(String time) {
		this.hours = Integer.parseInt(time.substring(0, time.indexOf(':')));
		this.minutes =
				Integer.parseInt(time.substring(time.indexOf(':') + 1, time.indexOf(':') + 3));
		char meridiem = time.substring(time.indexOf(':') + 3).charAt(0);

		if (meridiem == 'p' && this.hours != 12) {
			this.hours += 12;
		} else if (meridiem == 'a' && this.hours == 12) {
			this.hours = 0;
		}
	}

	/**
	 * Checks if two MovieTime objects are equal by comparing the hours and
	 * minutes of this time and o's time.
	 *
	 * @return true if the times are equal, false if they are not
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof MovieTime) {
			MovieTime m = (MovieTime) o;
			return this.hours == m.hours && this.minutes == m.minutes;
		}
		return false;
	}

	/**
	 * Compares two MovieTimes by comparing there times. It returns the
	 * difference between the number of minutes for this time and o's time. If
	 * this time is later, it will return a positive number of minutes. If o's
	 * time is later, it will return a negative number of minutes.
	 *
	 * @param o
	 *            the object being compared
	 * @return the number of minute that differ between the objects being
	 *         compared
	 */
	@Override
	public int compareTo(Object o) {
		if (o instanceof MovieTime) {
			MovieTime m = (MovieTime) o;
			return (this.hours - m.hours) * 60 + (this.minutes - m.minutes);
		}
		return -1;
	}

	/**
	 * Creates a string representation of a MovieTime object. The string will be
	 * in the following format:<br>
	 * 1:30pm or 12:00am or 4:44pm
	 *
	 * @return the string representing a MovieTime object
	 */
	@Override
	public String toString() {
		String meridiem = this.hours < 12 ? "am" : "pm";
		int newHours = this.hours == 0 ? 12 : (this.hours % 12);
		if (this.hours == 12) {
			newHours = 12;
		}
		return newHours + ":" + FORMATTER.format(this.minutes) + meridiem;
	}

}
