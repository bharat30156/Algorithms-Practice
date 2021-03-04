package Conversions;

import java.util.Scanner;

/**
 * 
 * @author bharat
 *
 */

//this class converts binary Numbers to decimal Numbers 

public class BinaryToDecimal {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int binNum, binCopy, d, s = 0, power = 0;
		System.out.println("Binary Number : ");
		binNum = sc.nextInt();
		binCopy = binNum;
		while(binCopy != 0)
		{
			d = binCopy % 10;
			s += d  * (int) Math.pow(2,power++);
			binCopy /= 10;
		}
		System.out.println("Decimal Equivalent : " + s);
		sc.close();
	}

}
