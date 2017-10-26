package chapter30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by blindcant on 22/10/17.
 */
public class TaskAndThreadExecutorDemo
{

	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//timeshared execution
		//TaskAndThreadExecutorDemo runtime = new TaskAndThreadExecutorDemo(1);
		
		//concurrent execution
		//TaskAndThreadExecutorDemo runtime = new TaskAndThreadExecutorDemo(3);
		TaskAndThreadExecutorDemo runtime = new TaskAndThreadExecutorDemo(7);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public TaskAndThreadExecutorDemo(int nThreads)
	{
		//create a fixed thread pool object with 3 threads
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
		
		//create and submit 7 runnable tasks to the executor
		executorService.execute(new TaskAndThreadDemo.PrintChar('D', 100));
		executorService.execute(new TaskAndThreadDemo.PrintChar('a', 100));
		executorService.execute(new TaskAndThreadDemo.PrintChar('l', 100));
		executorService.execute(new TaskAndThreadDemo.PrintChar('l', 100));
		executorService.execute(new TaskAndThreadDemo.PrintChar('a', 100));
		executorService.execute(new TaskAndThreadDemo.PrintChar('s', 100));
		executorService.execute(new TaskAndThreadDemo.PrintNumber(8, 100));
		
		//close the executor once it has finished running its threads
		executorService.shutdown();
		
	}
}
