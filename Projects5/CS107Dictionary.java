import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Intro to Java (600.107) Spring 2015 HW5 CS107Dictionary
 *
 * Dictionary of valid words.
 *
 * @author Katie Calabro - kcalabr1@jhu.edu
 *
 */
public class CS107Dictionary {

	/** Set of words in the dictionary. */
	private static HashSet<String> validWords;
	/** The name of the file where the words are defined. */
	private static final String WORD_FILE = "dictionaryWords.txt";
	/** List of all the possible base words that could be randomly generated. */
	private static ArrayList<String> baseWordCandidates;
	/** Random generator to pick base word. */
	private static final Random RAND = new Random();

	/**
	 * Checks if a given word is valid by checking if it exists in list of all
	 * the words in the dictionary, ignoring case. If the given word is in the
	 * dictionary, this method will return true.
	 *
	 * @param word
	 *            the word being checked if it is in the dictionary (ignoring
	 *            case)
	 * @return true if the word is in the dictionary, false if the word is not.
	 */
	public static boolean isValidWord(String word) {
		if (validWords == null || validWords.size() == 0) {
			initalizeValidWords();
		}
		return validWords.contains(word.toLowerCase());
	}

	/**
	 * This returns a random base word candidate. There is a set list of
	 * possible base word candidates and this method will randomly return one of
	 * them.
	 *
	 * @return a randomly generated base word candidate
	 */
	public static String getRandomBaseWordCandidate() {
		if (baseWordCandidates == null || baseWordCandidates.size() == 0) {
			initalizeBaseWordCandidates();
		}
		return baseWordCandidates.get(RAND.nextInt(baseWordCandidates.size()));
	}

	/**
	 * Initializes the HashSet of words by reading from the txt file that
	 * contains the entire list of words for the dictionary. If the file is not
	 * round, this method will print an error message.
	 */
	private static void initalizeValidWords() {
		validWords = new HashSet<String>();
		try {
			Scanner fromFile = new Scanner(new FileReader(WORD_FILE));
			while (fromFile.hasNext()) {
				String word = fromFile.next().toLowerCase();
				if (word.length() > 0) {
					validWords.add(word);
				}
			}
			fromFile.close();
		} catch (FileNotFoundException e) {
			System.err.println("The file "
							+ WORD_FILE
							+ " cannot be found. Make sure that it is named correctly and that it is"
							+ " in the same directory from where you are running this code.");
		} catch (Exception e) {
			System.err.println("There was an error initializing the dictionary of words."
							+ " Please make sure that the txt file and its contents are correct.");
		}
	}

	/**
	 * This initializes the base word array by inserting all the different
	 * possible words into the array.
	 */
	private static void initalizeBaseWordCandidates() {
		baseWordCandidates = new ArrayList<String>();
		baseWordCandidates.add("precaution");
		baseWordCandidates.add("pull");
		baseWordCandidates.add("java");
		baseWordCandidates.add("seaside");
		baseWordCandidates.add("absolute");
		baseWordCandidates.add("mantel");
		baseWordCandidates.add("margin");
		baseWordCandidates.add("cellphone");
		baseWordCandidates.add("at");
		baseWordCandidates.add("or");
		baseWordCandidates.add("ox");
		baseWordCandidates.add("tab");
		baseWordCandidates.add("dice");
		baseWordCandidates.add("gravy");
		baseWordCandidates.add("uncopyrightable");
		baseWordCandidates.add("absolute");
		baseWordCandidates.add("copyrightable");
		baseWordCandidates.add("kite");
		baseWordCandidates.add("unicorn");
		baseWordCandidates.add("ambidextrous");
	}

}
