/**
 * Intro to Java (600.107) - Spring 2015 - HW10
 *
 * @author Katie Calabro - kcalabr1@jhu.edu
 *
 */
public class MovieTester {

	/**
	 * Driver to test the Movie, IMAXMovie, and ThreeDMovie classes for HW10.
	 *
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
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

		// test 3
		printStartTest(4);
		test4();
		printEndTest();
	}

	/**
	 * This test create a Movie object and tests that getTitle(), getPrice(),
	 * getLength(), and toString() methods are all correct.
	 */
	private static void test1() {
		int numTestsFailed = 0;
		Movie m = new Movie("Cinderella", 105, 9.7);

		if (!m.getTitle().equals("Cinderella")) {
			System.out.println("Expected getTitle() result: Cinderella");
			System.out.println("Your getTitle() result: " + m.getTitle());
			System.out.println();
			numTestsFailed++;
		}

		if (m.getPrice() != 9.7) {
			System.out.println("Expected getPrice() result: 9.7");
			System.out.println("Your getPrice() result: " + m.getPrice());
			System.out.println();
			numTestsFailed++;
		}

		if (m.getLength() != 105) {
			System.out.println("Expected getLength() result: 105");
			System.out.println("Your getLength() result: " + m.getLength());
			System.out.println();
			numTestsFailed++;
		}

		if (!m.toString().equals("Cinderella - 105 minutes - $9.70")) {
			// If this is failing, check that you do not have any new line
			// characters being returned in your toString method, and that you
			// have the correct number of spaces.
			System.out.println("Expected toString() result: Cinderella - 105 minutes - $9.70");
			System.out.println("Your toString() result: " + m.toString());
			System.out.println();
			numTestsFailed++;
		}

		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}
	}

	/**
	 * This test creates three Movie objects and tests that the compareTo method
	 * is correct.
	 */
	private static void test2() {
		int numTestsFailed = 0;
		Movie m1 = new Movie("Cinderella", 105, 9.75);
		Movie m2 = new Movie("The Imitation Game", 114, 11.33);
		Movie m3 = new Movie("cinderella", 105, 9.75);
		// If this doesn't compile, that means you might not have written
		// "Comparable<Object>" on the Movie class, or you didn't write the
		// public int compareTo(Object o) method in Movie.java

		if (m1.compareTo(m2) >= 0) {
			System.out
			.println("Expected \"Cinderella\" compareTo \"The Imitation Game\" result: negative");
			System.out.println("Your \"Cinderella\" compareTo \"The Imitation Game\" result: "
					+ m1.compareTo(m2));
			System.out.println();
			numTestsFailed++;
		}

		if (m2.compareTo(m1) <= 0) {
			System.out
			.println("Expected \"The Imitation Game\" compareTo \"Cinderella\" result: positive");
			System.out.println("Your \"The Imitation Game\" compareTo \"Cinderella\" result: "
					+ m2.compareTo(m1));
			System.out.println();
			numTestsFailed++;
		}

		if (m1.compareTo(m3) != 0) {
			System.out.println("Expected \"Cinderella\" compareTo \"cinderella\" result: zero");
			System.out.println("Your \"Cinderella\" compareTo \"cinderella\" result: "
					+ m1.compareTo(m3));
			System.out.println();
			numTestsFailed++;
		}

		if (m3.compareTo(m1) != 0) {
			System.out.println("Expected \"cinderella\" compareTo \"Cinderella\" result: zero");
			System.out.println("Your \"cinderella\" compareTo \"Cinderella\" result: "
					+ m3.compareTo(m1));
			System.out.println();
			numTestsFailed++;
		}

		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}
	}

	/**
	 * This test create an IMAXMovie object and tests that getTitle(),
	 * getPrice(), getLength(), and toString() methods are all correct.
	 */
	private static void test3() {
		int numTestsFailed = 0;
		IMAXMovie m = new IMAXMovie("Furious 7", 137, 10.33, 2);

		if (!m.getTitle().equals("Furious 7")) {
			System.out.println("Expected getTitle() result: Furious 7");
			System.out.println("Your getTitle() result: " + m.getTitle());
			System.out.println();
			numTestsFailed++;
		}

		if (m.getPrice() != 20.66) {
			System.out.println("Expected getPrice() result: 20.66");
			System.out.println("Your getPrice() result: " + m.getPrice());
			System.out.println();
			numTestsFailed++;
		}

		if (m.getLength() != 137) {
			System.out.println("Expected getLength() result: 137");
			System.out.println("Your getLength() result: " + m.getLength());
			System.out.println();
			numTestsFailed++;
		}

		if (!m.toString().equals("Furious 7 - 137 minutes - $20.66")) {
			// If this is failing, check that you do not have any new line
			// characters being returned in your toString method, and that you
			// have the correct number of spaces.
			System.out.println("Expected toString() result: Furious 7 - 137 minutes - $20.66");
			System.out.println("Your toString() result: " + m.toString());
			System.out.println();
			numTestsFailed++;
		}

		if (numTestsFailed == 0) {
			System.out.println("Passed!");
		}
	}

	/**
	 * This test create an ThreeDMovie object and tests that getTitle(),
	 * getPrice(), getLength(), and toString() methods are all correct.
	 */
	private static void test4() {
		int numTestsFailed = 0;
		ThreeDMovie m = new ThreeDMovie("The Avengers: Age of Ultron", 142, 13.5, 5.5);

		if (!m.getTitle().equals("The Avengers: Age of Ultron")) {
			System.out.println("Expected getTitle() result: The Avengers: Age of Ultron");
			System.out.println("Your getTitle() result: " + m.getTitle());
			System.out.println();
			numTestsFailed++;
		}

		if (m.getPrice() != 19) {
			System.out.println("Expected getPrice() result: 19");
			System.out.println("Your getPrice() result: " + m.getPrice());
			System.out.println();
			numTestsFailed++;
		}

		if (m.getLength() != 142) {
			System.out.println("Expected getLength() result: 142");
			System.out.println("Your getLength() result: " + m.getLength());
			System.out.println();
			numTestsFailed++;
		}

		if (!m.toString().equals("The Avengers: Age of Ultron - 142 minutes - $19.00")) {
			// If this is failing, check that you do not have any new line
			// characters being returned in your toString method, and that you
			// have the correct number of spaces.
			System.out
			.println("Expected toString() result: The Avengers: Age of Ultron - 142 minutes - $19.00");
			System.out.println("Your toString() result: " + m.toString());
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
