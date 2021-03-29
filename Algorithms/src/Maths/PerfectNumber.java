package Maths;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * In number theory a perfect number is positive integer that is equal to the sum of its positive 
 * divisor excluding the number itself. For Instance 6 has divisor 1,2 and 3 (excluding itself) and 1 + 2 + 3 = 6, so is a perfect number 
 *
 */
public class PerfectNumber {
	public static void main(String[] args)
	{
		assert isPerfectNumber(6);
		assert !isPerfectNumber(8);
	}
	
	/**
	 * Check if {@code number} is number numbner or not 
	 * 
	 * @param number the number
	 * @return {@code true} if {@code number} is perfect number, otherwise false
	 */
	public static boolean isPerfectNumber(int number)
	{
		int sum = 0; 
		for(int i = 1; i < number; i++)
		{
			if(number % i == 0)
			{
				sum += i;
			}
		}
		return sum == number;
	}
}
