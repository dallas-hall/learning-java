package chapter12_exceptions_and_text_io.Question12;

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
 *
 * Much help provided from here https://www.regular-expressions.info/java.html
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-23
 */
public class MoveSourceCodeCurlyBrace
{
	//@@@ CLASS VARIABLES @@@
	public static final String sameLine = "public class SameLine {\n\tpublic SameLine() {\n\t\tif(true) {\n\t\t\tSystem.out.println(\"Hello World\");\n\t\t}\n\t}\n}";
	public static final String newLine = "public class NewLine\n{\n\tpublic NewLine()\n\t{\n\t\tif(true)\n\t\t{\n\t\t\tSystem.out.println(\"Hello World\");\n\t\t}\n\t}\n}";
	
	//@@@ INSTANCE VARIABLES @@@
	Scanner scanner;
	
	//@@@ MAIN METHOD @@@
	public static void main(String args[])
	{
		MoveSourceCodeCurlyBrace runtime = new MoveSourceCodeCurlyBrace();
		runtime.testString();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public MoveSourceCodeCurlyBrace()
	{
		scanner = new Scanner(System.in);
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
		System.out.println(newLine);
		System.out.println(stringSwitchToSameLine(newLine));
		System.out.println("\n[INFORMATION] Printing same line brace and then switching it to new line brace.");
		System.out.println(sameLine);
		System.out.println(stringSwitchToNewline(sameLine));
	}
}
