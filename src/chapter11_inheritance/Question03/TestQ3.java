package chapter11_inheritance.Question03;

import chapter09_objects_and_classes.Question07;

/**
 * Created by blindcant on 4/05/17.
 */
public class TestQ3
{
	//INSTANCE VARIABLES
	private static Question07[] accountArray = new Question07[10];
	private static int arrayCount = 0;
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		accountArray[arrayCount++] = new Question07("Donny Darko", 5000, 3);
		accountArray[arrayCount++] = new SavingsAccount("Donny Darko", 20000, 6, 1000);
		
		printArray();
		
		accountArray[1].withdraw(18000);
		System.out.println(accountArray[1].toString());
		
		accountArray[1].withdraw(1800);
		System.out.println(accountArray[1].toString());
		
		accountArray[1].getMonthlyInterest();
		System.out.println(accountArray[1].toString());
	}
	
	//CONSTRUCTOR(S)
	
	
	//METHODS
	public static void printArray()
	{
		for (int i = 0; i < arrayCount; i++)
		{
			System.out.println(accountArray[i].toString());
		}
	}
}
