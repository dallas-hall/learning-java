package Chapter08;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PseudoRandomNumbers
{
	private int[] numbers;

	private static final Logger logger = Logger.getLogger(PseudoRandomNumbers.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Create int[] with pseudo random numbers.");
		Thread.sleep(005);
		PseudoRandomNumbers prn = new PseudoRandomNumbers();
		prn.setNumbers(prn.createArray());
		System.out.println(Arrays.toString(prn.getNumbers()));
		logger.log(Level.INFO, "Print some numbers with different start seeds.");
		Thread.sleep(005);
		prn.printPrn(10);
	}

	public int[] createArray() {
		Random prn = new Random();

		int[] numbers = new int[prn.nextInt(32)];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = prn.nextInt(100);
		}
		return numbers;
	}

	public int[] getNumbers()
	{
		return numbers;
	}

	public void setNumbers(int[] numbers)
	{
		this.numbers = numbers;
	}

	public void printPrn(int limit)
	{
		Random prn = new Random();
		Random prn128 = new Random(128);
		Random prn256 = new Random(256);
		Random prn512 = new Random(512);

		for(int i = 0; i < limit; i++) {
			System.out.printf("%-6s\t%1d\t%-6s\t%1d\t%-6s\t%1d\t%-6s\t%1d\n"
					,"prn", prn.nextInt()
					,"prn128", prn128.nextInt()
					,"prn256", prn256.nextInt()
					,"prn512", prn512.nextInt()
			);
		}
	}
}
