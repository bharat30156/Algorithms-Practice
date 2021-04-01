package Misc;

import java.util.Scanner;

public class PalindromePrime {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the quatinty of first palindromic primes you want ");
		int n = in.nextInt();
		functioning(n);
		in.close();
	}
	
	public static boolean prime(int num)
	{
		for(int divisor = 3; divisor <= Math.sqrt(num); divisor += 2)
		{
			if(num % divisor == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static int reverse(int n)
	{
		int reverse = 0;
		while(n != 0)
		{
			reverse *= 10;
			reverse += n % 10;
			n /= 10;
		}
		return reverse;
	}
	
	public static void functioning(int y)
	{
		if(y == 0) return;
		System.out.println(2 + "\n");
		int count = 1;
		int num = 3;
		while (count < y)
		{
			if(num == reverse(num) && prime(num))
			{
				count++;
				System.out.println(num + "\n");
			}
			num += 2;
		}
	}
}
