package Chapter11;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>RationalNumber</h1>
 * <p>
 * This program creates rational numbers and ways to manipulate them.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-09
 */

// https://www.mathsisfun.com/rational-numbers.html
public class RationalNumber
{
	//@@@ CLASS VARIABLES @@@
	
	//@@@ INSTANCE VARIABLES @@@
	private int numerator;
	private int denominator;
	
	//@@@ CONSTRUCTOR(S) @@@
	public RationalNumber()
	{
		this.numerator = 0;
		this.denominator = 1;
	}
	
	public RationalNumber(int numerator, int denominator)
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getNumerator()
	{
		return numerator;
	}
	
	public int getDenominator()
	{
		return denominator;
	}
	
	
	//### SETTERS ###
	public void setNumerator(int numerator)
	{
		this.numerator = numerator;
	}
	
	public void setDenominator(int denominator)
	{
		this.denominator = denominator;
	}
	
	//### HELPERS ###
	@Override
	public String toString()
	{
		// a single ( is needed to enclose negative numbers, otherwise - is displayed
		return String.format("%d/%d", numerator, denominator);
	}
	
	public boolean equals(RationalNumber that)
	{
		return this.numerator == that.numerator &&
			this.denominator == that.denominator;
	}
	
	public void printRationalNumber()
	{
		System.out.println(this.toString());
	}
	
	public void flipRationalNumber()
	{
		int temp = numerator;
		numerator = denominator;
		denominator = temp;
	}
	
	// https://www.math-only-math.com/negative-rational-number.html
	public void negateRationalNumber()
	{
		int prn = ThreadLocalRandom.current().nextInt(1, 1000);
		if (prn <= 500) {
			int temp = numerator;
			numerator = 0 - numerator;
		}
		else {
			int temp = denominator;
			denominator = 0 - denominator;
		}
	}
	
	public double toDouble()
	{
		// https://www.mathsisfun.com/converting-fractions-decimals.html
		return ((double) numerator) / ((double) denominator);
	}
	
	public int gcdEuclidSubtractionRecursion(int a, int b)
	{
		// https://en.wikipedia.org/wiki/Euclidean_algorithm
		/*
		The Euclid subtraction algorithm works as follows.
		
		1) Start with 2 numbers, a and b.
		2) Find the difference between a and b (large -  small)
		3) Repeat step 2 until a = b or both are 0. This is the GCD.
		
		Many subtraction steps are necessary so it can be improved with division remainder.
		 */
		
		int c = Integer.MIN_VALUE;
		int recursionResult = Integer.MIN_VALUE;
		if(a == b) {
			return a;
		}
		
		if (a > b)
		{
			c = a - b;
			recursionResult = gcdEuclidSubtractionRecursion(b, c);
		} else {
			c = b - a;
			recursionResult = gcdEuclidSubtractionRecursion(a, c);
		}
		return recursionResult;
	}
	
	public int gcdEuclidModuloRecursion(int a, int b)
	{
		/*
		The Euclid division remainder algorithm
		
		1) Start with 2 numbers, a and b.
		2) Reduce the large number. a is now b and b is now a % b.
		3) Repeat 2 until the remainder is 0.
		 */
		
		if (b == 0) {
			return a;
		} else {
			int t = a % b;
			int recursionResult = gcdEuclidModuloRecursion(b, t);
			return recursionResult;
		}
	}
	
	public RationalNumber reduce()
	{
		// https://www.mathsisfun.com/least-common-denominator.html
		// https://www.mathsisfun.com/numbers/common-denominator.html
		int gcd = gcdEuclidModuloRecursion(numerator, denominator);
		return new RationalNumber(numerator / gcd, denominator / gcd);
	}
	
	public RationalNumber addRationals(int numerator, int denominator)
	{
		// https://www.mathsisfun.com/fractions_addition.html
		int lcd = this.denominator * denominator;
		int numeratorA = this.numerator * (lcd / this.denominator);
		int numeratorB = numerator * (lcd / denominator);
		RationalNumber t = new RationalNumber(numeratorA + numeratorB, lcd);
		this.numerator = t.getNumerator();
		this.denominator = t.getDenominator();
		return this.reduce();
	}
}
