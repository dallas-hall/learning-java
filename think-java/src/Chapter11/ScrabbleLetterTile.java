package Chapter11;
/**
 * <h1>ScrabbleLetterTile</h1>
 * <p>
 * This program represent letter tiles from the game Scrabble. It can create random or specific characters and their
 * points values.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-09
 */

import java.util.concurrent.ThreadLocalRandom;

public class ScrabbleLetterTile
{
	//@@@ INSTANCE VARIABLES @@@
	private char letter;
	private int value;
	
	//@@@ CONSTRUCTOR(S) @@@
	public ScrabbleLetterTile()
	{
		int charOrSpace = ThreadLocalRandom.current().nextInt(1, 101);
		if (charOrSpace <= 5) {
			this.letter = ' ';
		}
		else {
			this.letter = (char) ThreadLocalRandom.current().nextInt(65, 91);
		}
		setValue();
	}
	
	public ScrabbleLetterTile(char letter)
	{
		this.letter = letter;
		setValue();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public char getLetter()
	{
		return letter;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	//### SETTERS ###
	public void setLetter(char aChar)
	{
		this.letter = aChar;
		setValue();
	}
	
	private void setValue()
	{
		// https://en.wikipedia.org/wiki/Scrabble_letter_distributions
		switch (letter) {
			case 'A':
			case 'a':
				value = 1;
				break;
			case 'B':
			case 'b':
				value = 3;
				break;
			case 'C':
			case 'c':
				value = 3;
				break;
			case 'D':
			case 'd':
				value = 2;
				break;
			case 'E':
			case 'e':
				value = 1;
				break;
			case 'F':
			case 'f':
				value = 4;
				break;
			case 'G':
			case 'g':
				value = 2;
				break;
			case 'H':
			case 'h':
				value = 4;
				break;
			case 'I':
			case 'i':
				value = 1;
				break;
			case 'J':
			case 'j':
				value = 8;
				break;
			case 'K':
			case 'k':
				value = 5;
				break;
			case 'L':
			case 'l':
				value = 1;
				break;
			case 'M':
			case 'm':
				value = 3;
				break;
			case 'N':
			case 'n':
				value = 1;
				break;
			case 'O':
			case 'o':
				value = 1;
				break;
			case 'P':
			case 'p':
				value = 3;
				break;
			case 'Q':
			case 'q':
				value = 10;
				break;
			case 'R':
			case 'r':
				value = 1;
				break;
			case 'S':
			case 's':
				value = 1;
				break;
			case 'T':
			case 't':
				value = 1;
				break;
			case 'U':
			case 'u':
				value = 1;
				break;
			case 'V':
			case 'v':
				value = 4;
				break;
			case 'W':
			case 'w':
				value = 4;
				break;
			case 'X':
			case 'x':
				value = 8;
				break;
			case 'Y':
			case 'y':
				value = 4;
				break;
			case 'Z':
			case 'z':
				value = 10;
				break;
			case ' ':
				value = 2;
		}
	}
	//### HELPERS ###
	public void printTile()
	{
		System.out.println(this.toString());
	}
	
	@Override
	public String toString()
	{
		return String.format("%s has the value %d.", this.letter, this.value);
	}
	
	public boolean equals(ScrabbleLetterTile that)
	{
		return this.letter == that.letter &&
			this.value == that.value;
	}

}
