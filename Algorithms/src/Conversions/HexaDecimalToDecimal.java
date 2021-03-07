package Conversions;

import java.util.Scanner;

/**
 * 
 * @author Bharat
 *
 */

public class HexaDecimalToDecimal {
	// Converts hexaDecimal To Decimal
	public static int getHexToDec(String hex)
	{
		String digits = "0123456789ABCDEF";
		hex = hex.toUpperCase();
		int val = 0;
		for(int i = 0; i < hex.length();  i++)
		{
			int d = digits.indexOf(hex.charAt(i));
			val = 16 * val + d;
		}
		return val;
	}
	
	//drier code
	public static void main(String[] args)
	{
		String hexa_Input;
		int dec_Output;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter HexaDecimal Number : ");
		hexa_Input = scan.nextLine();
		
		//convert hexadecimal to decimal 
		dec_Output = getHexToDec(hexa_Input);
		
		/**
		 * pass the String to the getHexToDec function
		 * and it return decimal form in the variable dec_Output
		 */
		System.out.println("NUmbers in Decimal : " + dec_Output);
		scan.close();
	}

}
