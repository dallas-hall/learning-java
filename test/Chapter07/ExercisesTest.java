package Chapter07;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExercisesTest
{
	private Exercises runtime;

	@org.junit.jupiter.api.BeforeEach
	void setUp()
	{
		runtime = new Exercises();
	}

	@org.junit.jupiter.api.Test
	void approximateSquareRoot()
	{
		// Must be <= 0.000001 or the results won't be accurate
		double checkDifference = 0.000001;
		for (int i = 1; i < 10; i++) {
			double answer =runtime.approximateSquareRoot(i * i, checkDifference);
			System.out.println("Square root of " + (i * i) + " is " + answer);
			assertEquals((double) i, answer);
		}
	}

	@org.junit.jupiter.api.Test
	void powerIterative()
	{
		for (int i = 0; i < 8; i++) {
			double answer = runtime.powerIterative(2, i);
			System.out.println("2 ^ " + i + " is " + answer);
			assertEquals(Math.pow(2, i), answer);
		}
	}

	@org.junit.jupiter.api.Test
	void factorialIterative()
	{
		int n = 0;
		double checkAnswer = 1.0;
		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, runtime.factorialIterative(n));
		n++;

		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, runtime.factorialIterative(n));
		n++;

		checkAnswer = 2.0;
		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, runtime.factorialIterative(n));
		n++;

		checkAnswer = 6.0;
		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, runtime.factorialIterative(n));
		n++;

		checkAnswer = 24.0;
		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, runtime.factorialIterative(n));
		n++;

		checkAnswer = 120.0;
		System.out.println(n + "! is " + checkAnswer);
		assertEquals(checkAnswer, runtime.factorialIterative(n));
	}

	@org.junit.jupiter.api.Test
	void myExp()
	{
		// The number of rounds determines how accurate the approximation is.
		int rounds = 20;
		double answer = runtime.myExp(1.0, rounds);
		assertEquals(2.7182818284590455, answer);
		System.out.println("2.7182818284590455 is expected and myExp ^ 1 produced " + answer );
	}

	@org.junit.jupiter.api.Test
	void myExp2()
	{
		// The number of rounds determines how accurate the approximation is.
		int rounds = 20;
		double answer = runtime.myExp2(1.0, rounds);
		assertEquals(2.7182818284590455, answer);
		System.out.println("2.7182818284590455 is expected and myExp2 ^ 1 produced " + answer );
	}
}
