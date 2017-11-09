package chapter30_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by blindcant on 22/10/17.
 */
public class ThreadSafeImplicitLockDemo
{
	
	
	//@@@ CONSTRUCTOR(S) @@@
	
	//@@@ INSTANCE VARIABLES @@@
	private static Account account = new Account();
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		
		// Create and launch 100 threads
		for (int i = 0; i < 100; i++)
		{
			executor.execute(new AddAPennyTask());
		}
		
		executor.shutdown();
		
		// Wait until all tasks are finished
		while (!executor.isTerminated())
		{
		}
		
		System.out.println("What is balance? " + account.getBalance());
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	
	//### SETTERS ###
	
	//### HELPERS ###
	
	
	//@@@ INNER CLASSES @@@
	// A thread for adding a penny to the account
	private static class AddAPennyTask implements Runnable
	{
		public void run()
		{
			//account.depositNotThreadSafe(1);
			//account.depositThreadSafeViaMethod(1);
			account.depositThreadSafeViaCodeBlock(1);
		}
	}
	
	// An inner class for account
	private static class Account
	{
		private int balance = 0;
		
		public int getBalance()
		{
			return balance;
		}
		
		//this method is not thread safe
		public void depositNotThreadSafe(int amount)
		{
			int newBalance = balance + amount;
			
			// This delay is deliberately added to magnify the
			// data-corruption problem and make it easy to see.
			try
			{
				Thread.sleep(5);
			} catch (InterruptedException ex)
			{
			}
			
			balance = newBalance;
		}
		
		//this method is thread safe because of the synchronized keyword in the header - which uses implict object/class locking to resource handling
		public synchronized void depositThreadSafeViaMethod(int amount)
		{
			int newBalance = balance + amount;
			
			// This delay is deliberately added to magnify the
			// data-corruption problem and make it easy to see.
			try
			{
				Thread.sleep(5);
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
			
			balance = newBalance;
		}
		
		//this method is thread safe because of the synchronized keyword inside of it - which uses implict object/class locking to resource handling
		public void depositThreadSafeViaCodeBlock(int amount)
		{
			synchronized (this)
			{
				int newBalance = balance + amount;
				
				// This delay is deliberately added to magnify the
				// data-corruption problem and make it easy to see.
				try
				{
					Thread.sleep(5);
				} catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
				
				balance = newBalance;
			}
		}
	}
}
