package Chapter06;

public class AckermannFunction
{
	public static void main(String[] args)
	{
		AckermannFunction runtime = new AckermannFunction();
		// https://en.wikipedia.org/wiki/Ackermann_function#Example_expansions
		System.out.println(runtime.ackermann(1, 2));
		System.out.println(runtime.ackermann(0, 1));
	}

	private long ackermann(int m, int n)
	{
		long result = 0;
		if(m == 0) {
			result = n + 1;
		}
		else if (m > 0 && n == 0) {
			result = ackermann(m - 1, 1);
		}
		else if (m > 0 && n > 0) {
			result = ackermann(m - 1, (int) ackermann(m, n - 1));
		}

		return result;
	}
}
