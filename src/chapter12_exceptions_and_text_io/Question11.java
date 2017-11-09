package chapter12_exceptions_and_text_io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by blindcant on 14/05/17.
 */
public class Question11
{
	//INSTANCE VARIABLES
	//I/O stuff
	private File sourceFile;
	private File targetFile;
	private Scanner stdinKeyboard = new Scanner(System.in);
	private Scanner stdinFile;
	private PrintWriter stdoutFile;
	boolean sourceFileValidation = false;
	boolean targetFileValidation = false;
	//system properties - https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
	// in UNIX this is /home/username and in Windows it is either C:\_users\_username or C:\Documents and Settings\_username  (replace _ with nothing - needed because Java treats \ u as Unicode declaration)
	private String home = System.getProperty("user.home");
	// in UNIX this is / and in Windows it is \
	private String fileSeparator = System.getProperty("file.separator");
	// in UNIX this is \n and in Windows it is \r\n
	private String lineSeparator = System.getProperty("line.separator");
	
	//MAIN METHOD
	public static void main(String[] args)
	{
		Question11 run1 = new Question11();
	}
	
	//CONSTRUCTOR(S)
	public Question11()
	{
		createFileObjects();
		try
		{
			doFilesExist();
			updateFile();
		} catch (IOException e)
		{
			System.out.println("\nERROR: I/O Exception encountered.\n" + e.toString());
			System.exit(1);
		}
	}
	
	//METHODS
	public File getSourceFile()
	{
		return sourceFile;
	}
	
	public File getTargetFile()
	{
		return targetFile;
	}
	
	public void createFileObjects()
	{
		//create the sourcefile File object
		System.out.println("Enter the name of the source file.");
		sourceFile = new File(home + fileSeparator + stdinKeyboard.nextLine());
		System.out.println(sourceFile);
		//create the targetfile File object
		System.out.println("Enter the name of the target file.");
		targetFile = new File(home + fileSeparator + stdinKeyboard.nextLine());
		System.out.println(targetFile);
		System.out.println("File objects created.\n");
	}
	
	public void doFilesExist() throws IOException
	{
		System.out.println("Checking if the file(s) exists on the filesystem.");
		sourceFileValidation = isFileObjectValid(getSourceFile());
		targetFileValidation = isFileObjectValid(getTargetFile());
		System.out.println("Does the source file exist? " + sourceFileValidation);
		if (sourceFileValidation)
		{
			System.out.println("Exists @ " + getSourceFile().getAbsolutePath() + "\n");
		}
		else
		{
			throw new IOException("Source file does not exist, cannot continue.");
		}
		System.out.println("Does the target file exist? " + targetFileValidation);
		if (targetFileValidation)
		{
			System.out.println("Exists @ " + getTargetFile().getAbsolutePath() + "\n");
		}
	}
	
	public boolean isFileObjectValid(File fileObject)
	{
		if (fileObject.exists())
		{
			return true;
		} else
		{
			return false;
		}
	}
	
	public void updateFile() throws IOException
	{
		//get user input for string replacement
		System.out.println("Enter the string to be replaced.");
		String replacee = stdinKeyboard.nextLine();
		System.out.println("Enter the replacement string.");
		String replacement = stdinKeyboard.nextLine();
		
		//Do the file I/O operations
		stdinFile = new Scanner(getSourceFile());
		stdoutFile = new PrintWriter(getTargetFile());
		
		//check that the source file has contents in it still
		while (stdinFile.hasNext())
		{
			//read in and store the entire line
			String stdinLine = stdinFile.nextLine();
			String stdoutLine = stdinLine.replaceAll(replacee, replacement);
			//save the output to the target file
			stdoutFile.println(stdoutLine);
		}
		
		//close our open resources
		stdinFile.close();
		stdoutFile.close();
		stdinKeyboard.close();
	}
}

