import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemIO
{
	//@@@ INSTANCE VARIABLES @@@
	// ### System Properties ###
	public static final String HOME_DIR = System.getProperty("user.home");

	//### Character Sets ###
	private static final Charset ASCII = Charset.forName("US-ASCII");
	private static final Charset LATIN = Charset.forName("ISO-8859-1");
	private static final Charset UTF8 = Charset.forName("UTF-8");
	//default is BE
	private static final Charset UTF16_BE = Charset.forName("UTF-16");
	private static final Charset UTF16_LE = Charset.forName("UTF-16LE");

	//### FILESYSTEM I/O
	private Path absolutePathDirectoryOnly;
	private Path absolutePathDirectoryAndFile;
	private Path[] absolutePathDirectoryAndFileArray;

	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		FileSystemIO runtimeFileSystemIO = new FileSystemIO();
	}

	//@@@ CONSTRUCTOR(S) @@@
	public FileSystemIO()
	{
		DeleteAllFilesFromDirectory runtimeDelete = new DeleteAllFilesFromDirectory();
		Path tempPath;

		//try to create the directory
		tempPath = createDirectory(HOME_DIR + "/" + "java" + "/");
		if (tempPath != null)
		{
			absolutePathDirectoryOnly = tempPath;
		}

		//check if the directory is empty
		System.out.println("Is the directory empty? " + isDirectoryEmpty(absolutePathDirectoryOnly));

		//try to create N new files
		int numberOfFiles = 3;
		absolutePathDirectoryAndFileArray = new Path[numberOfFiles];
		for (int i = 0; i < numberOfFiles; i++)
		{
			tempPath = createFile(absolutePathDirectoryOnly, "file" + (i + 1) + ".txt");
			if (tempPath != null)
			{
				absolutePathDirectoryAndFileArray[i] = tempPath;
			}
		}

		//try to delete all the files inside the directory and then directory
		try
		{
			//check if the directory is empty
			System.out.println("Is the directory empty? " + isDirectoryEmpty(absolutePathDirectoryOnly));

			if(!isDirectoryEmpty(absolutePathDirectoryOnly))
			{
				//delete all files in the directory
				Files.walkFileTree(absolutePathDirectoryOnly, runtimeDelete);
			}

			//delete directory
			deletePath(absolutePathDirectoryOnly);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		//try to delete the file using the directory
		//deletePath(absolutePathDirectoryAndFile);
	}

	//@@@ METHODS @@@
	//https://docs.oracle.com/javase/tutorial/essential/io/pathOps.html#create
	private Path createPathFromString(String pathName)
	{
		Path path = Paths.get(pathName);
		return path;
	}

	private Path createDirectory(String directoryName)
	{
		System.out.println("@@@ Creating A Directory Using Path & Files @@@");
		Path absolutePath = createPathFromString(directoryName);
		//https://docs.oracle.com/javase/tutorial/essential/io/check.html
		if (Files.exists(absolutePath))
		{
			System.out.println("The directory " + absolutePath.toString() + " already exists.\n");
			return absolutePath;
		} else
		{
			System.out.println("Creating the following directory: " + absolutePath.toString() + "\n");
			try
			{
				return Files.createDirectory(absolutePath);

			} catch (IOException e)
			{
				System.out.println("<ERROR>\nUnable to create directory.\n");
				e.printStackTrace();
				System.out.println("</ERROR>\n");
				return null;
			}
		}
	}

	private Path createFile(Path absolutePath, String filename)
	{
		System.out.println("@@@ Creating A File Using Path & Files @@@");
		Path absolutePathAndFilename = createPathFromString(absolutePath + "/" + filename);
		//https://docs.oracle.com/javase/tutorial/essential/io/check.html
		if (Files.exists(absolutePathAndFilename))
		{
			System.out.println("The file " + filename.toString() + " already exists at " + absolutePath + "\n");
			return absolutePathAndFilename;
		} else
		{
			System.out.println("Creating the following file " + filename.toString() + " at " + absolutePath.toString() + "\n");
			try
			{
				//https://docs.oracle.com/javase/tutorial/essential/io/file.html#creating
				return Files.createFile(absolutePathAndFilename);
			} catch (IOException e)
			{
				System.out.println("<ERROR>\nUnable to create file.\n");
				e.printStackTrace();
				System.out.println("</ERROR>\n");
				return null;
			}
		}
	}

	//https://docs.oracle.com/javase/tutorial/essential/io/delete.html
	private void deletePath(Path absolutePath)
	{
		try
		{
			if (Files.isDirectory(absolutePath))
			{
				System.out.println("@@@ Deleting A Directory Using Path & Files @@@");
				System.out.println("Deleting the following directory: " + absolutePath.toString() + "\n");
				Files.deleteIfExists(absolutePath);
			} else if (Files.isRegularFile(absolutePath))
			{
				System.out.println("@@@ Deleting A File Using Path & Files @@@");
				System.out.println("Deleting the following file: " + absolutePath.toString() + "\n");
				Files.deleteIfExists(absolutePath);
			} else if (Files.isSymbolicLink(absolutePath))
			{
				System.out.println("@@@ Deleting A Symbolic Link Using Path & Files @@@");
				System.out.println("Deleting the following symbolic link: " + absolutePath.toString() + "\n");
				Files.deleteIfExists(absolutePath);
			} else
			{
				System.out.println("The Path provided was not a directory, file, or symbolic link.\nNothing was done.\n");
			}
		} catch (IOException e)
		{
			System.out.println("<ERROR>\nUnable to delete directory.\n");
			e.printStackTrace();
			System.out.println("</ERROR>\n");
		}
	}

	//https://docs.oracle.com/javase/tutorial/essential/io/dirs.html#listdir
	private boolean isDirectoryEmpty(Path path)
	{
		if (Files.exists(path) && Files.isDirectory(path))
		{
			try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path))
			{
				for (Path file : directoryStream)
				{
					return false;
				}
				return true;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
}
