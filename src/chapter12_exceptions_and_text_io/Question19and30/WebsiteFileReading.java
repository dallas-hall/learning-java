package chapter12_exceptions_and_text_io.Question19and30;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Website Reader & Counter</h1>
 * <p>
 * This program connects to a website and opens a file. It will then read in the file line by line, and count its characters, words, and lines. It now counts individual letters as well.
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
	private Map<String, Integer> letterCount;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		WebsiteFileReading runtime = new WebsiteFileReading();
		runtime.getWebsiteData(WEBSITE_URL);
		runtime.printResults(WEBSITE_URL);
		runtime.printLetterCountMap();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public WebsiteFileReading(String websiteURL)
	{
		this.websiteURL = websiteURL;
		letterCount = new LinkedHashMap<>();
		populateMap();
	}
	
	public WebsiteFileReading()
	{
		letterCount = new LinkedHashMap<>();
		populateMap();
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
				countCharacters(currentLine);
			}
		}
		catch (Exception e) {
			System.out.println("[ERROR] Something went wrong, see the stack trace for details.");
			e.printStackTrace();
		}
	}
	//### SETTERS ###
	private void populateMap()
	{
		int uppercaseCodePoint = 65;
		int lowercaseCodePoint = 97;
		
		for (int i = uppercaseCodePoint; i < uppercaseCodePoint + 26; i++) {
			letterCount.put(String.valueOf((char) i), 0);
		}
		
		for (int i = lowercaseCodePoint; i < lowercaseCodePoint + 26; i++) {
			letterCount.put(String.valueOf((char) i), 0);
		}
	}
	
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
	
	private void countCharacters(String currentLine)
	{
		int matchCount = 0;
		int uppercaseCodePoint = 65;
		int lowercaseCodePoint = 97;
		
		for (int i = uppercaseCodePoint; i < uppercaseCodePoint + 26; i++) {
			Pattern pattern = Pattern.compile(String.valueOf((char) i));
			Matcher matcher = pattern.matcher(currentLine);
			// https://stackoverflow.com/a/7378472
			while (matcher.find()) {
				matchCount++;
			}
			letterCount.put(String.valueOf((char) i), matchCount + letterCount.get(String.valueOf((char) i)));
		}
		
		for (int i = lowercaseCodePoint; i < lowercaseCodePoint + 26; i++) {
			Pattern pattern = Pattern.compile(String.valueOf((char) i));
			Matcher matcher = pattern.matcher(currentLine);
			// https://stackoverflow.com/a/7378472
			while (matcher.find()) {
				matchCount++;
			}
			letterCount.put(String.valueOf((char) i), matchCount + letterCount.get(String.valueOf((char) i)));
		}
	}
	
	public void printResults(String websiteURL)
	{
		System.out.println("[INFORMATION] File metadata:");
		System.out.println("URL: " + websiteURL);
		System.out.println("Lines: " + lines);
		System.out.println("Words: " + words);
		System.out.println("Characters: " + characters);
	}
	
	public void printLetterCountMap()
	{
		// https://stackoverflow.com/a/32264826
		letterCount.forEach((key, value) -> {
			System.out.println("Key : " + key + " Value : " + value);
		});
	}
}
