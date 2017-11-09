package chapter17;

import java.io.*;
import java.util.Scanner;

/**
 * Created by blindcant on 2/11/17.
 * <p>
 * Question 1 - text I/O with java.io
 */
public class TextWithPrintWriterAndScanner
{
	//@@@ INSTANCE VARIABLES @@@
	private File file;
	public static final java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		TextWithPrintWriterAndScanner runtime = new TextWithPrintWriterAndScanner(100);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public TextWithPrintWriterAndScanner(int amount)
	{
		file = new File(amount + "_integers.txt");
		try
		{
			createTextFile(file, UTF_8, amount);
			readTextFile(file, UTF_8);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public void readTextFile(File fileObject, java.nio.charset.Charset charset) throws FileNotFoundException
	{
		//create a Scanner object to the read the File object using UTF-8
		try (Scanner scanner = new Scanner(fileObject, charset.toString()); )
		{
			//create a StringBuffer to hold our data with
			StringBuffer aStringBuffer = new StringBuffer();
			
			//check that we have a line
			while (scanner.hasNextLine())
			{
				//read in the next line
				aStringBuffer.append(scanner.nextLine());
				
				
				//print the line
				System.out.println(aStringBuffer.toString());
				
				//reset the StringBuffer
				aStringBuffer.delete(0, aStringBuffer.length());
			}
		}
	}
	
	//### SETTERS ###
	public void createTextFile(File fileObject, java.nio.charset.Charset charset, int amount) throws IOException
	{
		//Replace the file if it exists or create it if the file doesn't exist, then write to it using UTF-8. I
		try ( PrintWriter printWriter = new PrintWriter(fileObject, UTF_8.toString()); )
		{
			for (int i = 1; i <= 100; i++)
			{
				//write 9 on a row
				printWriter.print(i + "\t");
				//write the 10th on the row and then start a new line
				if (i % 10 == 0)
				{
					printWriter.println();
				}
			}
			}
	}
}
