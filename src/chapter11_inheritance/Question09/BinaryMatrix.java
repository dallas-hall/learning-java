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
	
	public String getRow(boolean getLargest)
	{
		int total = 0;
		int row = 0;
		String rowValues = null;
		
		int currentRow = 0;
		StringBuffer aStringBuffer = new StringBuffer();
		
		for (List aList : binaryMatrix) {
			int currentRowTotal = 0;
			
			for (Object anObject : aList) {
				int currentInt = (Integer) anObject;
				currentRowTotal += currentInt;
				aStringBuffer.append(currentInt).append(" ");
			}
			
			if (getLargest) {
				if (currentRowTotal > total) {
					total = currentRowTotal;
					row = currentRow;
					rowValues = aStringBuffer.toString();
				}
			}
			else {
				if (currentRow == 0) {
					total = currentRowTotal;
					row = currentRow;
					rowValues = aStringBuffer.toString();
				}
				else if (currentRowTotal < total) {
					total = currentRowTotal;
					row = currentRow;
					rowValues = aStringBuffer.toString();
				}
			}
			
			aStringBuffer.delete(0, aStringBuffer.length());
			currentRow++;
		}
		if (getLargest) {
			return "The largest row was " + row + " which had " + rowValues;
		}
		else {
			return "The smallest row was " + row + " which had " + rowValues;
		}
	}
	
	//### SETTERS ###
	public void populateMatrix()
	{
		for (List aList : binaryMatrix) {
			for (int i = 0; i < amount; i++) {
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
}
