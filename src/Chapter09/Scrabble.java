package Chapter09;
/**
 * <h1>Scrabble</h1>
 * <p>
 * This program creates a random set of letters for a Scrabble rack and sees if a set of words can be spelled from it. Uses histograms.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-08
 */

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scrabble
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(Scrabble.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		logger.log(Level.INFO, "Chapter 9 - Exercise 8");
		Scrabble runtime = new Scrabble();
		String letters = runtime.getRandomLetters();
		String[] words = {
				"and",
				"the",
				"is",
				"I",
				"a",
				"he",
				"dog"
		};
		for (int i = 0; i < words.length; i++) {
			System.out.printf("%s %b.\n", "Can you spell \"" + words[i] + "\" from \"" + letters + "\"?", runtime.canSpell(words[i], letters));
		}
	}

	//@@@ METHODS @@@
	//### HELPERS ###
	public boolean canSpell(String word, String letters)
	{
		int[] wordHistogram = getHistogram(word);
		int[] lettersHistogram = getHistogram(letters);
		for (int i = 0; i < lettersHistogram.length; i++) {
			if(lettersHistogram[i] == 0 && wordHistogram[i] > 0) {
				return false;
			}
		}
		return true;
	}
	
	private String getRandomLetters()
	{
		// Scrabble rack is usually limited to 7
		int threshold = ThreadLocalRandom.current().nextInt(7, 15);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < threshold; i++) {
			sb.append(String.valueOf((char) ThreadLocalRandom.current().nextInt(65, 91)));
		}
		return sb.toString();
	}
	
	private int[] getHistogram(String s)
	{
		// 0 = a and A through to 25 = z and Z
		int[] histogram = new int[26];
		for (char aChar : s.toCharArray()) {
			switch (aChar) {
				case 'A':
				case 'a':
					histogram[0]++;
					break;
				case 'B':
				case 'b':
					histogram[1]++;
					break;
				case 'C':
				case 'c':
					histogram[2]++;
					break;
				case 'D':
				case 'd':
					histogram[3]++;
					break;
				case 'E':
				case 'e':
					histogram[4]++;
					break;
				case 'F':
				case 'f':
					histogram[5]++;
					break;
				case 'G':
				case 'g':
					histogram[6]++;
					break;
				case 'H':
				case 'h':
					histogram[7]++;
					break;
				case 'I':
				case 'i':
					histogram[8]++;
					break;
				case 'J':
				case 'j':
					histogram[9]++;
					break;
				case 'K':
				case 'k':
					histogram[10]++;
					break;
				case 'L':
				case 'l':
					histogram[11]++;
					break;
				case 'M':
				case 'm':
					histogram[12]++;
					break;
				case 'N':
				case 'n':
					histogram[13]++;
					break;
				case 'O':
				case 'o':
					histogram[14]++;
					break;
				case 'P':
				case 'p':
					histogram[15]++;
					break;
				case 'Q':
				case 'q':
					histogram[16]++;
					break;
				case 'R':
				case 'r':
					histogram[17]++;
					break;
				case 'S':
				case 's':
					histogram[18]++;
					break;
				case 'T':
				case 't':
					histogram[19]++;
					break;
				case 'U':
				case 'u':
					histogram[20]++;
					break;
				case 'V':
				case 'v':
					histogram[21]++;
					break;
				case 'W':
				case 'w':
					histogram[22]++;
					break;
				case 'X':
				case 'x':
					histogram[23]++;
					break;
				case 'Y':
				case 'y':
					histogram[24]++;
					break;
				case 'Z':
				case 'z':
					histogram[25]++;
					break;
			}
		}
		return histogram;
	}
}
