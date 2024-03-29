package Maths;
/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * I the theory the aliquot sum s(n) of positive integer n is the sum of all proper divisors
 * of n that is all divisor of n other that n itself For Example the proper divisors of 15 
 * (that is, the positive divisors of 15 thata re niot equal to 15) are 1, 3 and 5 so the aliquot 
 * sum of 15 is 9 i.e (1+3+5)
 *
 */
public class AliquotSum {
	public static void main(String[] args)
	{
		assert aliquotSum(1) == 0;
		assert aliquotSum(6) == 6;
		assert aliquotSum(15) == 9;
		assert aliquotSum(19) == 1;
	}
	/**
	 * Finds the aliquot sum of an integer number
	 * 
	 * @param number a positive integer
	 * @return aliquot sum of given{@code number}
	 */
	public static int aliquotSum(int number)
	{
		int sum = 0;
		for(int i = 1, limit = number / 2; i <= limit; i++)
		{
			if(number % i == 0)
			{
				sum += i;
			}
		}
		return sum;
	}

}
