package DataStructuresLists;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * This class implements a doublyLinkedList. this is done using the classes LinkedList and Link
 * 
 * <p> A linked is similar to an array, it holds value. However linkls in a linked list do not 
 * have indexex. with a linked list you do not need to predetermine it's size as it grows and 
 * shrinks as it is edited. This is an example of a double ended, doubly linked list. Each link 
 * refrences the next linkl and previous one.
 *
 */

public class DoublyLinkedList {
	
	/** head refers to the from of the list*/
	private Link head;
	/** Tail refers to the back of the list*/
	private Link tail;
	
	/** Size refers to the number of elements presents in the list*/
	private int size;
	
	/** Default constructor*/
	public DoublyLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * constructs a list contaning the elements of the array
	 * 
	 * @param array the array whose elements are to be placed into this list
	 * @throws nullPointerException if the specified collection is null
	 */
	public DoublyLinkedList(int[] array)
	{
		if(array == null) throw new NullPointerException();
		for(int i : array)
		{
			insertTail(i);
		}
		size = array.length;
	}
	
	/**
	 * Insert an element at the head
	 * 
	 * @param x element to be inserted
	 */
	public void insertHead(int x)
	{
		Link newLink = new Link(x); // create a new link with avalue attached to it 
		if (isEmpty()) // Set the first element added to be the tail
			tail = newLink;
		else head.previous = newLink; // newLink <-- currenthead(head)
		  	newLink.next = head; // newLink <--> currenthead(head)
		  	head = newLink; // newLink(head) <--> oldhead
		  	++size;		
	}
	
	/**
	 * Insert an element at the tail
	 * 
	 * @param x element to be inserted 
	 */
	public void insertTail(int x)
	{
		Link newLink = new Link(x);
		newLink.next = null; // currentTail(tail)   newlink ->
		if(isEmpty())
		{
			tail = newLink;
			head = tail;
		}
		else
		{
			tail.next = newLink; // currenttail(tail)  -> newLink ->
			newLink.previous = tail; // currenttail(tail) <--> newLink -->
			tail = newLink; // oldTail <--> newLink(tail) --->
		}
		size++;
	}
	
