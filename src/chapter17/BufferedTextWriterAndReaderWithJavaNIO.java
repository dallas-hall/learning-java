package chapter17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by blindcant on 2/11/17.
 * <p>
 * Question 1 - text I/O with java.io and java.nio
 */
 

public class BufferedTextWriterAndReaderWithJavaNIO
{
	//@@@ INSTANCE VARIABLES @@@
	private Path filePath;
	private StringBuffer aStringBuffer;
	public static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		BufferedTextWriterAndReaderWithJavaNIO runtime = new BufferedTextWriterAndReaderWithJavaNIO(100);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public BufferedTextWriterAndReaderWithJavaNIO(int amount)
	{
		try
		{
			//create the StringBuffer and file path, both are used for text processing
			aStringBuffer =  new StringBuffer();
			filePath = Paths.get(amount + "_doubles.txt");
			
			//create and read the file
			createTextFile(filePath, UTF_8, amount);
			readTextFile(filePath, UTF_8);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public void readTextFile(Path filePath, Charset charset) throws IOException
	{
		//check if the file exists, if it doesn't throw an error
		if(Files.notExists(filePath))
		{
			throw new IOException("File doesn't exist.");
		}
		
		//read the file in if it does exist
		try (BufferedReader bufferedReader = Files.newBufferedReader(filePath, charset); )
		{
			//try to read the first line
			String currentLine = null;
			
			// Store the current line as a String into currentLine.  The readLine() method returns null when the end of line is reached.
			//The while loop means the next line is continually read until EOF
			while((currentLine = bufferedReader.readLine()) != null)
			{
				//print out a line if it exists
				System.out.println(currentLine);
			}
		}
	}
	
	//### SETTERS ###
	public void createTextFile(Path filePath, Charset charset, int amount) throws IOException
	{
		//check if the file exists, create it if it doesn't and overwrite it if it does
		if(Files.notExists(filePath))
		{
			Files.createFile(filePath);
		}
		else
		{
		
		}
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath, charset) ;)
		{
			for (int i = 1; i <= amount; i++)
			{
				//create a random double between 1.0 and 101.0, excluding 101.0
				double aDouble = ThreadLocalRandom.current().nextDouble(1, 101);
				
				//append to StringBuffer and then write it
				aStringBuffer.append(aDouble);
				
				bufferedWriter.write( aStringBuffer.toString());
				
				//write on the same line until 10 are written, then start a new line
				if(i % 10 != 0)
				{
					bufferedWriter.write( "\t");
				}
				else
				{
					bufferedWriter.write( "\n");
				}
				
				//reset the StringBuffer
				aStringBuffer.delete(0, aStringBuffer.length());
			}
		}
		
	}
}
