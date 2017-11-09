package chapter30_multithreading;

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
		//threadpool task execution
		System.out.println("\n@@@ Threadpool Task Execution Printing @@@");
		
		//When threads = 1, execution is sequential
		//TaskAndThreadExecutorDemo runtimeSingleThread = new TaskAndThreadExecutorDemo(1);
		
		//When threads > 1 & threads < task, execution is concurrent but with some timesharing
		//TaskAndThreadExecutorDemo runtimeMultiThread = new TaskAndThreadExecutorDemo(3);
		
		//with threads >= task, execution is truely concurrent
		TaskAndThreadExecutorDemo runtimeMultiThread = new TaskAndThreadExecutorDemo(6);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public TaskAndThreadExecutorDemo(int nThreads)
	{
		/*
			Threadpools are an ideal way to execute multiple tasks concurrently.
			
			The ExecutorService is used to manage and control tasks.
			The Executor(s) is for executing tasks in a thread pool.
			
		 */
		
		//create a fixed thread pool object with n threads
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
		
		//create and submit n runnable tasks to the executor
		executorService.execute(new TaskAndThreadDemo.PrintChar('a', 100));
		executorService.execute(new TaskAndThreadDemo.PrintChar('b', 100));
		executorService.execute(new TaskAndThreadDemo.PrintChar('c', 100));
		executorService.execute(new TaskAndThreadDemo.PrintNumber(1, 100));
		executorService.execute(new TaskAndThreadDemo.PrintNumber(2, 100));
		executorService.execute(new TaskAndThreadDemo.PrintNumber(3, 100));
		
		//close the executor once it has finished running its threads
		executorService.shutdown();
		
	}
}
