package chapter09_objects_and_classes;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * <h1>Gregorian Calendar</h1>
 * <p>
 * This program shows how to use the GregorianCalendar class.
 * </p>
 * <p>
 * tags:	GregorianCalendar; TimeZone; Locale;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-04-17
 */
public class Question05
{
	//@@@ INSTANCE VARIABLES @@@
	private GregorianCalendar gregorianCalendar;
	private GregorianCalendar gregorianCalendar2;
	private GregorianCalendar gregorianCalendar3;
	private GregorianCalendar gregorianCalendar4;
	
	private Locale locale;
	private TimeZone timeZone;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Question05 runtime = new Question05();
		System.out.println(runtime.gregorianCalendar.toZonedDateTime());
		System.out.println(runtime.gregorianCalendar2.toZonedDateTime());
		System.out.println(runtime.gregorianCalendar3.toZonedDateTime());
		System.out.println(runtime.gregorianCalendar4.toZonedDateTime());
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public Question05()
	{
		// Australia - https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
		locale = new Locale("AU");
		// AEST
		timeZone = TimeZone.getTimeZone("Australia/Sydney");
		
		// https://docs.oracle.com/javase/10/docs/api/java/util/GregorianCalendar.html
		gregorianCalendar = new GregorianCalendar();
		gregorianCalendar2 = new GregorianCalendar(locale);
		gregorianCalendar3 = new GregorianCalendar(timeZone);
		gregorianCalendar4 = new GregorianCalendar(timeZone, locale);
	}
}
