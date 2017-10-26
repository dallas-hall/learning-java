package chapter19.question01;

import java.util.*;

/**
 * Created by blindcant on 27/09/17.
 */
public class GenericStackInheritance<E> extends ArrayList
{
	//@@@ INSTANCE VARIABLES @@@
	private List<E> genericList;
	private static Scanner stdin;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//### create stack ###
/*		GenericStackInheritance<String> stack1 = new GenericStackInheritance<>();
		System.out.println("Enter some words.\n");
		String userInput = stdin.nextLine();
		String[] words = userInput.split(" |$");

		for (int i = 0; i < words.length; i++)
		{
			stack1.pushToStack(words[i]);
		}
		
		//### maniupulate the stacks ###
		System.out.println("@@@ ArrayList<E> stack1 @@@");
		stack1.printStackSize();
		stack1.peekAtEntireStackPrint();
		//need to qualify the object name and the generic name to actually send something.
		stack1.addAll(removeDuplicates(stack1.genericList));
		stack1.peekAtEntireStackPrint();
		stack1.peekAtStackPrint();
		stack1.popFromStack();
		stack1.printStackSize();
		stack1.peekAtStackPrint();
		stack1.emptyStack();*/

		Integer[] anArray = {12, 5, 23, 67, 4, 8, 99, 24, 66, 43, 87, 21};
		Integer key = 24;
		//binarySearchArray(anArray, key);
		System.out.println("Searching for " + key);
		System.out.println("Binary.");
		int result = Arrays.binarySearch(sortArray(anArray), key);
		if (result >= 0)
		{
			System.out.println("After sorting, found! =) @ index " + result );
		}
		else
		{
			System.out.println("Not found... =(");
		}
		Arrays.toString(anArray);
		System.out.println("Linear.");
		result = linearSearch(anArray, key);
		if (result >= 0)
		{
			System.out.println("Found! =) @ index " + result );
		}
		else
		{
			System.out.println("Not found... =(");
		}
		
		
		
		
		
		

	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public GenericStackInheritance()
	{
		genericList = new ArrayList<>();
		stdin = new Scanner(System.in);
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

	public void peekAtEntireStackPrint()
	{
		int i = 0;
		for (E anElement : genericList)
		{
			System.out.println("Element " + i + ": " + anElement.toString());
			i++;
		}
		System.out.println();
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
	
	//### HELPERS ###
	//Question 19.3
	public static <E> List<E> removeDuplicates(List<E> list)
	{
		//LinkedHashSet will remove duplicates and return the order - https://stackoverflow.com/a/203992
		LinkedHashSet<E> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.addAll(list);
		list.clear();
		list.addAll(linkedHashSet);
		return list;
	}
	
	//Question 19.4
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
	{

		for (int i = 0; i < list.length; i++)
		{
			if(list[i].compareTo(key) == 0)
			{
				return i;
			}
		}
		return -1;
	}
	
/*	public static <E extends Comparable<E>> void binarySearchArray(E[] list, E key)
	{
		E[] sorted = sortArray(list);
		boolean done = false;
		
		//create boundaries
		int min = 0;
		int max = sorted.length;
		int attempts =
		int
		
		//create our start number
		int searchNumber = (min + max) / 2;
		
		while (!done || attempts != )
		{
			if (sorted[searchNumber].compareTo(key) == 0)
			{
				System.out.println("Found: " + key);
				done = true;
				return;
			}
			else if (sorted[searchNumber].compareTo(key) > 0)
			{
				max = searchNumber;
				searchNumber = (min + max) / 2;
			}
			else if (sorted[searchNumber].compareTo(key) < 0)
			{
				min = searchNumber;
				searchNumber = (min + max) / 2;
			}
		}
		System.out.println("Not found.");
	}*/
	

	public static <E extends Comparable<E>> E[] sortArray(E[] array)
	{
		E[] sorted = array;
		for (int i = 0; i < sorted.length; i++)
		{
			E minValue = sorted[i];
			int minPosition = i;
			for (int j = i + 1; j < array.length; j++)
			{
				if (sorted[j].compareTo(minValue) < 0)
				{
					minPosition = j;
					minValue = sorted[j];
				}
			}
			
			//if one is found and it isn't in the same position, swap
			if (minPosition != i)
			{
				array[minPosition] = array[i];
				array[i] = minValue;
			}
			
		}
		return sorted;
	}
	
	//Question 19.8
	public static <E extends Comparable <E>> List<E> shuffleList(List<E> list)
	{
		List<E> genericShuffledList = list;
		Collections.shuffle(genericShuffledList);
		return genericShuffledList;
	}
	
	//Question 19.9
	public static <E extends Comparable <E>> List<E> sortList(List<E> list)
	{
		List<E> genericSortedList = list;
		Collections.sort(genericSortedList);
		return genericSortedList;
	}
	
}
