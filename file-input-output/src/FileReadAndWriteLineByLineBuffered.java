import java.io.*;

/**
 * <h1>FileReadAndWriteLineByLineBuffered</h1>
 * <p>
 * Character I/O usually occurs in bigger units than single characters. One common unit is the line: a string of
 * characters with a line terminator at the end (\n or \r or \r\n).
 * <p>
 * https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
 * <p>
 * tags:	BufferedReader; FileReader; PrintWriter; FileWriter; character stream;
 * </p>
 *
 * @author dhall
 * @version 0.1 - 2018-06-01
 */
public class FileReadAndWriteLineByLineBuffered
{
	//@@@ INSTANCE VARIABLES @@@
	private BufferedReader stdin = null;
	private PrintWriter stdout = null;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//String inputFilepath = "Linux 101 Chapter Summaries.txt";
		String inputFilepath = "I can eat glass.txt";
		String outputFilepath = "Copy of " + inputFilepath;
		System.out.println("Reading in and copying line by line " + inputFilepath + "\nPlease wait.");
		FileReadAndWriteLineByLineBuffered run = new FileReadAndWriteLineByLineBuffered(inputFilepath, outputFilepath);
		System.out.println("Finished copying line by line the data in " + inputFilepath + " to " + outputFilepath);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public FileReadAndWriteLineByLineBuffered(String inputFilepath, String outputFilepath)
	{
		try
		{
			// assign our resources for standard input using FileReader and standard output using FileWriter

			// CANNOT CHOOSE DIFFERENT CHARSETS - for this use InputStreamReader on a FileInputStream
			// https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html
			stdin = new BufferedReader(new FileReader(inputFilepath));
			// CANNOT CHOOSE DIFFERENT CHARSETS - for this use OutputStreamWriter on a FileOutputStream
			// https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
			stdout = new PrintWriter(new FileWriter(outputFilepath));
			// do the character copy
			copyFileLineByLine(stdin, stdout);
		} catch (IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	private void copyFileLineByLine(BufferedReader fileToRead, PrintWriter fileToWrite) throws IOException
	{
		// store the current line here
		String currentLine;
		// Store the current line as a String into currentLine.  The readLine() method returns null when the end of line is reached.
		while ((currentLine = stdin.readLine()) != null)
		{
			// print the line to stdout
			stdout.println(currentLine);
		}

		// close the open resources
		stdin.close();
		stdout.close();
	}
}
