import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>TryWithResources</h1>
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
 * tags:	try with resources; BufferedReader; InputStreamReader; FileInputStream; BufferedWriter; OutputStreamWriter; FileOutputStream; byte stream; character stream;
 * </p>
 *
 * @author dhall
 * @version 0.1 - 2018-06-01
 */
public class TryWithResources
{
	//@@@ CLASS VARIABLES @@@
	public static final Charset UTF_8 = Charset.forName("UTF-8");
	// http://tutorials.jenkov.com/java-logging/index.html
	private static final Logger logger = Logger.getLogger(TryWithResources.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	private Path inputPath;
	private Path outputPath;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		//String inputFilepath = "Linux 101 Chapter Summaries.txt";
		String inputFilepath = "I can eat glass.txt";
		String outputFilepath = "Copy of " + inputFilepath;
		TryWithResources runtime = new TryWithResources(inputFilepath, outputFilepath);
		runtime.readFileAndWriteFile(runtime.getInputPath(), runtime.getOutputPath());
		logger.log(Level.INFO, "File reading and writing as finished.");
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public TryWithResources(String inputPath, String outputPath)
	{
		this.inputPath = Paths.get(inputPath);
		this.outputPath = Paths.get(outputPath);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public Path getInputPath()
	{
		return inputPath;
	}
	
	public Path getOutputPath()
	{
		return outputPath;
	}
	
	//### HELPERS ###
	public void readFileAndWriteFile(Path inputPath, Path outputPath)
	{
		logger.log(Level.INFO, "File reading starting.");
		
		// try-with-resources automatically closes resources.
		// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		try( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath.toString()), UTF_8)) ) {
			copyFileLineByLine(bufferedReader, outputPath);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, "File reading error occurred.");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private void copyFileLineByLine(BufferedReader bufferedReader, Path outputPath)
	{
		logger.log(Level.INFO, "File writing starting.");
		// store the current line here
		String currentLine;
		try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputPath.toString()), UTF_8))) {
			while ((currentLine = bufferedReader.readLine()) != null) {
				// print the line to stdout
				bufferedWriter.write(currentLine);
				bufferedWriter.newLine();
			}
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, "File writing error occurred.");
			e.printStackTrace();
			System.exit(1);
		}
	}
}

