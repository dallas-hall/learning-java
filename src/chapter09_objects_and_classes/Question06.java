package chapter09_objects_and_classes;

/**
 * <h1>Stop Watch</h1>
 * <p>
 * This program is a stop watch that uses milliseconds.
 * </p>
 * <p>
 * tags:	System.currentTimeMillis;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-20
 */
public class Question06
{
	//@@@ INSTANCE VARIABLES @@@
	private long startTime;
	private long endTime;
	
	//@@@ CONSTRUCTOR(S) @@@
	public Question06()
	{
		startTime = System.currentTimeMillis();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public long getStartTime()
	{
		return startTime;
	}
	
	public long getEndTime()
	{
		return endTime;
	}
	
	public long getElapsedTime()
	{
		return endTime - startTime;
	}
	
	//### SETTERS ###
	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}
	
	public void setEndTime(long endTime)
	{
		this.endTime = endTime;
	}
	
	public void start() {
		setStartTime(System.currentTimeMillis());
	}
	
	public void stop() {
		setEndTime(System.currentTimeMillis());
	}
}
