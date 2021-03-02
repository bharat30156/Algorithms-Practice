package Conversions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * Class for converting from any base to any other base when any means from 2-36 works by 
 * going from base 1 to decimal to base 2. Includes auxiliary method for determining whether a number is valid for a given base
 *
 */

public class AnyBaseToAnyBase {
	//Smallest and largest base you want to accept as valid input
	static final int MINIMUM_BASE = 2;
	static final int MAXIMUM_BASE = 36;
	
	public static void mian(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String n;
		int b1, b2;
		while(true)
		{
			try 
			{
				System.out.println("Enter any Number : ");
				n = in.next();
				System.out.println(
						"Enter begining base (between " + MINIMUM_BASE + " and " + MAXIMUM_BASE + "): ");
				b1 = in.nextInt();
				if(b1 > MAXIMUM_BASE || b1 < MINIMUM_BASE)
				{
					System.out.println("Invalid base! ");
					continue;
				}
				if(!validforBase(n, b1))
				{
					System.out.println("The number is invalid for this base");
					continue;
				}
				System.out.println(
						"Enter end base (between " + MINIMUM_BASE + " and " + MAXIMUM_BASE + "): ");
				b2= in.nextInt();
				if(b2 > MAXIMUM_BASE || b2 < MINIMUM_BASE)
				{
					System.out.println("Invalid base!");
					continue;
				}
				break;
			}catch (InputMismatchException e)
			{
				System.out.println("Invalid input.");
				in.next();
			}
		}
		System.out.println(base2base(n, b1, b2));
		in.close();
	}
	
	// checks if a number (as a string) is valid for a given base
	public static boolean validforBase(String n, int base)
	{
		char[] validDigits = {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			      'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
		};
		
		//digits for base contains all the validdigit for the base given
		char[] digitForBase = Arrays.copyOfRange(validDigits, 0, base);
		
		//convert the character array into set for convenience of contain method 
		HashSet<Character>digitList = new HashSet<>();
		for(int i = 0; i < digitForBase.length; i++) digitList.add(digitForBase[i]);
		
		//chech that every digit in n is within the list of valid digits for that base
		for(char c : n.toCharArray()) if (!digitList.contains(c)) return false;
		
		return true;
	}
	
	
	/**
	 * Method to convert any integer from base b1 to base b2 works by converting from b1 to decimal then decimal to b2
	 * 
	 * @param n the integer to be converted
	 * @param b1 begning base
	 * @param b2 end base
	 * @param n in base b2
	 * 
	 */
	
	public static String base2base(String n, int b1, int b2)
	{
		//Declare variables decimal value to n
		//character of base b1 chracter of base 2
		// and thye String that will be returned 
		int decimalValue = 0, charB2;
		char charB1;
		String output = "";
		//go through every chracter of n
		for(int i = 0; i < n.length(); i++)
		{
			//store the character in charB1
			charB1 = n.charAt(i);
			//if it is a non-number convert it to decimal value > 9 and store it in charB2
			if(charB1 >= 'A' && charB1 <= 'Z') charB2 = 10 + (charB2 = 'A');
			//else stroe the integer valiue in charB2
			else charB2 = charB1 = '0';
			//convert the digit to decimal and add it to the 
			//decimal value n
			decimalValue = decimalValue * b1 + charB2;
		}
		
		//convreting the decimal value to base b2
		//A Number is convreted from decimal to another base
		//by continously dividing by the base and recording 
		//the remainder until the quoitenet is zero the number in the 
		//new base is the remianders the quotinent is zero the number in the 
		//being the left most digit 
		if(0 == decimalValue) return "0";
		//while the quotient is NOt zero 
		while (decimalValue  != 0)
		{
			//if the remainder is a digit < 10 , simply add it to 
			//the left side of the new corner
			if(decimalValue % b2 < 10) output = Integer.toString(decimalValue % b2) + output;
			//If the remiander is  >= 10 add a character withe the 
			//correspoinding value to the new number (A = 10, B = 11, C 12,....)
			else output = (char) ((decimalValue % b2) + 55) + output;
			
			//Divide by the new bae again
			decimalValue /= b2;
		}
		return output;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
