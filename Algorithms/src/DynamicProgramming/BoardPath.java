package DynamicProgramming;
/**
 * 
 * @author Bharat
 *
 */

/**
 * 
 * This is an important algorithm in which 
 * we have starting point and ending point of the board and we have to reach
 * we have to count no of ways 
 * that hepls to recah end point i.e number by rolling the dice 
 * which have 1 to 6
 *
 */

public class BoardPath {
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
	
	public static int bpR(int start,int end)
	{
		if (start == end)
		{
			return 1;
		}
		else if (start > end)
			return 0;
		int count = 0;
		for(int dice  = 1; dice <= 6; dice++)
		{
			count += bpR(start + dice, end);
		}
		return count;
	}
	
	public static int bpRS(int curr, int end, int strg[])
	{
		if(curr ==  end)
		{
			return 1;
		}
		else if (curr > end)
			return 0;
		if(strg[curr] != 0)
			return strg[curr];
		int count = 0;
		for(int dice = 1; dice <= 6; dice++)
		{
			count += bpRS(curr + dice, end, strg);
		}
		strg[curr] = count;
		return count;
	}
	
	public static int bpIS(int curr, int end, int[] strg)
	{
		strg[end] =1;
		for(int i =  end - 1; i  >= 0; i-- )
		{
			int count = 0;
			for(int dice = 1; dice <= 6 && dice + 1 < strg.length; dice++)
			{
				count += strg[i + dice];
			}
			strg[i] = count;
		}
		return strg[0];
	}
	
	public static void main(String[] args)
	{
		int n = 10;
		startAlgo();
		System.out.println(bpR(0,n));
		System.out.println(endAlgo() + "ms");
		int[] strg = new int [n + 1];
		startAlgo();
		System.out.println(bpRS(0,n,strg));
		System.out.println(endAlgo() + "ms");
		startAlgo();
		System.out.println(bpIS(0,n,strg));
		System.out.println(endAlgo() + "ms");
	}
	
	
}
