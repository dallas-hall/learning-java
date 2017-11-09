package chapter05_loops;

import java.util.Scanner;

public class Dec2Hex
{
    /** Main method */
    public static void main(String[] args)
    {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a decimal integer
        System.out.print("Enter a decimal number: ");
        int decimal = input.nextInt();

        // Convert decimal to hex
        String hex = "";

        while (decimal != 0)
        {
// use modulo to work out the remainder, which is the character starting on the right in our answer
            int hexValue = decimal % 16;

            // Convert a decimal value to a hex digit
            char hexDigit = (hexValue <= 9 && hexValue >= 0)
// when adding a character with an integer, the characters unicode is used in that evaluation, by adding '0' to this number we get the unicode value for our answer
                    ? (char) (hexValue + '0')
// minus 10 so we get a number between 10 and 15, which is A-F, by adding 'A' to this number we get the unicode value for our answer
                    : (char) (hexValue - 10 + 'A');

// store the unicode result of the above if else below 
            hex = hexDigit + hex;
// use integer division to work out the quotient, which is the character starting on the left of the answer
            decimal = decimal / 16;
        }

        System.out.println("The hex number is " + hex);
    }
}