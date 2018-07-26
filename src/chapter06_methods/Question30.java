package chapter06_methods;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Simple Craps</h1>
 * <p>
 * This program is a simple Craps game. 12 is craps, you lose. 7 or 11 is natural, you win. All other numbers are stored as a Point, you need to roll the point to win.
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-18
 */
public class Question30
{
	//@@@ INSTANCE VARIABLES @@@
	
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		boolean gameOver = false;
		int di = 2;
		int sides = 6;
		int rollAmount = 2;
		int[] rollResults = new int[rollAmount];
		int currentGamePoint = 0;
		
		// LaunchSequence di rolling
/*		System.out.println("Rolling " + di + sides + " sided di(ce) " + rollAmount + " time(s).");
		for(int i = 0; i < 20; i++)
		{
			int[] rollResult = rollDice(di, sides, rollAmount);
			for(int j = 0; j < rollResult.length; j++)
			{
				System.out.println("Roll " + (j + 1) + " was " + rollResult[j] + ".");
			}
			System.out.println();
			
		}*/
		
		do
		{
			try
			{
				// Reset in case of previous runs
				gameOver = false;
				System.out.println("Welcome to Craps. Type roll to roll the dice or quit to quit the game.");
				if (currentGamePoint != 0)
					System.out.println("The current Points is " + currentGamePoint);
				String input = stdin.nextLine();
				
				if (input.toLowerCase().equals("roll"))
				{
					// Roll the di(ce)
					rollResults = rollDice(di, sides, rollAmount);
					int currentRollTotal = 0;
					// Check results
					for(int i = 0; i < rollResults.length; i++)
					{
						currentRollTotal += rollResults[i];
					}
					System.out.println("You have rolled:" + Arrays.toString(rollResults) + " which equals " + currentRollTotal);
					if (currentRollTotal == 12 || (currentRollTotal == 7 && currentGamePoint != 0))
					{
						System.out.println("Craps. You lose.");
						currentGamePoint = 0;
					}
					else if((currentRollTotal == 7 && currentGamePoint == 0) || (currentRollTotal == 11 && currentGamePoint != 0))
					{
						System.out.println("You're a Natural. You win.");
						currentGamePoint = 0;
					}
					else if(currentGamePoint == 0)
						currentGamePoint = currentRollTotal;
					else if(currentRollTotal == currentGamePoint)
					{
						System.out.println("You're a Natural. You win.");
						currentGamePoint = 0;
					}
					System.out.println();
				}
				else if (input.toLowerCase().equals("quit"))
				{
					System.out.println("You are leaving the game, thanks for playing.");
					break;
				}
				else
				{
					throw new Exception("You can only type 'roll' or 'quit'");
				}
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
		while (!gameOver);
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	public static int[] rollDice(int di, int sides, int amount)
	{
		/*
		 * https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadLocalRandom.html#nextInt-int-int-
		 *
		 * returns a number between min (inclusive) and max (exclusive).  So add one to max to include it.
		 */
		int[] result = new int[amount];
		for (int i = 0; i < amount; i++)
		{
			result[i] = ThreadLocalRandom.current().nextInt(1, sides + 1);
		}
		return result;
	}
}
