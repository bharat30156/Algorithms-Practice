package Maths;

import java.util.Scanner;

/**
 * 
 * @author Bharat
 *
 */
// This program will check whether the number is Prime or Not
public class PrimeCheck {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a Number : " );
		int n = sc.nextInt();
		if(isPrime(n))
		{
			System.out.println(n + " is a prime number");
		}
		else
		{
			System.out.println(n + " is not a prime number");
		}
		sc.close();
	}
	
	/**
	 * Checks if a number is prime or not 
	 * 
	 * @param n the number 
	 * @return {@code  true} if{@code n} is prime 
	 */
	public static boolean isPrime(int n)
	{
		if(n == 2)
		{
			return true;
		}
		if(n < 2 || n % 2 == 0)
		{
			return false;
		}
		for(int i = 3, limit = (int) Math.sqrt(n); i <= limit; i += 2)
		{
			if(n % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	

}
