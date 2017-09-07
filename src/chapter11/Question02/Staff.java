package chapter11.Question02;

/**
 * Created by blindcant on 3/05/17.
 */
public class Staff extends Employee
{
	//INSTANCE VARIABLES
	private String title;
	
	//CONSTRUCTOR(S)
	public Staff(String name, String streetAddress, String emailAddress, String phoneNumber, String office, double salary, String title)
	{
		super(name, streetAddress, emailAddress, phoneNumber, office, salary);
		this.title = title;
	}
	
	public Staff()
	{
	
	}
	//METHODS
	public String getTitle()
	{
		return title;
	}
	
	//HELPERS
	@Override
	public String toString()
	{
		return super.toString() + String.format("Job Title:\t\t\t%s\n"
				,getTitle());
	}
}
