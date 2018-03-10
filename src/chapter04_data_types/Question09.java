package chapter04_data_types;

import java.util.Scanner;

/**
 * Created by blindcant on 24/04/17.
 */
public class Question09 {
	//INSTANCE VARIABLES
	private Scanner keyboard = new Scanner(System.in);
	
	//MAIN METHOD
	public static void main(String[] args) {
		Question09 run1 = new Question09();
	}
	
	//CONSTRUCTOR(S)
	Question09() {
		System.out.println("Find Unicode number.");
		System.out.println("Enter a character:");
		//convert input from String to Char
		char userInput = keyboard.nextLine().charAt(0);
		//display Unicode number
		System.out.println("The Unicode for the character " + userInput + " is 0x" + Integer.toHexString(userInput));
	}
	
	//METHODS
}
