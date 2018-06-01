import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * <h1>FileReadAndWriteLineByLineBufferedNIO</h1>
 * <p>
 * Character I/O usually occurs in bigger units than single characters. One common unit is the line: a string of
 * characters with a line terminator at the end (\n or \r or \r\n).
 * <p>
 * https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
 * tags:	BufferedReader; newBufferedReader; BufferedWriter; newBufferedWriter; character stream;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-06-01
 */
public class FileReadAndWriteLineByLineBufferedNIO
{
	// Instance Variables
	private BufferedReader stdin = null;
	private BufferedWriter stdout = null;
	private static final Charset UTF8 = Charset.forName("UTF-8");

	// Main Method
	public static void main(String[] args)
	{
		//String inputFilepath = "Linux 101 Chapter Summaries.txt";
		String inputFilepath = "I can eat glass.txt";
		String outputFilepath = "(NIO) Copy of " + inputFilepath;
		System.out.println("Reading in and copying line by line " + inputFilepath + "\nPlease wait.");
		FileReadAndWriteLineByLineBuffered run = new FileReadAndWriteLineByLineBuffered(inputFilepath, outputFilepath);
		System.out.println("Finished copying line by line the data in " + inputFilepath + " to " + outputFilepath);
	}

	public FileReadAndWriteLineByLineBufferedNIO(String inputFilepath, String outputFilepath)
	{
		try
		{
			// The Files.newBufferedReader malformed-input and unmappable-character error reporting trap.
			// https://stackoverflow.com/a/43446789/7849241
			stdin = Files.newBufferedReader(Paths.get(inputFilepath), UTF8);
			stdout = Files.newBufferedWriter(Paths.get(outputFilepath), UTF8);
			// do the character copy
			copyFileLineByLine(stdin, stdout);
		} catch (IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
	}

	private void copyFileLineByLine(BufferedReader fileToRead, BufferedWriter fileToWrite) throws IOException
	{
		// store the current line here
		String currentLine;
		// Store the current line as a String into currentLine.  The readLine() method returns null when the end of line is reached.
		while ((currentLine = stdin.readLine()) != null)
		{
			// print the line to stdout
			stdout.write(currentLine);
			stdout.newLine();
		}

		// close the open resources
		stdin.close();
		stdout.close();
	}
}
