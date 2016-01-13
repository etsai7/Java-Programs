

public interface TownInterface {

	/**
	 * Adds a new movie showing to a particular theater.
	 *
	 * @param theaterNum
	 *            the theater number that the movie showing should be added
	 * @param m
	 *            the movie for the showing
	 * @param timesString
	 *            the string with all the movie times
	 */
	public void addMovieShowingToTheater(int theaterNum, Movie m, String timesString);

	/**
	 * Gets the number of theaters in the town
	 *
	 * @return the number of theaters.
	 */
	public int getNumTheaters();

	/**
	 * Prints all the movies that are only playing at one theater. If the movie
	 * "Cinderella" was only at theater 1 and no other theaters, this method
	 * should print the movie object associated with "Cinderella". If there is
	 * more than one theater playing "The Avengers: Age of Ultron", this method
	 * should not print the movie object associated with
	 * "The Avengers: Age of Ultron". If a movie with the title "Home" was
	 * playing at no theaters, this method should not print the movie object
	 * associated with "Home"
	 */
	public void printMoviesThatAppearAtOneTheater();

	/**
	 * Prints the theaters and the movie showing that have a showing around a
	 * certain time. The output should be formated like:<br>
	 * Theater 0:<br>
	 * The Avengers: Age of Ultron - 142 minutes - $19.00<br>
	 * &nbsp;times: 8:00am, 4:00pm, 10:00pm<br>
	 * <br>
	 * Theater 1:<br>
	 * Cinderella - 105 minutes - $9.75<br>
	 * &nbsp;times: 8:30am, 11:00am, 12:00pm, 11:30pm<br>
	 *
	 * @param time
	 *            the approximate time
	 */
	public void printShowingAroundTime(MovieTime time);

	/**
	 * Prints the theaters and the movie showing that have a showing that ends
	 * around a certain time. The output should be formated like:<br>
	 * Theater 0:<br>
	 * The Avengers: Age of Ultron - 142 minutes - $19.00<br>
	 * &nbsp;times: 8:00am, 4:00pm, 10:00pm<br>
	 * <br>
	 * Theater 1:<br>
	 * Cinderella - 105 minutes - $9.75<br>
	 * &nbsp;times: 8:30am, 11:00am, 12:00pm, 11:30pm<br>
	 *
	 * @param time
	 *            the approximate end time
	 */
	public void printShowingThatEndAroundTime(MovieTime time);

	/**
	 * Creates a string representation of a town. It should be in the following
	 * format: <br>
	 * Theater 0: <br>
	 * The Avengers: Age of Ultron - 142 minutes - $19.00 <br>
	 * &nbsp;times: 8:00am, 4:00pm, 10:00pm <br>
	 * <br>
	 * Theater 1: <br>
	 * Cinderella - 105 minutes - $9.75<br>
	 * &nbsp;times: 8:30am, 11:00am, 12:00pm, 11:30pm <br>
	 * The Avengers: Age of Ultron - 142 minutes - $19.00<br>
	 * &nbsp;times: 1:30am, 2:34am, 12:00pm, 1:30pm, 2:34pm
	 *
	 * @return the string representing a town object
	 */
	@Override
	public String toString();

}
