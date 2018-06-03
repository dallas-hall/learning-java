package chapter03_selections;

import java.util.Scanner;

/**
 * <h1>ChineseZodiac</h1>
 * <p>
 * This program shows the algorithm to calculate Chinese Zodiac signs. It is year % 12.
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-06-03
 */
public class ChineseZodiac
{
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a year: ");
		int year = input.nextInt();
		
		switch (year % 12) {
			case 0:
				System.out.println("monkey");
				break;
			case 1:
				System.out.println("rooster");
				break;
			case 2:
				System.out.println("dog");
				break;
			case 3:
				System.out.println("pig");
				break;
			case 4:
				System.out.println("rat");
				break;
			case 5:
				System.out.println("ox");
				break;
			case 6:
				System.out.println("tiger");
				break;
			case 7:
				System.out.println("rabbit");
				break;
			case 8:
				System.out.println("dragon");
				break;
			case 9:
				System.out.println("snake");
				break;
			case 10:
				System.out.println("horse");
				break;
			case 11:
				System.out.println("sheep");
		}
	}
}
