package chapter11_inheritance.Question09;

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
 * @version 0.0.1 - 2018-05-17
 */
public class Main
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		BinaryMatrix runtime = new BinaryMatrix(4);
		runtime.populateMatrix();
		runtime.printBinaryMatrix("Original binary matrix is: ");
		System.out.println(runtime.getRow(true));
		System.out.println(runtime.getRow(false));
	}
}
