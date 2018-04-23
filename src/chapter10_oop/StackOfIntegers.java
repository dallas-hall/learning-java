package chapter10_oop;

/**
 * <h1>Stack Data Structure</h1>
 * <p>
 * This program will use a stack data structure to store integers.
 * </p>
 * <p>
 * A stack is a data structure that holds data in a last-in, first-out fashion.
 * <p>
 * Example will have a stack being empty, having 3 bits of data pushed (loaded) into it and then popped (removed) from it
 * <p>
 * 1) Start with an empty stack
 * Stack = empty
 * 2) Push 1 data block into the stack (add data1)
 * Stack = data1
 * 3) Push 1 more data block into the stack (add data2)
 * Stack = data2
 * data1
 * 4) Push 1 more data block into the stack (add data3)
 * Stack = data3
 * data2
 * data1
 * 5) Pop the stack once (remove data3)
 * Stack = data2
 * data1
 * 6) Pop the stack once (remove data2)
 * Stack = data1
 * 7) Pop the stack once (remove data1)
 * Stace = empty.
 * </p>
 * <p>
 * tags:	stack; call stack; push; pop; peek;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-23
 */
public class StackOfIntegers
{
	//@@@ CLASS VARIABLES @@@
	public static final int DEFAULT_CAPACITY = 16;
	
	//@@@ INSTANCE VARIABLES @@@
	private int[] stackElements;
	private int stackSize;
	
	
	//@@@ CONSTRUCTOR(S) @@@
	public StackOfIntegers()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public StackOfIntegers(int capacity)
	{
		stackElements = new int[capacity];
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	/**
	 * Return the top element from the stack
	 */
	public int peek() throws Exception
	{
		try {
			return stackElements[stackSize - 1];
		}
		catch (Exception e) {
			throw new Exception("The stack is empty, can't peek.");
		}
	}
	
	/**
	 * Return any specified element from the stack
	 */
	public int peek(int index) throws Exception
	{
		try {
			return stackElements[index];
		}
		catch (Exception e) {
			throw new Exception("The stack is empty, can't peek.");
		}
	}
	
	/**
	 * Return the number of stackElements in the stack
	 */
	public int getstackSize()
	{
		return stackSize;
	}
	
	//### SETTERS ###
	/**
	 * Push a new integer to the top of the stack
	 */
	public void push(int value) throws Exception
	{
		//if the current stack doesn't have enough space, create a new array with double the size,
		// copy the contents to a temp array, and then copy them new double sized array
		if (stackSize >= stackElements.length) {
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
	
	//### HELPERS ###
	/**
	 * Checks whether the stack is empty
	 */
	public boolean empty()
	{
		return stackSize == 0;
	}
}