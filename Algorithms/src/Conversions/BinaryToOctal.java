package Conversions;

import java.util.Scanner;

/**
 * 
 * @author bharat
 *
 */
//converts Binary Number to Octal Number
public class BinaryToOctal {
	public static void mian(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the binary Number : ");
		int b = sc.nextInt();
		System.out.println("Octal equivalent : " + convertBinaryToOctal(b));
		sc.close();
	}
	
	/**
	 * This me6hod converts a binary number to an octal number
	 * 
	 * @param binary the binary NUmber
	 * @param the octal Number
	 */
	public static String convertBinaryToOctal(int binary)
	{
		String octal= "";
		int currBit = 0, j = 1;
		while(binary != 0)
		{
			int code3 = 0;
			for(int i = 1; i < 3; i++)
			{
				currBit = binary % 10;
				binary = binary / 10;
				code3 += currBit * j;
				j *= 2;
			}
			octal = code3 + octal;
			j = 1;	
		}
		return octal;
	}

}
