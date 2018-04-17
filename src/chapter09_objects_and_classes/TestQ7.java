package chapter09_objects_and_classes;

/**
 * <h1>Account Class Driver</h1>
 * <p>
 * This program is the driver class for the Account program. It creates Account objects and performs transactions on them.
 * </p>
 * <p>
 * tags:	constructor; dot notation;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-05-05
 */
public class TestQ7
{
	//@@@ MAIN METHOD @@@
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
}
