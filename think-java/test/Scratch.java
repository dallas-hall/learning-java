public class Scratch
{

	public static void main(String[] args)
	{

		System.out.println(gauss(1, 1));
		System.out.println(gauss(1, 5));
		System.out.println(gauss(1, 10));
		System.out.println(gauss(1, 15));
		System.out.println(gauss(1, 20));

		System.out.println(gauss2(1, 1));
		System.out.println(gauss2(1, 5));
		System.out.println(gauss2(1, 10));
		System.out.println(gauss2(1, 15));
		System.out.println(gauss2(1, 20));
	}

	public static double gauss(double x, int n){
		double result = 1;
		int q = 1;
		double p = 1;
		int pre = 1;
		for (int i=1;i<n;i++){
			result += (pre*=-1)*(p*=x*x)/(q*=i);
		}
		return result;
	}

	public static double gauss2 (double x, int n) {
		// https://en.wikipedia.org/wiki/Gaussian_integral
		// e is euler's number. e ^ (-x ^ 2) = 1 - x ^ 2 + x ^ 4 /2 - ... + x ^ i ^ i
		double total = 0;
		double result = 0;
		int exponent = 2;
		int divisor = 2;

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				total +=  1;
			}
			else if (i == 1){
				result = Math.pow(x, exponent);
				total -= result;
				exponent += 2;
			}
			else if (i == n - 1) {
				// the last step is meant to be (-1)^ i * x ^ (2 ^ i) / i!
			}
			else if (i % 2 == 0) {
				result = Math.pow(x, exponent) / divisor;
				total += result;
				divisor += 4;
				exponent += 2;
			} else {
				result = Math.pow(x, exponent) / divisor;
				total -= result;
				divisor += 4;
				exponent += 2;
			}
		}
		return total;
	}

	public static double powerIterative(double x, int n)
	{
		if (x == 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			double result = 1;
			for (int i = 1; i <= n; i++) {
				// result * x is the formula needed to calculate powers
				/*
				This works because initially x * 1 = x ^ 1. The result is stored.
				Then result * 2 = x ^ 2 and so on.
				*/
				result = result * x;
			}
			return result;
		}
	}
}
