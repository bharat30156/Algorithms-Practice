package DynamicProgramming;

public class CoinChange {
	public static void main(String[] args)
	{
		int amount = 12;
		int[] coins = {2,4,5};
		
		System.out.println("Number of combinations of getting change for " + amount + " is:" + change(coins,amount));
		
		System.out.println(
				"Minimun numbers of coins required for amount :"
				+ amount
				+ " is: "
				+ minimumCoins(coins, amount));
	}
	
	/**
	 *This method finds the number of combination of getting change for a given amount and vhange coins
	 * 
	 *@param coins the list of coins
	 *@param amount the for which we need to find the change finds the numbers of combinations 
	 *of change 
	 *  
	 */
	
	public static int change(int[] coins, int amount)
	{
		int[] combination = new int[amount + 1];
		combination[0] = 1;
		
		for(int coin : coins)
		{
			for(int i = coin; i < amount + 1; i++)
			{
				combination[i] += combination[i - coin];
			}
		}
		return combination[amount];
	}
	
	/**
	 *  this method finds the minimum of coins needed for agiven amount
	 *  
	 *  @param coins the list of coins 
	 *  @param amount the amount for which we need to find the the minimum number of coins finds the 
	 *  minimum numbers of coins that make  given value
	 */
	
	public static int minimumCoins(int[] coins, int amount)
	{
		//minimumCoins[i] will store the minimum coins for amount i
		int[] minimumCoins = new int[amount + 1];
		
		minimumCoins[0] = 0;
		
		for(int i = 1; i <= amount; i++)
		{
			minimumCoins[i] = Integer.MAX_VALUE;
		}
		for(int i = 1; i <= amount; i++)
		{
			for(int coin : coins)
			{
				if(coin <= i)
				{
					int sub_res = minimumCoins[i - coin];
					if(sub_res != Integer.MAX_VALUE && sub_res + 1 < minimumCoins[i])
						minimumCoins[i] = sub_res + 1;
				}
			}
		}
		
		return minimumCoins[amount];
	}
	
	// A basic print method which print all the content of the arary
	public static void printAmount(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}
}
