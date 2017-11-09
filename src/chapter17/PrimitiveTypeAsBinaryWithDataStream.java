package chapter17;

import java.io.*;

/**
 * Created by blindcant on 2/11/17.
 *
 * The DataInputStream and DataOutputStream can only read and write primitive types.
 * This example shows reading from and writing to files.
 */
public class PrimitiveTypeAsBinaryWithDataStream
{
	//@@@ INSTANCE VARIABLES @@@
	private String[][] students = {{"Johnny", "66.9"}, {"Jane", "88.3"}, {"Harry", "55.8"}, {"Nancy", "75.8"}};
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		PrimitiveTypeAsBinaryWithDataStream runtime = new PrimitiveTypeAsBinaryWithDataStream();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public PrimitiveTypeAsBinaryWithDataStream()
	{
		String filename = "students_with_DataStream.dat";
		try
		{
			writeData(filename, students);
			readData(filename);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	private void readData(String filename) throws IOException
	{
		//data streams write primitive types
		try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filename));)
		{
			//keep looping until EOF
			try
			{
				while (true)
				{
					System.out.println(dataInputStream.readUTF() + " " + dataInputStream.readDouble());
					//System.out.println(dataInputStream.readByte());
				}
			}
			//finish when EOFException is encountered, which means the end of the file
			catch (EOFException e)
			{
				System.out.println("\nAll the data has been read.");
			}
		}
	}
	
	//### SETTERS ###
	private void writeData(String filename, String[][] inputData) throws IOException
	{
		//create a data output stream filter for primtitive data types, which is used by the binary file output stream
		//this is using try-with-resources to it closes automatically
		try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filename));)
		{
			for (int i = 0; i < inputData.length; i++)
			{
				for (int j = 0; j < inputData[i].length; j++)
				{
					//write the name in UTF-8
					if (j == 0)
					{
						dataOutputStream.writeUTF(inputData[i][j]);
					}
					//write the score as a double
					else
					{
						dataOutputStream.writeDouble(Double.parseDouble(inputData[i][j]));
					}
				}
			}
			//dataOutputStream.writeByte(91);
		}
	}
}
