package chapter17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by blindcant on 2/11/17.
 */
public class BinaryFileStreamUsingTryWithResources
{

	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		BinaryFileStreamUsingTryWithResources runtime = new BinaryFileStreamUsingTryWithResources();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public BinaryFileStreamUsingTryWithResources()
	{
		//a binary file, can't be read with a text editor
		String filename = "temp.dat";
		try
		{
			createOutput(filename, 10);
			readOutput(filename);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	private void readOutput(String filename) throws IOException
	{
		//create the input stream using try-with-resources, which automatically closes the resource
		try (FileInputStream input = new FileInputStream(filename);)
		{
			//read the value into here
			int value = 0;
			
			//add data to the output stream -1 is returned when finished
			while ((value = input.read()) != -1)
			{
				System.out.print(value + " ");
			}
		}
	}
	
	//### SETTERS ###
	private void createOutput(String filename, int amount) throws IOException
	{
		//create the output stream using try-with-resources, which automatically closes the resource
		try (FileOutputStream output = new FileOutputStream(filename);)
		{
			//add data to the output stream
			for (int i = 1; i <= amount; i++)
			{
				//write the numbers consecutively on the same line
				output.write(i);
			}
			
			//flush the buffer and close the steam
			output.close();
		}
	}
}
