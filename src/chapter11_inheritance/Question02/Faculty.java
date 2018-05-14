package chapter11_inheritance.Question02;

/**
 * <h1>Employee</h1>
 * <p>
 * This program is my implementation of a faculty member using inheritance and interfaces.
 * </p>
 * <p>
 * tags:	inheritance; extends; super class constructor; over riding;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-05-03
 */
public class Faculty extends Employee
{
	//@@@ INSTANCE VARIABLES @@@
	private String officeHours;
	private String rank;
	
	//@@@ CONSTRUCTOR(S) @@@
	public Faculty(String name, String streetAddress, String emailAddress, String phoneNumber, String office, double salary, String officeHours, String rank)
	{
		super(name, streetAddress, emailAddress, phoneNumber, office, salary);
		this.officeHours = officeHours;
		this.rank = rank;
	}
	
	public Faculty()
	{
	
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public String getOfficeHours()
	{
		return officeHours;
	}
	
	public String getRank()
	{
		return rank;
	}
	
	//### HELPERS ###
	@Override
	public String toString()
	{
		return super.toString() + String.format("Office hours:\t\t%s\nRank:\t\t\t\t%s\n", getOfficeHours(), getRank());
	}
}
