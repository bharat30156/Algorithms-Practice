package Conversions;

import java.util.Scanner;

/**
 * 
 * @author Bharat
 *
 */
/** This class converts decimal number to octal numbers*/
public class DecimalToOctal {
	public static void mian(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n, k, d, s = 0, c = 0;
		System.out.println("Decimal number : ");
		n = sc.nextInt();
		k = n;
		while (k != 0)
		{
			d = k % 8;
			s += d * (int) Math.pow(10, c++);
			k /= 8;
		}
		
		System.out.println("Octal Equivalent : " + s);
		sc.close();
	}

}
