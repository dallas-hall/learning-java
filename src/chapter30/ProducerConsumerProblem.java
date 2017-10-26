package chapter30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by blindcant on 22/10/17.
 * https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem
 */
public class ProducerConsumerProblem
{
	//@@@ INSTANCE VARIABLES @@@
	private Buffer buffer = new Buffer();
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		ProducerConsumerProblem runtime = new ProducerConsumerProblem();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public ProducerConsumerProblem()
	{
		// Create a thread pool with two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		// Create and submit 2 tasks for the Executor
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		
		// Close the Executor once it has finished running its threads.
		executor.shutdown();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	
	//### SETTERS ###
	
	//### HELPERS ###
	
	//@@@ INNER CLASSES @@@
	// A task for adding an int to the buffer
	private class ProducerTask implements Runnable
	{
		public void run()
		{
			try
			{
				// This is an infinite loop which tries to write to a non-empty buffer with a number that increments each loop iteration.
				int i = 1;
				while (true)
				{
					System.out.println("Producer writes " + i);
					// Add a value to the buffer and increment, but write() has locks that coordinate with read() - so this may not occur immediately.
					buffer.write(i++);
					// Put the thread into sleep
					Thread.sleep((int) (Math.random() * 10000));
				}
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	// A task for reading and deleting an int from the buffer
	private class ConsumerTask implements Runnable
	{
		public void run()
		{
			try
			{
				// This is an infinite loop which tries to read from a non-empty buffer.
				while (true)
				{
					// Try to read a value from the buffer, but read() has locks that coordinate with write() - so this may not occur immediately.
					System.out.println("\t\t\tConsumer reads " + buffer.read());
					// Put the thread into sleep
					Thread.sleep((int) (Math.random() * 10000));
				}
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	// An inner class for buffer
	private class Buffer
	{
		private static final int CAPACITY = 1; // buffer size
		private java.util.LinkedList<Integer> queue = new java.util.LinkedList<>();
		
		// Create a new lock
		private Lock lock = new ReentrantLock();
		
		// Create two conditions and assign them to the lock
		private Condition notEmpty = lock.newCondition();
		private Condition notFull = lock.newCondition();
		
		public void write(int value)
		{
			// Acquire the lock
			lock.lock();
			try
			{
				// Check that there is 1 item in the queue (i.e. buffer is full)
				while (queue.size() == CAPACITY)
				{
					System.out.println("Wait for notFull condition");
					// Current thread is told to wait for notFull condition, because the buffer is currently full.
					notFull.await();
				}
				
				// Once the queue is not full, we can add the value to the queue.
				queue.offer(value);
				// Signal notEmpty condition to other threads, as the buffer is no longer empty.
				notEmpty.signal();
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			} finally
			{
				// Always release the lock
				lock.unlock();
			}
		}
		
		public int read()
		{
			int value = 0;
			// Acquire the lock
			lock.lock();
			try
			{
				// Check that the queue is empty
				while (queue.isEmpty())
				{
					System.out.println("\t\t\tWait for notEmpty condition");
					// Current thread is told to wait for notEmpty condition, because the buffer is currently empty.
					notEmpty.await();
				}
				
				// Once the buffer isn't empty, remove the value.
				value = queue.remove();
				// Signal notFull condition to other threads, as the buffer is currently empty.
				notFull.signal();
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			} finally
			{
				// Always release the lock
				lock.unlock();
				// Return the value that was read from the buffer.
				return value;
			}
		}
	}
}

