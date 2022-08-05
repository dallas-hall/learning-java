package Chapter10;


import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExercisesTest
{
	private static BigIntegerFactorial bigIntegerFactorial;
	private static BigIntegerPowerRecursive bigIntegerPowerRecursive;
	
	@org.junit.jupiter.api.BeforeAll
	static void initAll()
	{
		bigIntegerFactorial = new BigIntegerFactorial();
		bigIntegerPowerRecursive = new BigIntegerPowerRecursive();

	}
	
	@org.junit.jupiter.api.Test
	void factorialIterativeBigInteger()
	{
		int n = 0;
		BigInteger checkAnswer = BigInteger.ONE;
		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, bigIntegerFactorial.factorialIterativeBigInteger(n));
		n++;
		
		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, bigIntegerFactorial.factorialIterativeBigInteger(n));
		n++;
		
		checkAnswer = BigInteger.TWO;
		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, bigIntegerFactorial.factorialIterativeBigInteger(n));
		n++;
		
		checkAnswer = BigInteger.valueOf(6);
		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, bigIntegerFactorial.factorialIterativeBigInteger(n));
		n++;
		
		checkAnswer = BigInteger.valueOf(24);
		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, bigIntegerFactorial.factorialIterativeBigInteger(n));
		n++;
		
		checkAnswer = BigInteger.valueOf(120);
		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, bigIntegerFactorial.factorialIterativeBigInteger(n));
	}
	
	@org.junit.jupiter.api.Test
	void powerRecursionInt()
	{
		int startNumber = 2;
		for (int i = 0; i < 17; i++) {
			System.out.printf("%s %s.\n", startNumber + " ^ " + i + " is", bigIntegerPowerRecursive.powerRecursionInt(startNumber, i)) ;
			assertEquals(Math.pow(startNumber, i), bigIntegerPowerRecursive.powerRecursionInt(startNumber, i));
		}
	}
	
	@org.junit.jupiter.api.Test
	void powerRecursiveBigInteger()
	{
		int startNumber = 2;
		for (int i = 0; i < 17; i++) {
			System.out.printf("%s %s.\n", startNumber + " ^ " + i + " is", bigIntegerPowerRecursive.powerRecursiveBigInteger(startNumber, i)) ;
			// Need to cast the double to an int as BigInteger only works with int
			assertEquals(BigInteger.valueOf((int) Math.pow(startNumber, i)), bigIntegerPowerRecursive.powerRecursiveBigInteger(startNumber, i));
		}
	}
}
