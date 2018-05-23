package chapter12_exceptions_and_text_io.Question12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>PROGRAM NAME GOES HERE</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
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
		System.out.println("[INFORMATION] Printing new line brace and then switching it to same line brace.");
		System.out.println(newLine);
		System.out.println(runtime.stringSwitchToSameLine(newLine));
		//System.out.println("\n[INFORMATION] Printing same line brace and then switching it to new line brace.");
		//System.out.println(sameLine);
		//System.out.println(runtime.stringSwitchToNewline(sameLine));
		
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
		// Look for a newline followed by optional spaces/tabs that have a curly brace after it
		Pattern pattern = Pattern.compile("(?<spaces>[ \t]*)\\{\n");
		// Replace the above pattern with a space and curly brace
		return inputString.replaceAll("([ \t]*)([A-Za-z0-9\\p{Punct}]) \\{\n([ \t]*)", "$1$2\n");
	}
	
	public String stringSwitchToSameLine(String inputString)
	{
		// Look for a newline followed by optional spaces/tabs that have a curly brace after it
		Pattern pattern = Pattern.compile("\n[ \t]*\\{");
		// Replace the above pattern with a space and curly brace
		return inputString.replaceAll(pattern.toString(), " {");
	}
	
	//@@@ INNER CLASS(ES) @@@
}
