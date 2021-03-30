package Maths;

/**
 * 
 * @author bharat
 *
 */
// A utility to check if a given number is power of two or not.
public class PoweOfTwoOrNot {
	public static void main(String[] args)
	{
		assert !checkIfPowerOfTwoOrNot(0);
		assert checkIfPowerOfTwoOrNot(1);
		assert checkIfPowerOfTwoOrNot(16);
		
	}
	
	/**
	 * Check is the given number power is 2 or not 
	 * 
	 * @param number number to check
	 * @return {@code true} if a given Number is power of two, otherwise {@code false}
	 */
	public static boolean checkIfPowerOfTwoOrNot(int number)
	{
		return number != 0 && ((number & (number - 1)) == 0);
	}

}
