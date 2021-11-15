package DataStructuresLists;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author Bharat
 *
 */
public class Mereg_K_SortedLinkedlist {
	/**
	 * 
	 * this functions merge k sorted LinkedList
	 * 
	 * @param a array of LinkedList
	 * @param N size of array
	 * @return node
	 */
	Node mergeList(Node[] a, int N)
	{
		//Min Heap
		PriorityQueue<Node> min = new PriorityQueue<>(Comparator.comparingInt(x -> x.data));
		
		// adding head of all linkedlist inmin Heap
		min.addAll(Arrays.asList(a).subList(0, N));
		
		//Make new head among smallest heads in k linkedList
		Node head = min.poll();
		min.add(head.next);
		Node curr = head;
		
		//merging LinkedList
		while(!min.isEmpty())
		{
			Node temp = min.poll();
			curr.next = temp;
			curr = temp;
			
			//Add Node in min heap only if temp.next is not null
			if(temp.next != null)
			{
				min.add(temp.next);
			}
		}
		return head;
	}
	
	private class Node
	{
		private int data;
		private Node next;
		
		public Node(int d)
		{
			this.data = d;
			next = null;
		}
	}
}
