package chapter06_methods;

import java.util.Arrays;

/**
 * <h1>>Manual Number Sorting</h1>
 * <p>
 * This program will generate random numbers and then sort them in ascending and descending order using an array.
 * </p>
 * <p>
 * tags: Math.random; anonymous array; varags (arguments as arrays);
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-24
 */
public class Question05_Array_Sorting
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//create a random number between 0.n and 100.5n
		Question05_Array_Sorting run1 = new Question05_Array_Sorting((double)(Math.random() * 101.5), (double)(Math.random() * 101.5), (double)(Math.random() * 101.5));
		//create a random number between 0 and 15
		Question05_Array_Sorting run2 = new Question05_Array_Sorting((int)(Math.random() * 16), (int)(Math.random() * 16), (int)(Math.random() * 16), (int)(Math.random() * 16));
		//create a random number between 0 and 1000
		Question05_Array_Sorting run3 = new Question05_Array_Sorting((int)(Math.random() * 1001), (int)(Math.random() * 1001), (int)(Math.random() * 1001), (int)(Math.random() * 1001), (int)(Math.random() * 1001));
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	// Accept any number of doubles and store it into an array
	Question05_Array_Sorting(double... inputNumbers)
	{
		System.out.println("Starting numbers are: " + Arrays.toString(inputNumbers));
		// Anonymous array - https://stackoverflow.com/a/1154027
		try
		{
			//System.out.println("Ascending sorted numbers are: " + Arrays.toString(displaySortedNumbers(new double[] {inputNumber1, inputNumber2, inputNumber3}, 'a')));
			System.out.println("Ascending sorted numbers are: " + Arrays.toString(displaySortedNumbers(inputNumbers, 'a')));
			System.out.println("Descending sorted numbers are: " + Arrays.toString(displaySortedNumbers(inputNumbers, 'd')));
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println();
		}
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public double[] displaySortedNumbers(double[] inputNumbers, char sortFlag)
	{
		double[] sorted = new double[inputNumbers.length];
		int sortedLength = sorted.length;
		// Add values
		for (int i = 0; i < sortedLength; i++)
		{
			sorted[i] = inputNumbers[i];
		}
		
		// Sort the arrays
		if (sortFlag == 'a' || sortFlag == 'A')
		{
			for (int i = 0; i < sortedLength; i++)
			{
				double startValue = sorted[i];
				int startValueIndex = i;
				double lowestValue = sorted[i];
				int lowestValueIndex = i;

				for (int j = i + 1; j < sortedLength; j++)
				{
					if (sorted[j] < lowestValue)
					{
						lowestValue = sorted[j];
						lowestValueIndex = j;
						
					}
				}
				
				if(startValueIndex != lowestValueIndex)
				{
					sorted[i] = lowestValue;
					sorted[lowestValueIndex] = startValue;
				}
			}
		}
		else if (sortFlag == 'd' || sortFlag == 'D')
		{
			for (int i = 0; i < sortedLength; i++)
			{
				double startValue = sorted[i];
				int startValueIndex = i;
				double highestValue = sorted[i];
				int highestValueIndex = i;
				
				for (int j = i + 1; j < sortedLength; j++)
				{
					if (sorted[j] > highestValue)
					{
						highestValue = sorted[j];
						highestValueIndex = j;
						
					}
				}
				
				if(startValueIndex != highestValue)
				{
					sorted[i] = highestValue;
					sorted[highestValueIndex] = startValue;
				}
			}
		}
		else
		{
			throw new IllegalArgumentException("sortFlag must be a or A for ascending, or d or D for descending.");
		}
		
		return sorted;
	}
}
