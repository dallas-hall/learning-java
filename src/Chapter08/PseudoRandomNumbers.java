package Chapter08;

import java.util.Arrays;
import java.util.Random;

public class PseudoRandomNumbers
{
	private int[] numbers;

	public static void main(String[] args)
	{
		PseudoRandomNumbers prn = new PseudoRandomNumbers();
		prn.setNumbers(prn.createArray());
		System.out.println(Arrays.toString(prn.getNumbers()));
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
}
