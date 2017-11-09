package chapter11_inheritance.Question10;

import java.util.List;
import java.util.ArrayList;


/**
 * Created by blindcant on 19/09/17.
 */
public class CallStack
{
	//@@@ INSTANCE VARIABLES @@@
	private List<Object> callStackElements;
	
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
	
	//@@@ CONSTRUCTOR(S) @@@
	public CallStack(int callStackSize)
	{
		createAndPopulateStack(callStackSize);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getSize()
	{
		return callStackElements.size();
	}
	
	public boolean isEmpty()
	{
		return callStackElements.isEmpty();
	}
	
	//### HELPERS ###
	private void createAndPopulateStack(int numberOfStackElements)
	{
		//create the ArrayList
		callStackElements = new ArrayList<>();
		
		//start with the letter A (65 in ASCII is A)
		//char aCharacter = 65;
		//start with the letter A (41 in HEX is A)
		char aCharacter = '\u0041';
		for (int i = 0; i < numberOfStackElements; i++)
		{
			if (i != 0)
			{
				aCharacter++;
			}
			push(String.valueOf(aCharacter));
		}
	}
	
	public Object peek()
	{
		return callStackElements.get(getSize() - 1);
	}
	
	public Object pop()
	{
		Object o = callStackElements.get(getSize() - 1);
		callStackElements.remove(getSize() - 1);
		return o;
	}
	
	public void push(Object anObject)
	{
		callStackElements.add(anObject);
	}
	
	@Override
	public String toString()
	{
		return "Current call stack: " + callStackElements.toString();
	}
}
