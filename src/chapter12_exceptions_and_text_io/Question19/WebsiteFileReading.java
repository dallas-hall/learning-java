package chapter12_exceptions_and_text_io.Question19;

import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Website Reader & Counter</h1>
 * <p>
 * This program connects to a website and opens a file. It will then read in the file line by line, and count its characters, words, and lines.
 * </p>
 * <p>
 * tags:	URL; Scanner(url.openStream()); Pattern; Matcher; regex;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-30
 */
public class WebsiteFileReading
{
	//@@@ CLASS VARIABLES @@@
	public static final String WEBSITE_URL = "http://cs.armstrong.edu/liang/data/Lincoln.txt";
	
	//@@@ INSTANCE VARIABLES @@@
	private String websiteURL;
	private String websiteData;
	private Scanner scanner;
	private int lines;
	private int words;
	private int characters;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		WebsiteFileReading runtime = new WebsiteFileReading();
		runtime.getWebsiteData(WEBSITE_URL);
		runtime.printResults(WEBSITE_URL);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public WebsiteFileReading(String websiteURL)
	{
		this.websiteURL = websiteURL;
	}
	
	public WebsiteFileReading()
	{
	
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public void getWebsiteData(String websiteURL)
	{
		String currentLine = null;
		try {
			URL url = new URL(websiteURL);
			scanner = new Scanner(url.openStream());
			while (scanner.hasNext()) {
				currentLine = scanner.nextLine();
				lines++;
				characters += currentLine.length();
				words += countWords(currentLine);
			}
		}
		catch (Exception e) {
			System.out.println("[ERROR] Something went wrong, see the stack trace for details.");
			e.printStackTrace();
		}
	}
	//### SETTERS ###
	
	//### HELPERS ###
	private long countWords(String currentLine)
	{
		// Need to escape the \ into \\. The capture group is needed so we can return captured group count.
		int matchCount = 0;
		Pattern pattern = Pattern.compile("\\b(\\w+)\\b");
		Matcher matcher = pattern.matcher(currentLine);
		// https://stackoverflow.com/a/7378472
		while (matcher.find()) {
			matchCount++;
		}
		return matchCount;
	}
	
	public void printResults(String websiteURL)
	{
		System.out.println("[INFORMATION] File metadata:");
		System.out.println("URL: " + websiteURL);
		System.out.println("Lines: " + lines);
		System.out.println("Words: " + words);
		System.out.println("Characters: " + characters);
	}
}
