package chapter10_oop;

/**
 * <h1>Queue Data Structure</h1>
 * <p>
 * This program will use a queue data structure to store integers. A queue is a first-in first-out (FIFO) data structure.
 * </p>
 * <p>
 * tags:	queue; FIFO;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-23
 */
public class QueueOfIntegers
{
	//@@@ CLASS VARIABLES @@@
	public static final int DEFAULT_QUEUE_SIZE = 8;
	
	//@@@ INSTANCE VARIABLES @@@
	private int[] queue;
	private int currentQueueSize = 0;
	
	//@@@ MAIN METHOD @@@
	
	
	//@@@ CONSTRUCTOR(S) @@@
	public QueueOfIntegers()
	{
		queue = new int[DEFAULT_QUEUE_SIZE];
	}
	
	public QueueOfIntegers(int size)
	{
		queue = new int[size];
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getCurrentQueueSize()
	{
		return currentQueueSize;
	}
	
	public int getQueueLength()
	{
		return queue.length;
	}
	
	public int[] getQueue()
	{
		return queue;
	}
	
	public boolean isEmpty()
	{
		return currentQueueSize == 0;
	}
	
	//### HELPERS ###
	/*
	Add an element to the queue.
	 */
	public void enqueue(int value) throws Exception
	{
		try {
			queue[currentQueueSize] = value;
			currentQueueSize++;
		}
		catch (Exception e) {
			throw new Exception("Cannot add as the queue is full.");
		}
	}
	
	/*
	Remove and return the element from the queue using FIFO
	 */
	public int dequeue() throws Exception
	{
		if (currentQueueSize > 0) {
			int numberToReturn = queue[0];
			// Move everything down one and reset the unused queue space.
			for(int i = 0; i < currentQueueSize - 1; i++) {
				queue[i] = queue[i + 1];
			}
			queue[currentQueueSize - 1] = 0;
			currentQueueSize--;
			return numberToReturn;
		}
		else {
			throw new Exception("Cannot remove as the queue is empty.");
		}
	}
}
