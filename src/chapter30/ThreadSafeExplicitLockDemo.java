package chapter30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by blindcant on 22/10/17.
 */
public class ThreadSafeExplicitLockDemo
{
	//@@@ INSTANCE VARIABLES @@@
	private Account account = new Account();
	
	//@@@ CONSTRUCTOR(S) @@@
	public ThreadSafeExplicitLockDemo()
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
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		ThreadSafeExplicitLockDemo runtime = new ThreadSafeExplicitLockDemo();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	
	//### SETTERS ###
	
	//### HELPERS ###
	
	
	//@@@ INNER CLASSES @@@
	// A thread for adding a penny to the account
	private class AddAPennyTask implements Runnable
	{
		public void run()
		{
			//this becomes thread safe because of the implicit resource lock
			account.depositNotThreadSafe(1);
		}
	}
	
	// An inner class for account
	private class Account
	{
		//create the Lock object
		private Lock aLock = new ReentrantLock();
		private int balance = 0;
		
		public int getBalance()
		{
			return balance;
		}
		
		//THE CRITICAL REGION
		//this method is not thread safe
		public void depositNotThreadSafe(int amount)
		{
			//get and apply the lock
			aLock.lock();
			try
			{
				int newBalance = balance + amount;
				
				// This delay is deliberately added to magnify the
				// data-corruption problem and make it easy to see.
				Thread.sleep(5);
				
				balance = newBalance;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				//release the lock always - if we don't there will be a deadlock
				aLock.unlock();
			}
		}
		
	}
}
