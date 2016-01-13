import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Intro to Java (600.107) - Spring 2015 - HW10
 *
 * @author Katie Calabro - kcalabr1@jhu.edu
 *
 */
public class MovieListTester {

	/**
	 * Driver to test the MovieList class for HW10.
	 *
	 * @param args
	 *            command line arguments
	 * @throws IOException
	 *             file not found exception
	 */
	public static void main(String[] args) throws IOException {
		// make sure to use the small_movie_list.txt file that was provided
		String filename = "small_movie_list.txt";
		File f = new File(filename);

		if (!f.exists()) {
			System.err.println("File " + filename + " does not exist!!");
			System.err.println("Make sure you get this file from piazza");
			System.err.println("Make sure this file exists here: (" + f.getAbsolutePath()
					+ ")");
		} else {
			// the txt file has to exist before any tests can be run

			// test 1
			printStartTest(1);
			boolean passed = test1(filename);
			printEndTest();

			if (passed) {
				// you have to pass test 1 before any more tests can be run

				// test 2
				printStartTest(2);
				test2();
				printEndTest();

				// test 3
				printStartTest(3);
				test3();
				printEndTest();

				// test 4
				printStartTest(4);
				test4();
				printEndTest();

				// test 5
				printStartTest(5);
				test5();
				printEndTest();

				// test 6
				printStartTest(6);
				test6();
				printEndTest();

				// test 7
				printStartTest(7);
				test6();
				printEndTest();
			}

		}
	}

	/**
	 * This adds movies to the MovieList class by the given filename. The file
	 * has to be the same file provided on piazza for this test.
	 *
	 * @param filename
	 *            test file name
	 * @return true if the test passes (i.e. doesn't crash the program), false
	 *         else
	 * @throws IOException
	 *             file not found exception
	 */
	private static boolean test1(String filename) throws IOException {
		try {
			MovieList.addMovies(filename);
		} catch (Exception e) {
			System.out.println("Test 1 failed because the program crashed!");
			e.printStackTrace();
			return false;
		}
		System.out.println("Passed!");
		return true;
	}

