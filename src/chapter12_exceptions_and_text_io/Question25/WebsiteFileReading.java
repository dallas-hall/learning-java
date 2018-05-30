package chapter12_exceptions_and_text_io.Question25;

import java.math.BigDecimal;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * <h1>Website File Reading & Processing</h1>
 * <p>
 * This program connects to a website and reads a file there line by line. It splits that file using space and stores
 * the result into an array, and that into an ArrayList. It will then iterate over that ArrayList and sum and avg all
 * the salaries based on position title.
 * </p>
 * <p>
 * tags:	URL; Scanner(url.openStream()); Pattern; Matcher; NumberFormat; BigDecimal;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-30
 */
public class WebsiteFileReading
{
	//@@@ CLASS VARIABLES @@@
	public static final String WEBSITE_URL = "http://cs.armstrong.edu/liang/data/Salary.txt";
	
	//@@@ INSTANCE VARIABLES @@@
	private URL url;
	private Scanner scanner;
	private List<String[]> staff;
	// Money representation - https://stackoverflow.com/a/1359905
	// Use 6 decimal places and round up from >=5
	private BigDecimal assistantTotalSalary;
	private BigDecimal assistantAverageSalary;
	private int assistantStaffTotal;
	private BigDecimal associatesTotalSalary;
	private BigDecimal associatesAverageSalary;
	private int associateStaffTotal;
	private BigDecimal fullTotalSalary;
	private BigDecimal fullAverageSalary;
	private int fullStaffTotal;
	
	// Money to 2 places
	NumberFormat aud2Places;
	// Money to 6 places
	NumberFormat aud6Places;
	
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		WebsiteFileReading runtime = new WebsiteFileReading();
		runtime.getFileData(WEBSITE_URL);
		//runtime.printAllStaff();
		runtime.printTotalSalaries();
		runtime.printAverageSalaries();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public WebsiteFileReading()
	{
		staff = new ArrayList<>();
		// Use Australian formatting to display the money
		aud2Places = NumberFormat.getCurrencyInstance(Locale.getDefault());
		aud2Places.setMinimumFractionDigits(2);
		aud2Places.setMaximumFractionDigits(2);
		aud6Places = NumberFormat.getCurrencyInstance(Locale.getDefault());
		aud6Places.setMinimumFractionDigits(6);
		aud6Places.setMaximumFractionDigits(6);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public void getFileData(String websiteUrl)
	{
		try {
			// Connect to the website and open the file
			url = new URL(websiteUrl);
			scanner = new Scanner(url.openStream());
			String currentLine;
			// Get the file's contents line by line
			while (scanner.hasNext()) {
				currentLine = scanner.nextLine();
				// Store into the staff list
				staff.add(currentLine.split(" "));
			}
		}
		catch (Exception e) {
			System.out.println("[ERROR] Something went wrong, see the stack trace for details.");
			e.printStackTrace();
		}
	}
	
	//### SETTERS ###
	public void calculateTotalSalaries()
	{
		// Use BigDecimal to store money up to 6 decimal places, round >=5
		assistantTotalSalary = BigDecimal.ZERO.setScale(6, BigDecimal.ROUND_HALF_EVEN);
		associatesTotalSalary = BigDecimal.ZERO.setScale(6, BigDecimal.ROUND_HALF_EVEN);
		fullTotalSalary = BigDecimal.ZERO.setScale(6, BigDecimal.ROUND_HALF_EVEN);
		
		for (String[] person : staff) {
			if (person[2].equals("assistant")) {
				assistantTotalSalary = assistantTotalSalary.add(BigDecimal.valueOf(Double.valueOf(person[3]))).setScale(2, BigDecimal.ROUND_HALF_EVEN);
				assistantStaffTotal++;
			}
			else if (person[2].equals("associate")) {
				associatesTotalSalary = associatesTotalSalary.add(BigDecimal.valueOf(Double.valueOf(person[3]))).setScale(2, BigDecimal.ROUND_HALF_EVEN);
				associateStaffTotal++;
			}
			else if (person[2].equals("full")) {
				fullTotalSalary = fullTotalSalary.add(BigDecimal.valueOf(Double.valueOf(person[3]))).setScale(2, BigDecimal.ROUND_HALF_EVEN);
				fullStaffTotal++;
			}
			
		}
	}
	
	public void calculateAverageSalaries()
	{
		// Use BigDecimal to store money up to 6 decimal places, round >=5
		assistantAverageSalary = BigDecimal.ZERO.setScale(6, BigDecimal.ROUND_HALF_EVEN);
		associatesAverageSalary = BigDecimal.ZERO.setScale(6, BigDecimal.ROUND_HALF_EVEN);
		fullAverageSalary = BigDecimal.ZERO.setScale(6, BigDecimal.ROUND_HALF_EVEN);
		
		calculateTotalSalaries();
		// Rounding mode is needed inside of divide()
		assistantAverageSalary = associatesTotalSalary.divide(BigDecimal.valueOf(assistantStaffTotal), BigDecimal.ROUND_HALF_EVEN).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		associatesAverageSalary = associatesTotalSalary.divide(BigDecimal.valueOf(associateStaffTotal), BigDecimal.ROUND_HALF_EVEN).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		fullAverageSalary = fullTotalSalary.divide(BigDecimal.valueOf(fullStaffTotal), BigDecimal.ROUND_HALF_EVEN).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	//### HELPERS ###
	public void printAllStaff()
	{
		for (String[] person : staff) {
			for (int i = 0; i < person.length; i++) {
				System.out.print(person[i] + " ");
			}
			System.out.println();
		}
	}
	
	public void printTotalSalaries()
	{
		calculateTotalSalaries();
		System.out.println("[INFORMATION] Salary totals:");
		System.out.println("The total salary for assistant professors is: " + aud2Places.format(assistantTotalSalary));
		System.out.println("The total salary for associate professors is: " + aud2Places.format(associatesTotalSalary));
		System.out.println("The total salary for full professors is: " + aud2Places.format(fullTotalSalary));
	}
	
	public void printAverageSalaries()
	{
		calculateAverageSalaries();
		System.out.println("[INFORMATION] Salary averages:");
		System.out.println("The average salary for assistant professors is: " + aud2Places.format(assistantAverageSalary));
		System.out.println("The average salary for associate professors is: " + aud2Places.format(associatesAverageSalary));
		System.out.println("The average salary for full professors is: " + aud2Places.format(fullAverageSalary));
	}
	
}
