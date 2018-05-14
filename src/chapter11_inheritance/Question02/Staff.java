package chapter11_inheritance.Question02;

/**
 * <h1>Staff</h1>
 * <p>
 * This program is my implementation of a staff member using inheritance and interfaces.
 * </p>
 * <p>
 * tags:	inheritance; extends; super class constructor; over riding;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-05-03
 */
public class Staff extends Employee
{
	//@@@ INSTANCE VARIABLES @@@
	private String title;
	
	//@@@ CONSTRUCTOR(S) @@@
	public Staff(String name, String streetAddress, String emailAddress, String phoneNumber, String office, double salary, String title)
	{
		super(name, streetAddress, emailAddress, phoneNumber, office, salary);
		this.title = title;
	}
	
	public Staff()
	{
	
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public String getTitle()
	{
		return title;
	}
	
	//### HELPERS ###
	@Override
	public String toString()
	{
		return super.toString() + String.format("Job Title:\t\t\t%s\n", getTitle());
	}
}
