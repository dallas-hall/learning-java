package chapter08_multi_d_arrays;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Matrices Multiplication</h1>
 * <p>
 * This program will create 2 x 2d arrays with random numbers, and then add each together.
 * </p>
 * <p>
 * tags:	int[][]; nested for loops; ThreadLocalRandom.current().nextInt;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-09
 */
public class Question06
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) {
		int[][] a = new int[3][3];
		int[][] b = new int[3][3];
		
		setArray(a);
		setArray(b);
		printArray(a);
		printArray(b);
		int[][] c = multiplyArrays(a, b);
		//printArray(c);
		
	}
	
	//@@@ METHODS @@@
	//### SETTERS ###
	public static void setArray(int[][] c) {
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i].length; j++) {
				c[i][j] = ThreadLocalRandom.current().nextInt(1, 11);
			}
		}
	}
	
	public static int[][] multiplyArrays(int[][] a, int[][] b) {
		System.out.println("Calculating input arrays & printing final array.");
		int[][] c = new int[a.length][b.length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " * " + b[i][j] + " = " + (a[i][j] *  b[i][j]) + " ");
				c[i][j] = a[i][j] *  b[i][j];
			}
			System.out.println();
		}
		return c;
	}
	
	//### HELPERS ###
	public static void printArray(int[][] a) {
		System.out.println("Printing array.");
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
