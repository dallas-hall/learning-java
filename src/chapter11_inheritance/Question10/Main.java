package chapter11_inheritance.Question10;

/**
 * <h1>Call Stack Driver</h1>
 * <p>
 * This is the driver for the Call Stack class. It demonstrates how the call stack works.
 * </p>
 * <p>
 * tags:	call stack; polymorphism;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-14
 */
public class Main
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		CallStack aCallStack = new CallStack(8);
		System.out.println(aCallStack.toString());
		System.out.println("Peeking at the call stack yeilds: " + aCallStack.peek());
		System.out.println("Popping the call stack.");
		aCallStack.pop();
		System.out.println("Peeking at the call stack yeilds: " + aCallStack.peek());
		System.out.println("Pushing 'Z' to the call stack.");
		aCallStack.push("Z");
		System.out.println("Peeking at the call stack yeilds: " + aCallStack.peek());
		System.out.println(aCallStack.toString());
	}
}
