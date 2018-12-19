package Chapter06;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ExercisesTest
{
	private static IsDivisible isDivisible;
	private static CanCreateTriangle canCreateTriangle;

	@org.junit.jupiter.api.BeforeAll
	static void initAll()
	{
		isDivisible = new IsDivisible();
		canCreateTriangle = new CanCreateTriangle();
	}

	@org.junit.jupiter.api.Test
	void isDivisible()
	{
		int number = 10;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0 || i == 1 || i == number) {
				assertEquals(true, isDivisible.isDivisible(number, i));
			}
			else {
				assertEquals(false, isDivisible.isDivisible(number, i));
			}
		}
	}

	@org.junit.jupiter.api.Test
	void canCreateTriangle()
	{
		for (int i = 1; i < 5; i++) {
			int a = 1;
			int b = 2;
			int c = 3;
			if (i % 2 == 1) {
				a *= 1;
				b *= 2;
				c *= 3;
				assertEquals(false, canCreateTriangle.canCreateTriangle(a, b, c));
			} else {
				a *= i;
				b *= i;
				c *= i;
				assertEquals(true, canCreateTriangle.canCreateTriangle(a, b, c));
			}
		}
	}

	/*@org.junit.jupiter.api.Test
	void multaddOperation()
	{
		assertEquals(5.0, runtime.multaddOperation(1, 2, 3));
		assertEquals(16.0, runtime.multaddOperation(2, 4, 8));
	}

	@org.junit.jupiter.api.Test
	void prod()
	{
		assertEquals(24.0, runtime.prod(1, 4));
	}

	@org.junit.jupiter.api.Test
	void prodRewrite()
	{
		assertEquals(24.0, runtime.prodRewrite(1, 4));
	}

	@org.junit.jupiter.api.Test
	void oddSum()
	{
		assertEquals(9, runtime.oddSum(5));
		assertEquals(25, runtime.oddSum(10));
	}

	@org.junit.jupiter.api.Test
	void ackermann()
	{
		assertEquals(2, runtime.ackermann(0, 1));
		assertEquals(4, runtime.ackermann(1, 2));
	}

	@org.junit.jupiter.api.Test
	void power()
	{
		assertEquals(1.0, runtime.power(2, 0));
		assertEquals(2.0, runtime.power(2, 1));
		assertEquals(128.0, runtime.power(2, 7));
		assertEquals(256.0, runtime.power(2, 8));
	}*/
}
