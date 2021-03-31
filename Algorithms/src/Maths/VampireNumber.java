package Maths;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Bharat
 *
 */

/**
 * 
 * n number theory, a vampire number (or true vampire number) is composite natural number with an 
 * even number of digits, that can be factored into the two natural number each with half as many 
 * digits as the original number and not both with trailing zeores, where the two factors contains 
 * precisely all the digits of the original number in any order, counting multiplicity. The first 
 * vampire number is 1260 = 21 x 60. *
 *
 */
public class VampireNumber {
	public static void main (String[] args )
	{
		test(10, 1000);
	}
	
	static void test (int startValue, int stopValue)
	{
		int countofRes = 1;
		StringBuilder res = new StringBuilder();
		
		for(int i = startValue; i <= stopValue; i++)
		{
			for(int j = i; j <= stopValue; j++)
			{
				if(isVampireNumber(i, j, true))
				{
					countofRes++;
					res.append("" + countofRes + ": = ( " + " , " + j + " = " + i * j + ")" + "\n");
				}
			}
		}
		System.out.println(res);
	}
	
	static boolean isVampireNumber (int a, int b, boolean noPseudoVampireNumber)
	{
		if(noPseudoVampireNumber)
		{
			if(a * 10 <= b || b * 10 <= a)
			{
				return false;
			}
		}
		
		String mulDigits = splitIntoDigits(a * b, 0);
		String faktorDigits = splitIntoDigits(a, b);
		
		return mulDigits.equals(faktorDigits);
	}
	
	static String splitIntoDigits(int num, int num2)
	{
		StringBuilder res = new StringBuilder();
		ArrayList<Integer> digits = new ArrayList<>();
		while(num > 0)
		{
			digits.add(num % 10);
			num /= 10;
		}
		while (num2 > 0)
		{
			digits.add(num2 % 10);
			num2 /= 10;
		}
		Collections.sort(digits);
		for(int i : digits)
		{
			res.append(i);
		}
		return res.toString();
	}

}
