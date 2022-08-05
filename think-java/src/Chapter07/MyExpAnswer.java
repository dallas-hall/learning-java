package Chapter07;

public class MyExpAnswer
{
	// https://github.com/AllenDowney/thinkjavasolutions5/blob/master/old_solutions/Exp.java
	public static void main(String[] args)
	{
		System.out.println(myexp(1, 20));
		System.out.println();

		for (int i = 1; i < 2; i++) {
			check(i);
		}
	}

	public static double myexp(double x, int n)
	{
		int i = 1;
		double total = 1.0;
		double num = 1.0;
		double den = 1.0;

		while (i < n) {
			num = num * x;
			den = den * i;
			total = total + num / den;
			i = i + 1;
		}
		return total;
	}

	public static void check(double x)
	{
		System.out.print(x + "\t");
		System.out.print(myexp(x, 20) + "\t");
		System.out.println(Math.exp(x));

	}
}
