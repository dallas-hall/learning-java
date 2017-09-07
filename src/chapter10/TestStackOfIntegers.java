package chapter10;

/**
 * Created by blindcant on 23/04/17.
 */
public class TestStackOfIntegers
{
	/**
	 *  Main method used for testing
	 */
	public static void main(String[] args)
	{
		//create object
		StackOfIntegers stack1 = new StackOfIntegers();
		
		//populate some of the stack array
		for (int i = 0; i < 10; i++)
		{
			stack1.push(i);
		}
		
		//show the entire stack
		System.out.println("Remember that the stack is a data structure that holds data in a last-in, first-out fashion.");
		System.out.println("The entire elements of the stack are: ");
		
		for (int i = 0; i < 10; i++)
		{
			System.out.print(stack1.peek(i) + " ");
		}
		
		//show the last data element in the stack
		System.out.println("\nThe last element of the stack currently is: " + stack1.peek());
		
		
		//pop the stack
		while (!stack1.empty())
		{
			System.out.print(stack1.pop() + " ");
		}
	}
}
