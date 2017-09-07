package chapter06;

/**
 * Created by blindcant on 24/04/17.
 */
public class Question04
{
	//INSTANCE VARIABLES
	
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question04 run1 = new Question04(4567);
		Question04 run2 = new Question04(987654321);
		Question04 run3 = new Question04(123456789);
	}
	
	//CONSTRUCTOR(S)
	public Question04(int startNumber)
	{
		//print the result
		System.out.println("Start number: " + startNumber + " & reversed number: " + reverseInt2(startNumber));
	}
	
	//METHODS
	public void reverseInt(int inputNumber)
	{
		int arraySize = Integer.toString(inputNumber).length();
		//create an array used for temporary swapping
		char tmpCharArray[] = new char[arraySize];
		//create an array that is the size of all the digits in our number
		char reversedArray[] = new char[arraySize];
		
		
		//use for loop to split out the startNumber in the temp array
		//or just use toCharArray function
/*		for (int i = 0; i < arraySize; i++)
		{
			//extract each char from the int
			char tmp1 = Integer.toString(inputNumber).charAt(i);
			//store into the tmp array
			tmpCharArray[i] = tmp1;
			System.out.print(tmpCharArray[i] + " ");
		}*/
		tmpCharArray = Integer.toString(inputNumber).toCharArray();
		
		//reverse the array
		for (int i = 0, j = arraySize - 1; i < arraySize; i++, j--)
		{
			reversedArray[i] = tmpCharArray[j];
		}
		System.out.println();
		
		//convert the array to String then back to integer
		String tmpString = "";
		for (int i = 0; i < arraySize; i++)
		{
			
			System.out.print(reversedArray[i] + " ");
			tmpString = tmpString.concat(Character.toString(reversedArray[i]));
		}
		System.out.println();
		
		//print the reversed int
		System.out.println(Integer.parseInt(tmpString));
	}
	
	public int reverseInt2(int inputNumber)
	{
		//set up variables
		long reversedNumber = 0;
		long inputNumberAsLong = inputNumber;
		
		while (inputNumberAsLong != 0)
		{
			//times value by 10 to increase its place value
			//modulo input long by 10 to extract the value in the ones place (by remove everything that isn't a ones)
			reversedNumber = reversedNumber * 10 + inputNumberAsLong % 10;
			//divide by 10 to remove the value in the ones place
			inputNumberAsLong = inputNumberAsLong / 10;
		}
		
		//error handling
		if (reversedNumber > Integer.MAX_VALUE || reversedNumber < Integer.MIN_VALUE)
		{
			throw new IllegalArgumentException();
		}
		return (int) reversedNumber;
	}
}
