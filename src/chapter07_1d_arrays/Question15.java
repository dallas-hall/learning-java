package chapter07_1d_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>Unique Array Elements</h1>
 * <p>
 * This program will accept an array with duplicates and return an array with unique values.
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-22
 */
public class Question15
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		int[] duplicates = {0, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 7, 8, 9,};
		System.out.println(Arrays.toString(duplicates));
		System.out.println(Arrays.toString(returnUniqueArray(duplicates)));
	}
	//@@@ METHODS @@@
	//### HELPERS ###
	private static int[] returnUniqueArray(int[] start)
	{
		int startLength = start.length;
		int size = 0;
		int[] processing = new int[startLength];
		boolean duplicateFound = false;
		
		for(int i = 0 ; i < startLength; i++)
		{
			// Always store the first number
			if(i == 0)
			{
				processing[i] = start[i];
				size++;
				continue;
			}
			// Check all other numbers
			for(int j = 0; j < size; j++)
			{
				// Go through all indices in the processing array and check them against the starting array
				if(processing[j] == start[i])
				{
					// Exit if a duplicate is found
					duplicateFound = true;
					break;
				}
			}
			// if no duplicates are found
			if(!duplicateFound)
			{
				processing[size] = start[i];
				size++;
			}
			
			// Reset after previous run
			duplicateFound = false;
		}
		
		int[] unique = new int[size];
		for(int i = 0; i < size; i++)
		{
			unique[i] = processing[i];
		}
		return unique;
	}
}
