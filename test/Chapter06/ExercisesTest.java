package Chapter06;

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
	void isDivisible()
	{
		assertEquals(true, runtime.isDivisible(9, 3));
		assertEquals(false, runtime.isDivisible(9, 4));
	}

	@org.junit.jupiter.api.Test
	void canCreateTriangle()
	{
		assertEquals(true, runtime.canCreateTriangle(1, 2, 3));
		assertEquals(false, runtime.canCreateTriangle(1, 2, 4));
	}

	@org.junit.jupiter.api.Test
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
}