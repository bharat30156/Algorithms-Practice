package Maths;

/**
 * 
 * @author Bharat
 *
 */

// find the number of digits in a number 
public class NumberOfDigits {
	public static void mian(String[] args)
	{
		int[] number = { 0, 12, 123, 1234, -12345, 123456, 1234567, 12345678, 123456789};
		for(int i = 0 ; i < number.length; i++)
		{
			assert numberOfDigits(number[i]) == i + 1;
			assert numberOfDigitsFast(number[i]) == i + 1;
			assert numberOfDigitsFaster(number[i]) == i + 1;
			assert numberOfDigitsRecursion(number[i]) == i + 1;
		}
	}
	
	/**
	 *  Find the number of the digits in a number 
	 *  
	 *  @param number number to find 
	 *  @return number of digits of given number 
	 */
	
	public static int numberOfDigits(int number)
	{
		int digits = 0;
		do
		{
			digits++;
			number /= 10;
		}
		while(number != 0);
		return digits;
	}
	
	/**
	 * find the number of digits in the fast version 
	 * 
	 * @param number number to find 
	 * @return number of digits of given number
	 */
	private static int numberOfDigitsFast(int number)
	{
		return number == 0 ? 1 : (int) Math.floor(Math.log10(Math.abs(number)) + 1);
	}
	
	/**
	 * find the number of digits in the faster version 
	 * 
	 * @param number number to find
	 * @return number of digits of given number 
	 */
	private static int numberOfDigitsFaster(int number)
	{
		return number < 0 ? (-number + "").length() : (number  + "").length();
	}
	
	/**
	 * Find the number of digits in the number using recrsion
	 * 
	 * @param number number to find 
	 * @return number of digits in a given number
	 */
	private static int numberOfDigitsRecursion(int number)
	{
		return number / 10 == 0 ? 1 : 1 + numberOfDigitsRecursion(number / 10);
	}
	

}
