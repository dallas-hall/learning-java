package chapter08_multi_d_arrays;

import java.util.concurrent.ThreadLocalRandom;
import chapter05_loops.DecimalToBinary;

/**
 * <h1>9 Heads & 9 Tails</h1>
 * <p>
 * This program uses a 3x3 matrix to hold coins, which are either heads of tails. There are 512 combinations, a random number is generated and that combination is displayed.
 * </p>
 * <p>
 * tags:	char[][]; ThreadLocalRandom.current().nextInt; nested for loops;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-09
 */
public class Question11
{
	//@@@ INSTANCE VARIABLES @@@
	public static final int START_NUMBER = 0;
	public static final int FINAL_NUMBER = 512;
	public static final int RADIX = 2;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) {
		int startNumberBase10 = ThreadLocalRandom.current().nextInt(START_NUMBER, FINAL_NUMBER + 1);
		char[][] gameBoard = new char[3][3];
		String startNumberBase2 = DecimalToBinary.getBinary(startNumberBase10);
		// Pad with an extra 0 if the number needs it
		if(startNumberBase2.length() < 9) {
			startNumberBase2 = '0' + startNumberBase2;
		}
		System.out.println("Starting number in base10 is: " + startNumberBase10);
		System.out.println("Starting number in base2 is: " + startNumberBase2);
		
		int character = 0;
		for(int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				if (startNumberBase2.charAt(character) == '0')
					gameBoard[i][j] = 'H';
				else
					gameBoard[i][j] = 'T';
				character++;
			}
		}
		
		for(int i = 0; i < gameBoard.length; i++) {
			for(int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println();
		}

	}
}
