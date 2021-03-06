package Conversions;
/**
 * 
 * @author bk301
 *
 */
//hex = [0 - 9] -> [A - F]
class DecimalToHexaDecimal {
	private static final int sizeOfIntInHalfBytes= 8;
	private static final int numberOfBitsInHalByte = 4;
	private static final int halfByte = 0x0F;
	private static final char[] hexDigits= {
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
	};
	
	//Returns the hex value of the dec entered in the parameter
	public static String decToHex(int dec)
	{
		StringBuilder hexBuilder = new StringBuilder(sizeOfIntInHalfBytes);
		hexBuilder.setLength(sizeOfIntInHalfBytes);
		for(int i = sizeOfIntInHalfBytes - 1; i >= 0; i--)
		{
			int j = dec & halfByte;
			hexBuilder.setCharAt(i, hexDigits[j]);
			dec >>= numberOfBitsInHalByte;
		}
		return hexBuilder.toString().toLowerCase();
	}
	/*
	 * Driver Code
	 */
	public static void mian(String[] args)
	{
		System.out.println("Test....");
		int dec = 305445566;
		String libraryDecToHex = Integer.toHexString(dec);
		String decToHex = decToHex(dec);
		System.out.println("Result from the libarray : " + libraryDecToHex);
		System.out.println("Result decToHex method : " + decToHex);
	}

}
