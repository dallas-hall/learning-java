package Chapter08;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExercisesTest
{

	private static Factors factors;
	private static Reduce reduce;
	
	@org.junit.jupiter.api.BeforeAll
	static void initAll()
	{
 		factors = new Factors();
 		reduce = new Reduce();
	}
	
	@org.junit.jupiter.api.Test
	void areFactors()
	{
		assertEquals(true, factors.areFactors(1, new int[]{1}));
		assertEquals(true, factors.areFactors(2, new int[]{2}));
		assertEquals(false, factors.areFactors(4, new int[]{1, 2, 4, 8}));
		assertEquals(true, factors.areFactors(8, new int[]{1, 2, 4, 8}));
	}
	
	@org.junit.jupiter.api.Test
	void arePrimerFactors()
	{
		assertEquals(false, factors.arePrimerFactors(1, new int[]{1}));
		assertEquals(true, factors.arePrimerFactors(2, new int[]{2}));
		assertEquals(false, factors.arePrimerFactors(4, new int[]{1, 2, 4, 8}));
		assertEquals(false, factors.arePrimerFactors(8, new int[]{1, 2, 4, 8}));
	}
	
	@org.junit.jupiter.api.Test
	void min()
	{
		int[] a = {10, 20, 30};
		assertEquals(10, reduce.min(a));
	}
	
	@org.junit.jupiter.api.Test
	void max()
	{
		int[] a = {10, 20, 30};
		assertEquals(30, reduce.max(a));
	}
	
	@org.junit.jupiter.api.Test
	void sum()
	{
		int[] a = {10, 20, 30};
		assertEquals(60, reduce.sum(a));
	}
	
	@org.junit.jupiter.api.Test
	void count()
	{
		int[] a = {10, 20, 30};
		assertEquals(3, reduce.count(a));
	}
	
	@org.junit.jupiter.api.Test
	void minRecursive()
	{
		int[] a = {10, 20, 30};
		assertEquals(10, reduce.minRecursive(a, 0, a.length - 1));
	}
	
	@org.junit.jupiter.api.Test
	void maxRecursive()
	{
		int[] a = {10, 20, 30};
		assertEquals(30, reduce.maxRecursive(a, 0, a.length - 1));
	}
	
	@org.junit.jupiter.api.Test
	void sumRecursive()
	{
		int[] a = {10, 20, 30};
		assertEquals(60, reduce.sumRecursive(a, 0, a.length - 1));
	}
	
	@org.junit.jupiter.api.Test
	void countRecursive()
	{
		int[] a = {10, 20, 30};
		assertEquals(3, reduce.countRecursive(a, 0, a.length - 1));
	}
}
