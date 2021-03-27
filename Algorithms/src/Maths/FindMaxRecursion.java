package Maths;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author Bharat
 *
 */
public class FindMaxRecursion {
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		// rand size 
		int size = rand.nextInt();
		int[] array = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			array[i] = rand.nextInt() % 100;
		}
		
		assert max(array, array.length) == Arrays.stream(array).max().getAsInt();
		assert max(array, 0 , array.length - 1) == Arrays.stream(array).max().getAsInt();
	}
	
	/**
	 * Get the max of array using divide and conquer algorithm 
	 * 
	 * @param array comtians elements 
	 * @param low index of the first element 
	 * @param high index of te first element
	 * @return max of {@code array}
	 */
	public static int max(int array[], int low, int high)
	{
		if(low == high)
		{
			return array[low]; // pr array[high]
		}
		int mid = (low + high) >>> 1;
		int leftMax = max(array, low, mid); 
		int rightMax = max(array, mid + 1, high);
		
		return Math.max(leftMax, rightMax);
	}
	
	/**
	 * Get max of the array using recursion algorithm
	 * 
	 * @param array contains elements 
	 * @param len of the given array
	 * @return max value of {@code array}
	 */
	
	public static int max(int array[], int len)
	{
		return len == 1 ? array[0] : Math.max(max(array, len - 1), array[len -1]);
	}

}
