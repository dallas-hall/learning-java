package chapter11_inheritance.Question02;

import java.util.Date;

/**
 * <h1>Person</h1>
 * <p>
 * This program is my implementation of an abstract Person which is used to create other classes from.
 * </p>
 * <p>
 * tags:	inheritance; abstract class; super class; over riding;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-05-03
 */
public abstract class Person
{
	//@@@ INSTANCE VARIABLES @@@
	private String name;
	private String streetAddress;
	private String emailAddress;
	private String phoneNumber;
	private java.util.Date creationDate;
	
	//@@@ CONSTRUCTOR(S) @@@
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
	
	//@@@ METHODS @@@
	//### GETTERS ###
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
	
	//### HELPERS ###
	public String toString()
	{
		return String.format("Name:\t\t\t\t%s\nAddress:\t\t\t%s\nEmail:\t\t\t\t%s\nPhone:\t\t\t\t%s\nCreation date:\t\t%s\n", getName(), getStreetAddress(), getEmailAddress(), getPhoneNumber(), getCreationDate());
	}
}
