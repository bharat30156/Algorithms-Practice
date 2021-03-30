package Maths;

import java.util.Scanner;

public class PrimeFactorization {
	public static void main(String[] args)
	{
		System.out.println("## all prime factors ##");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number : ");
		int n = sc.nextInt();
		System.out.println("Printing factors of " + n + " : ");
		pfactors(n);
		sc.close();
	}
	
	public static void pfactors(int n)
	{
		while (n % 2 == 0)
		{
			System.out.println(2 + " ");
			n /= 2;
		}
		
		for(int i = 3; i <= Math.sqrt(n); i += 2)
		{
			while (n % i == 0)
			{
				System.out.println(i + " ");
				n /= i;
			}
		}
		
		if(n > 2) System.out.println(n);
	}
}
