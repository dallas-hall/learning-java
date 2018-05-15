package chapter11_inheritance.Question04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>ArrayList Values</h1>
 * <p>
 * This program processes an ArrayList of Integers and can return its min, max, and avg value.
 * </p>
 * <p>
 * tags:	List; ArrayList; Integer; boxing; polymorphism; over loading;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-15
 */
public class ArrayListValues
{
	//@@@ INSTANCE VARIABLES @@@
	private List<Integer> aList;

	//@@@ CONSTRUCTOR(S) @@@
	public ArrayListValues()
	{
		aList = new ArrayList<>();
	}
	
	public ArrayListValues(int amount)
	{
		aList = new ArrayList<>();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
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
	
	//### HELPERS ###
	public void printList()
	{
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
}
