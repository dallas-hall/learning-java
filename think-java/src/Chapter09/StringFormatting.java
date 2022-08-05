package Chapter09;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StringFormatting
{
	private static final Logger logger = Logger.getLogger(StringFormatting.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Original Strings.");
		Thread.sleep(005);
		StringFormatting runtime = new StringFormatting();
		System.out.println(runtime.timeString(0, 1));
		System.out.println(runtime.timeString(0, 15));
		System.out.println(runtime.timeString(12, 1));
		System.out.println(runtime.timeString(18, 59));
	}

	public String timeString(int hour, int minute)
	{
		String suffix;
		if (hour < 12) {
			suffix = "AM";
			if (hour == 0) {
				hour = 12;
			}
		}
		else {
			suffix = "PM";
			if (hour > 12) {
				hour = hour - 12;
			}
			else {
				hour = 12;
			}
		}
		return String.format("%02d:%02d %s", hour, minute, suffix);
	}
}
