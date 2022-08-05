package Chapter09;
/**
 * <h1>LetterHistogram</h1>
 * <p>
 * This program takes a string and returns an integer array with a histogram of all alpha characters. Upper and lowercase
 * counts are combined.
 * </p>
 * <p>
 * tags:	switch; case; histogram;
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-07
 */

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LetterHistogram
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(LetterHistogram.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 9 - Exercise 2");
		Thread.sleep(005);
		LetterHistogram runtime = new LetterHistogram();
		String[] s = {
				"Show me the money!",
				"You can't handle the truth!",
				"I'll be back.",
				"The quick brown fox jumps over the lazy dog."
		};
		
		for (int i = 0; i < s.length; i++) {
			System.out.println("The histogram of letters in \"" + s[i] + "\" is:\n" + Arrays.toString(runtime.getHistogram(s[i])));
		}
	}
	
	//### HELPERS ###
	public int[] getHistogram(String s)
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
