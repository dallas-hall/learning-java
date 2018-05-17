package chapter11_inheritance.Question04_07_11_to_14;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>ArrayList Manipulation</h1>
 * <p>
 * This program processes an ArrayList of Integers and can return its min, max, and avg value. It can shuffle, sort, sum all values, and distinct merge.
 * </p>
 * <p>
 * tags:	List; ArrayList; Integer; boxing; polymorphism; over loading; LinkedHashSet; Collections.sort; Collections.reverse; ThreadLocalRandom.current().nextInt;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-15
 */
public class ArrayListManipulation
{
	//@@@ INSTANCE VARIABLES @@@
	private List<Integer> aList;

	//@@@ CONSTRUCTOR(S) @@@
	public ArrayListManipulation()
	{
		aList = new ArrayList<>();
	}
	
	public ArrayListManipulation(int amount)
	{
		aList = new ArrayList<>();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public List<Integer> getList()
	{
		return aList;
	}
	
	// Question 4
	public int getMax()
	{
		int max = Integer.MIN_VALUE;
		for (Integer anInt : aList) {
			if(anInt > max)
				max = anInt;
		}
		return max;
	}
	
	public int getMin()
	{
		int min = Integer.MAX_VALUE;
		for (Integer anInt : aList) {
			if(anInt < min)
				min = anInt;
		}
		return min;
	}
	
	public int getAverage()
	{
		int sum = 0;
		for (Integer anInt : aList) {
			sum += anInt;
		}
		return sum / aList.size();
	}
	
	//### SETTERS ###
	public void setList(List<Integer> aList)
	{
		this.aList = aList;
	}
	
	public void populateList()
	{
		// Random number between 5-10 inclusive
		int amount = ThreadLocalRandom.current().nextInt(5, 11);
		for (int i = 0; i < amount; i++) {
			int number = ThreadLocalRandom.current().nextInt(1, 100);
			aList.add(number);
		}
	}
	
	public void populateList(int amount)
	{
		for (int i = 0; i < amount; i++) {
			int number = ThreadLocalRandom.current().nextInt(1, 100);
			aList.add(number);
		}
	}
	
	// Question 7
	public void shuffleList()
	{
		Collections.shuffle(aList);
	}
	
	// Question 11
	public void sortList()
	{
		Collections.sort(aList);
	}
	
	public void reverseList()
	{
		Collections.reverse(aList);
	}
	
	// Question 13
	public void removeDuplicates()
	{
		// Use a Set to remove duplicates
		Set<Integer> aSet = new LinkedHashSet(aList);
		aList.clear();
		aList.addAll(aSet);
	}
	
	//### HELPERS ###
	public void printList(String message)
	{
		System.out.println(message);
		int counter = 1;
		for (Integer anInt : aList) {
			System.out.print(anInt + "\t");
			if (counter % 10 == 0) {
				System.out.println();
			}
			counter++;
		}
		System.out.println();
	}
	
	// Question 12
	public int sumList()
	{
		int total = 0;
		for(Integer anInt : aList) {
			total += anInt;
		}
		return total;
	}
	
	// Question 14
	public List unionLists(List a, List b)
	{
		List<Integer> unionList = new ArrayList<>();
		unionList.addAll(a);
		unionList.addAll(b);
		return unionList;
	}
}
