package DataStructuresLists;

import java.util.Scanner;

/**
 * 
 * @author Bharat
 *
 */
public class CreateAndDetectLoop {
	
	/**
	 * Prints the linked lists
	 * 
	 * @param head head nide of the linked list
	 */
	static void printList(Node head)
	{
		Node cur = head;
		
		while(cur != null)
		{
			System.out.println(cur.value + " ");
			cur = cur.next;
		}
	}
	
	/**
	 * creates a loop in the linked list 
	 * 
	 * @param head    head node of the linkedList 
	 * @param position of the nide where loop is to be created 
	 */
	
	static void createloop(Node head, int k)
	{
		if(head == null)
			return;
		Node temp = head;
		int count = 1;
		while(count < k)
		{
			temp = temp.next;
			count++;
		}
		Node connectedPoint = temp;
		
		
		while(temp.next != null)  // transverse remaning nodes
			temp = temp.next;
		
		temp.next = connectedPoint; // connect list node to k - th element
	}
	
	/**
	 * Detects the prensence of a loop in the linked lists 
	 * 
	 * @param head head the head node of linked lists 
	 * @return true if loop exists else false
	 */
	static boolean detectLoop(Node head)
	{
		Node sptr = head;
		Node fptr = head;
		
		while(fptr != null && fptr.next != null)
		{
			sptr = sptr.next;
			fptr = fptr.next.next;
			if(fptr == sptr)
				return true;
		}
		return false;
	}
	
	public static void main(String... args)
	{
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the numnber of elements to be inserted : ");
		int n = sc.nextInt();
		System.out.printf("Enter the %d elements : /n", n);
		while(n-- > 0)
			singlyLinkedList.insert(sc.nextInt());
		
		System.out.println("Given List : ");
		printList(singlyLinkedList.getHead());
		System.out.println();
		
		System.out.println("Enter the location to generate loop : ");
		int k = sc.nextInt();
		
		createloop(singlyLinkedList.getHead(), k);
		
		if(detectLoop(singlyLinkedList.getHead()))
			System.out.println("Loop found");
		else
			System.out.println("No Loop Found");
		
		sc.close();
	
		
	}
	

}
