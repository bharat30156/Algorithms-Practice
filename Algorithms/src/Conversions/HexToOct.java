package Conversions;

import java.util.Scanner;

/**
 * 
 * @author bharat
 *
 */
/** converts any Hexadecimal number into octal Number*/
public class HexToOct {
	/**
	 * This method converts a Hexadecimal Number to a decimal numbere
	 * 
	 *  @param s the HexaDecimal Number 
	 *  @return The decimal number 
	 */
	public static int hex2decimal(String s)
	{
		String str = "0123456789ABCDEF";
		s = s.toUpperCase();
		int val = 0;
		for(int i = 0; i < s.length(); i++)
		{
			char a = s.charAt(i);
			int n = str.indexOf(a);
			val = 16 * val + n;
		}
		return val;
	}
	/**
	 * This method converts a decimal number to a octal Number
	 * 
	 *  @param q the decimal Number 
	 *  @return the octal number
	 */
	public static int decimal2octal(int q)
	{
		int now;
		int i = 1;
		int octnum = 0;
		while (q > 0)
		{
			now = q % 8;
			octnum = (now * (int) (Math.pow(10, i))) + octnum;
			q /= 8;
			i++;
		}
		octnum /= 10;
		return octnum;
	}
	/**
	 * Driver code 
	 * 
	 * @param args argument
	 */
	
	public static void main(String[] args)
	{
		String hexadecnum;
		int decnum, octalnum;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Hexadecimal Number : ");
		hexadecnum = scan.nextLine();
		
		//first convert hexadecimal to decimal 
		decnum = 
				hex2decimal(
						hexadecnum); // Pass the String the hex2decimal function and get the decimal form in
		
		// variable decnum 
		
		// convert decimal to octal
		
		octalnum = decimal2octal(decnum);
		System.out.println("Number in octal : " + octalnum );
		scan.close();
	}

}
