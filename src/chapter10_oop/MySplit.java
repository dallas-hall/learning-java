package chapter10_oop;

import java.util.Arrays;

/**
 * <h1>PROGRAM NAME GOES HERE</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-05-08
 */
public class MySplit
{
	//@@@ INSTANCE VARIABLES @@@
	private String original;
	private String[] result;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		System.out.println("[INFO] Test 1.");
		MySplit runtime = new MySplit("Blind;Can't;Likes;Java", ";");
		System.out.println("Starting string: " + runtime.getOriginal());
		System.out.println("Original split: " + Arrays.toString("Blind;Can't;Likes;Java".split(";")));
		System.out.println("My split: " + Arrays.toString(runtime.getResult()));
		System.out.println("\n[INFO] Test 2.");
		MySplit runtime2 = new MySplit("Blind<>Can't<>Likes<>Java", "<>");
		System.out.println("Starting string: " + runtime2.getOriginal());
		System.out.println("Original split: " + Arrays.toString("Blind<>Can't<>Likes<>Java".split("<>")));
		System.out.println("My split: " + Arrays.toString(runtime2.getResult()));
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public MySplit(String startString, String delimiter)
	{
		original = startString;
		result = mySplit(startString, delimiter);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public String[] getResult()
	{
		return result;
	}
	
	public String getOriginal()
	{
		return original;
	}
	
	//### HELPERS ###
	public String[] mySplit(String startString, String delimiter)
	{
		String[] splitResult = startString.split(delimiter);
		// Need -1 to ensure we don't store an extra delimiter
		String[] mySplitResult = new String[splitResult.length * 2 - 1];
		for (int i = 0; i < splitResult.length; i++) {
			// i * 2 will be 0, 2, 4 etc
			mySplitResult[i * 2] = splitResult[i];
			// Make sure we don't try to store an extra delimiter
			if(i != splitResult.length - 1)
				mySplitResult[i * 2 + 1] = delimiter;
		}
		return mySplitResult;
	}
	
	public String[] mySplit2(String startString, String delimiter)
	{
		String[] mySplitResult = null;
		return mySplitResult;
	}
}
