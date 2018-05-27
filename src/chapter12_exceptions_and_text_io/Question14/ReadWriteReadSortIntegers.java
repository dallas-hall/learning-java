package chapter12_exceptions_and_text_io.Question14;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h1>Read, Write, Read, & Sort A File Of Integers.</h1>
 * <p>
 * This program will try to read in a file with integers. If the file doesn't exist it will create it an populate it. It then reads it in, sorts the integers, and writes the file back out.
 * </p>
 * <p>
 * tags:	Charset; Path; Paths; Files; newBufferedRead; newBufferedWriter; IOException; try with resources; ThreadLocalRandom;
 * </p>
 *
 * @author blindcant
 * @version 0.0.1 - 2018-05-27
 */
public class ReadWriteReadSortIntegers
{
	//@@@ CLASS VARIABLES @@@
	public static final Charset UTF8 = Charset.forName("UTF-8");
	
	//@@@ INSTANCE VARIABLES @@@
	private Path inputAbsolutePath;
	private Path outputAbsolutePath;
	private int amount;
	private int[] integers;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		ReadWriteReadSortIntegers runtime = new ReadWriteReadSortIntegers("/media/veracrypt1/java-random-files-for-io/integers-in.txt", "/media/veracrypt1/java-random-files-for-io/integers-out.txt", 100);
		System.out.println("[INFORMATION] Printing initial variables.");
		System.out.println("Input absolute path is: " + runtime.getInputAbsolutePath());
		System.out.println("Input path only is: " + runtime.getInputPath());
		System.out.println("Input filename is: " + runtime.getInputFilename());
		System.out.println("Output absolute path is: " + runtime.getOutputAbsolutePath());
		System.out.println("Output path only is: " + runtime.getOutputPath());
		System.out.println("Output filename is: " + runtime.getOutputFilename());
		System.out.println("The amount of integers to create is: " + runtime.getAmount());
		System.out.println("[INFORMATION] Running program.");
		runtime.storeRandomIntegers(runtime.readFile(runtime.getInputAbsolutePath()));
		runtime.printIntegers();
		runtime.sortAndWriteIntegers();
		runtime.printIntegers(runtime.outputAbsolutePath);
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public ReadWriteReadSortIntegers(String inputPath, String outputPath)
	{
		inputAbsolutePath = Paths.get(inputPath);
		outputAbsolutePath = Paths.get(outputPath);
		amount = 100;
		integers = new int[amount];
	}
	
	public ReadWriteReadSortIntegers(String inputPath, String outputPath, int amount)
	{
		inputAbsolutePath = Paths.get(inputPath);
		outputAbsolutePath = Paths.get(outputPath);
		this.amount = amount;
		integers = new int[amount];
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public Path getInputAbsolutePath()
	{
		return inputAbsolutePath;
	}
	
	public Path getInputPath()
	{
		// Need -1 so we remove the filename
		return Paths.get("/" + inputAbsolutePath.subpath(0, inputAbsolutePath.getNameCount() - 1));
	}
	
	public Path getInputFilename()
	{
		return inputAbsolutePath.getFileName();
	}
	
	public Path getOutputAbsolutePath()
	{
		return outputAbsolutePath;
	}
	
	public Path getOutputPath()
	{
		// Need -1 so we remove the filename
		return Paths.get("/" + outputAbsolutePath.subpath(0, outputAbsolutePath.getNameCount() - 1));
	}
	
	public Path getOutputFilename()
	{
		return outputAbsolutePath.getFileName();
	}
	
	public int getAmount()
	{
		return amount;
	}
	
	//### SETTERS ###
	private void storeRandomIntegers(String output)
	{
		String[] integers = output.split(" ");
		for(int i = 0; i < integers.length; i++) {
			this.integers[i] = Integer.valueOf(integers[i]);
		}
	}
	
	private void sortAndWriteIntegers()
	{
		writeIntegers(outputAbsolutePath, amount, false);
	}
	
	//### HELPERS ###
	public void createFile(Path inputPath)
	{
		// Check if the file exists, if not create it
		try {
			//https://docs.oracle.com/javase/tutorial/essential/io/check.html
			if (!Files.exists(inputPath)) {
				//https://docs.oracle.com/javase/tutorial/essential/io/file.html#creating
				Files.createFile(inputPath);
				writeIntegers(inputPath, amount, true);
			}
		}
		catch (IOException e) {
			System.out.println("[ERROR] File error occurred.\n" + e.getStackTrace());
		}
	}
	
	private String readFile(Path inputPath)
	{
		// Check if the file exists, if not create it
		createFile(inputPath);
		
		// Read the file
		System.out.println("[INFORMATION] Reading file " + inputPath);
		StringBuffer stringBuffer = new StringBuffer();
		
		// Using NIO & try with resources
		// https://docs.oracle.com/javase/tutorial/essential/io/file.html#textfiles
		// https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
		try (BufferedReader bufferedReader = Files.newBufferedReader(inputPath, UTF8)) {
			// store the current line here
			String currentLine;
			// Store the current line as a String into currentLine.  The readLine() method returns null when the end of line is reached.
			while ((currentLine = bufferedReader.readLine()) != null) {
				stringBuffer.append(currentLine);
			}
		}
		catch (IOException e) {
			System.out.println("[ERROR] File error occurred.\n" + e.getStackTrace());
		}
		return stringBuffer.toString();
	}
	
	private void writeIntegers(Path outputPath, int amount, boolean writingRandom)
	{
		if (writingRandom) {
			System.out.println("[INFORMATION] Writing file with " + amount + " random integers.");
		}
		else {
			System.out.println("[INFORMATION] Sorting integers and writing to output file.");
			Arrays.sort(integers);
		}
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath, UTF8)) {
			int printCount = 0;
			for (int i = 0; i < amount; i++) {
				if (writingRandom) {
					bufferedWriter.write(ThreadLocalRandom.current().nextInt(0, 1000) + " ");
				}
				else {
					bufferedWriter.write(integers[i] + " ");
				}
				printCount++;
				if (printCount % 10 == 0) {
					bufferedWriter.write("\n");
				}
			}
		}
		catch (IOException e) {
			System.out.println("[ERROR] File error occurred.\n" + e.getStackTrace());
		}
	}
	
	public void printIntegers(Path inputPath)
	{
		System.out.println("[INFORMATION] Printing integers.");
		int printCount = 0;
		String[] fileOutput = readFile(inputPath).split(" ");
		for (int i = 0; i < amount; i++) {
			printCount++;
			System.out.print(fileOutput[i] + " ");
			if (printCount % 10 == 0) {
				System.out.println();
			}
		}
	}
	
	public void printIntegers()
	{
		System.out.println("[INFORMATION] Printing integers.");
		int printCount = 0;
		for (int i = 0; i < amount; i++) {
			printCount++;
			System.out.print(integers[i] + " ");
			if (printCount % 10 == 0) {
				System.out.println();
			}
		}
	}
}
