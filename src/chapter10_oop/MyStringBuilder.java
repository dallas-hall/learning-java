package chapter10_oop;

import java.util.Arrays;

/**
 * <h1>StringBuilder</h1>
 * <p>
 * This program is my implementation of the StringBuilder class.
 * </p>
 * <p>
 * tags:	new String(char[]); Arrays.copyOf();
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-05-10
 */
public class MyStringBuilder
{
	//@@@ INSTANCE VARIABLES @@@
	private char[] myStringBuilder;
	private int size = 0;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		MyStringBuilder runtime = new MyStringBuilder("blind");
		runtime.testPrint();
		runtime.append("can't");
		runtime.testPrint();
		runtime.append(" likes to");
		runtime.testPrint();
		runtime.append(" code in Java.");
		runtime.testPrint();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public MyStringBuilder(String startString)
	{
		myStringBuilder = new char[startString.length()];
		for (int i = 0; i < startString.length(); i++) {
			myStringBuilder[i] = startString.charAt(i);
		}
		size = startString.length();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public int getSize()
	{
		return size;
	}
	
	//### SETTERS ###
	public void append(String aString)
	{
		if (aString.length() > myStringBuilder.length - (size - 1)) {
			myStringBuilder = Arrays.copyOf(myStringBuilder, myStringBuilder.length + aString.length());
		}
		for (int i = 0; i < aString.length(); i++) {
			myStringBuilder[size] = aString.charAt(i);
			size++;
		}
	}
	
	//### HELPERS ###
	public String toString()
	{
		return new String(myStringBuilder);
	}
	
	public void testPrint()
	{
		System.out.println(new String(myStringBuilder));
		System.out.println("Size is: " + size);
	}
}
