package chapter12_exceptions_and_text_io.Question12;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Source Code Curly Brace Refactor</h1>
 * <p>
 * This program reads in C style source code from a String or a file, and switches the curly brace location.
 * </p>
 * <p>
 * tags:	Pattern; Matcher; MULTILINE;
 * </p>
 * <p>
 * Much help provided from here https://www.regular-expressions.info/java.html & https://regex101.com/
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-23
 */
public class MoveSourceCodeCurlyBrace
{
	//@@@ CLASS VARIABLES @@@
	public static final String sameLineString = "public class SameLine {\n\tpublic SameLine() {\n\t\tif(true) {\n\t\t\tSystem.out.println(\"Hello World\");\n\t\t}\n\t}\n}";
	public static final String newLineString = "public class NewLine\n{\n\tpublic NewLine()\n\t{\n\t\tif(true)\n\t\t{\n\t\t\tSystem.out.println(\"Hello World\");\n\t\t}\n\t}\n}";
	public static final String sameLineFile = "/media/veracrypt1/java-random-files-for-io/sameLine.java";
	public static final String newLineFile = "/media/veracrypt1/java-random-files-for-io/newLine.java";
	
	
	//@@@ INSTANCE VARIABLES @@@
	private List<Path> paths;
	private BufferedReader bufferedReader;
	private PrintWriter printWriter;
	
	//@@@ MAIN METHOD @@@
	public static void main(String args[])
	{
		MoveSourceCodeCurlyBrace runtime = new MoveSourceCodeCurlyBrace();
		//runtime.testString();
		runtime.createFiles();
		runtime.populateFiles();
		runtime.readFilesAndPrint();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public MoveSourceCodeCurlyBrace()
	{
		paths = new ArrayList<>();
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	
	//### SETTERS ###
	
	//### HELPERS ###
	public String stringSwitchToNewline(String inputString)
	{
		// Note: WITHOUT MATCHER THE MULTILINE DOESN'T WORK!!!
		// Capture the space at the start of the line, capture all the text before the {
		Pattern pattern = Pattern.compile("^([ \t]*)([^{]+) \\{$", Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(inputString);
		// Replace the original spacing and text, add a new line and add the original spacing and the {
		return matcher.replaceAll("$1$2\n$1{");
	}
	
	public String stringSwitchToSameLine(String inputString)
	{
		// Look for a newline followed by optional spaces/tabs that have a curly brace after it
		Pattern pattern = Pattern.compile("\n[ \t]*\\{");
		Matcher matcher = pattern.matcher(inputString);
		// Replace the above pattern with a space and curly brace
		return matcher.replaceAll(" {");
	}
	
	public void testString()
	{
		System.out.println("[INFORMATION] Printing new line brace and then switching it to same line brace.");
		System.out.println(newLineString);
		System.out.println(stringSwitchToSameLine(newLineString));
		System.out.println("\n[INFORMATION] Printing same line brace and then switching it to new line brace.");
		System.out.println(sameLineString);
		System.out.println(stringSwitchToNewline(sameLineString));
	}
	
	public void createFiles()
	{
		System.out.println("[INFORMATION] Creating files using Path & Files.");
		Path sameLinePath = Paths.get(sameLineFile);
		Path newLinePath = Paths.get(newLineFile);
		paths.add(sameLinePath);
		paths.add(newLinePath);
		
		for (Path currentPath : paths) {
			//https://docs.oracle.com/javase/tutorial/essential/io/check.html
			if (Files.exists(currentPath)) {
				// Need -1 here to remove the filename
				System.out.println("The file " + currentPath.getFileName() + " already exists at /" + currentPath.subpath(0, currentPath.getNameCount() - 1));
			}
			else {
				System.out.println("The file " + currentPath.getFileName() + " will be created at /" + currentPath.subpath(0, currentPath.getNameCount() - 1));
				try {
					//https://docs.oracle.com/javase/tutorial/essential/io/file.html#creating
					Files.createFile(currentPath);
				}
				catch (IOException e) {
					System.out.println("[ERROR] Unable to create file.\n");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void populateFiles()
	{
		System.out.println("[INFORMATION] Adding source code to the files.");
		for (Path currentPath : paths) {
			System.out.println("Source code added to " + currentPath.toString());
			try {
				printWriter = new PrintWriter(new FileWriter(currentPath.toFile()));
				if (currentPath.getFileName().toString().equals("sameLine.java")) {
					printWriter.print(sameLineString);
				}
				else {
					printWriter.print(newLineString);
				}
			}
			catch (IOException e) {
				System.out.println("[ERROR] Unable to write to file.\n");
				e.printStackTrace();
			}
			finally {
				printWriter.close();
			}
		}
	}
	
	public void readFilesAndPrint()
	{
		System.out.println("[INFORMATION] Reading source code from the files.");
		for (Path currentPath : paths) {
			System.out.println("Source code read from " + currentPath.toString());
			try {
				bufferedReader = bufferedReader = new BufferedReader(new FileReader(currentPath.toFile()));
				// store the current line here
				String currentLine;
				// Store the current line as a String into currentLine.  The readLine() method returns null when the end of line is reached.
				while ((currentLine = bufferedReader.readLine()) != null)
				{
					System.out.println(currentLine);
				}
			}
			catch (IOException e) {
				System.out.println("[ERROR] Unable to write to file.\n");
				e.printStackTrace();
			}
		}
	}
}
