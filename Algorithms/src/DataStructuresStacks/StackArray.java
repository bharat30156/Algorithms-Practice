package DataStructuresStacks;

/**
 * 
 * @author Bharat
 *
 *<p> A Stack is exactly what is sounds like. An element gets added to the top of the stack and only the element on the top may be removed.
 *this is an example of the an array implementation of a stack. So an element can only be added/removed from the end of the array. In theory stack have no fixed size,
 *but with ana array implementation it does.
 */

public class StackArray {
	
	/**
	 * Driover code 
	 */
	public static void main(String... args)
	{
		
	}
	
	/**
	 * default intial capacity 
	 */
	private static final int DEFAULT_CAPACITY = 10;
	
	/**
	 * the max size of the stack 
	 */
	private int maxSize;
	
	/**
	 * The array represetation of the stack
	 */
	private int[] stackArray;
	
	/**
	 * the top of the stack
	 */
	private int top;
	
	/**
	 * init stack with DEFAULT_CAPACITY
	 */
	public StackArray()
	{
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * constructor
	 * 
	 * @param size size of the stack
	 */
	public StackArray(int size)
	{
		maxSize = size;
		stackArray =  new int[maxSize];
		top = -1;
	}
	
	/**
	 * Adds an element to the top of the stack 
	 * 
	 * @param value of the element added 
	 */
	public void push(int value)
	{
		if(!isFull()) // checks for full stack
		{
			top++;
			stackArray[top] = value;
		}
		else
		{
			resize(maxSize * 2);
			push(value); // push after resizing
		}
	}
	
	/**
	 * removes the top element of the stack and returns the value you've removed 
	 * 
	 * 
	 * @return value popped off the stack 
	 */
	public int pop()
	{
		if(!isEmpty()) // checks for empty stack
		{
			return stackArray[top--];
		}
		
		if(top < maxSize / 4)
		{
			resize(maxSize / 2);
			return pop(); 
		}
		else
		{
			System.out.println("The stack is already empty");
			return -1;
		}
	}
	
	/**
	 * returns the element at the top of the stack 
	 * 
	 * @return element at the tpop of the stack 
	 */
	public int peek()
	{
		if(!isEmpty()) // checks for empty stack 
		{
			return stackArray[top];
		}
		else
		{
			System.out.println("The stack is empty, cann't peek");
			return -1;
		}
	}
	
	private void resize(int newSize)
	{
		int[] transferArray =  new int[newSize];
		
		for(int i = 0; i < stackArray.length; i++)
		{
			transferArray[i] = stackArray[i];
		}
		//There is refrenece change here
		stackArray = transferArray;
		maxSize = newSize;
	}
	
	/**
	 * returns ture if the stack is mepty 
	 * 
	 * @return true if the stack is empty 
	 */
	public boolean isEmpty()
	{
		return (top == -1);
	}

	/**
	 * return true if the stack is full 
	 * 
	 * @return true if the stack is full 
	 */
	public boolean isFull()
	{
		return(top + 1 == maxSize);
	}
	
	/**
	 * Deletes everthing in the stack 
	 * 
	 * <p> doesn't deletrs elemembnt in the array but if you can pusgh method after 
	 * calling it will overwrite previous values 
	 */
	public void makeEmpty() // doesn't delet elements in the array but if you call
	{
		top = -1; // push methid after calling makeEmpty it will overwrite previous values
	}
	
	/**
	 * returns size of the stack 
	 * 
	 * retuns size of the stack 
	 */
	public int size()
	{
		return top + 1;
	}
	
	

}
