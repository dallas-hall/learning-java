package chapter09_objects_and_classes;

/**
 * Created by blindcant on 4/05/17.
 */
public class TestQ7
{
	//INSTANCE VARIABLES
	
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question07 account1 = new Question07("Donny Darko", 20000, 4.5);
		
		System.out.println(account1.toString());
		System.out.println();
		
		account1.withdraw(2500);
		System.out.println("Currnet balance: " + account1.getAccountBalance());
		
		account1.deposit(3000);
		System.out.println("Currnet balance: " + account1.getAccountBalance());
		
		account1.getMonthlyInterest();
		System.out.println("Currnet balance: " + account1.getAccountBalance());
		
	}
	
	//CONSTRUCTOR(S)
	
	
	//METHODS
	
}
