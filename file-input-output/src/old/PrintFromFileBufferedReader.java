import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by hmd911 on 16/05/2017.
 */
public class PrintFromFileBufferedReader
{
	public static void main(String[] args)
	{
		PrintFromFileBufferedReader run1 = new PrintFromFileBufferedReader();
	}

	public PrintFromFileBufferedReader()
	{
		printFromFileScanner("Linux 101 Chapter Summaries.txt");
	}

	public void printFromFileScanner(String inputFilename)
	{
		BufferedReader inputReader = null;

		try
		{
			//Create the File object
			File filename = new File(inputFilename);

			//Assign the File object to the BufferedReader via FileReader
			inputReader = new BufferedReader(new FileReader(filename), 16384);

			//Check if the File object points to a real file
			if (!filename.exists())
			{
				System.out.println("ERROR: file doesn't exist.");
			} else
			{
				String outputLine = null;

				while (inputReader.readLine() != null)
				{
					outputLine = inputReader.readLine();
					System.out.println(outputLine);
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
			}
			catch (Exception e)
			{
				System.out.println("ERROR: Exception encountered.\n" + e.getMessage());
			}

		}
	}


}
