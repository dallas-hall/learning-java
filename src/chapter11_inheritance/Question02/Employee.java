package chapter11_inheritance.Question02;

import java.util.Date;

/**
 * Created by blindcant on 3/05/17.
 */
public abstract class Employee extends Person
{
	//INSTANCE VARIABLES
	private String office;
	private double salary;
	private java.util.Date hireDate;
	
	//MAIN METHOD
	
	
	//CONSTRUCTOR(S)
	public Employee(String name, String streetAddress, String emailAddress, String phoneNumber, String office, double salary)
	{
		super(name, streetAddress, emailAddress, phoneNumber);
		this.office = office;
		this.salary = salary;
		this.hireDate = new java.util.Date();
	}
	
	public Employee()
	{
	
	}
	
	//METHODS
	public String getOffice()
	{
		return office;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public Date getHireDate()
	{
		return hireDate;
	}
	
	public void setOffice(String office)
	{
		this.office = office;
	}
	
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	//HELPERS
	@Override
	public String toString()
	{
		return super.toString() + String.format("Office location:\t%s\nSalary:\t\t\t\t$%,.2f\nHire Date:\t\t\t%s\n"
				,getOffice(), getSalary(), getHireDate());
	}
}
