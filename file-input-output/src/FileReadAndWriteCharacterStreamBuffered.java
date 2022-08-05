import java.io.*;

/**
 * <h1>FileReadAndWriteCharacterStreamBuffered</h1>
 * <p>
 * Used for copying characters via character streams.
 * <p>
 * Character streams are often "wrappers" for byte streams. Character streams are often "wrappers" for byte streams.
 * The character stream uses the byte stream to perform the physical I/O, while the character stream handles translation
 * between characters and bytes. FileReader, for example, uses FileInputStream, while FileWriter uses FileOutputStream.
 * <p>
 * There are two general-purpose byte-to-character "bridge" streams: InputStreamReader and OutputStreamWriter.
 * <p>
 * https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
 * <p>
 * ---------------------------------------------------------------------------------------------------------------------
 * <p>
 * Most of the examples we've seen so far use unbuffered I/O. This means each read or write request is handled directly
 * by the underlying OS. This can make a program much less efficient, since each such request often triggers disk access,
 * network activity, or some other operation that is relatively expensive.
 * <p>
 * To reduce this kind of overhead, the Java platform implements buffered I/O streams. Buffered input streams read data
 * from a memory area known as a buffer; the native input API is called only when the buffer is empty. Similarly,
 * buffered output streams write data to a buffer, and the native output API is called only when the buffer is full.
 * <p>
 * There are four buffered stream classes used to wrap unbuffered streams: BufferedInputStream and BufferedOutputStream
 * create buffered byte streams, while BufferedReader and BufferedWriter create buffered character streams.
 * <p>
 * https://docs.oracle.com/javase/tutorial/essential/io/buffers.html
 * <p>
 * tags:	BufferedReader; FileReader; BufferedWriter; FileWriter; character stream;
 * </p>
 *
 * @author dhall
 * @version 0.1 - 2018-06-01
 */
public class FileReadAndWriteCharacterStreamBuffered
{
	//@@@ INSTANCE VARIABLES @@@
	private BufferedReader stdin = null;
	private BufferedWriter stdout = null;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//String inputFilepath = "Linux 101 Chapter Summaries.txt";
		String inputFilepath = "I can eat glass.txt";
		String outputFilepath = "Copy of " + inputFilepath;
		System.out.println("Reading in and copying the characters of " + inputFilepath + " into a buffer.\nPlease wait.");
		FileReadAndWriteCharacterStreamBuffered run = new FileReadAndWriteCharacterStreamBuffered(inputFilepath, outputFilepath);
		System.out.println("Finished copying the characters of " + inputFilepath + " to " + outputFilepath + "using a buffer.");
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public FileReadAndWriteCharacterStreamBuffered(String inputFilepath, String outputFilepath)
	{
		try {
			// assign our resources for standard input using FileReader and standard output using FileWriter
			// CANNOT CHOOSE DIFFERENT CHARSETS - for this use InputStreamReader on a FileInputStream
			// https://docs.oracle.com/javase/8/docs/api/java/io/FileReader.html
			stdin = new BufferedReader(new FileReader(inputFilepath));
			// CANNOT CHOOSE DIFFERENT CHARSETS - for this use OutputStreamWriter on a FileOutputStream
			// https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
			stdout = new BufferedWriter(new FileWriter(outputFilepath));
			// do the character copy
			copyFileCharacters(stdin, stdout);
		}
		catch (IOException ioE) {
			System.out.println(ioE.getMessage());
		}
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	private void copyFileCharacters(BufferedReader fileToRead, BufferedWriter fileToWrite) throws IOException
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
