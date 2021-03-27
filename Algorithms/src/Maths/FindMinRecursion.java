package Maths;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author Bharat
 *
 */
public class FindMinRecursion {
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		int size = rand.nextInt(100) + 1;
		int[] array = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			array[i] = rand.nextInt() % 100;
		}
		
		assert min(array, 0, array.length - 1) == Arrays.stream(array).min().getAsInt();
		assert min(array,  array.length ) == Arrays.stream(array).min().getAsInt();
		
	}
	/**
	 * get min of the array using divide and conquer algorithm 
	 * 
	 * @param array contains elments 
	 * @param low index of the first elelment
	 * @param high index ogf the last element
	 * @return min opf {@code array}
	 */
	public static int min(int[] array, int low, int high)
	{
		if(low == high)
		{
			return array[low];
		}
		int mid = (low + high) >>> 1;
		
		int leftMin = min(array, low, mid);
		int rightMin = min(array, mid + 1, high);
		
		return Math.min(leftMin, rightMin);
		
	}
	
	/**
	 * Get min of the array using recursion algorithm
	 * 
	 * @param array contains elements
	 * @param len length of the array
	 * @return ming value of {@code array}
	 */
	
	public static int min(int[] array, int len)
	{
		return len == 1 ? array[0] : Math.min(min(array, len  -1), array[len - 1]);
	}

}
