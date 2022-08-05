import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

//https://docs.oracle.com/javase/tutorial/essential/io/walk.html
public class DeleteAllFilesFromDirectory extends SimpleFileVisitor<Path>
{
	//@@@ INSTANCE VARIABLES @@@
	
	//@@@ MAIN METHOD @@@
	
	//@@@ CONSTRUCTOR(S) @@@
	
	//@@@ METHODS @@@
	//print file information and then delete
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException
	{
		if (attr.isSymbolicLink()) {
			System.out.format("Deleting Symbolic link: %s ", file);
			Files.deleteIfExists(file);
		}
		else if (attr.isRegularFile()) {
			System.out.format("Deleting Regular file: %s ", file);
			Files.deleteIfExists(file);
		}
		else {
			System.out.format("Deleting Other: %s ", file);
			Files.deleteIfExists(file);
		}
		System.out.println("(" + attr.size() + "bytes)");
		return CONTINUE;
	}
	
	//print directory information and then delete
/*	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
	{
		System.out.format("Deleting Directory: %s%n", dir);
		//Files.deleteIfExists(dir);
		return CONTINUE;
	}*/
}
