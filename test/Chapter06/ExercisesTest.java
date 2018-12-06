package Chapter06;

import Chapter06.Exercises;

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

}