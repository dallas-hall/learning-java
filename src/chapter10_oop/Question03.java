package chapter10_oop;

/**
 * Created by blindcant on 23/04/17.
 */
public class Question03
{
	//INSTANCE VARIABLES
	private int value;
	
	//CONSTRUCTORS
	public Question03(int inputValue)
	{
		this.value = inputValue;
	}
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question03 myInt1 = new Question03(3);
		System.out.println(myInt1.getValue() + " is prime? " + myInt1.isPrime(myInt1.getValue()));
		System.out.println(myInt1.getValue() + " is prime v2? " + myInt1.isPrime2(myInt1.getValue()));
		System.out.println(myInt1.getValue() + " is even? " + myInt1.isEven(myInt1.getValue()));
		System.out.println(myInt1.getValue() + " is odd? " + myInt1.isOdd(myInt1.getValue()));
		System.out.println(myInt1.getValue() + " equals 3? " + myInt1.equals(3));
		System.out.println(myInt1.getValue() + " object int = 3? " + myInt1.equals(myInt1));
		System.out.println();
		Question03 myInt2 = new Question03(4);
		System.out.println(myInt2.getValue() + " is prime? " + myInt2.isPrime(myInt2.getValue()));
		System.out.println(myInt2.getValue() + " is prime v2? " + myInt2.isPrime2(myInt2.getValue()));
		System.out.println(myInt2.getValue() + " is even? " + myInt2.isEven(myInt2.getValue()));
		System.out.println(myInt2.getValue() + " is odd? " + myInt2.isOdd(myInt2.getValue()));
		System.out.println(myInt2.getValue() + " equals 3? " + myInt1.equals(4));
		System.out.println(myInt2.getValue() + " object int = 3? " + myInt1.equals(myInt2));
		System.out.println();
		Question03 myInt3 = new Question03(5);
		System.out.println(myInt3.getValue() + " is prime? " + myInt3.isPrime(myInt3.getValue()));
		System.out.println(myInt3.getValue() + " is prime v2? " + myInt3.isPrime2(myInt3.getValue()));
		System.out.println(myInt3.getValue() + " is even? " + myInt3.isEven(myInt3.getValue()));
		System.out.println(myInt3.getValue() + " is odd? " + myInt3.isOdd(myInt3.getValue()));
		System.out.println(myInt3.getValue() + " equals 3? " + myInt1.equals(5));
		System.out.println(myInt3.getValue() + " object int = 3? " + myInt1.equals(myInt3));
		System.out.println();
		
		char[] intAsCharArray = {'1','2','3'};
		String intAsString = "123";
		System.out.println("Char[] {1,2,3} as an int is: " + parseInt(intAsCharArray));
		System.out.println("String \"123\" as an int is: " + parseInt(intAsString));
	}
	
	//GETTERS
	public int getValue()
	{
		return this.value;
	}
	
	public boolean isEven(int inputValue)
	{
		if (inputValue % 2 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isOdd(int inputValue)
	{
		if (inputValue % 2 == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isPrime(int inputValue)
	{
		//A prime number is any number that only has 2 factors, 1 and itself.
		boolean isPrime = true;
		//check for primes by dividing the starting number from 2 up until starting number - 1
		for (int divisor = 2; divisor <= (inputValue - 1); divisor++)
		{
			//if any of these equations = 0 then the number is not prime
			if (inputValue % divisor == 0)
			{
				isPrime = false;
				return isPrime;
			}
		}
		//return prime only if the above for loop check fails.
		return isPrime;
	}
	
	public boolean isPrime2(int inputValue)
	{
		//A prime number is any number that only has 2 factors, 1 and itself. E.g. 2, 3, 5, 7...
		//if the Number is even (n % 2 = 0) and greater than 2, it isn't prime. Return false immediately
		if (inputValue > 2 && isEven(inputValue))
		{
			return false;
		}
		else if (inputValue == 2)
		{
			return true;
		}
		else
		{
			//if the number can be divided evenly by any number less than itself, it isn't prime
			//we go up by 2 so every divisor being used is always an odd number, as we have already eliminated all evens
			//we use inputValue - 2 because every divisor being uses is always an odd number, thus the highest number we
			// need to check as a divisor is inputValue - 2 as inputValue - 1 is an even number and will never be reached
			for (int divisor = 3; divisor <= (inputValue - 2); divisor+=2)
			{
				if (inputValue % divisor == 0)
				{
					return false;
				}
			}
		}
		//return prime only if the above if/else and for loop check fails.
		return true;
	}

	
	public boolean equals(int inputValue)
	{
		if (inputValue == getValue())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean equals(Question03 inputObject)
	{
		if (inputObject.getValue() == 3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static int parseInt(char[] inputValue)
	{
		String tempString = new String("");
		StringBuilder finalString = new StringBuilder("");
		//convert the char[] inputValue to a String  using toString, and then parse the String to an int using Integer.parseInt
		for (int i = 0; i < inputValue.length; i++)
		{
			//store the char at position i in a temporary String
			tempString = String.valueOf(inputValue[i]);
			//append that temporary String to our StringBuilder
			finalString = finalString.append(tempString);
		}
		//convert the StringBuiler into a String using toString.  convert that into an Integer using parseInt.
		int newValue = Integer.parseInt(finalString.toString());
		return newValue;
	}
	
	public static int parseInt(String inputValue)
	{
		//parse the String to an int using Integer.parseInt
		int newValue = Integer.parseInt(inputValue);
		return newValue;
	}
}
