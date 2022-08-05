import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <h1>FileReadAndWriteByteStream</h1>
 * <p>
 * This program reads from and write to files with bytes using unbuffered (slow) byte streams.
 * </p>
 * <p>
 * https://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html
 *
 * <p>
 * tags:	FileInputStream; FileOutputStream; byte stream;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-06-01
 */
public class FileReadAndWriteByteStream
{
	//@@@ INSTANCE VARIABLES @@@
	private FileInputStream stdin = null;
	private FileOutputStream stdout = null;
	private byte[] fileBytesArray = null;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		String inputFilepath = "bcprov-jdk15on-157.zip";
		//String inputFilepath = "CliCommandsFull.jpg";
		String outputFilepath = "Copy of " + inputFilepath;
		System.out.println("Reading in and copying the bytes of " + inputFilepath + "\nPlease wait.");
		FileReadAndWriteByteStream programRun = new FileReadAndWriteByteStream(inputFilepath, outputFilepath);
		System.out.println("Finished copying the bytes of " + inputFilepath + " to " + outputFilepath);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	
	/**
	 * This constructor takes 2 file locations, one for the input file and one for the output file.
	 * It then calls a method to do a byte by byte copy from the input file to the output file.
	 *
	 * @param inputFilepath  - Holds the input file location as a String, which is converted to a FileInputStream object.
	 * @param outputFilepath - Holds the output file location as a String, which is converted to a FileOutputStream object.
	 */
	public FileReadAndWriteByteStream(String inputFilepath, String outputFilepath)
	{
		try {
			//assign resources
			//create a FileInputStream Object that points to the input file location
			stdin = new FileInputStream(inputFilepath);
			//create a FileOutputStream Object that points to the output file location.
			stdout = new FileOutputStream(outputFilepath);
			
			//read bytes from the original file and write them to a new file
			copyFileBytes(stdin, stdout);
		}
		catch (IOException ioE) {
			System.out.println(ioE.getMessage());
		}
	}
	
	//@@@ METHODS @@@
	//### HELPERS ###
	
	/**
	 * This method reads in a file 1 byte at a time and copies it to another file 1 byte at a time.
	 *
	 * @param fileToRead  - holds a FileInputStream object pointing to the file to read from
	 * @param fileToWrite - holds a FileOutputStream object pointing to the file to write to
	 * @throws IOException - Handling Input/Output exceptions only
	 */
	private void copyFileBytes(FileInputStream fileToRead, FileOutputStream fileToWrite) throws IOException
	{
		// store the current byte(8 bits) information as an integer
		int currentByte;
		//Store the integer representation of binary of the current byte into currentByte.  The read() method returns -1 when the end of file is reached
		while ((currentByte = fileToRead.read()) != -1) {
			fileToWrite.write(currentByte);
		}
		//close our resources
		stdin.close();
		stdout.close();
	}
}
