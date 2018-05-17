package chapter11_inheritance.Question09;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Binary Table</h1>
 * <p>
 * This program creates a binary table and then determines the largest row and column.
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-17
 */
public class BinaryMatrix
{
	//@@@ INSTANCE VARIABLES @@@
	private List<List> binaryMatrix;
	private int amount;
	
	//@@@ CONSTRUCTOR(S) @@@
	public BinaryMatrix(int amount)
	{
		binaryMatrix = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			binaryMatrix.add(new ArrayList<>());
		}
		this.amount = amount;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public List<List> getBinaryMatrix()
	{
		return binaryMatrix;
	}
	
	//### SETTERS ###
	public void populateMatrix()
	{
		for (List aList : binaryMatrix) {
			for(int i = 0; i < amount; i++) {
				// Add 0 or 1
				aList.add(ThreadLocalRandom.current().nextInt(0, 2));
			}
		}
	}
	
	//### HELPERS ###
	public void printBinaryMatrix(String message)
	{
		System.out.println(message);
		for (List aList : binaryMatrix) {
			for (Object anObject : aList) {
				System.out.print((Integer) anObject + " ");
			}
			System.out.println();
		}
	}
	
	//@@@ INNER CLASS(ES) @@@
}
