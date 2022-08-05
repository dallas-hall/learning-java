package Chapter03;

import java.util.Scanner;

public class SecondsToHours
{
	public static void main(String[] args)
	{
		int hours, minutes, seconds;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the amount of seconds. This will be converted to hours:minutes:seconds");

		int inputSeconds = scanner.nextInt();
		// Consume the trailing newline.
		scanner.nextLine();

		seconds = inputSeconds % 60;
		minutes = inputSeconds / 60 % 60;
		hours = inputSeconds / 60 / 60;

		// https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
		System.out.printf(inputSeconds + " seconds is %1$2s:%2$2s:%3$2s", hours, minutes, seconds);
	}
}
