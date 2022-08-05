package Chapter06;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExercisesTest
{
	private static IsDivisible isDivisible;
	private static CanCreateTriangle canCreateTriangle;
	private static MultAdd multAdd;
	private static Prod prod;
	private static OddSum oddSum;
	private static Ackermann ackermann;
	private static PowersRecursion powersRecursion;

	@org.junit.jupiter.api.BeforeAll
	static void initAll()
	{
		isDivisible = new IsDivisible();
		canCreateTriangle = new CanCreateTriangle();
		multAdd = new MultAdd();
		prod = new Prod();
		oddSum = new OddSum();
		ackermann = new Ackermann();
		powersRecursion = new PowersRecursion();
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

	@org.junit.jupiter.api.Test
	void multaddOperation()
	{
		assertEquals(5.0, multAdd.multaddOperation(1, 2, 3));
		assertEquals(16.0, multAdd.multaddOperation(2, 4, 8));
	}

	@org.junit.jupiter.api.Test
	void prod()
	{
		assertEquals(24.0, prod.prod(1, 4));
	}

	@org.junit.jupiter.api.Test
	void prodRewrite()
	{
		assertEquals(24.0, prod.prodRewrite(1, 4));
	}

	@org.junit.jupiter.api.Test
	void oddSum()
	{
		assertEquals(9, oddSum.oddSum(5));
		assertEquals(25, oddSum.oddSum(10));
	}

	@org.junit.jupiter.api.Test
	void ackermann()
	{
		assertEquals(2, ackermann.ackermann(0, 1));
		assertEquals(4, ackermann.ackermann(1, 2));
	}

	@org.junit.jupiter.api.Test
	void power()
	{
		for (int i = 0; i < 17; i++) {
			assertEquals(Math.pow(2, i), powersRecursion.power(2, i));
		}
	}
}
