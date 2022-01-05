package DataStructuresStacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author Bharat
 *
 */

/**
 * 
 * 1. you are given a String exp represting an expression 
 * 2. Assume that the expression is balanced i.e the openening and closing brackets match with each other 
 * 3. But, Some of the pair of bracket maybe extra/needsless
 * 4. Your are required to print true if you direct detact extra brackets and false otherwise 
 * 
 * eg, '
 * ((a+b) + (c+d)) -> false
 * (a+b) + ((c+d)) -> true
 *
 */
public class DupliactesBrackets {
	public static boolean check(String str) 
	{
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) 
        {
            char ch = str.charAt(i);
            if (ch == ')') 
            {
                if (st.peek() == '(') 
                {
                    return true;
                } else {
                    while (st.size() > 0 && st.peek() != '(') 
                    {
                        st.pop();
                    }
                    st.pop();
                }

            } 
            else 
            {
                st.push(ch);
            }
            // System.out.println(st);
        }
        return false;
    }
	
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String str =  sc.nextLine();
		System.out.println(check(str));
	}


}
