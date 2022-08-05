package Chapter06;

import Chapter06.FibonacciRecursion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciRecursionTest
{
	FibonacciRecursion runtime;
	
	@BeforeEach
	void setUp()
	{
		runtime = new FibonacciRecursion(5);
	}
	
	@AfterEach
	void tearDown()
	{
		runtime = null;
	}
	
	@Test
	void getLimit()
	{
		assertEquals(5, runtime.getLimit());
	}
	
	@Test
	void fibonacci()
	{
		assertEquals(1, runtime.fibonacci(1));
		assertEquals(1, runtime.fibonacci(2));
		assertEquals(2, runtime.fibonacci(3));
	}
}