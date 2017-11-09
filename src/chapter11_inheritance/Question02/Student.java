package chapter11_inheritance.Question02;

/**
 * Created by blindcant on 3/05/17.
 */
public class Student extends Person
{
	//INSTANCE VARIABLES
	private final String classStatus;
	
	//CONSTRUCTOR(S)
	public Student(String name, String streetAddress, String emailAddress, String phoneNumber, String classStatus)
	{
		super(name, streetAddress, emailAddress, phoneNumber);
		this.classStatus = classStatus;
	}
	
	//METHODS
	public String getClassStatus()
	{
		return classStatus;
	}
	
	//HELPERS
	
	@Override
	public String toString()
	{
		return super.toString() + String.format("Student status:\t\t%s\n"
				,getClassStatus());
	}
}
