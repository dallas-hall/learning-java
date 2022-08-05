package Chapter11;
/**
 * <h1>TimeMain</h1>
 * <p>
 * This driver class for the Time class.
 * </p>
 *
 * @author blindcant
 * @version 0.1.0 - 2019-01-09
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeMain
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(TimeMain.class.getName());
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Time Driver Class");
		// 00:00:00.0
		Time runtime1 = new Time();
		// 14:15:45.9
		Time runtime2 =  new Time(14, 15, 45.9);
		// 02:02:01.9
		Time runtime3 =  new Time(25, 61, 61.9);
		
		// Implicit call to object.toString()
		System.out.println(runtime1);
		System.out.println(runtime2);
		System.out.println(runtime3);
		
		// Set to 00:00:00
		runtime2.incrementSeconds(14.1);
		System.out.println(runtime2);
		runtime2.incrementMinutes(44);
		System.out.println(runtime2);
		runtime2.incrementHours(9);
		System.out.println(runtime2);
		
		System.out.println(runtime1.equals(runtime2));
		
	}
}