	/**
	 * Insert an element at the index
	 * 
	 * @param x element to be inserted 
	 * @param index Index(from start) ata which element x to be inserted
	 */
	public void insertElementByIndex(int x, int index)
	{
		if(index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
		if(index == 0)
		{
			insertHead(x);
		}
		else
		{
			if(index == size)
			{
				insertTail(x);
			}
			else
			{
				Link newLink = new Link(x);
				Link previousLink = head; //
				for(int i = 1; i < index; i++)
				{
					//Loop to reach the index
					previousLink = previousLink.next;
				}
				//previousLink is the Link at the index -1 from start
				previousLink.next.previous = newLink;
				newLink.next = previousLink.next;
				newLink.previous = previousLink;
				previousLink.next = newLink;
			}
		}
		size++;
	}
	
	/**
	 * Delete the element at the head
	 * 
	 * @return the new head
	 */
	public Link deleteHead()
	{
		Link temp = head;
		head = head.next; // oldHead <--> 2ndElement(head)
		
		if(head == null)
		{
			tail = null;
		}
		else
		{
			head.previous = null; // oldHead --> 2nd(head) nothing pointing at old head so will
		}
		size--;
		return temp;
	}
	
	/**
	 * Delete the element at the tail
	 * 
	 * @return the new tail
	 */
	public Link deleteTail()
	{
		Link temp = tail;
		tail = tail.previous; // 
		
		if(tail == null)
		{
			head = null;
		}
		else
		{
			tail.next = null;
		}
		size--;
		return temp;
	}
	
	/**
	 * Delete the element from somwhere in the list
	 * 
	 * @param x element to be deleted 
	 * @return Link deleted
	 */
	public void delete(int x)
	{
		Link current = head;
		
		while(current.value != x)
		{
			//Find the position to delete
			if(current != tail)
			{
				current = current.next;
			}
			else
			{
				// if we reach the tail and the element is still not found
				throw new RuntimeException("The element to be deleted does not exists");
			}
		}
		if(current == head) deleteHead();
		else if (current == tail) deleteTail();
		else 
		{
			current.previous.next = current.next; // 1 <-->
			current.next.previous = current.previous;
		}
		size--;
	}
	
	/**
	 * Inserts element and reorders
	 * 
	 * @param x elements to added
	 */
	public void insertOrdered(int x)
	{
		Link newLink = new Link(x);
		Link current = head;
		
		while(current != null && x > current.value) // find the position to insert
		current = current.next;
		
		if(current == head) insertHead(x);
		else if (current == null) insertTail(x);
		else
		{
			//Before: 1 <--> 2(current) <--> 3
			newLink.previous = current.previous;
			current.previous.next = newLink;
			newLink.next = current;
			current.previous = newLink;
		}
		size++;
	}
	
	/**
	 * Deletes the passed node from the current Node 
	 * 
	 * 
	 * @param z element to be deleted 
	 */
	public void deleteNode(Link z)
	{
		if(z.next == null)
		{
			deleteTail();
		}
		else if (z == head)
		{
			deleteHead();
		}
		else
		{
			//before <-- 1 <--> 2 (z) <--> 3 -->
			z.previous.next = z.next;
			z.next.previous = z.previous; // 1 <--> 3
		}
		size--;
	}
	
	public static void removeDupDuplicates(DoublyLinkedList l)
	{
		Link linkOne = l.head;
		while(linkOne.next != null)
		{
			//list is present
			Link linkTwo = linkOne.next; // second link for comparision
			while(linkTwo.next != null)
			{
				if(linkOne.value == linkTwo.value)
				l.delete(linkTwo.value);
				linkTwo = linkTwo.next;
			}
			linkOne = linkOne.next; // go to link to iterate the whole list again 
		}
	}
	
	/**
	 * Reverse the list in place 
	 * 
	 * 
	 * @param l the DoublyLinkedList to reverse
	 */
	
	public void reverse() 
	{
		// keep refrences to the head and the tail
		Link thisHead = this.head;
		Link thisTail = this.tail;
		
		//flip the head an dtail refrences 
		this.head = thisTail;
		this.tail = thisHead;
		
		//while the link we 're visiting is not null, flip the 
		//next and previous links 
		Link nextLink = thisHead;
		while(nextLink != null)
		{
			Link nextLinkNext = nextLink.next;
			Link nextLinkPrevious = nextLink.previous;
			nextLink.next = nextLinkPrevious;
			nextLink.previous = nextLinkNext;
			
			//Now, we want to go to the next link
			nextLink = nextLinkNext;
		}
	}
	
	public void clearList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * returns true if the list is empty 
	 * 
	 * @return true if the list is empty 
	 */
	public boolean isEmpty()
	{
		return (head == null);
	}
	
	/**
	 * prints content of the list 
	 */
	public void display()
	{
		Link current = head;
		while(current != null)
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	
	/**
	 * Prints the content of the list in revrse order 
	 */
	public void displayBackwards()
	{
		Link current = tail;
		while(current != null)
		{
			current.displayLink();
			current = current.previous;
		}
		System.out.println();
	}
}
/**
 * This class is used to implement the nodes of the linked List
 */
class Link
{
	/** value of node */
	public int value;
	/** This points to the link in front of the new link*/
	public Link next;
	/** This points to the link behind the new link*/
	public Link previous;
	
	/**
	 * Constructor
	 * 
	 * @param value Value of node
	 */
	public Link(int value)
	{
		this.value = value;
	}
	
	/** Displays the node*/
	public void displayLink()
	{
		System.out.println(value + " ");
	}
	
	/**
	 * main method
	 * @param args command line arguments 
	 */
	
	public static void main(String... args)
	{
		DoublyLinkedList myList = new DoublyLinkedList();
	    myList.insertHead(13);
	    myList.insertHead(7);
	    myList.insertHead(10);
	    myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->
	    myList.displayBackwards();

	    myList.insertTail(11);
	    myList.display(); // <-- 10(head) <--> 7 <--> 13 <--> 11(tail) -->
	    myList.displayBackwards();

	    myList.deleteTail();
	    myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->
	    myList.displayBackwards();

	    myList.delete(7);
	    myList.display(); // <-- 10(head) <--> 13(tail) -->
	    myList.displayBackwards();

	    myList.insertOrdered(23);
	    myList.insertOrdered(67);
	    myList.insertOrdered(3);
	    myList.display(); // <-- 3(head) <--> 10 <--> 13 <--> 23 <--> 67(tail) -->
	    myList.insertElementByIndex(5, 1);
	    myList.display(); // <-- 3(head) <--> 5 <--> 10 <--> 13 <--> 23 <--> 67(tail) -->
	    myList.displayBackwards();
	    myList.reverse(); // <-- 67(head) <--> 23 <--> 13 <--> 10 <--> 5 <--> 3(tail) -->
	    myList.display();
	    
	    myList.clearList();
	    myList.display();
	    myList.displayBackwards();
	    myList.insertHead(20);
	    myList.display();
	    myList.displayBackwards();
	}
}
