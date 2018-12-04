package Chapter05;

public class CountdownRecursion
{
	public static void main(String[] args)
	{
		CountdownRecursion countdownRecursion = new CountdownRecursion();
		countdownRecursion.countdown(10);
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
}
