import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hmd911 on 16/05/2017.
 *
 * https://docs.oracle.com/javase/tutorial/essential/io/file.html
 */
public class PrintFromFiles
{
	public static void main(String[] args)
	{
		PrintFromFiles run1 = new PrintFromFiles();
	}

	public PrintFromFiles()
	{
		String encodedString = null;
		try
		{
			//encodedString = readFileAllBytes("Linux 101 Chapter Summaries.txt", Charset.forName("UTF-8"));
			printFileAllLines(readFileAllLines("Linux 101 Chapter Summaries.txt", Charset.forName("UTF-8")));
			//System.out.println(encodedString);
			//writeFile(encodedString, Charset.forName("UTF-8"));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public String readFileAllBytes(String path, Charset encoding) throws IOException
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

/*	public boolean writeFileAllBytes(String inputEncodedString, Charset inputEncodingScheme)
	{
		byte[] decoded = inputEncodedString.getBytes()
	}*/

	public List<String> readFileAllLines(String path, Charset encoding) throws IOException
	{
		//Create a List that stores Strings, read the file into the List
		List<String> file = Files.readAllLines(Paths.get(path), encoding);
		return file;
	}

	public void printFileAllLines(List<String> inputList)
	{
		//Print the content from the List containing Strings
		for (String line : inputList)
		{
			System.out.println(line);
		}
	}


	public void writeFile(String encodedString, Charset encoding) throws IOException
	{
		//grab and format current date
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-MM");
		String currentDate = dateFormat.format(new Date());
		//set the output path and filename
		Path outputFilename = Paths.get( "output@" + currentDate + ".txt");
		//write to file
		BufferedWriter stdoutFile = Files.newBufferedWriter(outputFilename);
		stdoutFile.write(encodedString);
		//need to close and flush the buffer to ensure everything is written to the file
		stdoutFile.close();
	}
}
