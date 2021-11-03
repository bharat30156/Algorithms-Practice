package DataStructuresLists;

public class CountSinglyLinkedListRecursion extends SinglyLinkedList{
	public static void main(String...  args)
	{
		CountSinglyLinkedListRecursion list = new CountSinglyLinkedListRecursion();
		for(int i = 1; i <= 5; i++)
		{
			list.insert(i);
		}
		
		assert list.count() == 5;
		
	}
	
	/**
	 * calculates the count of the list manually using recursion
	 * 
	 * @param head head of the list 
	 * @return count of the list 
	 */
	private int countRecursion(Node head)
	{
		return head == null ? 0 : 1 + countRecursion(head.next);
	}
	
	/** return the counts of the list */
	public int count()
	{
		return countRecursion(getHead());
				
	}
}
