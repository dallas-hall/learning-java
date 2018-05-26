package chapter12_exceptions_and_text_io.Question13;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Count Characters, Words, & Lines</h1>
 * <p>
 * This program will read a file and count its characters, words (regex word blocks), and lines. It will display the results.
 * </p>
 * <p>
 * tags:	Charset; LinkedHashMap; static immutable map; static initialiser; Path; Paths; File;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-26
 */
public class CountFileCharactersWordsLines
{
	//@@@ CLASS VARIABLES @@@
	//### Character Sets ###
	// Static and immutable map initialisation - https://stackoverflow.com/a/507658
	public static final Map<String, Charset> charsets;
	static {
		Map<String, Charset> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("ASCII", Charset.forName("US-ASCII"));
		linkedHashMap.put("ISO-8859-1", Charset.forName("ISO-8859-1"));
		linkedHashMap.put("UTF8", Charset.forName("UTF-8"));
		//default is BE, intel is BE (numbers are displayed right to left, opposite to how humans do it which is also LE)
		linkedHashMap.put("UTF16_LE", Charset.forName("UTF-16LE"));
		linkedHashMap.put("UTF16_BE", Charset.forName("UTF-16"));
		charsets = Collections.unmodifiableMap(linkedHashMap);
	}
	
	//@@@ INSTANCE VARIABLES @@@
	// File I/O
	private Path inputAbsolutePath;
	// File metadata
	private long characters;
	private long words;
	private long lines;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		CountFileCharactersWordsLines runtime = new CountFileCharactersWordsLines("/media/veracrypt1/java-random-files-for-io", "newLine.java");
		System.out.println("[INFORMATION] Printing initial variables.");
		System.out.println("Input path: " + runtime.getInputPathOnly().toString());
		System.out.println("Input file: " + runtime.getInputFileOnly().toString());
		System.out.println("Absolute path: " + runtime.getInputAbsolutePath().toString());
		// Iterating through maps : https://stackoverflow.com/a/1066607
		System.out.println("Charsets available:");
		for(String currentKey : charsets.keySet()) {
			System.out.println("\t" + charsets.get(currentKey));
		}
		System.out.println("\n[INFORMATION] Reading file & calculating metadata.");
		runtime.setFileMetadata();
		System.out.println("Total lines was: " + runtime.getLineCount());
		System.out.println("Total characters was: " + runtime.getCharacterCount());
		System.out.println("Total words was: " + runtime.getWordCount());
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public CountFileCharactersWordsLines(String inputPath, String inputFile)
	{
		
		if(inputPath.charAt(inputPath.length() - 1) != '/')
			this.inputAbsolutePath = Paths.get(inputPath + "/" + inputFile);
		else
			this.inputAbsolutePath = Paths.get(inputPath + inputFile);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public Path getInputAbsolutePath()
	{
		return inputAbsolutePath;
	}
	
	public Path getInputPathOnly()
	{
		// Need -1 so we remove the filename
		return Paths.get("/" + inputAbsolutePath.subpath(0, inputAbsolutePath.getNameCount() - 1));
	}
	
	public Path getInputFileOnly()
	{
		return inputAbsolutePath.getFileName();
	}
	
	public long getCharacterCount()
	{
		return characters;
	}
	
	public long getWordCount()
	{
		return words;
	}
	
	public long getLineCount()
	{
		return lines;
	}

	//### SETTERS ###
	public void setFileMetadata()
	{
		// The new try with resources approach, automatically closes the resource the the end.
		// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputAbsolutePath.toFile()))) {
			// store the current line here
			String currentLine;
			// Store the current line as a String into currentLine.  The readLine() method returns null when the end of line is reached.
			while ((currentLine = bufferedReader.readLine()) != null) {
				lines++;
				characters += currentLine.length();
				words += countWords(currentLine);
			}
		}
		catch (IOException e) {
			System.out.println("[ERROR] File error occurred.\n" + e.getStackTrace());
		}
	}
	
	//### HELPERS ###
	public long countWords(String currentLine)
	{
		// Need to escape the \ into \\. The capture group is needed so we can return captured group count.
		int matchCount = 0;
		Pattern pattern = Pattern.compile("\\b(\\w+)\\b");
		Matcher matcher = pattern.matcher(currentLine);
		// https://stackoverflow.com/a/7378472
		while(matcher.find()) {
			matchCount++;
		}
		return matchCount;
	}
}
