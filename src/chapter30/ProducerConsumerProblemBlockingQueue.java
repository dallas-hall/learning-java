package chapter30;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by blindcant on 22/10/17.
 * https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem
 */
public class ProducerConsumerProblemBlockingQueue
{
	//@@@ INSTANCE VARIABLES @@@
	private ArrayBlockingQueue<Integer> buffer;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//create the object and run it
		//ProducerConsumerProblemBlockingQueue runtime = new ProducerConsumerProblemBlockingQueue(1);
		ProducerConsumerProblemBlockingQueue runtime = new ProducerConsumerProblemBlockingQueue(2);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public ProducerConsumerProblemBlockingQueue(int capacity)
	{
		// Create the blocking queue which handles the coordinated locking
		buffer = new ArrayBlockingQueue<>(capacity);
		
		// Create a thread pool with two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		// Create and submit 2 tasks for the Executor
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		
		// Close the Executor once it has finished running its threads.
		executor.shutdown();
	}

	
	//@@@ INNER CLASSES @@@
	// A task for adding an int to the buffer
	private class ProducerTask implements Runnable
	{
		public void run()
		{
			try
			{
				// Run an infinite loop that tries to write integers to the buffer. The blocking queue handles resource sharing and locking when the queue is empty or full.
				int i = 1;
				while (true)
				{
					System.out.println("Producer writes " + i);
					// Add an integer to the buffer
					buffer.put(i++);
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
				// Run an infinite loop that tries to read and remove integers from the buffer.  The blocking queue handles resource sharing and locking when the queue is empty or full.
				while (true)
				{
					// Remove an integer from the buffer
					System.out.println("\t\t\tConsumer reads " + buffer.take());
					// Put the thread into sleep
					Thread.sleep((int) (Math.random() * 10000));
				}
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
