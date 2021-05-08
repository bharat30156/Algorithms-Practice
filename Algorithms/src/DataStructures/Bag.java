package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Bharat
 *
 *Collection which does not allow removing element (only collect and iterate)
 *
 * @param <Element> the generic type of element in this bag
 */

public class Bag<Element> implements Iterable<Element> {
	private Node<Element> firstElement; // first Elemnt of the bag
	private int size;
	
	private static class Node<Element>
	{
		private Element content;
		private Node<Element> nextElement;
	}
	
	// create an empty bag
	public Bag()
	{
		firstElement = null;
		size = 0;
	}
	
	/**
	 * @return true if bag is empty, false otherwise 
	 */
	public boolean isEmpty()
	{
		return firstElement == null;
	}
	
	/**
	 * @return the number of elements
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * @param element - the elemnt to add
	 */
	public void add(Element element)
	{
		Node<Element> oldfirst = firstElement;
		firstElement = new Node<>();
		firstElement.content = element;
		firstElement.nextElement = oldfirst;
		size++;
	}
	
	/**
	 * checsks if teh bug contains a specific element
	 * 
	 * @param element which you want to look for 
	 * @return true if abg conatins elements, otherwise false 
	 */
	public boolean contains(Element element)
	{
		Iterator<Element> iterator = this.iterator();
		while(iterator.hasNext())
		{
			if(iterator.next().equals(element))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return An Iterator that iterates over the element in this bag in arbitrary order
	 */
	public Iterator<Element> iterator()
	{
		return new ListIterator<>(firstElement);
	}
	
	private class ListIterator<Element> implements Iterator<Element>
	{
		private Node<Element> currentElement;
		
		public ListIterator(Node<Element> firstElement)
		{
			currentElement = firstElement;
		}
		
		public boolean hasNext()
		{
			return currentElement != null;
		}
		
		/**
		 * remove is not allowed in bag
		 */
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
		public Element next()
		{
			if(!hasNext()) throw new NoSuchElementException();
			Element element = currentElement.content;
			currentElement  = currentElement.nextElement;
			return element;
		}
	}
	
	// main method for testing 
	
	public static void main(String [] args)
	{
		Bag<String> bag = new Bag<>();
		
		bag.add("1");
		bag.add("1");
		bag.add("2");
		
		System.out.println("Size of bag = " + bag.size());
		
		for(String s : bag)
		{
			System.out.println(s);
		}
		
		System.out.println(bag.contains(null));
		System.out.println(bag.contains("1"));
		System.out.println(bag.contains("3"));
	}
	
	
	
	
}
