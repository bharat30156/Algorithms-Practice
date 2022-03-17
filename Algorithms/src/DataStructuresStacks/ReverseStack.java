package DataStructuresStacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author Bharat
 * 
 * reversal of stack using recursion 
 *
 */
public class ReverseStack {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements yopu wish to insert in the stack");
		int n =  sc.nextInt();
		int i;
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println("Enter the stack elelments");
		for(i = 0; i < n; i++)
		{
			stack.push(sc.nextInt());
		}
		sc.close();
		reverseStack(stack);
		System.out.println("The reversed stack is:");
		while(!stack.isEmpty())
		{
			System.out.println(stack.peek() + ",");
			stack.pop();
		}
	}
	
	public static void reverseStack(Stack<Integer> stack)
	{
		if(stack.isEmpty())
		{
			return;
		}
		
		//Store the topmost element
		int element =  stack.peek();
		//remove the topmost elememt
		stack.pop();
		
		//reverse the stack for the leftover elements
		reverseStack(stack);
		
		//Insert the topmost element to the bottom of the stack 
		insertAtBottom(stack, element);
	}
	
	private static void insertAtBottom(Stack<Integer> stack, int element)
	{
		if(stack.isEmpty())
		{
			// when stack is empty, insert the element so it will be present at the bottom of the stack 
			stack.push(element);
			return;
		}
		
		int ele = stack.peek();
		/**
		 * Keep pooping elements till stack becomes empty. push the elements once the topmost element has 
		 * moved to teh bottom of the stack 
		 */
		stack.pop();
		insertAtBottom(stack, element);
		
		stack.push(ele);
	}

}
