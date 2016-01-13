import java.io.IOException;

/**
 * Intro to Java (600.107) - Spring 2015 - HW10
 *
 * @author Katie Calabro - kcalabr1@jhu.edu
 *
 */
public class MovieShowingTester {

	/**
	 * Driver to test the MovieShowing class for HW10.
	 *
	 * @param args
	 *            command line arguments
	 * @throws IOException
	 *             file not found exception
	 */
	public static void main(String[] args) throws IOException {
		// test 1
		printStartTest(1);
		test1();
		printEndTest();

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

		// test 4
		printStartTest(5);
		test5();
		printEndTest();
	}

	/**
	 * Tests that the toString method is correct.
	 */
	private static void test1() /*throws IOException*/{
		int numTestsFailed = 0;
		Movie m = new Movie("Cinderella", 105, 9.7);
		String times = "    1:30pm         12:00pm        2:34pm        2:34am     1:30am   ";
		MovieShowing ms = new MovieShowing(m, times);

		String studentStr = ms.toString();
		String correctStr =
				"Cinderella - 105 minutes - $9.70\n\ttimes: "
						+ "1:30am, 2:34am, 12:00pm, 1:30pm, 2:34pm";

		if (!studentStr.trim().equals(correctStr.trim())) {
			System.out.println("Expected toString() result:");
			System.out.println(correctStr);
			System.out.println();
			System.out.println("Your toString() result: ");
			System.out.println(studentStr);
			System.out.println();
			numTestsFailed++;
		}

		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}
	}

	/**
	 * Tests that the getMovie() method is correct.
	 */
	private static void test2() throws IOException {
		int numTestsFailed = 0;
		Movie m = new Movie("Cinderella", 105, 9.7);
		String times = "    1:30pm         12:00pm        2:34pm        2:34am     1:30am   ";
		MovieShowing ms = new MovieShowing(m, times);

		if (!m.equals(ms.getMovie())) {
			System.out.println("Expected getMovie() result: Cinderella - 105 minutes - $9.70");
			System.out.println("Your getMovie() result: " + ms.getMovie());
			System.out.println();
			numTestsFailed++;
		}

		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}
	}

	/**
	 * Tests that the hasShowingAroundTime() method is correct.
	 */
	private static void test3() /*throws IOException*/ {
		int numTestsFailed = 0;
		IMAXMovie m = new IMAXMovie("Furious 7", 137, 10.33, 2);
		String times = "   11:30pm       11:00am   12:00pm  ";
		MovieShowing ms = new MovieShowing(m, times);

		MovieTime time = new MovieTime("11:30pm");
		boolean b = ms.hasShowingAroundTime(time);
		if (!b) {
			System.out.println("Expected hasShowingAroundTime(11:30pm) result: true");
			System.out.println("Your hasShowingAroundTime(11:30pm) result: " + b);
			System.out.println();
			numTestsFailed++;
		}

		time = new MovieTime("11:15pm");
		b = ms.hasShowingAroundTime(time);
		if (!b) {
			System.out.println("Expected hasShowingAroundTime(11:15pm) result: true");
			System.out.println("Your hasShowingAroundTime(11:15pm) result: " + b);
			System.out.println();
			numTestsFailed++;
		}

		time = new MovieTime("11:14pm");
		b = ms.hasShowingAroundTime(time);
		if (b) {
			System.out.println("Expected hasShowingAroundTime(11:14pm) result: false");
			System.out.println("Your hasShowingAroundTime(11:14pm) result: " + b);
			System.out.println();
			numTestsFailed++;
		}

		time = new MovieTime("11:45pm");
		b = ms.hasShowingAroundTime(time);
		if (!b) {
			System.out.println("Expected hasShowingAroundTime(11:45pm) result: true");
			System.out.println("Your hasShowingAroundTime(11:45pm) result: " + b);
			System.out.println();
			numTestsFailed++;
		}

		time = new MovieTime("11:46pm");
		b = ms.hasShowingAroundTime(time);
		if (b) {
			System.out.println("Expected hasShowingAroundTime(11:46pm) result: false");
			System.out.println("Your hasShowingAroundTime(11:46pm) result: " + b);
			System.out.println();
			numTestsFailed++;
		}

		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}
	}

	/**
	 * Tests that the hasShowingThatEndsAroundTime() method is correct.
	 */
	private static void test4()  /*throws IOException*/{
		int numTestsFailed = 0;

		ThreeDMovie m = new ThreeDMovie("The Avengers: Age of Ultron", 142, 13.5, 5.5);
		String times = "   1:30pm         12:00pm        2:33pm        2:34am     1:30am  ";
		MovieShowing ms = new MovieShowing(m, times);

		MovieTime time = new MovieTime("4:55pm");
		boolean b = ms.hasShowingThatEndsAroundTime(time);
		if (!b) {
			System.out.println("Expected hasShowingThatEndsAroundTime(4:55pm) result: true");
			System.out.println("Your hasShowingThatEndsAroundTime(4:55pm) result: " + b);
			System.out.println();
			numTestsFailed++;
		}

		time = new MovieTime("4:40pm");
		b = ms.hasShowingThatEndsAroundTime(time);
		if (!b) {
			System.out.println("Expected hasShowingThatEndsAroundTime(4:40pm) result: true");
			System.out.println("Your hasShowingThatEndsAroundTime(4:40pm) result: " + b);
			System.out.println();
			numTestsFailed++;
		}

		time = new MovieTime("4:39pm");
		b = ms.hasShowingThatEndsAroundTime(time);
		if (b) {
			System.out.println("Expected hasShowingThatEndsAroundTime(4:39pm) result: false");
			System.out.println("Your hasShowingThatEndsAroundTime(4:39pm) result: " + b);
			System.out.println();
			numTestsFailed++;
		}

		time = new MovieTime("5:10pm");
		b = ms.hasShowingThatEndsAroundTime(time);
		if (!b) {
			System.out.println("Expected hasShowingThatEndsAroundTime(5:10pm) result: true");
			System.out.println("Your hasShowingThatEndsAroundTime(5:10pm) result: " + b);
			System.out.println();
			numTestsFailed++;
		}

		time = new MovieTime("5:11pm");
		b = ms.hasShowingThatEndsAroundTime(time);
		if (b) {
			System.out.println("Expected hasShowingThatEndsAroundTime(5:11pm) result: false");
			System.out.println("Your hasShowingThatEndsAroundTime(5:11pm) result: " + b);
			System.out.println();
			numTestsFailed++;
		}

		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}
	}

	/**
	 * Tests that the compareTo() method is correct.
	 */
	private static void test5() /*throws IOException*/ {
		int numTestsFailed = 0;

		ThreeDMovie m1 = new ThreeDMovie("The Avengers: Age of Ultron", 142, 13.5, 5.5);
		String times1 = "   1:30pm         12:00pm        2:33pm        2:34am     1:30am  ";
		MovieShowing ms1 = new MovieShowing(m1, times1);

		IMAXMovie m2 = new IMAXMovie("Furious 7", 137, 10.33, 2);
		String times2 = "   11:30pm       11:00am   12:00pm  ";
		MovieShowing ms2 = new MovieShowing(m2, times2);

		Movie m3 = new Movie("the avengers: age of ultron", 142, 13.5);
		String time3 = "10:00pm 4:00pm 8:00am";
		MovieShowing ms3 = new MovieShowing(m3, time3);

		String ms1Str =
				"The Avengers: Age of Ultron - 142 minutes - $19.00\\n\\ttimes: 1:30am, 2:34am, 12:00pm, 1:30pm, 2:33pm";
		String ms2Str = "Furious 7 - 137 minutes - $20.66\\n\\ttimes: 11:00am, 12:00pm, 11:30pm";
		String ms3Str =
				"the avengers: age of ultron - 142 minutes - $13.50\\n\\ttimes: 8:00am, 4:00pm, 10:00pm";

		int comp = ms1.compareTo(ms2);
		if (comp <= 0) {
			System.out.println("Expected \"" + ms1Str + "\" compareTo \"" + ms2Str
					+ "\" result: positive");
			System.out.println("Your \"" + ms1Str + "\" compareTo \"" + ms2Str
					+ "\" result: result: " + comp);
			System.out.println();
			numTestsFailed++;
		}

		comp = ms2.compareTo(ms1);
		if (comp >= 0) {
			System.out.println("Expected \"" + ms2Str + "\" compareTo \"" + ms1Str
					+ "\" result: negative");
			System.out.println("Your \"" + ms2Str + "\" compareTo \"" + ms1Str
					+ "\" result: result: " + comp);
			System.out.println();
			numTestsFailed++;
		}

		comp = ms1.compareTo(ms3);
		if (comp != 0) {
			System.out.println("Expected \"" + ms1Str + "\" compareTo \"" + ms3Str
					+ "\" result: zero");
			System.out.println("Your \"" + ms1Str + "\" compareTo \"" + ms3Str
					+ "\" result: result: " + comp);
			System.out.println();
			numTestsFailed++;
		}

		comp = ms3.compareTo(ms1);
		if (comp != 0) {
			System.out.println("Expected \"" + ms3Str + "\" compareTo \"" + ms1Str
					+ "\" result: zero");
			System.out.println("Your \"" + ms3Str + "\" compareTo \"" + ms1Str
					+ "\" result: result: " + comp);
			System.out.println();
			numTestsFailed++;
		}

		comp = ms3.compareTo(ms3);
		if (comp != 0) {
			System.out.println("Expected \"" + ms3Str + "\" compareTo \"" + ms3Str
					+ "\" result: zero");
			System.out.println("Your \"" + ms3Str + "\" compareTo \"" + ms3Str
					+ "\" result: result: " + comp);
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
