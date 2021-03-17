package Maths;

import java.util.Arrays;

/**
 * 
 * @author Bharat
 *
 */
public class AbsoluteMax {
	public static void main(String[] args)
	{
		int[] testnums = {-2,0, 16};
		assert absMax(testnums) == 16;
		
		int[] numbers = {3, -10, -2};
		System.out.println("absMax(" + Arrays.toString(numbers) + ")" + absMax(numbers));
	}
	/**
	 * get the vakue, return the absolute max value
	 * 
	 * @param the numebr contain elements 
	 */
	public static int absMax(int[] numbers)
	{
		int absMaxValue = numbers[0];
		for(int i = 1, length = numbers.length; i < length; i++)
		{
			if(Math.abs(numbers[i]) > Math.abs(absMaxValue))
			{
				absMaxValue = numbers[i];
			}
		}
		return absMaxValue;
	}

}
