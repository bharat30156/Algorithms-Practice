package Maths;

import java.util.Arrays;

/**
 * 
 * @author Bharat
 *
 */
public class Median {
	public static void mian(String[] args)
	{
		assert median(new int[] {0}) == 0;
		assert median(new int[] {1,2}) == 1.5;
		
	}
	
	/**
	 * Calculate eteh average median
	 * 
	 * @param value number series 
	 * @return median of give code {@code values}
	 */
	
	public static double median(int[] values)
	{
		Arrays.sort(values);
		int length = values.length;
		return length % 2 == 0
				? (values[length / 2] + values[length / 2 - 1]) / 2.0
						: values[length/2];
	}

}
