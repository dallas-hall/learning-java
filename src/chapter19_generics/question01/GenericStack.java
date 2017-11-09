package chapter19_generics.question01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blindcant on 27/09/17.
 */
public class GenericStack<E>
{
	//@@@ INSTANCE VARIABLES @@@
	private List<E> genericList;
	private E[] genericArray;
	

	//@@@ CONSTRUCTOR(S) @@@
	public GenericStack()
	{
		genericList = new ArrayList<>();
		//genericArray = (E[])new Object[2];
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getStackSize()
	{
		return genericList.size();
	}
	
	public void printStackSize()
	{
		System.out.println("The stack size is currently " + getStackSize());
	}
	
	public E peekAtStack()
	{
		int lastElement = getStackSize() - 1;
		if (lastElement >= 0)
		{
			return genericList.get(lastElement);
		}
		else
		{
			return null;
		}
	}
	
	public void peekAtStackPrint()
	{
		int lastElement = getStackSize() - 1;
		if (lastElement >= 0)
		{
			System.out.println("Peeking yields " + peekAtStack().toString());
		}
		else
		{
			System.out.println("Peeking yields nothing, the stack is empty.");
		}
	}
	
	//### SETTERS ###
	public void pushToStack(E element)
	{
		genericList.add(element);
	}
	
	
	public void popFromStack()
	{
		int lastElement = getStackSize() - 1;
		if (lastElement >= 0)
		{
			E stackElement = genericList.get(lastElement);
			System.out.println("Popping " + stackElement.toString() + ".");
			genericList.remove(lastElement);
		}
		else
		{
			System.out.println("Can't pop, stack is empty.");
		}
	}
	
	public void emptyStack()
	{
		int i = genericList.size() - 1;
		while (i >= 0)
		{
			popFromStack();
			i--;
		}
	}
}
