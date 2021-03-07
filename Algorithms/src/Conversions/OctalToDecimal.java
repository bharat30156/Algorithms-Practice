package Conversions;
/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * Converts Any Octal Numbers to Decimal Number
 *
 */
public class OctalToDecimal {
	// Driver Code
	public static void main(String[] args)
	{
		
	}
	
	/**
	 * This Method converts an Octal Number to decimal Number 
	 * 
	 * @param inputDecimal the Octal number 
	 * @return the decimal Number
	 */
	public static int convertOctalToDecimal(String inputOctal)
	{
		try 
		{
			//Actual Conversion of octal to decimal 
			Integer outputDecimal = Integer.parseInt(inputOctal, 8);
			return outputDecimal;
		}
		catch(NumberFormatException ex)
		{
			//Printing a warning message if that input is not a valid octal
			System.out.println("Invaliud Input, Expecting octal Number 0 -7");
			return -1;
		}	
	}
}
