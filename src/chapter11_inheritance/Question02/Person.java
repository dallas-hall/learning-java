package chapter11_inheritance.Question02;

import java.util.Date;

/**
 * Created by blindcant on 3/05/17.
 */
public abstract class Person
{
	//INSTANCE VARIABLES
	private String name;
	private String streetAddress;
	private String emailAddress;
	private String phoneNumber;
	private java.util.Date creationDate;
	
	//MAIN METHOD
	
	
	//CONSTRUCTOR(S)
	public Person()
	{
	
	}
	
	public Person(String name, String streetAddress, String emailAddress, String phoneNumber)
	{
		this.name = name;
		this.streetAddress = streetAddress;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.creationDate = new java.util.Date();
	}
	
	//METHODS
	public String getName()
	{
		return name;
	}
	
	public String getStreetAddress()
	{
		return streetAddress;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public Date getCreationDate()
	{
		return creationDate;
	}
	
	//HELPERS
	public String toString()
	{
		return String.format("Name:\t\t\t\t%s\nAddress:\t\t\t%s\nEmail:\t\t\t\t%s\nPhone:\t\t\t\t%s\nCreation date:\t\t%s\n"
		,getName(), getStreetAddress(), getEmailAddress(), getPhoneNumber(), getCreationDate());
	}
}
