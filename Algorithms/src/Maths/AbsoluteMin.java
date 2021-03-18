package Maths;

import java.util.Arrays;

/**
 * 
 * @author Bharat
 *
 */
public class AbsoluteMin {
	public static void main(String[] args)
	{
		int[] testnums = {4, 0, 16};
		assert absMin(testnums) == 0;
		
		int[] numbers = {3, -10, -2};
		System.out.println("absMin(" + Arrays.toString(numbers) + ") = " + absMin(numbers));
	}
	/**
	 * gte teh value, returns the absolute min value min
	 * 
	 * @param numbers contain elements 
	 * @return the absolute min value 
	 */
	public static int absMin(int[] numbers)
	{
		int absMinValue = numbers[0];
		for(int i = 1, length = numbers.length; i < length; i++)
		{
			if(Math.abs(numbers[i]) < Math.abs(absMinValue))
			{
				absMinValue = numbers[i];
			}
		}
		return absMinValue;
	}

}
