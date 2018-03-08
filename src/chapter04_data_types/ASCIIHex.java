package chapter04_data_types;

/**
 * <h1>Decimal to Hex</h1>
 * <p>
 * This program will convert decimal 0-255 (ASCII range) into binary.
 * </p>
 * <p>
 * tags: for loop;modulo;integer division;StringBuffer;hex;hexadecimal;base16;ASCII
 * </p>
 *
 * @author blindcant
 * @version 0.1 - 2018-03-08
 */
public class ASCIIHex {
	//@@@ INSTANCE VARIABLES @@@
	// ASCII range is 0-127, 'extended' is 128-255
	public static final int START_NUMBER = 0;
	public static final int FINAL_NUMBER = 255;
	public static final int RADIX = 16;
	
	//@@@ MAIN METHOD @@@
	public static void main(String[] args) {
		ASCIIHex runtime = new ASCIIHex();
		int printCounter = 0;
		for(int i = START_NUMBER; i <= FINAL_NUMBER; i++) {
			System.out.print(runtime.getHex(i) + " ");
			printCounter++;
			if(printCounter % 16 == 0) {
				System.out.println();
			}
		}
	}
	
	//@@@ CONSTRUCTOR(S) @@@
	public ASCIIHex() {
		System.out.println("@@@ ASCII Range As Hex @@@");
	}
	
	//@@@ METHODS @@@
	//### GETTERS ###
	public String getHex(int current_number) {
		StringBuffer aStringBuffer = new StringBuffer();
		aStringBuffer.append("0x");
		boolean padding = false;
		
		if(current_number == 0) {
			aStringBuffer.append('0');
		} else if (current_number % 16 == 0) {
			padding = true;
		}
		
		while(current_number > 0) {
			if(current_number >= RADIX) {
				int answer = current_number / RADIX;
				aStringBuffer.append(convertDecimalToHex(answer));
				current_number -= (RADIX * answer);
			} else {
				aStringBuffer.append(convertDecimalToHex(current_number));
				current_number -= current_number;
			}
		}
		if (padding)
			aStringBuffer.append('0');
		return aStringBuffer.toString();
	}

	//### HELPERS ###
	private String convertDecimalToHex(int number) {
		switch (number) {
			case 10:
				return ("A");
			case 11:
				return ("B");
			case 12:
				return ("C");
			case 13:
				return ("D");
			case 14:
				return ("E");
			case 15:
				return ("F");
			default:
				return (Integer.toString(number));
		}
	}
}
