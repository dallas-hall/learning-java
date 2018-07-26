package chapter10_oop.Stack;

/**
 * <h1>LaunchSequence StackOfIntegers</h1>
 * <p>
 * This program has the main method for the StackOfIntegers class.
 * </p>
 * <p>
 * tags:	stack; call stack; push; pop; peek;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-23
 */

public class TestStackOfIntegers
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		try {
			//create object
			StackOfIntegers stack1 = new StackOfIntegers();
			
			//populate some of the stack array
			for (int i = 0; i < 10; i++) {
				stack1.push(i);
			}
			
			//show the entire stack
			System.out.println("Remember that the stack is a data structure that holds data in a last-in, first-out fashion (LIFO).");
			System.out.println("The entire elements of the stack are: ");
			for (int i = 0; i < 10; i++) {
				System.out.print(stack1.peek(i) + " ");
			}
			
			//show the last data element in the stack
			System.out.println("\nThe last element of the stack currently is: " + stack1.peek());
			
			//pop the stack until its empty
			while (!stack1.empty()) {
				System.out.println("Popping " + stack1.pop() + ".");
				System.out.println("\nThe last element of the stack currently is: " + stack1.peek());
			}
			
			//try to show the last data element in the stack
			System.out.println("\nThe last element of the stack currently is: " + stack1.peek());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
