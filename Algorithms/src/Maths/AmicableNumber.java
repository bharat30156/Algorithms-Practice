package Maths;
/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * amicable numbers are two different numbers so related that the sum of the proper divisor of each
 * is equal to the other number. (A proper divisor of a number is a positive factor of that number
 * other than the number itself. For Example the proper divisor of 6 are 1, 2 and 3). A paoir of 
 * numbers consititues an aliquot sequence of period 2 it is known if tehre are 
 * infinitely many pairs of amicable numbers.
 *
 *<p> Simple Example : (220, 284) is divisible by {1,2,3,4,5,10,11,20,44,55,110} <- sum = 284
 *divisible by -> 1,2,4,71,142  and the sum of that is Yes Right probably expected it 
 */
public class AmicableNumber {
	public static void main(String[] args)
	{
		AmicableNumber.findAllInRange(1, 3000);
	}
	/**
	 * @param startValue
	 * @param StopValue
	 * @return
	 */
	static void findAllInRange(int startValue, int stopValue)
	{
		/**
		 * The 2 for loops are to avoid to double check tuple. For example (200, 100) and (100, 200) is the same calculation
		 * also to avoid is to check the number with it self a  number with itself is always a AmicableNumber
		 * 
		 */
		StringBuilder res = new StringBuilder();
		int countofRes = 0;
		
		for(int i = startValue; i < stopValue; i++)
		{
			for(int j = i + 1 ;j <= stopValue; j++)
			{
				if(isAmicableNumber(i, j))
				{
					countofRes++;
					res.append("" + countofRes + ": = (" + i + "," + ")" + "\t");
				}
			}
		}
		res.insert(
				0, 
				"Int Range of "
				+ startValue
				+ " till "
				+ stopValue
				+ " there are "
				+ countofRes
				+ "Amicabke_number. These are \n ");
		System.out.println(res.toString());
	}
	
	/**
	 * check if {@code numberOne and numberTwo} are Amicable number or not
	 * 
	 * @param numberone numberTwo
	 * @return {@code true} if{@code numberOne numberTwo} isAmicablenumbers otherwise false
	 */
	static boolean isAmicableNumber(int numberOne, int numberTwo)
	{
		return ((recusiveCalcOfDividerSum(numberOne, numberOne) == numberTwo
				&& numberOne == recusiveCalcOfDividerSum(numberTwo, numberTwo)));
	}
	
	/**
	 * calculated in recurisve calls the sum of all the divider beside it self
	 * 
	 * @param number div = the next to test dividely by using the muldo operator 
	 * @return sum of all the dividers
	 */
	
	static int recusiveCalcOfDividerSum(int number, int div)
	{
		if(div == 1)
		{
			return 0; 
		}
		else if (number % --div == 0)
		{
			return recusiveCalcOfDividerSum(number, div) + div;
		}
		else
		{
			return recusiveCalcOfDividerSum(number, div);
		}
	}	
}
