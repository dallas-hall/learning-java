/**
 *
 */
package chapter05_loops;

/**
 * <h1>Subtraction Test</h1>
 * <p>
 * This program will generate 2 random numbers 10 times. It will ask the user to calculate the largest number minus the smallest number. It will check the answers at the end.
 * </p>
 * <p>
 * tags: Scanner; while; nextInt; if else; Math.random; System.currentTimeMillis;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-01
 */

import java.util.Scanner;

public class Exercise_02
{
	public static void main(String[] args)
	{
		final int NUMBER_OF_QUESTIONS = 10; // Number of questions
		int correctCount = 0; // Count the number of correct answers
		int count = 0; // Count the number of questions
		long startTime = System.currentTimeMillis();
		String output = " "; // output string is initially empty
		Scanner input = new Scanner(System.in);

		while (count < NUMBER_OF_QUESTIONS)
		{
			// 1. Generate two random single-digit integers
			int number1 = (int) (Math.random() * 15); //update the last number to specify the range
			int number2 = (int) (Math.random() * 15);

			// 2. If number1 < number2, swap number1 with number2
			if (number1 < number2)
			{
				int temp = number1;
				number1 = number2;
				number2 = temp;
			}

			// 3. Prompt the student to answer "What is number1 – number2?"
			System.out.print("What is " + number1 + " - " + number2 + "? ");
			int answer = input.nextInt();

			// 4. Grade the answer and display the result
			if (number1 - number2 == answer)
			{
				System.out.println("You are correct!");
				correctCount++; // Increase the correct answer count
			}
			else
			{
				System.out.println("Your answer is wrong.\n" + number1 + " - " + number2 + " should be " + (number1 - number2));
			}

			// Increase the question count
			count++;

			output += "\n" + number1 + "-" + number2 + "=" + answer + ((number1 - number2 == answer) ? " correct" : " wrong");

		}

		long endTime = System.currentTimeMillis();
		long testTime = endTime - startTime;

		System.out.println("Correct count is " + correctCount + "\nChars time is " + testTime / 1000 + " seconds\n" + output);
	}
}