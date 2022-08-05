package Chapter06;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Prod
{
	private static final Logger logger = Logger.getLogger(Prod.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		Prod runtime = new Prod();
		logger.log(Level.INFO, "Exercise 6 - prod recursion");
		Thread.sleep(005);
		for (int i = 1; i < 10; i++) {
			System.out.println(runtime.prod(1, i));
			System.out.println(runtime.prodRewrite(1, i));
		}
	}

	public static int prod(int m, int n)
	{
		if (m == n) {
			return n;
		} else {
			int recurse = prod(m, n - 1);
			int result = n * recurse;
			return result;
		}
	}

	public static int prodRewrite(int m, int n)
	{
		if (m == n) {
			return n;
		} else {
			return prod(m, n - 1) * n;
		}
	}
}
