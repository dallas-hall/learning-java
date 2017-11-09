package chapter17_binary_io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by blindcant on 08/11/17.
 *
 * Question 2
 * ObjectInputStream and ObjectOutputStream can write both primitive types and objects.
 * This example is wrapped with a BufferedReader and BufferedWriter to improve performance when reading from and writing to a file
 */
public class ObjectsAsBianryWithBufferedObjectReaderAndWriter
{
	//@@@ INSTANCE VARIABLES @@@
	private String[][] students;
	private java.util.Date[] date;
	private Path filePath;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args)
	{
		ObjectsAsBianryWithBufferedObjectReaderAndWriter runtime = new ObjectsAsBianryWithBufferedObjectReaderAndWriter();
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public ObjectsAsBianryWithBufferedObjectReaderAndWriter()
	{
		try
		{
			//write elements individually
			filePath = Paths.get("students_with_ObjectStream.dat");
			createData();
			System.out.println("@@@ Individual Element Processing @@@");
			writeData(filePath, students, date);
			readData(filePath);
			
			//write the entire array at once
	/*		System.out.println("@@@ Array Processing @@@");
			filePath = Paths.get("arrays_with_ObjectStream.dat");
			writeArrays(filePath);
			readArrays(filePath);*/
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	private void readData(Path filePath) throws IOException, ClassNotFoundException
	{
		/*
		Create a ObjectInputStream which is used to write objects and primitive types as binary.
		We are using a BufferedInputStream to wrap a FileInputStream to improve the performance of reading the binary
		to the file.
		
		It is also using a try-with-resources statement, so the resources are closed automatically after use.
		
		 */
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath.toFile())));)
		{
			//keep looping until EOF
			try
			{
				while (true)
				{
					String name = objectInputStream.readUTF();
					double score = objectInputStream.readDouble();
					java.util.Date date = (java.util.Date) objectInputStream.readObject();
					
					System.out.println(name + " " + score + " @ " + date );
					//System.out.println(dataInputStream.readByte());
				}
			}
			//finish when EOFException is encountered, which means the end of the file
			catch (EOFException e)
			{
				System.out.println("\nAll the data has been read.\n");
			}
		}
	}
	
	private void readArrays(Path filePath) throws IOException
	{
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath.toFile())));)
		{
			try
			{
				while (true)
				{
					//create a new 2D String array and read the serialized 2D String array from the file
					String[][] stringArray = (String[][]) objectInputStream.readObject();
					//create a new 2D java.util.Date array and read the serialized 2D java.util.Date array from the file
					java.util.Date[] dateArray = (java.util.Date[]) objectInputStream.readObject();
					
					for (int i = 0; i < stringArray.length; i++)
					{
						for (int j = 0; j < stringArray[i].length; j++)
						{
							//print name
							if (j == 0)
							{
								System.out.print(stringArray[i][j] + " ");
							}
							//print score and date
							else if (j == 1)
							{
								System.out.print(stringArray[i][j] + " @ " + dateArray[i] + "\n");
							}
						}
					}
				}
			}
			catch (EOFException e)
			{
				System.out.println("\nAll the data has been read.\n");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	//### SETTERS ###
	private void createData()
	{
		students = new String[][] {{"Johnny", "66.9"}, {"Jane", "88.3"}, {"Harry", "55.8"}, {"Nancy", "75.8"}};
		
		date = new java.util.Date[students.length];
		for (int i = 0; i < date.length; i++)
		{
			date[i] = new java.util.Date();
			//sleep for 1 second so we can see the date change
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	private void writeData(Path filePath, String[][] inputData, java.util.Date[] date) throws IOException
	{
		/*
		Create a ObjectOutputStream which is used to write objects and primitive types as binary.
		We are using a BufferedOutputStream to wrap a FileOutputStream to improve the performance of writing the binary
		to the file.
		
		It is also using a try-with-resources statement, so the resources are closed automatically after use.
		
		 */
		//check if the file exists, if it does append to it, else create it and write to it
		boolean append = false;
		if(Files.exists(filePath))
		{
			//append = true;
		}
		
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath.toFile(), append)));)
		{
			/*
				When writing, the header 0xAC will be written if the stream resets.  This needs to be catered for with reset();
				https://stackoverflow.com/a/2395269
				
			*/
/*			if (append)
			{
				objectOutputStream.reset();
			}*/

			for (int i = 0; i < inputData.length; i++)
			{
				for (int j = 0; j < inputData[i].length; j++)
				{
					//write the name in UTF-8
					if (j == 0)
					{
						objectOutputStream.writeUTF(inputData[i][j]);
					}
					//write the score as a double
					else if (j == 1)
					{
						objectOutputStream.writeDouble(Double.parseDouble(inputData[i][j]));
						//write the date as a java.util.Date object
						objectOutputStream.writeObject(date[i]);
					}
				}
			}
		}
	}
	
	private void writeArrays(Path filePath) throws IOException
	{
		//check if the file exists, if it does append to it, else create it and write to it
		boolean append = false;
		if(Files.exists(filePath))
		{
			//append = true;
		}
		
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath.toFile(), append)));)
		{
			/*
				When writing, the header 0xAC will be written if the stream resets.  This needs to be catered for with reset();
				https://stackoverflow.com/a/2395269
			*/
/*			if (append)
			{
				objectOutputStream.reset();
			}*/
			
			//write the student and date arrays
			objectOutputStream.writeObject(students);
			objectOutputStream.writeObject(date);
		}
	}
}