	/**
	 * Tests to make sure that the getNumMovies() method is correct.
	 */
	private static void test2() {
		int numTestsFailed = 0;

		if (MovieList.getNumMovies() != 3) {
			System.out.println("Expected getNumMovies() result: 3");
			System.out.println("Your getNumMovies() result: " + MovieList.getNumMovies());
			System.out.println();
			numTestsFailed++;
		}

		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}
	}

	/**
	 * Tests to make sure that the getMovieWithTitle() method is correct.
	 */
	private static void test3() {
		int numTestsFailed = 0;
		Movie m = MovieList.getMovieWithTitle("Home");

		if (m == null || !m.getTitle().equals("Home") || m.getLength() != 94 || m.getPrice() != 18
				|| !m.toString().equals("Home - 94 minutes - $18.00")) {
			System.out.println("Expected getMovieWithTitle() result: Home - 94 minutes - $18.00");
			System.out.println("Your getMovieWithTitle() result: " + m);
			System.out.println();
			numTestsFailed++;
		}

		m = MovieList.getMovieWithTitle("home");
		if (m == null || !m.getTitle().equals("Home") || m.getLength() != 94 || m.getPrice() != 18
				|| !m.toString().equals("Home - 94 minutes - $18.00")) {
			System.out.println("Expected getMovieWithTitle() result: Home - 94 minutes - $18.00");
			System.out.println("Your getMovieWithTitle() result: " + m);
			System.out.println();
			numTestsFailed++;
		}

		m = MovieList.getMovieWithTitle("Still");
		if (m != null) {
			System.out.println("Expected getMovieWithTitle() result: null");
			System.out.println("Your getMovieWithTitle() result: " + m);
			System.out.println();
			numTestsFailed++;
		}

		m = MovieList.getMovieWithTitle("");
		if (m != null) {
			System.out.println("Expected getMovieWithTitle() result: null");
			System.out.println("Your getMovieWithTitle() result: " + m);
			System.out.println();
			numTestsFailed++;
		}


		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}
	}

	/**
	 * Tests to make sure that the getMovieAtIndex() method is correct.
	 */
	private static void test4() {
		int numTestsFailed = 0;
		Movie m = null;
		try {
			m = MovieList.getMovieAtIndex(-1);
		} catch (Exception e) {
			System.out.println("Expected getMovieAtIndex(-1) result: null");
			System.out.println("Your getMovieAtIndex(-1) result: " + "crashed program");
			System.out.println();
			e.printStackTrace();
			numTestsFailed++;
			return;
		}

		if (m != null) {
			System.out.println("Expected getMovieAtIndex(-1) result: null");
			System.out.println("Your getMovieAtIndex(-1) result: " + m);
			System.out.println();
			numTestsFailed++;
		}

		try {
			m = MovieList.getMovieAtIndex(3);
		} catch (Exception e) {
			System.out.println("Expected getMovieAtIndex(3) result: null");
			System.out.println("Your getMovieAtIndex(3) result: " + "crashed program");
			System.out.println();
			e.printStackTrace();
			numTestsFailed++;
			return;
		}

		if (m != null) {
			System.out.println("Expected getMovieAtIndex(3) result: null");
			System.out.println("Your getMovieAtIndex(3) result: " + m);
			System.out.println();
			numTestsFailed++;
		}

		m = MovieList.getMovieAtIndex(0);
		if (m == null || !m.getTitle().equals("Insurgent") || m.getLength() != 119
				|| m.getPrice() != 14.30 || !m.toString().equals("Insurgent - 119 minutes - $14.30")) {
			System.out
			.println("Expected getMovieAtIndex(0) result: Insurgent - 119 minutes - $14.30");
			System.out.println("Your getMovieAtIndex(0) result: " + m);
			System.out.println();
			numTestsFailed++;
		}

		m = MovieList.getMovieAtIndex(1);
		if (m == null || !m.getTitle().equals("Home") || m.getLength() != 94 || m.getPrice() != 18
				|| !m.toString().equals("Home - 94 minutes - $18.00")) {
			System.out.println("Expected getMovieAtIndex(1) result: Home - 94 minutes - $18.00");
			System.out.println("Your getMovieAtIndex(1) result: " + m);
			System.out.println();
			numTestsFailed++;
		}

		m = MovieList.getMovieAtIndex(2);
		if (m == null || !m.getTitle().equals("Still Alice") || m.getLength() != 101
				|| m.getPrice() != 8 || !m.toString().equals("Still Alice - 101 minutes - $8.00")) {
			System.out
			.println("Expected getMovieAtIndex(2) result: Still Alice - 101 minutes - $8.00");
			System.out.println("Your getMovieAtIndex(2) result: " + m);
			System.out.println();
			numTestsFailed++;
		}

		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}

	}

	/**
	 * Tests to make sure that the printMoviesByCategory() method is correct.
	 */
	private static void test5() {
		int numTestsFailed = 0;
		String correctOutput =
				"Movies:\nStill Alice - 101 minutes - $8.00\n"
						+ "\n3D Movies:\nInsurgent - 119 minutes - $14.30\n"
						+ "\nIMAX Movies:\nHome - 94 minutes - $18.00";
		PrintStream stdio = System.out;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		MovieList.printMoviesByCategory();
		String studentOutput = outContent.toString();

		System.setOut(stdio);

		if (!studentOutput.trim().equals(correctOutput.trim())) {
			System.out.println("Expected printMoviesByCategory() result: ");
			System.out.println(correctOutput);
			System.out.println();
			System.out.println("Your printMoviesByCategory() result: ");
			System.out.println(studentOutput);
			System.out.println();
			numTestsFailed++;
		}

		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}
	}

	/**
	 * Tests to make sure that the getMovieWithSimilarTitle() method is correct.
	 */
	private static void test6() {
		int numTestsFailed = 0;

		Movie m = MovieList.getMovieWithSimilarTitle("hom");
		if (m == null || !m.getTitle().equals("Home") || m.getLength() != 94 || m.getPrice() != 18
				|| !m.toString().equals("Home - 94 minutes - $18.00")) {
			System.out
			.println("Expected getMovieWithSimilarTitle() result: Home - 94 minutes - $18.00");
			System.out.println("Your getMovieWithSimilarTitle() result: " + m);
			System.out.println();
			numTestsFailed++;
		}

		m = MovieList.getMovieWithSimilarTitle("aLiCe");
		if (m == null || !m.getTitle().equals("Still Alice") || m.getLength() != 101
				|| m.getPrice() != 8 || !m.toString().equals("Still Alice - 101 minutes - $8.00")) {
			System.out
			.println("Expected getMovieWithSimilarTitle() result: Still Alice - 101 minutes - $8.00");
			System.out.println("Your getMovieWithSimilarTitle() result: " + m);
			System.out.println();
			numTestsFailed++;
		}

		m = MovieList.getMovieWithSimilarTitle("INSURG");
		if (m == null || !m.getTitle().equals("Insurgent") || m.getLength() != 119
				|| m.getPrice() != 14.30 || !m.toString().equals("Insurgent - 119 minutes - $14.30")) {
			System.out
			.println("Expected getMovieWithSimilarTitle() result: Insurgent - 119 minutes - $14.30");
			System.out.println("Your getMovieWithSimilarTitle() result: " + m);
			System.out.println();
			numTestsFailed++;
		}

		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}

	}

	/**
	 * Nicely formats the current test number.
	 *
	 * @param num
	 *            test number
	 */
	private static void printStartTest(int num) {
		System.out.println("--------------- test" + num + " ---------------");
	}

	/**
	 * Nicely formats the line operating one test from another.
	 */
	private static void printEndTest() {
		System.out.println("-------------------------------------\n");
	}

}
