package chapter11_inheritance.Question03;

import chapter09_objects_and_classes.Question07;

/**
 * <h1>Account Driver</h1>
 * <p>
 * This is the driver class for Account, showcasing inheritance and polymorphism.
 * </p>
 * <p>
 * tags:	inheritance; extends; super class constructor; packages;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-05-04
 */
public class Main
{
	//@@@ INSTANCE VARIABLES @@@
	private static Question07[] accountArray = new Question07[10];
	private static int arrayCount = 0;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		accountArray[arrayCount++] = new Question07("Donny Darko", 5000, 3);
		accountArray[arrayCount++] = new SavingsAccount("Sonny Marko", 20000, 6, 1000);
		
		printArray();
		
		// Should pass
		accountArray[1].withdraw(18000);
		System.out.println(accountArray[1].toString());
		
		// Should fail due to minimum balance
		accountArray[1].withdraw(1800);
		System.out.println(accountArray[1].toString());
		
		// Should calculate
		accountArray[1].getMonthlyInterest();
		System.out.println(accountArray[1].toString());
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	public static void printArray()
	{
		for (int i = 0; i < arrayCount; i++) {
			System.out.println(accountArray[i].toString());
		}
	}
}
