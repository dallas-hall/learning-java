package chapter31_networking.object_example;

import java.io.Serializable;

/**
 * Created by blindcant on 10/11/17.
 */
public class Person implements Serializable
{
	//@@@ INSTANCE VARIABLES @@@
	private String name;
	private byte age;
	private char sex;
	private String birthday;
	
	//@@@ CONSTRUCTOR(S) @@@
	public Person(String name, byte age, char sex, String birthday)
	{
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public String getName()
	{
		return name;
	}
	

	public byte getAge()
	{
		return age;
	}

	
	public char getSex()
	{
		return sex;
	}
	

	public String getBirthday()
	{
		return birthday;
	}

	//### SETTERS ###
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAge(byte age)
	{
		this.age = age;
	}
	
	public void setSex(char sex)
	{
		this.sex = sex;
	}
	
	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}
	//### HELPERS ###
	@Override
	public String toString()
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Name:\t" + name + "\n");
		stringBuffer.append("Age:\t" + age + "\n");
		stringBuffer.append("Sex:\t" + sex + "\n");
		stringBuffer.append("DOB:\t" + birthday + "\n");
		return stringBuffer.toString();
	}
}
