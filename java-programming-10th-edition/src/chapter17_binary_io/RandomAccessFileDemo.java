package chapter17_binary_io;

import java.io.*;

/**
 * Created by dhall on 2/11/17.
 */
public class RandomAccessFileDemo
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws IOException {
		// Create a random access file
		try ( RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw"); )
		{
			// Clear the file to destroy the old contents if exists
			inout.setLength(0);
			
			// Write new integers to the file
			for (int i = 0; i < 200; i++)
				inout.writeInt(i);
			
			// Display the current length of the file, 200 values * 4 bytes (1 int = 4 bytes) = 800
			System.out.println("Current file length in bytes is " + inout.length());
			
			// Retrieve the first number
			inout.seek(0); // Move the file pointer to the beginning
			System.out.println("The first number is " + inout.readInt());
			
			// Retrieve the second number
			inout.seek(1 * 4); // Move the file pointer to the second number
			System.out.println("The second number is " + inout.readInt());
			
			// Retrieve the tenth number
			inout.seek(9 * 4); // Move the file pointer to the tenth number
			System.out.println("The tenth number is " + inout.readInt());
			
			// Modify the eleventh number, because readInt() has moved us along 1 byte
			inout.writeInt(555);
			
			// Append a new number
			inout.seek(inout.length()); // Move the file pointer to the end
			inout.writeInt(999);
			
			// Display the new length
			System.out.println("The new length in bytes is " + inout.length());
			
			// Retrieve the new eleventh number
			inout.seek(10 * 4); // Move the file pointer to the eleventh number
			System.out.println("The eleventh number is " + inout.readInt());
		}
	}
}

