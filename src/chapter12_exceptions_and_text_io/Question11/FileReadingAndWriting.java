package chapter12_exceptions_and_text_io.Question11;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <h1>File Reading & Files Writing</h1>
 * <p>
 * This program reads a text file, does a string replacement, and writes to a new text file.
 * </p>
 * <p>
 * tags:	Scanner; PrintWriter; System.getProperty; scanner.hasNext(); scanner.close(); IOException; printWriter.println(); File; fileObject.exists();
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2017-05-14
 */
public class FileReadingAndWriting
{
	//@@@ INSTANCE VARIABLES @@@
	//### I/O stuff ###
	private File sourceFile;
	private File targetFile;
	private Scanner scanner;
	private String home;
	private String fileSeparator;
	private String lineSeparator;
	private String ioPath = "/media/veracrypt1/java-random-files-for-io";
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		FileReadingAndWriting runtime = new FileReadingAndWriting();
		//runtime.createFileObjects(null, null);
		runtime.createFileObjects(runtime.getIoPath() + runtime.getFileSeparator() + "random-text.txt", runtime.getIoPath() + runtime.getFileSeparator() + "random-text-updated.txt");
		try {
			runtime.doFilesExist();
			runtime.updateFile();
		}
		catch (IOException e) {
			System.out.println("\nERROR: I/O Exception encountered.\n" + e.toString());
			System.exit(1);
		}
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public FileReadingAndWriting()
	{
		//system properties - https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
		// in UNIX this is /home/username and in Windows it is either C:\_users\_username or C:\Documents and Settings\_username  (replace _ with nothing - needed because Java treats \ u as Unicode declaration)
		home = System.getProperty("user.home");
		// in UNIX this is / and in Windows it is \
		fileSeparator = System.getProperty("file.separator");
		// in UNIX this is \n and in Windows it is \r\n
		lineSeparator = System.getProperty("line.separator");
		scanner = new Scanner(System.in);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public File getSourceFile()
	{
		return sourceFile;
	}
	
	public File getTargetFile()
	{
		return targetFile;
	}
	
	public String getIoPath()
	{
		return ioPath;
	}
	
	public String getFileSeparator()
	{
		return fileSeparator;
	}
	
	public String getLineSeparator()
	{
		return lineSeparator;
	}
	
	//### SETTERS ###
	public void createFileObjects(String sourceFilePath, String targetFilePath)
	{
		if (sourceFilePath == null) {
			//create the sourcefile File object
			System.out.println("Enter the name of the source file.");
			sourceFile = new File(home + fileSeparator + scanner.nextLine());
		}
		else {
			sourceFile = new File(sourceFilePath);
		}
		System.out.println(sourceFile);
		
		if(targetFilePath == null) {
			//create the target file File object
			System.out.println("Enter the name of the target file.");
			targetFile = new File(home + fileSeparator + scanner.nextLine());
		}
		else {
			targetFile = new File(targetFilePath);
		}
		System.out.println(targetFile);
		
		System.out.println("File objects created.\n");
	}
	
	public void updateFile() throws IOException
	{
		//get user input for string replacement
		System.out.println("Enter the target string to be replaced.");
		String target = scanner.nextLine();
		System.out.println("Enter the replacement string.");
		String replacement = scanner.nextLine();
		
		//Do the file I/O operations
		scanner = new Scanner(getSourceFile());
		PrintWriter printWriter = new PrintWriter(getTargetFile());
		
		//check that the source file has contents in it still
		while (scanner.hasNext()) {
			//read in and store the entire line
			String sourceCurrentLine = scanner.nextLine();
			String outputLine = sourceCurrentLine.replaceAll(target, replacement);
			//save the output to the target file
			printWriter.println(outputLine);
		}
		
		//close our open resources
		scanner.close();
		printWriter.close();
	}
	
	//### HELPERS ###
	public void doFilesExist() throws IOException
	{
		System.out.println("Checking if the file(s) exists on the filesystem.");
		boolean sourceFileValidation = isFileObjectValid(getSourceFile());
		boolean targetFileValidation = isFileObjectValid(getTargetFile());
		System.out.println("Does the source file exist? " + sourceFileValidation);
		if (sourceFileValidation) {
			System.out.println("Exists @ " + getSourceFile().getAbsolutePath() + "\n");
		}
		else {
			throw new IOException("Source file does not exist, cannot continue.");
		}
		System.out.println("Does the target file exist? " + targetFileValidation);
		if (targetFileValidation) {
			System.out.println("Exists @ " + getTargetFile().getAbsolutePath() + "\n");
		}
	}
	
	public boolean isFileObjectValid(File fileObject)
	{
		if (fileObject.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
}

