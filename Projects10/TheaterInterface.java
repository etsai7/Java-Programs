
public interface TheaterInterface {

	/** The start size of the showings array. */
	public static final int START_SIZE = 5;

	/**
	 * Adds a movie showing to the the showings array. It first checks if the
	 * array needs to be resized. Then it adds the a new move showing object to
	 * the array. It then sorts the array so that the movie showing are in
	 * alphabetical order according to movie showing's movie title.
	 *
	 * @param m
	 *            the movie for the new MovieShowing object
	 * @param timesString
	 *            the string that contains all the movie showing times.
	 */
	public void addShowing(Movie m, String timesString);

	/**
	 * Checks if any of the movie showings is showing a particular movie
	 *
	 * @param m
	 *            the movie object
	 * @return true if there is a movie showing at this theater showing m, false
	 *         if not
	 */
	public boolean isShowingMovie(Movie m);

	/**
	 * Prints the movie showing if it has a showing time around the time passed
	 * into the method. The formatting of the printing should be: <br>
	 * Cinderella - 105 minutes - $9.75<br>
	 * &nbsp;times: 8:30am, 11:00am, 12:00pm, 11:30pm<br>
	 *
	 * @param time
	 *            the approximate time
	 */
	public void printShowingAroundTime(MovieTime time);

	/**
	 * Prints the movie showing if it has a showing time that ends around the
	 * time passed into the method. The formatting of the printing should be: <br>
	 * Cinderella - 105 minutes - $9.75<br>
	 * &nbsp;times: 8:30am, 11:00am, 12:00pm, 11:30pm<br>
	 *
	 * @param time
	 *            the approximate end time
	 */
	public void printShowingThatEndsAroundTime(MovieTime time);

	/**
	 * Sorts the times array by sorting the movie showings in alphabetical order
	 * according to the movie title of the movie showing.
	 */
	public void sortMovieShowings();

	/**
	 * Resizes the showings array by doubling the current size of the array.
	 */
	public void resize();


	/**
	 * Creates a string representation of a theater object. The string should be
	 * formated like: <br>
	 * Cinderella - 105 minutes - $9.75 <br>
	 * &nbsp;times: 8:30am, 11:00am, 12:00pm, 11:30pm <br>
	 * The Avengers: Age of Ultron - 142 minutes - $19.00 <br>
	 * &nbsp;times: 1:30am, 2:34am, 12:00pm, 1:30pm, 2:34pm <br>
	 *
	 * @return the string for this theater object
	 */
	@Override
	public String toString();

}
