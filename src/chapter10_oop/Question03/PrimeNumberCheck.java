package chapter10_oop.Question03;

/**
 * <h1>Prime Number Checker</h1>
 * <p>
 * This program will check if a number is a prime number. It also has 2 methods to parse integers from chars and Strings.
 * </p>
 * <p>
 * tags:	modulo; prime numbers; parseInt(char); parseInt(String);
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-23
 */
public class PrimeNumberCheck
{
	//@@@ CLASS VARIABLES @@@
	public static int[] numbersToCheck;
	
	//@@@ INSTANCE VARIABLES @@@
	private int value;
	
	//@@@ CONSTRUCTOR(S) @@@
	public PrimeNumberCheck(int inputValue)
	{
		this.value = inputValue;
	}
	
	public PrimeNumberCheck()
	{
		numbersToCheck = new int[10];
		for (int i = 0; i < numbersToCheck.length; i++) {
			numbersToCheck[i] = i;
		}
	}
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
/*		ArrayIndexException myInt1 = new ArrayIndexException(1);
		myInt1.checkSingleNumber(myInt1.getValue(), myInt1);
		ArrayIndexException myInt2 = new ArrayIndexException(2);
		myInt1.checkSingleNumber(myInt2.getValue(), myInt2);
		ArrayIndexException myInt3 = new ArrayIndexException(3);
		myInt1.checkSingleNumber(myInt3.getValue(), myInt3);*/
		
		PrimeNumberCheck intArray = new PrimeNumberCheck();
		intArray.checkArrayOfNumbers(intArray);
		
		char[] intAsCharArray = {'1', '2', '3'};
		String intAsString = "123";
		System.out.println("Char[] {1,2,3} as an int is: " + parseInt(intAsCharArray));
		System.out.println("String \"123\" as an int is: " + parseInt(intAsString));
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getValue()
	{
		return this.value;
	}
	
	public boolean isEven(int inputValue)
	{
		if (inputValue % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isOdd(int inputValue)
	{
		if (inputValue % 2 == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isPrime(int inputValue)
	{
		//A prime number is any number that only has 2 factors, 1 and itself.
		boolean isPrime = true;
		if (inputValue < 2) {
			isPrime = false;
		}
		//check for primes by dividing the starting number from 2 up until starting number - 1
		for (int divisor = 2; divisor <= (inputValue - 1); divisor++) {
			//if any of these equations = 0 then the number is not prime
			if (inputValue % divisor == 0) {
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
		if (inputValue > 2 && isEven(inputValue) || inputValue < 2) {
			return false;
		}
		else if (inputValue == 2) {
			return true;
		}
		else {
			//if the number can be divided evenly by any number less than itself, it isn't prime
			//we go up by 2 so every divisor being used is always an odd number, as we have already eliminated all evens
			//we use inputValue - 2 because every divisor being uses is always an odd number, thus the highest number we
			// need to check as a divisor is inputValue - 2 as inputValue - 1 is an even number and will never be reached
			for (int divisor = 3; divisor <= (inputValue - 2); divisor += 2) {
				if (inputValue % divisor == 0) {
					return false;
				}
			}
		}
		//return prime only if the above if/else and for loop check fails.
		return true;
	}
	
	//### HELPERS ###
	public boolean equals(int inputValue)
	{
		if (inputValue == getValue()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean equals(PrimeNumberCheck inputObject)
	{
		if (inputObject.getValue() == 3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int parseInt(char[] inputValue)
	{
		String tempString = new String("");
		StringBuilder finalString = new StringBuilder("");
		//convert the char[] inputValue to a String  using toString, and then parse the String to an int using Integer.parseInt
		for (int i = 0; i < inputValue.length; i++) {
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
	
	public void checkSingleNumber(int number, PrimeNumberCheck inputObject)
	{
		System.out.println(number + " is prime? " + inputObject.isPrime(number));
		System.out.println(number + " is prime v2? " + inputObject.isPrime2(number));
		System.out.println(number + " is even? " + inputObject.isEven(number));
		System.out.println(number + " is odd? " + inputObject.isOdd(number));
		System.out.println(number + " equals 3? " + inputObject.equals(3));
		System.out.println(number + " object int = 3? " + inputObject.equals(inputObject));
		System.out.println();
	}
	
	public void checkArrayOfNumbers(PrimeNumberCheck inputObject)
	{
		for (int i = 0; i < PrimeNumberCheck.numbersToCheck.length; i++) {
			checkSingleNumber(PrimeNumberCheck.numbersToCheck[i], inputObject);
		}
	}
}
