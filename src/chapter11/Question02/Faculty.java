package chapter11.Question02;

/**
 * Created by blindcant on 3/05/17.
 */
public class Faculty extends Employee
{
	//INSTANCE VARIABLES
	private String officeHours;
	private String rank;
	
	//CONSTRUCTOR(S)
	public Faculty(String name, String streetAddress, String emailAddress, String phoneNumber, String office, double salary, String officeHours, String rank)
	{
		super(name, streetAddress, emailAddress, phoneNumber, office, salary);
		this.officeHours = officeHours;
		this.rank = rank;
	}
	
	public Faculty()
	{
	
	}
	
	//METHODS
	public String getOfficeHours()
	{
		return officeHours;
	}
	
	public String getRank()
	{
		return rank;
	}
	
	//HELPERS
	@Override
	public String toString()
	{
		return super.toString() + String.format("Office hours:\t\t%s\nRank:\t\t\t\t%s\n"
				,getOfficeHours(), getRank());
	}
}
