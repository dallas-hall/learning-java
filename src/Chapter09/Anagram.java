package Chapter09;/**
 * <h1>Anagram</h1>
 * <p>
 * This program checks if 2 Strings are an anagram. An anagram means they both have the same number of letters.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-08
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class Anagram
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(Anagram.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		logger.log(Level.INFO, "Chapter 9 - Exercise 7.");
		Anagram runtime = new Anagram();
		String[][] s = {
			{"pots", "stop"},
			{"john", "jon"},
			{"allen downey", "well annoyed"},
			{"letter", "better"}
		};
		
		for (int i = 0; i < s.length; i++) {
			System.out.printf("%s %b.\n", "Is " + s[i][0] + " & " + s[i][1] + " an anagram?", runtime.isAnagram(s[i][0], s[i][1]));
		}
	}

	//@@@ METHODS @@@
	//### HELPERS ###
	public boolean isAnagram(String s1, String s2)
	{
		int[] s1Histogram = getHistogram(s1.trim());
		int[] s2Histogram = getHistogram(s2.trim());
		
		if (s1.length() != s2.length()) {
			return false;
		}
		
		for (int i = 0; i < s1.length(); i++) {
			if (s1Histogram[i] != s2Histogram[i]) {
				return false;
			}
		}
		return true;
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
