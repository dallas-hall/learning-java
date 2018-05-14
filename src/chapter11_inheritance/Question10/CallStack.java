package chapter11_inheritance.Question10;

import java.util.List;
import java.util.ArrayList;

/**
 * <h1>Call Stack</h1>
 * <p>
 * This program is my implementation a call stack using List data structures. You can push, pop, and peek.
 * </p>
 * <p>
 * tags:	polymorphism; List; ArrayList; call stack;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-09-19
 */
public class CallStack
{
	//@@@ INSTANCE VARIABLES @@@
	private List<Object> callStackElements;
	
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
	
	public Object peek()
	{
		return callStackElements.get(getSize() - 1);
	}
	
	//### SETTERS ###
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
	
	//### HELPERS ###
	private void createAndPopulateStack(int numberOfStackElements)
	{
		//create the ArrayList
		callStackElements = new ArrayList<>();
		
		//start with the letter A (65 in ASCII is A)
		//char aCharacter = 65;
		//start with the letter A (41 in HEX is A)
		char aCharacter = '\u0041';
		for (int i = 0; i < numberOfStackElements; i++) {
			if (i != 0) {
				aCharacter++;
			}
			push(String.valueOf(aCharacter));
		}
	}
	
	@Override
	public String toString()
	{
		return "Current call stack: " + callStackElements.toString();
	}
	
}
