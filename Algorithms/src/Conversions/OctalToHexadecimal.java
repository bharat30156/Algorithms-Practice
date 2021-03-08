package Conversions;

import java.util.Scanner;

/**
 * 
 * @author bharat
 *
 */
/**
 * 
 * Converts any octal Number to hexadecimal
 *
 */

public class OctalToHexadecimal {
	/**
	 * This methid converts a octal Number To a decimal Number
	 * 
	 * @param s the octal Number
	 * @return the decimal Number
	 */
	
	public static int octToDec(String s)
	{
		int i = 0;
		for(int j = 0; j < s.length(); j++)
		{
			char num = s.charAt(j);
			num-= '0';
			i *= 8;
			i += num;
		}
		return i;
	}
	/**
	 * This Method Converts a decimal Number to a HexaDecimal number
	 * 
	 * @param d the decimal Number
	 * @return the HexaDecimal Number
	 */
	public static String decimalToHex(int d)
	{
		String digits = "0123456789ABCDEF";
		if(d <= 0) return "0";
		String hex = "";
		while(d > 0)
		{
			int digit = d % 16;
			hex = digits.charAt(digit) + hex;
			d = d / 16;
		}
		return hex;
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the octal Number : ");
		//Take octal Number as input from the user in a String
		String oct = input.next();
		
		int decimal = octToDec(oct);
		
		String hex = decimalToHex(decimal);
		System.out.println("The HexaDecimal Equivalent is : " + hex);
		input.close();
	}
	
}
