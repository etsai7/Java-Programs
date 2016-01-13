public interface MovieShowingInterface extends Comparable<Object> {

	/** The start size of the times array. */
	public static final int START_SIZE = 5;
	/**
	 * The number of plus or minus minutes variation for hasShowingAroundTime().
	 */
	public static final int TIME_THRESHOLD = 15;

	/**
	 * Gets the movie associated with this movie showing.
	 *
	 * @return the movie
	 */
	public Movie getMovie();

	/**
	 * Goes through the times and checks if there is a movie around the time
	 * passed into the method. A time is "around" a movie time if it is between
	 * plus or minus TIME_THRESHOLD, inclusive. For example, if TIME_THRESHOLD
	 * is 15 minutes and the time passed into the method is 1:30pm and the movie
	 * times are 1:14pm, 1:15pm, 1:45pm, and 1:46pm; the movie times that are
	 * within the TIME_THRESHOLD are 1:15pm and 1:45pm because they are within
	 * plus or minus TIME_THRESHOLD of the time passed into the method.
	 *
	 * @param time
	 *            the approximate time
	 * @return true if this movie showing has a time around the given time
	 */
	public boolean hasShowingAroundTime(MovieTime time);

	/**
	 * Goes through the times and checks if there is a movie that ends around
	 * the time passed into the method. A time is "around" a movie time if it is
	 * between plus or minus TIME_THRESHOLD, inclusive. For example, if
	 * TIME_THRESHOLD is 15 minutes and the time passed into the method is
	 * 1:30pm, the movie would have to <b>end</b> between 1:15pm and 1:45pm
	 * inclusively for it to be and acceptable movie showing.
	 *
	 * @param time
	 *            the approximate end time
	 * @return true if this movie showing has an end time around the given time
	 */
	public boolean hasShowingThatEndsAroundTime(MovieTime time);

	/**
	 * Sorts the times array by sorting the times in ascending order, where the
	 * earliest time is first and the latest time is last.
	 */
	public void sortMovieTimes();


	/**
	 * Compares a MovieShowing based on comparing the Movie objects. This method
	 * will return -1 if o is not of type MovieShowing.
	 *
	 * @return 0 if the movies objects are the same, negative if this movie
	 *         object is less than o, positive if this movie object is greater
	 *         than o.
	 */
	@Override
	public int compareTo(Object o);

	/**
	 * Creates a string representation of a movie showing object. It should be
	 * formatted like:<br>
	 * The Avengers: Age of Ultron - 142 minutes - $19.00<br>
	 * &nbsp;times: 1:30am, 2:34am, 12:00pm, 1:30pm, 2:34pm
	 *
	 * @return the string representing this movie showing object.
	 */
	@Override
	public String toString();

}
