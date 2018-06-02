package chapter12_exceptions_and_text_io.Question29;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>CreateMoveDeleteFiles</h1>
 * <p>
 * This program creates a temporary work directory and 10 files in there. It then goes into that temporary working directory and renames the files.
 * </p>
 * <p>
 * tags:	Logger; Path; Path; File; Files; create directory; create file; delete file; delete directory; move file;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-06-02
 */
public class CreateMoveDeleteFiles
{
	//@@@ CLASS VARIABLES @@@
	private static final Logger logger = Logger.getLogger(CreateMoveDeleteFiles.class.getName());
	
	//@@@ INSTANCE VARIABLES @@@
	private Path workingPath;
	private Path[] paths;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		String workingPath = "/media/veracrypt1/java-random-files-for-io/tmp-work-dir";
		CreateMoveDeleteFiles runtime = new CreateMoveDeleteFiles(workingPath);
		runtime.deleteDirectoryAndContents(runtime.getWorkingPath());
		runtime.createDirectory(runtime.getWorkingPath());
		runtime.createFiles();
		runtime.renameFiles();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public CreateMoveDeleteFiles(String workingPath)
	{
		this.workingPath = Paths.get(workingPath);
		paths = new Path[10];
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public Path getWorkingPath()
	{
		return workingPath;
	}
	
	//### SETTERS ###
	
	//### HELPERS ###
	public void deleteDirectoryAndContents(Path path)
	{
		logger.log(Level.INFO, "Attempting to delete the following Path and its contents:\n" + path);
		if (Files.exists(path) && Files.isDirectory(path)) {
			//delete all files in the directory - https://stackoverflow.com/a/35989142
			try {
				// https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#walk-java.nio.file.Path-java.nio.file.FileVisitOption...-
				Files.walk(path)
					 // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
					 // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#sorted-java.util.Comparator-
					 .sorted(
							 // https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html#reverseOrder--
							 Comparator.reverseOrder())
					 // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#map-java.util.function.Function-
					 .map(Path::toFile)
					 // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#peek-java.util.function.Consumer-
					 .peek(System.out::println)
					 // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#forEach-java.util.function.Consumer-
					 .forEach(File::delete);
				logger.log(Level.INFO, "The following path and its contents was deleted successfully:\n" + path);
			}
			catch (Exception e) {
				logger.log(Level.SEVERE, "The following Path and its contents weren't deleted successfully:\n" + path);
				e.printStackTrace();
			}
		}
		else {
			logger.log(Level.WARNING, "The following Path doesn't exist or isn't a directory:\n" + path);
		}
	}
	
	
	private boolean isDirectoryEmpty(Path path)
	{
		//https://docs.oracle.com/javase/tutorial/essential/io/dirs.html#listdir
		if (Files.exists(path) && Files.isDirectory(path)) {
			try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
				for (Path file : directoryStream) {
					logger.log(Level.WARNING, "The following Path contains files:\n" + path);
					return false;
				}
				logger.log(Level.INFO, "The following path is empty:\n" + path);
				return true;
			}
			catch (Exception e) {
				logger.log(Level.SEVERE, "Something went wrong when trying to process the following path:\n" + path);
				e.printStackTrace();
				return false;
			}
		}
		logger.log(Level.WARNING, "The following Path doesn't exist or isn't a directory:\n" + path);
		return false;
	}
	
	public void createDirectory(Path path)
	{
		logger.log(Level.INFO, "Attempting to create the following Path:\n" + path);
		//https://docs.oracle.com/javase/tutorial/essential/io/check.html
		if (Files.exists(path)) {
			logger.log(Level.WARNING, "The following Path already exists:\n" + path);
		}
		else {
			try {
				Files.createDirectory(path);
				logger.log(Level.INFO, "The following Path was created:\n" + path);
			}
			catch (IOException e) {
				logger.log(Level.SEVERE, "The following Path wasn't created:\n" + path);
				e.printStackTrace();
			}
		}
	}
	
	public void createFiles()
	{
		logger.log(Level.INFO, "Attempting to create 10 files.");
		for (int i = 0; i < 10; i++) {
			// https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
			String currentFileFormatted = String.format("%1$s%2$02d", workingPath + "/file-", (i + 1));
			Path currentFile = Paths.get(currentFileFormatted);
			paths[i] = currentFile;
			
			//https://docs.oracle.com/javase/tutorial/essential/io/check.html
			if (Files.exists(currentFile)) {
				logger.log(Level.WARNING, "The following Path already exists:\n" + currentFile);
			}
			else {
				try {
					//https://docs.oracle.com/javase/tutorial/essential/io/file.html#creating
					Files.createFile(paths[i]);
					logger.log(Level.INFO, "The following Path was created:\n" + currentFile);
				}
				catch (IOException e) {
					logger.log(Level.SEVERE, "The following Path wasn't created:\n" + currentFile);
					e.printStackTrace();
				}
			}
		}
	}
	
	public void renameFiles()
	{
		for (int i = 0; i < paths.length; i++) {
			String newFileFormatted = String.format("%1$s%2$03d", workingPath + "/file-", ((i + 1) * 100));
			Path currentFile = paths[i];
			if (Files.exists(currentFile)) {
				try {
					// https://docs.oracle.com/javase/tutorial/essential/io/move.html
					Files.move(currentFile, Paths.get(newFileFormatted));
					logger.log(Level.INFO, "The following Path was moved to another Path\n" + currentFile + "\n" + newFileFormatted);
					paths[i] = Paths.get(newFileFormatted);
				}
				catch (IOException e) {
					logger.log(Level.SEVERE, "An error occured when trying to move the following Paths:\n" + currentFile + "\n" + newFileFormatted);
					e.printStackTrace();
				}
			}
			else {
				logger.log(Level.WARNING, "The following Path doesn't exists:\n" + currentFile);
			}
		}
	}
}
