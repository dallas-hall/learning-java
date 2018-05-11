package chapter10_oop;

import java.util.Arrays;

/**
 * <h1>My version of StringBuilder</h1>
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
		System.out.println("[INFO] Starting with nothing.");
		MyStringBuilder runtime = new MyStringBuilder();
		runtime.append("Blind");
		runtime.performTests(runtime);
		runtime.append("can't");
		runtime.performTests(runtime);
		System.out.println(runtime.substring(5));

		System.out.println("\n[INFO] Starting with a String.");
		MyStringBuilder runtime2 = new MyStringBuilder("Blind");
		runtime2.performTests(runtime2);
		runtime2.append("can't");
		runtime2.performTests(runtime2);
		System.out.println(runtime2.substring(5));
		
		System.out.println("\n[INFO] Starting with char[].");
		MyStringBuilder runtime3 = new MyStringBuilder(new char[] {'B', 'l', 'i', 'n', 'd'});
		runtime3.performTests(runtime3);
		runtime3.append("can't");
		runtime3.performTests(runtime3);
		System.out.println(runtime3.substring(5));
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public MyStringBuilder()
	{
		myStringBuilder = new char[8];
		size = 0;
	}
	
	public MyStringBuilder(String startString)
	{
		myStringBuilder = new char[startString.length()];
		for (int i = 0; i < startString.length(); i++) {
			myStringBuilder[i] = startString.charAt(i);
		}
		size = startString.length();
	}
	
	public MyStringBuilder(char[] startChars)
	{
		myStringBuilder = Arrays.copyOf(startChars, startChars.length);
		size = startChars.length;
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
		if(myStringBuilder == null || myStringBuilder[0] == '\u0000')
			return "";
		else
			return new String(myStringBuilder);
	}
	
	public void performTests(MyStringBuilder myStringBuilder)
	{
		System.out.println("String: " + myStringBuilder.toString());
		System.out.println("Size is: " + myStringBuilder.size);
		System.out.println("Reversed: " + myStringBuilder.reverse());
		System.out.println("Lowercase: " + myStringBuilder.toLowerCase());
		System.out.println("Uppercase: " + myStringBuilder.toUpperCase());
	}
	
	public MyStringBuilder reverse()
	{
		char[] reversed = new char[myStringBuilder.length];
		for(int i = 0, j = size - 1; i < size; i++, j--) {
			reversed[i] = myStringBuilder[j];
		}
		return new MyStringBuilder(reversed);
	}
	
	public MyStringBuilder toUpperCase()
	{
		char[] uppercase = new char[myStringBuilder.length];
		for (int i = 0; i < myStringBuilder.length; i++) {
			uppercase[i] = Character.toUpperCase(myStringBuilder[i]);
		}
		return new MyStringBuilder(uppercase);
	}
	
	public MyStringBuilder toLowerCase()
	{
		char[] lowercase = new char[myStringBuilder.length];
		for (int i = 0; i < myStringBuilder.length; i++) {
			lowercase[i] = Character.toLowerCase(myStringBuilder[i]);
		}
		return new MyStringBuilder(lowercase);
	}
	
	public MyStringBuilder substring(int startIndex)
	{
		// https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#copyOfRange-char:A-int-int-
		return new MyStringBuilder(Arrays.copyOfRange(myStringBuilder, startIndex, myStringBuilder.length));
	}
}
