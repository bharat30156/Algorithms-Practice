package Maths;

import java.util.Random;

public class AbsoluteValue {
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		/* test 1000 random numbers*/
		for(int i = 0; i <= 1000; i++)
		{
			int randomNumber = rand.nextInt();
			System.out.println(absVal(randomNumber) == Math.abs(randomNumber));
		}
	}
	
	/**
	 * if value is less than zero make value positive
	 * 
	 * @param value a number
	 * @return the absolute value of a number
	 */
	public static int absVal(int value)
	{
		return value < 0 ? - value : value;
	}

}
