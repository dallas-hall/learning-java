package chapter05_loops;

/**
 * <h1>>Student Scoring</h1>
 * <p>
 * This program will ask for student names and scores and calculate the winner.
 * </p>
 * <p>
 * tags: do while; boolean;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-01
 */

import java.util.Scanner;

public class Exercise_08
{
	public static void main(String[] args)
	{
		boolean done = false;
		String name = "";
		int score = 0;

		do
		{
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter student name: ");
			String tempName = keyboard.nextLine();
			System.out.print("\nEnter student score: ");
			int tempScore = Integer.parseInt(keyboard.nextLine());
			if (tempScore > score)
			{
				name = tempName;
				score = tempScore;
			}
			System.out.println("Are you finished?");
			char input = Character.toUpperCase(keyboard.nextLine().charAt(0));
			if (input == 'Y')
			{
				done = true;
			}
		}
		while (!done);
		System.out.println("The winner was: " + name + " with a score of: " + score);
	}
}
