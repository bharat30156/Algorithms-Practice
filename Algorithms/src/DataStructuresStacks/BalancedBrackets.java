package DataStructuresStacks;

import java.util.Stack;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * The nested brackets problem is a problem that determines if a sequence of brackets are properly nested. A sequence of brackets is considered properly 
 * nested if any of the following conditions are true - s is empty considered properly 
 * nested if any of the following conditions are true - s is empty has the 
 * form (U) or[U] or {u} is a properly nested strong - s has the form VW where V and W
 * are properly nested strings For example, the string "()()[()]" is properly nested but "[(())]" is not.
 * The function caled is_balanced takes as input a string which is a sequence of brackets and returns true if is nested 
 * and false otherwise 
 */
public class BalancedBrackets {
	/**
	 * check if {@code leftBracket} and {@code rightBrackets} is paired or not 
	 * 
	 * @param leftBracket left bracket
	 * @param rightBracket right bracket
	 * @return {@code true } if {@code leftBracket} and {@code rightBracket} is 
	 * paired, otherwise {@code true}
	 */
	public static boolean isPaired(char leftBracket, char rightBracket)
	{
		char[][] pairedBrackets = {
				{'(', ')'},
				{'[', ']'},
				{'{', '}'},
				{'<', '>'},
		};
		
		for(char[] pairedBracket : pairedBrackets)
		{
			if(pairedBracket[0] == leftBracket && pairedBracket[1] == rightBracket)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * check if {@code brackets} is balanced 
	 * 
	 * @param brackets the brackets
	 * @return {@code true} if {@code brackets} is balanced otherwise
	 * {@code flase}
	 */
	public static boolean isBalanced(String brackets)
	{
		if(brackets == null)
		{
			throw new IllegalArgumentException("brackets are null");
		}
		
		Stack<Character> bracketsStack = new Stack<>();
		for(char bracket : brackets.toCharArray())
		{
			switch(bracket)
			{
			case '(':
			case '[':
			case '{':
				bracketsStack.push(bracket);
				break;
			case ')':
			case ']':
			case '}':
				if(bracketsStack.isEmpty() || !isPaired(bracketsStack.pop(), bracket))
				{
					return false;
				}
				break;
				default:
					//otehr character is invalid 
					return false;
			}
		}
		return bracketsStack.isEmpty();
	}
	
	public static void main(String... args)
	{
		assert isBalanced("[()]{}{[()()]()}");
        assert !isBalanced("[(])");
	}

}
