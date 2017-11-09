package chapter10_oop;

/**
 * Created by blindcant on 23/04/17.
 *
 * A stack is a data structure that holds data in a last-in, first-out fashion.
 *
 *  Example will have a stack being empty, having 3 bits of data pushed (loaded) into it and then popped (removed) from it
 *
 *  1) Start with an empty stack
 *      Stack = empty
 *  2) Push 1 data block into the stack (add data1)
 *      Stack = data1
 *  3) Push 1 more data block into the stack (add data2)
 *      Stack = data2
 *              data1
 *  4) Push 1 more data block into the stack (add data3)
 *      Stack = data3
 *              data2
 *              data1
 *  5) Pop the stack once (remove data3)
 *      Stack = data2
 *              data1
 *  6) Pop the stack once (remove data2)
 *      Stack = data1
 *  7) Pop the stack once (remove data1)
 *      Stace = empty.
 */
public class StackOfIntegers
{
	//INSTANCE VARIABLES
	private int[] stackElements;
	private int stackSize;
	public static final int DEFAULT_CAPACITY = 16;
	
	//CONSTRUCTOR(S)
	/**
	 * Construct a stack with the default capacity 16
	 */
	public StackOfIntegers()
	{
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Construct a stack with the specified maximum capacity
	 */
	public StackOfIntegers(int capacity)
	{
		stackElements = new int[capacity];
	}
	
	//METHODS
	/**
	 * Push a new integer to the top of the stack
	 */
	public void push(int value)
	{
		//if the current stack doesn't have enough space, create a new array with double the size,
		// copy the contents to a temp array, and then copy them new double sized array
		if (stackSize >= stackElements.length)
		{
			int[] temp = new int[stackElements.length * 2];
			System.arraycopy(stackElements, 0, temp, 0, stackElements.length);
			stackElements = temp;
		}
		
		stackElements[stackSize++] = value;
	}
	
	/**
	 * Return and remove the top element from the stack
	 */
	public int pop()
	{
		return stackElements[--stackSize];
	}
	
	/**
	 * Return the top element from the stack
	 */
	public int peek()
	{
		return stackElements[stackSize - 1];
	}
	
	/**
	 * Return any specified element from the stack
	 */
	public int peek(int index)
	{
		return stackElements[index];
	}
	
	/**
	 * Chars whether the stack is empty
	 */
	public boolean empty()
	{
		return stackSize == 0;
	}
	
	/**
	 * Return the number of stackElements in the stack
	 */
	public int getstackSize()
	{
		return stackSize;
	}
}