package chapter09_objects_and_classes;

import java.util.Arrays;

/**
 * <h1>Q13 LaunchSequence</h1>
 * <p>
 * This program will create the Q13 object and run it.
 * </p>
 * <p>
 * tags:	Arrays.deepToString;
 * </p>
 *
 * @author dhall
 * @version 0.1 - 2018-04-20
 */
public class TestQ13
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Question13 runtime = new Question13();
		int[][] numbers = runtime.getNumbers();
		runtime.findMaximumValue(numbers);
		System.out.println("@@@ LaunchSequence 1 @@@");
		System.out.println("The starting array is:");
		System.out.println(Arrays.deepToString(numbers));
		System.out.println("The maximum value found is: " + runtime.getMaximumValue());
		System.out.println("The position it was found in was: [" + runtime.getRow() + "," + runtime.getColumn() + "]");
		
		System.out.println("\n@@@ LaunchSequence 2 @@@");
		runtime = new Question13(6, 6);
		numbers = runtime.getNumbers();
		runtime.findMaximumValue(numbers);
		System.out.println("The starting array is:");
		System.out.println(Arrays.deepToString(numbers));
		System.out.println("The maximum value found is: " + runtime.getMaximumValue());
		System.out.println("The position it was found in was: [" + runtime.getRow() + "," + runtime.getColumn() + "]");
	}
}
