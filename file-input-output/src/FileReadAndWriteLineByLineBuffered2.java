import java.io.*;
import java.nio.charset.Charset;

/**
 * <h1>FileReadAndWriteLineByLineBuffered2</h1>
 * <p>
 * Character I/O usually occurs in bigger units than single characters. One common unit is the line: a string of
 * characters with a line terminator at the end (\n or \r or \r\n).
 * <p/>
 * <p>A FileInputStream obtains input bytes from a file in a file system.
 * InputStreamReader is a bridge from byte streams to character streams: It reads bytes and decodes them into characters using a specified charset.
 * BufferedReader reads text from a character stream.
 *
 * FileOutputStream is meant for writing streams of raw bytes such as image data.
 * An OutputStreamWriter is a bridge from character streams to byte streams: Characters written to it are encoded into bytes using a specified charset.
 * BufferedWriter writes text to a character-output stream.</p>
 *
 * https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
 *
 * tags:	BufferedReader; InputStreamReader; FileInputStream; BufferedWriter; OutputStreamWriter; FileOutputStream; byte stream; character stream;
 * </p>
 *
 * @author dhall
 * @version 0.1 - 2018-06-01
 */
public class FileReadAndWriteLineByLineBuffered2
{
	//@@@ INSTANCE VARIABLES @@@
	private BufferedReader stdin = null;
	private BufferedWriter stdout = null;
	private Charset UTF_8 = Charset.forName("UTF-8");
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//String inputFilepath = "Linux 101 Chapter Summaries.txt";
		String inputFilepath = "I can eat glass.txt";
		String outputFilepath = "Copy of " + inputFilepath;
		System.out.println("Reading in and copying line by line " + inputFilepath + "\nPlease wait.");
		FileReadAndWriteLineByLineBuffered2 run = new FileReadAndWriteLineByLineBuffered2(inputFilepath, outputFilepath);
		System.out.println("Finished copying line by line the data in " + inputFilepath + " to " + outputFilepath);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public FileReadAndWriteLineByLineBuffered2(String inputFilepath, String outputFilepath)
	{
		try
		{
			// assign our resources for standard input using FileReader and standard output using FileWriter
			// https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html - talks about using InputStreamReader on a FileInputStream to choose a charset yourself.
			stdin = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilepath), UTF_8));
			// https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html - talks about using OutputStreamWriter on a FileOutputStream to choose a charset yourself.
			stdout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilepath), UTF_8));
			// do the character copy
			copyFileLineByLine(stdin, stdout);
		} catch (IOException ioE)
		{
			System.out.println(ioE.getMessage());
		}
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	private void copyFileLineByLine(BufferedReader fileToRead, BufferedWriter fileToWrite) throws IOException
	{
		// store the current line here
		String currentLine;
		// Store the current line as a String into currentLine.  The readLine() method returns null when the end of line is reached.
		while ((currentLine = stdin.readLine()) != null)
		{
			// print the line to stdout
			stdout.write(currentLine);
		}

		// close the open resources
		stdin.close();
		stdout.close();
	}
}
