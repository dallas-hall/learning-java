package Chapter11;
/**
 * <h1>ScrabbleLetterTileMain</h1>
 * <p>
 * This program is the driver for ScrabbleLetterTile.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-09
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class ScrabbleLetterTileMain
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(ScrabbleLetterTileMain.class.getName());
	public static final String PROGRAM_VERSION = "0.1.0";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Chapter 11 - Exercise 3");
		logger.log(Level.INFO, "Print 10 random tiles.");
		Thread.sleep(005);
		for(int i = 0; i < 10; i++) {
			System.out.println(new ScrabbleLetterTile().toString());
		}
		
		logger.log(Level.INFO, "Create 1 random character.");
		Thread.sleep(005);
		ScrabbleLetterTile tile1 = new ScrabbleLetterTile();
		System.out.println(tile1);
		logger.log(Level.INFO, "Create 1 specified character.");
		Thread.sleep(005);
		ScrabbleLetterTile tile2 = new ScrabbleLetterTile('A');
		tile2.printTile();
		System.out.printf("%s %b.\n", "Does " + tile1.getLetter() + " equal " + tile2.getLetter() + "?", tile1.equals(tile2));
		tile1.setLetter('A');
		System.out.printf("%s %b.\n", "Does " + tile1.getLetter() + " equal " + tile2.getLetter() + "?", tile1.equals(tile2));
		tile1.setLetter('A');
	}

}
