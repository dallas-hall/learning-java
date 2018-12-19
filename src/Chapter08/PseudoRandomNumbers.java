package Chapter08;

import java.util.Arrays;
import java.util.Random;

public class PseudoRandomNumbers
{
	public static void main(String[] args)
	{
		Random prn = new Random();
		int[] numbers = new int[prn.nextInt(32)];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = prn.nextInt(100);
		}

		System.out.println(Arrays.toString(numbers));
	}
}
