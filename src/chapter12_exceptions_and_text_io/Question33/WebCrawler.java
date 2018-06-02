package chapter12_exceptions_and_text_io.Question33;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

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
 * @version 0.0.1 - 2018-06-02
 */
public class WebCrawler
{
	//@@@ INSTANCE VARIABLES @@@
	private Scanner scanner;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		WebCrawler runtime = new WebCrawler("http://cs.armstrong.edu/liang");
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public WebCrawler()
	{
		scanner = new java.util.Scanner(System.in);
		System.out.print("Enter a URL: ");
		String url = scanner.nextLine();
		crawler(url); // Traverse the Web from the a starting url
	}
	
	public WebCrawler(String url)
	{
		crawler(url); // Traverse the Web from the a starting url
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	public void crawler(String startingURL)
	{
		ArrayList<String> listOfPendingURLs = new ArrayList<>();
		ArrayList<String> listOfTraversedURLs = new ArrayList<>();
		
		// Add starting url to the pending list
		listOfPendingURLs.add(startingURL);
		while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
			// Remove the starting url from the list and start crawling
			String urlString = listOfPendingURLs.remove(0);
			// Add new urls to the traversed list
			if (!listOfTraversedURLs.contains(urlString)) {
				listOfTraversedURLs.add(urlString);
				System.out.println("Crawling " + urlString);
				
				for (String s : getSubURLs(urlString)) {
					if (!listOfTraversedURLs.contains(s)) {
						listOfPendingURLs.add(s);
					}
				}
			}
		}
	}
	
	public ArrayList<String> getSubURLs(String urlString)
	{
		ArrayList<String> list = new ArrayList<>();
		
		try {
			// Create a URL
			URL url = new java.net.URL(urlString);
			//  Connect to and read from the URL
			scanner = new Scanner(url.openStream());
			int current = 0;
			// Process URL data
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				// Question 33 says to stop when this phrase is found
				//System.out.println(line);
				if (line.contains("Computer Programming") || line.contains("computer programming")
					|| line.contains("Programming") || line.contains("programming")) {
					System.out.println("Found the word at: " + urlString);
					break;
				}
				// Look for more URLs
				current = line.indexOf("http:", current);
				while (current > 0) {
					int endIndex = line.indexOf("\"", current);
					if (endIndex > 0) {
						list.add(line.substring(current, endIndex));
						current = line.indexOf("http:", endIndex);
					}
					else {
						current = -1;
					}
				}
			}
		}
		catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return list;
	}
}
