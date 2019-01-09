package Chapter11;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeTest
{
	private static Time time1;
	private static Time time2;
	
	@org.junit.jupiter.api.BeforeAll
	static void initAll()
	{
		time1 = new Time();
		time2 = new Time(25, 61, 61.9);
	}
	
	// Execution order isn't permanent yet, so need this dirty hack
	@org.junit.jupiter.api.Test
	void testAll()
	{
		System.out.println("time1Constructor");
		time1Constructor();
		System.out.println("time2Constructor");
		time2Constructor();
		System.out.println("time1Update");
		time1Update();
		System.out.println("timeComparison");
		timeComparison();
		System.out.println("time2Update");
		time2Update();
		System.out.println("addTime");
		addTime();;
	}
	
	void time1Constructor()
	{
		assertEquals("00:00:00.0", time1.toString());
		System.out.println("time1 is " + time1);
	}
	
	void time2Constructor()
	{
		assertEquals("02:02:01.9", time2.toString());
		System.out.println("time2 is " + time2);
	}
	
	
	void time1Update()
	{
		System.out.println("time1 is " + time1);
		time1.incrementHours(25);
		time1.incrementMinutes(61);
		time1.incrementSeconds(61.9);
		assertEquals("02:02:01.9", time1.toString());
	}
	
	void timeComparison()
	{
		System.out.println("time1 is " + time1);
		System.out.println("time2 is " + time2);
		assertEquals(true, time1.equals(time2));
		assertEquals(true, time2.equals(time1));
	}
	
	void time2Update()
	{
		time2.setHours(16);
		time2.setMinutes(59);
		time2.setSeconds(59.9);
		assertEquals("16:59:59.9", time2.toString());
		System.out.println("time2 is " + time2);
		time2.incrementSeconds(0.1);
		assertEquals("17:00:00.0", time2.toString());
		System.out.println("time2 is " + time2);
		time2.incrementMinutes(59);
		System.out.println("time2 is " + time2);
		assertEquals("17:59:00.0", time2.toString());
		time2.incrementMinutes(1);
		assertEquals("18:00:00.0", time2.toString());
		System.out.println("time2 is " + time2);
		time2.incrementHours(6);
		assertEquals("00:00:00.0", time2.toString());
		System.out.println("time2 is " + time2);
		time2.incrementHours(25);
		assertEquals("01:00:00.0", time2.toString());
		System.out.println("time2 is " + time2);
	}
	
	void addTime()
	{
		System.out.println("time2 is " + time2);
		Time result = time2.addTime(time2);
		assertEquals("02:00:00.0", result.toString());
		System.out.println("result is " + result);
		result = result.addTime(new Time(22, 61, 61.0));
		assertEquals("01:02:01.0", result.toString());
		System.out.println("result is " + result);
		
	}
}
