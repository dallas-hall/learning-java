package chapter09_objects_and_classes;

import java.util.Random;

/**
 * <h1>Random Numbers</h1>
 * <p>
 * This program creates a Random number object with 1000 as the seed and shows the next 50 integers that it generates.
 * </p>
 * <p>
 * tags:	java.util.Random; seed number;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-17
 */
public class Question04
{
	//@@@ CLASS VARIABLES @@@
	public static final int LIMIT = 50;
	
	//@@@ INSTANCE VARIABLES @@@
	private Random prn;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Question04 runtime = new Question04(1000);
		for (int i = 1; i <= LIMIT; i++) {
			System.out.print(runtime.getNextInt(runtime.getPrn()) + " ");
			if (i % 10 == 0) {
				System.out.println();
			}
		}
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public Question04(int seed)
	{
		prn = new Random(seed);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	private int getNextInt(Random prn)
	{
		return prn.nextInt(100);
	}
	
	private Random getPrn()
	{
		return this.prn;
	}
}
