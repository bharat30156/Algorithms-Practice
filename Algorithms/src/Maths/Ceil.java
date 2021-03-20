package Maths;

import java.util.Random;

/**
 * 
 * @author Bharat
 *
 */
public class Ceil {
	public static void main(String[] args)
	{
		Random random = new Random();
		for(int i = 1; i <= 1000; i++)
		{
			double randomNumber = random.nextDouble();
			assert Ceil(randomNumber) == Math.ceil(randomNumber);
		}
	}
	/**
	 * Return the smallest (closet to negative infinetly)
	 * 
	 * @param number the number
	 * @return the smallest number (closet to infinitely) of given {@code number}
	 */
	public static double Ceil(double number)
	{
		if(number - (int) number == 0)
		{
			return number;
		}
		else if(number - (int) number > 0)
		{
			return(int)(number + 1);
		}
		else
		{
			return (int) number;
		}
	}
}
