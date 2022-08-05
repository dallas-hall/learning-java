import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <h1>FileReadAndWriteCharacterStream</h1>
 * <p>
 * Used for copying characters via character streams.
 * </p>
 * Character streams are often "wrappers" for byte streams. Character streams are often "wrappers" for byte streams.
 * The character stream uses the byte stream to perform the physical I/O, while the character stream handles translation
 * between characters and bytes. FileReader, for example, uses FileInputStream, while FileWriter uses FileOutputStream.
 * <p>
 * There are two general-purpose byte-to-character "bridge" streams: InputStreamReader and OutputStreamWriter.
 * </p>
 * <p>
 * https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
 *
 * <p>
 * tags:	FileReader; FileWriter; character stream;
 * </p>
 *
 * @author dhall
 * @version 0.1 - 2018-06-01
 */
public class FileReadAndWriteCharacterStream
{
	//@@@ INSTANCE VARIABLES @@@
	private FileReader stdin = null;
	private FileWriter stdout = null;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//String inputFilepath = "Linux 101 Chapter Summaries.txt";
		String inputFilepath = "I can eat glass.txt";
		String outputFilepath = "Copy of " + inputFilepath;
		System.out.println("Reading in and copying the characters of " + inputFilepath + "\nPlease wait.");
		FileReadAndWriteCharacterStream run = new FileReadAndWriteCharacterStream(inputFilepath, outputFilepath);
		System.out.println("Finished copying the characters of " + inputFilepath + " to " + outputFilepath);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public FileReadAndWriteCharacterStream(String inputFilepath, String outputFilepath)
	{
		try {
			// assign our resources for standard input using FileReader and standard output using FileWriter
			// CANNOT CHOOSE DIFFERENT CHARSETS - for this use InputStreamReader on a FileInputStream
			// https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html
			stdin = new FileReader(inputFilepath);
			// CANNOT CHOOSE DIFFERENT CHARSETS - for this use OutputStreamWriter on a FileOutputStream
			// https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
			stdout = new FileWriter(outputFilepath);
			// do the character copy
			copyFileCharacters(stdin, stdout);
		}
		catch (IOException ioE) {
			System.out.println(ioE.getMessage());
		}
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	private void copyFileCharacters(FileReader fileToRead, FileWriter fileToWrite) throws IOException
	{
		// store 16 bits of character information here
		int currentCharacter;
		// Store the integer representation of binary of the current 16 bits into currentByte.  The read() method returns -1 when the end of file is reached
		while ((currentCharacter = fileToRead.read()) != -1) {
			stdout.write(currentCharacter);
		}
		
		// close the open resources
		stdin.close();
		stdout.close();
	}
}
