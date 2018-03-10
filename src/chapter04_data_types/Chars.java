package chapter04_data_types;

/**
 * Created by blindcant on 23/04/17.
 */
public class Chars
{
	public static void main(String[] args)
	{
		//SHOW Chars DECIMAL CODE FOR Chars CHARS
		System.out.println("1 has the ASCII codepoint of " + (int) '1');
		System.out.println("'A' has the ASCII codepoint of " + (int) 'A');
		System.out.println("'Z' has the ASCII codepoint of " + (int) 'Z');
		System.out.println("'a' has the ASCII codepoint of " + (int) 'a');
		System.out.println("'z' has the ASCII codepoint of " + (int) 'z');
		System.out.println("'0' has the ASCII codepoint of " + (int) '0');
		System.out.println("'9' has the ASCII codepoint of " + (int) '9');
		System.out.println();
		//SHOW Chars CHAR FOR DECIMAL CODES
		System.out.println("40 is the ASCII codepoint for " + (char) 40);
		System.out.println("59 is the ASCII codepoint for " + (char) 59);
		System.out.println("79 is the ASCII codepoint for " + (char) 79);
		System.out.println("85 is the ASCII codepoint for " + (char) 85);
		System.out.println("90 is the ASCII codepoint for " + (char) 90);
		System.out.println();
		//SHOW HEX CODES OF DECIMAL NUMBERS
		System.out.println("40 is hex-code for: " + (byte) '\u0040');
		System.out.println("5A is hex-code for: " + (byte) '\u005A');
		System.out.println("71 is hex-code for: " + (byte) '\u0071');
		System.out.println("72 is hex-code for: " + (byte) '\u0072');
		System.out.println("7A is hex-code for: " + (byte) '\u007A');
		System.out.println();
		//CHARS AS Chars NUMBERS
		int i = '1';
		System.out.println(i);
		int j = '1' + '2' * ('4' - '3') + 'b' / 'a';
		System.out.println(j);
		int j2 = 49 + 50 * (52 - 51) + 98 / 97;
		System.out.println(j2);
		int k = 'a';
		System.out.println(k);
		char c = 90;
		System.out.println(c);
		System.out.println();
		//CONVERSIONS
		char cc = 'A';
		System.out.println(cc);
		int i2 = (int) cc;
		System.out.println(i2);
		float f = 1000.34f;
		int i3 = (int) f;
		System.out.println(i3);
		double d = 1000.34;
		int i4 = (int) d;
		System.out.println(i4);
		//print a
		int i5 = 97;
		char c3 = (char) i5;
		System.out.println(c3);
		System.out.println();
		//OUTPUT TRACING
		char x = 'a';
		char y = 'c';
		System.out.println(++x);
		System.out.println(y++);
		System.out.println(x - y);
		System.out.println();
		//GENERATE RANDOM LOWER CASE LETTER (a + Math.random() * b) returns random number between a and a+b, excluding a+b
		//'a' = 97 and 'z' = 122 : 122 - 97 = 25.  But we want to get z, so 25 + 1 = 26.
		int randomLowerChar = 97 + (int) (Math.random() * 26);
		System.out.println("Random generated lowercase char is: " + (char) randomLowerChar);
		//GENERATE RANDOM UPPER CASE LETTER (a + Math.random() * b) returns random number between a and a+b, excluding a+b
		//'A' = 65 and 'Z' = 90 : 90 - 65 = 25.  But we want to get Z, so 25 + 1 = 26.
		int randomUpperChar = 65 + (int) (Math.random() * 26);
		System.out.println("Random generated uppercase char is: " + (char) randomUpperChar);
		System.out.println();
		//OUTPUT OF CHAR COMPARISON
		System.out.println("Is 'a' < 'b'?\t" + ('a' < 'b'));
		System.out.println("Is 'a' <= 'A'?\t" + ('a' <= 'A'));
		System.out.println("Is 'a' > 'b''?\t" + ('a' > 'b'));
		System.out.println("Is 'a' >= 'A'?\t" + ('a' >= 'A'));
		System.out.println("Is 'a' == 'a'?\t" + ('a' == 'a'));
		System.out.println("Is 'a' != 'b'?\t" + ('a' != 'b'));
		System.out.println();
		
		System.out.printf("%6b%-8s\n", (1 > 2), "Java");
	}
}

