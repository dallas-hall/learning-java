package chapter12_exceptions_and_text_io.Question14;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <h1>PROGRAM NAME GOES HERE</h1>
 * <p>
 * This program
 * </p>
 * <p>
 * tags:	<insert concept tags here for training code only>
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-27
 */
public class ReadWriteReadSortIntegers
{
	//@@@ CLASS VARIABLES @@@
	
	
	//@@@ INSTANCE VARIABLES @@@
	private Path absolutePath;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		ReadWriteReadSortIntegers runtime = new ReadWriteReadSortIntegers("/media/veracrypt1/java-random-files-for-io/integers.txt");
		System.out.println("[INFORMATION] Printing initial variables.");
		System.out.println("Absolute path is: " + runtime.getAbsolutePath());
		System.out.println("Path only is: " + runtime.getPath());
		System.out.println("Filename is: " + runtime.getFilename());
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public ReadWriteReadSortIntegers(String inputPath)
	{
		absolutePath = Paths.get(inputPath);
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public Path getAbsolutePath()
	{
		return absolutePath;
	}
	
	public Path getPath()
	{
		// Need -1 so we remove the filename
		return Paths.get("/" + absolutePath.subpath(0, absolutePath.getNameCount() - 1));
	}
	
	public Path getFilename()
	{
		return absolutePath.getFileName();
	}
	
	//### SETTERS ###
	
	//### HELPERS ###
	
	//@@@ INNER CLASS(ES) @@@
}
