import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by hmd911 on 16/05/2017.
 */
public class PrintFromFileScanner
{
	private File inputFilename;
	private File outputFilename;

	public static void main(String[] args)
	{
		PrintFromFileScanner run1 = new PrintFromFileScanner();
	}

	public PrintFromFileScanner()
	{
		String filename = "Linux 101 Chapter Summaries.txt";
		printFromFileScanner(filename, "Copy of " + filename);
	}

	public void printFromFileScanner(String inputFilename, String outputFilename)
	{
		Scanner inputReader = null;
		PrintWriter stdoutFile = null;

		try
		{
			//Create the File object
			this.inputFilename = new File(inputFilename);
			this.outputFilename = new File(outputFilename);

			//Assign the File object to the BufferedReader via FileReader
			inputReader = new Scanner(this.inputFilename);

			//create output file
			stdoutFile = new PrintWriter(this.outputFilename);

			//Check if the File object points to a real file
			if (!this.inputFilename.exists() && !this.outputFilename.exists())
			{
				System.out.println("ERROR: files don't exist.");
			} else
			{
				System.out.println("Input file found @ " + this.inputFilename.getAbsolutePath());
				System.out.println("Output file found @ " + this.outputFilename.getAbsolutePath());

				String outputLine = null;

				while (inputReader.hasNext())
				{
					outputLine = inputReader.nextLine();
					//System.out.println(outputLine);
					stdoutFile.println(outputLine);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("ERROR: Exception encountered.\n" + e.getMessage());
		}
		finally
		{
			try
			{
				inputReader.close();
				stdoutFile.flush();
				stdoutFile.close();
			}
			catch (Exception e)
			{
				System.out.println("ERROR: Exception encountered.\n" + e.getMessage());
			}

		}
	}


}
