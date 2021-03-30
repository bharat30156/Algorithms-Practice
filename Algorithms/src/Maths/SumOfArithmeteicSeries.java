package Maths;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * In Mathematics, an arithemetic progression (Ap) or airthmetic swquence is a sequence of numbers
 * such that the difference between the consecutive terms is constant. Differnece here means 
 * second minus the first. For Instance, the sequence 5,7,9,11,13,15,... is an airthmetic progression with common difference 2 
 *
 */

public class SumOfArithmeteicSeries {
	public static void main(String[] args)
	{
		assert Double.compare(55.0, sumOfSeries(1, 1, 10)) == 0;
		
		assert Double.compare(100.0, sumOfSeries(1, 10, 10)) == 0;
		
		assert Double.compare(460.0, sumOfSeries(0.1, 0.1, 10)) == 0;
		
	}
	
	/**
	 * Calculate sum of airthmetic series 
	 * 
	 * @param firstTerm the inital term of an arithmetic series 
	 * @param commonDiff the common difference of an airthemetic series 
	 * @param numOfTerms  the total terms of an aritmetic series
	 * @return sum of given arithmetic series 
	 */
	private static double sumOfSeries(double firstTerms, double commonDiff, int numOfTerms)
	{
		return numOfTerms / 2.0 * (2 * firstTerms + (numOfTerms - 1) * commonDiff);
	}

}
