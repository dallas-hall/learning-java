package chapter30;

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
		Runnable printLetterD = new PrintChar('D', 100);
		Runnable printLettera = new PrintChar('a', 100);
		Runnable printLetterl = new PrintChar('l', 100);
		Runnable printLetters = new PrintChar('s', 100);
		Runnable printNumber8 = new PrintNumber(8, 100);
		
		//creating threads
		Thread thread1 = new Thread(printLetterD);
		Thread thread2 = new Thread(printLettera);
		Thread thread3 = new Thread(printLetterl);
		Thread thread4 = new Thread(printLetterl);
		Thread thread5 = new Thread(printLettera);
		Thread thread6 = new Thread(printLetters);
		Thread thread7 = new Thread(printNumber8);
		
		//starting threads
		System.out.println("@@@ Multithreaded Printing @@@");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
	
		//start thread with timesharing
		System.out.println("\n@@@ Single Threaded Printing @@@");
		thread1.run();
		thread2.run();
		thread3.run();
		thread4.run();
		thread5.run();
		thread6.run();
		thread7.run();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	
	
	//@@@ METHODS @@@
	//### GETTERS ###
	
	//### SETTERS ###
	
	//### HELPERS ###
	
	//@@@ INNER CLASSES @@@
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


