package Maths;

public class PythagoreanTriple {
	public static void main(String[] args)
	{
		assert isPythagTriple(3,4,5);
		assert isPythagTriple(10,20,30);
	}
	
	/**
	 * check if a,b,c are pythagorean Triple
	 * 
	 * @param a x/y component length of right triangle 
	 * @param b y/x component length of right triangle 
	 * @param c hypotenuse length of a right triangle 
	 * @return boolean <tt>true</true> if a,b,c satisfy the pythegorean theorm, otherwise <tt>False</False>
	 */
	
	public static boolean isPythagTriple(int a, int b, int c)
	{
		if(a <= 0|| b <= 0 || c<= 0)
		{
			return false;
		}
		else
		{
			return (a*a) + (b*b) == (c*c);
		}
	}

}
