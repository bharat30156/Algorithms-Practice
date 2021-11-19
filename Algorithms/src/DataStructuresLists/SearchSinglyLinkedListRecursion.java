package DataStructuresLists;
/**
 * 
 * @author Bharat
 *
 */
public class SearchSinglyLinkedListRecursion extends SinglyLinkedList {
	public static void main(String... args)
	{
		SearchSinglyLinkedListRecursion list = new SearchSinglyLinkedListRecursion();
		for(int i = 1; i <= 10; i++)
		{
			assert list.search(i);
		}
		assert !list.search(-1) && !list.search(100);
	}
	
	/**
	 * Test if the value key is present in the list using recursion
	 * 
	 * @param node the head node 
	 * @param key the to value to be searched 
	 * @param {{@code true} if key is present in the list, otherwise 
	 * {@code false}
	 */
	private boolean searchedRecursion(Node node, int key)
	{
		return node != null && (node.value == key || searchedRecursion(node.next, key));
	}
	
	public boolean search(int key)
	{
		return searchedRecursion(getHead(), key);
	}

}
