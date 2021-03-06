package Conversions;

import java.util.Scanner;

/**
 * 
 * @author Bharat
 *
 */

// this class converts a Decimal number to a binary number
class DecimalToBinary {
	public static void main(String[] args)
	{
		conventionalConversion();
		bitwiseConversion();
	}
	//This mtehod converts a decimal Number to abinary number using a conventional algorithm 
	public static void conventionalConversion()
	{
		int n, b = 0, c = 0, d;
		Scanner input = new Scanner(System.in);
		System.out.printf("Conventional conversion.%n Enter thye deimal number : ");
		n = input.nextInt();
		while(n != 0)
		{
			d = n % 2;
			b = b + d * (int) Math.pow(10, c++);
			n /= 2;
		} // converting decimal to binary\
		System.out.println("\tBinary number : " + b);
		input.close();
	}
	
	/**This method converts a decimal number to ab unary number using a bitwise algorithm*/
	public static void bitwiseConversion()
	{
		int n, b= 0, c = 0, d;
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Bitwise Conversion.%n Enter the decimal number : ");
		n = input.nextInt();
		while(n != 0)
		{
			d = (n & 1);
			b+= d * (int) Math.pow(10, c++);
			n >>= 1;
		}
		System.out.println("\tBinary number: " + b);
		input.close();
	}
	

}
