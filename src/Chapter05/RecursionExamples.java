package Chapter05;

public class RecursionExamples
{
	public static void main(String[] args)
	{
		RecursionExamples countdownRecursion = new RecursionExamples();
		countdownRecursion.countdown(10);
		System.out.println();
		countdownRecursion.countup(3);
		System.out.println();
		countdownRecursion.convertDecimalToBinary(32);
	}

	private void countdown(int i)
	{
		// Error check.
		if (i < 0) {
			System.out.println("Input must be greater than 0.");
			return;
		} else if (i > 0) {
			System.out.println(i + "...");
			countdown(i - 1);
		}
		// This is the base case (the final stack frame) for the stack diagram. This ends the recursion.
		else {
			System.out.println("Blast off!");
		}
	}

	private void countup(int i)
	{
		// Error check.
		if (i < 0) {
			System.out.println("Input must be greater than 0.");
			return;
		}
		// This is the base case (the final stack frame) for the stack diagram. This ends the recursion.
		else if (i == 0) {
			System.out.println("Blast off!");
		} else {
			/*
			The recursive calls here delay the println from executing.
			Each time the call is made, a new frame is added to the stack, which holds the current value of i.
			*/
			countup(i - 1);
			/*
			Once the recursion is over, the println is executed before the stack frames are popped.
			 */
			System.out.println(i + "...");
		}
	}

	/**
	 * This method converts a binary number to a decimal. This works because of using the recursive print in reverse trick.
	 * This reverse printing tricks mimics converting decimal to binary by hand, which is writing the powers of 2 right to left.
	 *
	 * @param i
	 */
	private void convertDecimalToBinary(int i)
	{
		// Error check.
		if (i < 0) {
			System.out.println("Input must be greater than 0.");
			return;
		}
		/*
		This handles the base case (the final stack frame) for the stack diagram. This ends the recursion.
		It also handles every other case.

		 */
		else if (i > 0) {
			/*
			The recursive calls here delay the println from executing.
			Each time the call is made, a new frame is added to the stack, which holds the current value of i.

			Using integer division to halve the number before the recursive call.
			*/
			convertDecimalToBinary(i / 2);
			/*
			Once the recursion is over, the println is executed before the stack frames are popped.

			Using modulo to get the remainder, which is 0 for even and 1 for odd.
			By printing this in reverse, it shows the binary number.
			 */
			System.out.print(i % 2);
		}
	}
}
