package chapter06_methods;

/**
 * <h1>Regex Password Validation</h1>
 * <p>
 * This program uses regular expressions to validate passwords against really bad password rules.
 * </p>
 * <p>
 * tags: Math.random; if else;
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2017-04-24
 */
public class Question18
{
	//MAIN METHOD
	public static void main(String[] args)
	{
		System.out.println("Password rules");
		System.out.println("Must contain at least 8 characters");
		System.out.println("Must contain only letters and numbers");
		System.out.println("Must contain at least 2 digits");
		System.out.println();
		Question18 run1 = new Question18("passwrd"); //should fail, < 8
		Question18 run2 = new Question18("Password"); //should fail [0-9] < 2
		Question18 run3 = new Question18("Password1"); //should fail [0-9] < 2
		Question18 run4 = new Question18("Password12"); //should pass
		Question18 run5 = new Question18("P@ssword12"); //should fail, punctuation present
		Question18 run6 = new Question18("P4ssw0rd"); //should pass
		Question18 run7 = new Question18("9asswor6"); //should pass
		Question18 run8 = new Question18("9assw0r6"); //should pass
		
	}
	
	//CONSTRUCTOR(S)
	Question18(String inputPassword)
	{
		System.out.println("Is the password: \"" + inputPassword + "\" valid? " + checkPassword(inputPassword));
	}
	
	//METHODS
	public boolean checkPassword(String inputPassword)
	{
		// less than 8 is invalid
		if (inputPassword.length() < 8)
		{
			return false;
		}
		// any punctuation / control character is invalid
		else if (inputPassword.matches("^.*\\p{Punct}+.*$||^.* .*$"))
		{
			return false;
		}
		// a single (or more) number appearing anywhere with another single (or more) number appearing anywhere AND containing alpha characters is valid
		// OR 2 numbers (or more) appearing anywhere AND containing alpha characters is valid
		else if (inputPassword.matches("^.*[0-9]{2,}.*$||^.*[0-9]+.*[0-9]+.*$") && inputPassword.matches("^.*[A-Za-z]+.*$"))
		{
			return true;
		}
		//anything else is just garbage and invalid
		else
		{
			return false;
		}
	}
}
