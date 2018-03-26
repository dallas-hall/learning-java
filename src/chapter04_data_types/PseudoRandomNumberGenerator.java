package chapter04_data_types;

import java.util.Random;
// PRNG for >= Java 1.7
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Pseudo Random Number Generators</h1>
 * <p>
 * This program displays a variety of ways to generate non-cryptographically suitable pseudo-random numbers.
 * </p>
 * <p>
 * tags:	Math.random; prng; Random; ThreadLocalRandom;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-18
 */
public class PseudoRandomNumberGenerator
{
	//@@@ INSTANCE VARIABLES @@@
	private Random prng;
	private Random prngUser;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//create objects
		PseudoRandomNumberGenerator defaultSeedBit = new PseudoRandomNumberGenerator();
		PseudoRandomNumberGenerator seedBit8 = new PseudoRandomNumberGenerator(8);
		PseudoRandomNumberGenerator seedBit128 = new PseudoRandomNumberGenerator(128);
		PseudoRandomNumberGenerator seedBit256 = new PseudoRandomNumberGenerator(256);
		PseudoRandomNumberGenerator seedBit512 = new PseudoRandomNumberGenerator(512);
		
		//print stuff using objects
		defaultSeedBit.prngDefault(10);
		seedBit8.prngUser(16, 8);
		seedBit128.prngUser(16, 128);
		seedBit256.prngUser(16, 256);
		seedBit512.prngUser(16, 512);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public PseudoRandomNumberGenerator(int seedNumberInBits)
	{
		prngUser = new Random(seedNumberInBits);
	}
	
	public PseudoRandomNumberGenerator()
	{
		prng = new Random();
	}
	
	public void prngDefault(int printAmount)
	{
		System.out.println("\n### Printing Default Seed ###");
		for (int i = 0; i < printAmount; i++)
		{
			System.out.println(prng.nextInt());
		}
	}
	
	public void prngUser(int printAmount, int seedNumberInBits)
	{
		System.out.println("\n### Printing User Defined Seed: " + seedNumberInBits + " bits ###");
		for (int i = 0; i < printAmount; i++)
		{
			System.out.println(prngUser.nextInt());
		}
	}
	
	
	//@@@ METHODS @@@
	//### HELPERS ###
	public void roll6SidedDice(int times)
	{
		for (int i = 0; i < times; i++)
		{
			//produces a random number between 0 (inclusive) and n (exclusive)
			//by adding 1 we never return 0 and we can return sides
			//sides is 6, the roll will be between 1 and 6.
			int roll = prng.nextInt(6) + 1;
			System.out.println("On roll " + (i + 1) + " the 6 sided di has rolled: " + roll);
		}
	}
	
	public void rollDice(int sides, int times)
	{
		for (int i = 0; i < times; i++)
		{
			//produces a random number between 0 (inclusive) and n (exclusive)
			//by adding 1 we never return 0 and we can return sides
			// e.g. if sides is 6, the roll will be between 1 and 6.
			int roll = prng.nextInt(sides) + 1;
			System.out.println("On roll " + (i + 1) + " the " + sides + " sided di has rolled: " + roll);
		}
	}
	
	//exercise 5.19
	public int prngBetween1andMax(int max)
	{
		//add 1 to the number so it generates between 1 and max, instead of 0 and max - 1
		int prn = prng.nextInt(max) + 1;
		return prn;
	}
	
	public void test519(int max, int amount)
	{
		for (int i = 0; i < amount; i++)
		{
			System.out.println(prngBetween1andMax(max));
		}
	}
	
	//exercise 5.20
	public int prngBetweenMinandMax(int min, int max)
	{
		/*
		 * https://stackoverflow.com/a/363692
		 *
		 * step 1, generate a number between 0 and (max - min) excluding ((max - min) + 1)
		 * step 2, add min to that number
		 *
		 * example, min = 5 and max = 10
		 *
		 * step 1, generate a number between 0 and 5 (10 - 5 = 5), excluding 6 ((10 - 5) + 1) = 6
		 * step 2, n + min = answer (n can only be 0 - 5)
		 *
		 * 0 + 5 = 5
		 * 1 + 5 = 6
		 * 2 + 5 = 7
		 * 3 + 5 = 8
		 * 4 + 5 = 9
		 * 5 + 5 = 10
		 *
		 */
		int prnRandomnextInt = prng.nextInt((max - min) + 1) + min;
		
		/*
		 * THIS INTRODUCES A BIAS THOUGH - the highest values may not be reached.
		 *
		 * https://stackoverflow.com/a/363732
		 *
		 * Math.random() returns a number between 0 and 1.0, excluding 1.0
		 * (int)(Math.random * 10) returns a number between 0 and 10, excluding 10
		 * a + (int)(Math.random * b) returns a number between a and a + b, excluding a + b
		 *
		 * example, min = 5 and max = 10 (Note the math logic is the same as above)
		 *
		 * 5 + (int)(Math.random() * ((max - min) + 1));
		 *
		 * step 1, (10 - 5) + 1 = 6
		 * step 2, generate a number between 0 and 5, excluding 6
		 * step 3, add min to that number
		 *
		 */
		int prnMathrandom = min + (int) (Math.random() * ((max - min) + 1));
		
		/*
		 * https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadLocalRandom.html#nextInt-int-int-
		 *
		 * returns a number between min (inclusive) and max (exclusive).  So add one to max to include it.
		 */
		int prnThreadLocalRandom = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		return prnThreadLocalRandom;
	}
	
	public void test520(int min, int max, int amount)
	{
		for (int i = 0; i < amount; i++)
		{
			System.out.println(prngBetweenMinandMax(min, max));
		}
	}
}
