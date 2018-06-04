package chapter10_oop;

import java.util.Arrays;

/**
 * <h1>My String</h1>
 * <p>
 * This program is my first implementation of the Java String class. Backed by char[] and String manipulation.
 * </p>
 * <p>
 * tags:	anonymous array; char[]; anonymous object;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-05-03
 */
public class MyString
{
	//@@@ INSTANCE VARIABLES @@@
	private char[] myString;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		MyString runtime = new MyString(new char[] {'B', 'l', 'i', 'n', 'd', 'C', 'a', 'n', 't'});
		for (int i = 0; i < runtime.length(); i++) {
			System.out.print(runtime.charAt(i));
		}
		System.out.println();
		for (int i = 0; i < runtime.length(); i++) {
			System.out.print(runtime.valueOf(i).myString);
		}
		System.out.println("\nThe MyString is " + runtime.length() + " long.");
		System.out.println("This test should be true: " + runtime.equals(new MyString(new char[] {'B', 'l', 'i', 'n', 'd', 'C', 'a', 'n', 't'})));
		System.out.println("This test should be false: " + runtime.equals(new MyString(new char[] {'b', 'l', 'i', 'n', 'd', 'c', 'a', 'n', 't'})));
		System.out.println(runtime.toLowerCase().myString);
		System.out.println(runtime.toUpperCase().myString);
		System.out.println(runtime.substring(0).myString);
		System.out.println(runtime.substring(0, 5).myString);
		System.out.println(runtime.substring(5).myString);
		System.out.println("This test should be 0: " + runtime.compare(new MyString(new char[] {'B', 'l', 'i', 'n', 'd', 'C', 'a', 'n', 't'})));
		System.out.println("This test should not be 0: " + runtime.compare(new MyString(new char[] {'b', 'l', 'i', 'n', 'd', 'c', 'a', 'n', 't'})));
		System.out.println(Arrays.toString(runtime.toCharArray()));
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public MyString(char[] chars)
	{
		myString = Arrays.copyOf(chars, chars.length);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public char charAt(int index)
	{
		if (index < 0 || index >= myString.length) {
			return '\u0000';
		}
		else {
			return myString[index];
		}
	}
	
	public MyString valueOf(int index)
	{
		if (index < 0 || index >= myString.length) {
			return null;
		}
		else
		// Use an anonymous array
		{
			return new MyString(new char[] {myString[index]});
		}
	}
	
	public int length()
	{
		return myString.length;
	}
	
	public char[] toCharArray()
	{
		return Arrays.copyOf(myString, myString.length);
	}
	
	//### HELPERS ###
	public MyString substring(int begin, int end)
	{
		StringBuffer aStringBuffer = new StringBuffer();
		if (begin < 0 || begin > myString.length) {
			return null;
		}
		else if (end < 0 || end > myString.length) {
			return null;
		}
		else {
			for (int i = begin; i < end; i++) {
				aStringBuffer.append(myString[i]);
			}
			return new MyString(aStringBuffer.toString().toCharArray());
		}
	}
	
	public MyString substring(int begin)
	{
		return substring(begin, myString.length);
	}
	
	public MyString toLowerCase()
	{
		/*
		System.out.println(new String(myString));
		System.out.println(new String(myString).toLowerCase());
		System.out.println(new String(myString).toLowerCase().toCharArray());
		System.out.println(new MyString(new String(myString).toLowerCase().toCharArray()).myString);
		*/
		return new MyString(new String(myString).toLowerCase().toCharArray());
	}
	
	public MyString toUpperCase()
	{
		return new MyString(new String(myString).toUpperCase().toCharArray());
	}
	
	public boolean equals(MyString aMyString)
	{
		if (new String(aMyString.myString).equals(new String(myString))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int compare(MyString aMyString)
	{
		for (int i = 0; i < aMyString.length(); i++) {
			if (!String.valueOf(aMyString.myString[i]).equals(String.valueOf(this.myString[i]))) {
				return aMyString.myString[i] - this.myString[i];
			}
		}
		return 0;
	}
}
