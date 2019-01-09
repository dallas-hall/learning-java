package Chapter10;


import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExercisesTest
{
	private static BigIntegerFactorial bigIntegerFactorial;
	
	@org.junit.jupiter.api.BeforeAll
	static void initAll()
	{
		bigIntegerFactorial = new BigIntegerFactorial();

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
}
