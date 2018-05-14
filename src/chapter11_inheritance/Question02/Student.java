package chapter11_inheritance.Question02;

/**
 * <h1>Student</h1>
 * <p>
 * This program is my implementation of a student using inheritance and interfaces.
 * </p>
 * <p>
 * tags:	inheritance; extends; super class constructor; over riding;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-05-03
 */
public class Student extends Person
{
	//@@@ INSTANCE VARIABLES @@@
	private final String classStatus;
	
	//@@@ CONSTRUCTOR(S) @@@
	public Student(String name, String streetAddress, String emailAddress, String phoneNumber, String classStatus)
	{
		super(name, streetAddress, emailAddress, phoneNumber);
		this.classStatus = classStatus;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public String getClassStatus()
	{
		return classStatus;
	}
	
	//### HELPERS ###
	@Override
	public String toString()
	{
		return super.toString() + String.format("Student status:\t\t%s\n", getClassStatus());
	}
}
