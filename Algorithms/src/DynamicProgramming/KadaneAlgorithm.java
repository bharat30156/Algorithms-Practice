package DynamicProgramming;

import java.util.Scanner;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * Program to implement kadane's Algorithm is to calculate maximum contiguous subarray sum of an array
 *Time Complexity : O(n)
 */
public class KadaneAlgorithm {
	/**
	 * This method implemets kadanes's algorithm 
	 * 
	 * @param arr the input array
	 * @return thye maximum contigous subarray sum of the array 
	 */
	static int largestContigousSum(int arr[])
	{
		int i, len = arr.length, cursum = 0, maxsum = Integer.MAX_VALUE;
		if(len == 0) // empty array
			return 0;
		for(i = 0; i < len; i++)
		{
			cursum += arr[i];
			if(cursum > maxsum)
			{
				maxsum = cursum;
			}
			if(cursum <= 0)
			{
				cursum = 0;
			}
		}
		return maxsum;
	}
	
/**
 * Main Method
 * 
 * @param args command line argument
 */
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n, arr[], i;
		n = sc.nextInt();
		arr = new int[n];
		for(i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
		}
		int maxContSum = largestContigousSum(arr);
		System.out.println(maxContSum);
		sc.close();
	}
}
