package DynamicProgramming;

public class CountNumBinaryString {
	public static long startTime;
	public static long endTime;
	public static void startAlgo()
	{
		startTime = System.currentTimeMillis();
	}
	public static long endAlgo()
	{
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
	public static int numStrIs(int n)
	{
		int[] zeros = new int[n];
		int[] ones = new int[n];
		
		//seed
		zeros[0] = 1;
		ones[0] = 1;
		for(int i = 1; i < n; i++)
		{
			zeros[i] = zeros[i - 1] + ones[i - 1];
			ones[i] = zeros[i - 1];
		}
		int ans = zeros[n- 1] + ones[n -1 ];
		return ans;
	}
	
	private class Binary
	{
		int ones;
		int zeros;
		int ans;
		Binary(int ones, int zeros)
		{
			this.ones = ones;
			this.zeros = zeros;
			this.ans = 0;
		}
		Binary(){}
	}
	public Binary numStrR(int n)
	{
		if( n == 1)
		{
			Binary br = new Binary(1,1);
			return br;
		}
		Binary mr = new Binary();
		Binary rr = numStrR(n -1);
		mr.zeros = rr.zeros+rr.ones;
		mr.ones = rr.zeros;
		mr.ans = mr.zeros + mr.ones;
		return mr;
	}
	
	public static int countsStrings(int n, int lastDigit)
	{
		if(n == 0)
		{
			return 0;
		}
		//if only one digit is left
		if(n == 1)
		{
			return (lastDigit == 1) ? 1 :2;
		}
		
		//if last digit is 0 we can have both 0 and 1 at current pos
		if(lastDigit == 0)
			return countsStrings(n -1, 0) + countsStrings(n - 1, 1);
		
		// if last digit is 1, we can have only one 0 at current position
		else
		{
			return countsStrings(n -1, 0);
		}
	}
	
	public static void main(String[] args)
	{
		int n =  30;
		startAlgo();
		System.out.println(numStrIs(n));
		System.out.println(endAlgo() + "ms");
		
		startAlgo();
		CountNumBinaryString out  = new CountNumBinaryString();
		System.out.println(out.numStrR(n).ans);
		System.out.println(endAlgo() + "ms");
		
	}
	

}
