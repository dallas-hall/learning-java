package Chapter05;

public class CountdownRecursion
{
	public static void main(String[] args)
	{
		CountdownRecursion countdownRecursion = new CountdownRecursion();
		countdownRecursion.countdown(10);
		System.out.println();
		countdownRecursion.countup(3);
	}

	private void countdown(int i)
	{
		if (i < 0) {
			System.out.println("Input must be greater than 0.");
			return;
		}
		else if (i > 0) {
			System.out.println(i + "...");
			countdown(i - 1);
		}
		else {
			System.out.println("Blast off!");
		}
	}

	private void countup(int i)
	{
		if (i < 0) {
			System.out.println("Input must be greater than 0.");
			return;
		}
		else if (i == 0) {
			System.out.println("Blast off!");
		}
		else {
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
}
