package chapter30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by blindcant on 22/10/17.
 */
public class ThreadCooperationDemo
{
	//@@@ INSTANCE VARIABLES @@@
	private Account account = new Account();
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		ThreadCooperationDemo runtime = new ThreadCooperationDemo();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public ThreadCooperationDemo()
	{
		// Create a thread pool with two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		//create 2 Runnable tasks that can be executed in the thread pool
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		
		//close the executor once it has finished running its threads
		executor.shutdown();
		
		System.out.println("Thread 1\t\tThread 2\t\tBalance");
	}
	//@@@ METHODS @@@
	//### GETTERS ###
	
	//### SETTERS ###
	
	//### HELPERS ###
	
	//@@@ INNER CLASSES @@@
	public class DepositTask implements Runnable
	{
		@Override // Keep adding an amount to the account
		public void run()
		{
			try
			{ // Purposely delay it to let the withdraw method proceed
				while (true)
				{
					account.deposit((int) (Math.random() * 10) + 1);
					Thread.sleep(1000);
				}
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public class WithdrawTask implements Runnable
	{
		@Override // Keep subtracting an amount from the account
		public void run()
		{
			while (true)
			{
				account.withdraw((int) (Math.random() * 10) + 1);
			}
		}
	}
	
	// An inner class for account
	private class Account
	{
		// Create a new lock
		private Lock lock = new ReentrantLock();
		
		// Create a condition
		private Condition newDeposit = lock.newCondition();
		
		private int balance = 0;
		
		public int getBalance()
		{
			return balance;
		}
		
		public void withdraw(int amount)
		{
			lock.lock(); // Acquire the lock
			try
			{
				while (balance < amount)
				{
					System.out.println("\t\t\tWait for a deposit");
					// Signal to all threads wanting to withdraw that they must wait
					newDeposit.await();
				}
				
				balance -= amount;
				System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			} finally
			{
				lock.unlock(); // Release the lock
			}
		}
		
		public void deposit(int amount)
		{
			lock.lock(); // Acquire the lock
			try
			{
				balance += amount;
				System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
				
				// Signal to all threads wanting to withdraw that they can now withdraw
				newDeposit.signalAll();
			} finally
			{
				lock.unlock(); // Release the lock
			}
		}
	}
}

