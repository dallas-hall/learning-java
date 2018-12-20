package Chapter08;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Histogram
{
	private static final Logger logger = Logger.getLogger(Histogram.class.getName());

	public static void main(String[] args) throws InterruptedException
	{
		logger.log(Level.INFO, "Test scores histogram.");
		Thread.sleep(005);

		Histogram runtime = new Histogram();
		int students = 10;
		// 0% - 100%
		int[] testScores = runtime.createTestScores(students);
		int[] histogram = runtime.countTestScoresForLoop(testScores);
		int[] histogram2 = runtime.countTestScoresForEachLoop(testScores);

		System.out.println(Arrays.toString(testScores));
		System.out.println(Arrays.toString(histogram));
		System.out.println(Arrays.toString(histogram2));
	}

	public int[] createTestScores(int studentAmount)
	{
		int[] testScores = new int [studentAmount];

		for (int i = 0; i < studentAmount; i++) {
			testScores[i] = ThreadLocalRandom.current().nextInt(0, 101);
		}

		return testScores;
	}

	public int[] countTestScoresForLoop(int[] testScores)
	{
		// Storing 0% - 100%
		int[] histogram = new int[101];
		for (int i = 0; i < testScores.length; i++) {
			// Get the score and add it to the histogram
			int j = testScores[i];
			histogram[j]++;
		}
		return histogram;
	}

	public int[] countTestScoresForEachLoop(int[] testScores)
	{
		int[] histogram = new int[101];
		for(int score: testScores) {
			histogram[score]++;
		}
		return histogram;
	}
}
