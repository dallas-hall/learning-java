package chapter30_multithreading;

/**
 * Created by blindcant on 22/10/17.
 */
public class TaskAndThreadDemo
{
	//@@@ INSTANCE VARIABLES @@@
	
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//Creating tasks
		Runnable printLettera = new PrintChar('a', 100);
		Runnable printLetterb = new PrintChar('b', 100);
		Runnable printLetterc = new PrintChar('c', 100);
		Runnable printNumber1 = new PrintNumber(1, 100);
		Runnable printNumber2 = new PrintNumber(2, 100);
		Runnable printNumber3 = new PrintNumber(3, 100);
		
				//creating threads
		Thread thread1 = new Thread(printLettera);
		Thread thread2 = new Thread(printLetterb);
		Thread thread3 = new Thread(printLetterc);
		Thread thread4 = new Thread(printNumber1);
		Thread thread5 = new Thread(printNumber2);
		Thread thread6 = new Thread(printNumber3);
		
		//start threads with timesharing, which is using one thread only
		System.out.println("\n@@@ Single Threaded Printing @@@");
		thread1.run();
		thread2.run();
		thread3.run();
		thread4.run();
		thread5.run();
		thread6.run();
		
		//starting threads with mulithreading
		System.out.println("\n@@@ Multithreaded Printing @@@");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	
	
	//@@@ METHODS @@@
	//### GETTERS ###
	
	//### SETTERS ###
	
	//### HELPERS ###
	
	//@@@ INNER CLASSES @@@
	
	/**
	 * By implementing Runnable and overriding run(), we can get this method to be executed as a task on a thread, without extending Thread.
	 */
	static class PrintChar implements Runnable
	{
		private char charToPrint;
		private int amount;
		
		public PrintChar(char charToPrint, int amount)
		{
			this.charToPrint = charToPrint;
			this.amount = amount;
		}
		
		@Override
		public void run()
		{
			for (int i = 0; i < amount; i++)
			{
				System.out.print(charToPrint);
			}
		}
	}
	
	static class PrintNumber implements Runnable
	{
		private int intToPrint;
		private int amount;
		
		public PrintNumber(int intToPrint, int amount)
		{
			this.intToPrint = intToPrint;
			this.amount = amount;
		}
		
		@Override
		public void run()
		{
			for (int i = 0; i < amount; i++)
			{
				System.out.print(intToPrint);
			}
		}
	}
}


