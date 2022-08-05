package Chapter05;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>BottlesOfBeerSong</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2018-12-06
 */
public class BottlesOfBeerSong
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(BottlesOfBeerSong.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	public static final String PROGRAM_VERSION = "0.1.0";
	private int amount;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		BottlesOfBeerSong runtime = new BottlesOfBeerSong(3);
		runtime.singSong(runtime.getAmount());
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public BottlesOfBeerSong(int amount)
	{
		logger.log(Level.INFO, "Chapter 5 - Exercise 5");
		try {
			Thread.sleep(005);
		}
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		this.amount = amount;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getAmount()
	{
		return amount;
	}
	
	private String getLyric(int i)
	{
		String lyric = i + " bottles of beer on the wall,\n" + i + " bottles of beer!\n";
		if (i > 1) {
			lyric = lyric.concat("ya'take one down, ya' pass it around,\n" + (i - 1) + " bottles of beer on the wall.");
		}
		else {
			lyric = lyric.concat("ya' can't take one down, ya' pass it around,\n 'cause there are no more bottles of beer on the wall.");
		}
		return lyric + "\n";
	}
	
	//### SETTERS ###
	
	//### HELPERS ###
	private void singSong(int i)
	{
		if (i >= 0) {
			String lyric = getLyric(i);
			System.out.println(lyric);
			singSong(i - 1);
		}
		
	}
}
