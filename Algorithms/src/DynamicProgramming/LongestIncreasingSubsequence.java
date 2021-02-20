package DynamicProgramming;

import java.util.Scanner;

/**
 * 
 * @author Bharat
 *
 */
public class LongestIncreasingSubsequence {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			ar[i] = sc.nextInt();
		}
		System.out.println(LIS(ar));
		sc.close();
	}
	
	private static int UpperBound(int[] ar, int l, int r, int key)
	{
		while(l < r - 1)
		{
			int m = (l + r) >>> 1;
			if(ar[m] >= key) r  = m;
			else l = m;
		}
		return r;
	}
	
	private static int LIS(int[] array)
	{
		int N = array.length;
		if(N == 0) return 0;
		
		int[] tail = new int[N];
		
		//always points empty slot in tail
		int length = 1;
		
		tail[0] = array[0];
		for(int i = 1; i < N; i++)
		{
			// new smallest value
			if(array[i] < tail[0]) tail[0] = array[i];
			
			// array[i] extends largezst subsequence
			else if (array[i] > tail[length - 1]) tail[length++] = array[i];
			
			
			//array[i] will become end candidate of an existing susequence or
			//Throw away larger elements in all LTS to make room for upcoming grater elements than 
			//array[i]
			//(and, also array[i] wpould have already apperead in one of LTS identify the location a 
			//replace it)
			else tail[UpperBound(tail, -1, length - 1, array[i])] = array[i];
		}
		return length;
	}
}
