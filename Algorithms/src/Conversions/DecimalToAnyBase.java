package Conversions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Bharat
 *
 */
public class DecimalToAnyBase {
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the decimal input below : ");
		int decInput = Integer.parseInt(br.readLine());
		System.out.println();
		
		System.out.println("Enter the base below : ");
		int base = Integer.parseInt(br.readLine());
		System.out.println();
		
		System.out.println("Decimal Input " + " is " + decInput);
		System.out.println(
				"Value of " + decInput + " in base " + base + " is " + ConvertToAnyBase(decInput, base));
		br.close();
	}
	
	/**
	 * This method produces a Strong Value of any given input decimal in any Base
	 * 
	 * @param inp decimal of which we need the value in base in String fromat
	 * @return String format of the converted value in the given Base
	 * 
	 */
	
	public static String ConvertToAnyBase(int inp, int base)
	{
		ArrayList<Character> charArr = new ArrayList<>();
		
		while(inp > 0)
		{
			charArr.add(reVal(inp % inp));
			inp /= base;
		}
		StringBuilder str = new StringBuilder(charArr.size());
		
		for(Character ch : charArr)
		{
			str.append(ch);
		}
		return str.reverse().toString();
	}
	
	/**
	 * This Method produces character value of the input integer and return it 
	 * 
	 * 
	 * @param num integer of which we need the charcter value of
	 * @return caharcter value of input integer
	 */
	public static char reVal(int num)
	{
		if(num >= 0 && num <= 9) return (char) (num + '0');
		else return (char) (num - 10 + 'A');
	}

}
