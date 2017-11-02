package chapter17;

import java.io.*;

/**
 * Created by blindcant on 2/11/17.
 */
public class BinaryFileStream
{
	//@@@ INSTANCE VARIABLES @@@
	private static FileOutputStream output;
	private static FileInputStream input;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		BinaryFileStream runtime = new BinaryFileStream();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public BinaryFileStream()
	{
		//a binary file, can't be read with a text editor
		String filename = "temp.txt";
		createOutput(filename, 10);
		readOutput(filename);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	private void readOutput(String filename)
	{
		try
		{
			//create the input stream
			input = new FileInputStream(filename);
			
			//read the value into here
			int value = 0;
			
			//add data to the output stream -1 is returned when finished
			while ((value = input.read()) != -1)
			{
				System.out.print(value + " ");
			}
			
			//flush the buffer and close the steam
			{
				output.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//### SETTERS ###
	private void createOutput(String filename, int amount)
	{
		try
		{
			//create the output stream
			output = new FileOutputStream(filename);
			
			//add data to the output stream
			for (int i = 1; i <= amount; i++)
			{
				//write the numbers consecutively on the same line
				output.write(i);
			}
			
			//flush the buffer and close the steam
			output.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
