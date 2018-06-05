package chapter10_oop;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>MyCharacter</h1>
 * <p>
 * This program is my implementation of the Character class.
 * </p>
 * <p>
 * tags:	casting; charAt();
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-06-05
 */
public class MyCharacter
{
	//@@@ INSTANCE VARIABLES @@@
	private int[] aChar;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		MyCharacter runtime = new MyCharacter();
		runtime.setChar("d");
		runtime.printChar();
		runtime.setChar("aa");
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public MyCharacter()
	{
		this.aChar = new int[1];
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public char getChar()
	{
		return (char) this.aChar[0];
	}
	
	public int getCharInt()
	{
		return this.aChar[0];
	}
	
	//### SETTERS ###
	public void setChar(String s)
	{
		if(s.length() > 1)
			throw new IllegalArgumentException("The argument must be only be 1 character.");
		this.aChar[0] = s.charAt(0);
		
	}
	
	//### HELPERS ###
	public void printChar()
	{
		System.out.print((char) this.aChar[0]);
	}
}
