package chapter10_oop;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>PROGRAM NAME GOES HERE</h1>
 * <p>
 * This program has the main method for the QueueOfIntegers program. It will create a queue, populate it, and remove everything from it.
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-23
 */
public class TestQueueOfIntegers
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) {
		// Create Queue
		QueueOfIntegers queueOfIntegers = new QueueOfIntegers(20);
		
		// Populate Queue
		try {
			for (int i = 0; i < queueOfIntegers.getQueueLength(); i++) {
				queueOfIntegers.enqueue(ThreadLocalRandom.current().nextInt(1, 101));
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Display Queue
		System.out.println(Arrays.toString(queueOfIntegers.getQueue()));
		
		// Remove an item
		try {
			while(!queueOfIntegers.isEmpty()) {
				System.out.println("Processing the queue, currently processing: " + queueOfIntegers.dequeue());
				
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
