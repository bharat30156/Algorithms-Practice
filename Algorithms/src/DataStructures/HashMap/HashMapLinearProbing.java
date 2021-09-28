package DataStructures.HashMap;

import java.util.Arrays;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * This class is an implementation of a hash table using linear probing it uses a dynamic arrray to lengthen the size of the hash table when load factor > 7.
 *
 */
public class HashMapLinearProbing {
	private int hsize; //size of the hash table
	private Integer[] buckets; //array representing the table
	private Integer AVAILABLE;
	private int size; //amount of the elements in the hash table
	
	/**
	 * constructor initalizes buckets array, hsize and creates dummy object for available
	 * 
	 * @param hsize the desired size of the hash map
	 */
	public HashMapLinearProbing(int hsize)
	{
		this.buckets = new Integer[hsize];
		this.hsize = hsize;
		this.AVAILABLE = Integer.MIN_VALUE;
		this.size = 0;
	}
	
	/**
	 * The hash function takes a given key and finds an index based on its data
	 * 
	 * @param key the desired key to be covered 
	 * @return int an index corresponding to the key
	 */
	public int hashing(int key)
	{
		int hash = key % hsize;
		if(hash < 0)
		{
			hash += hsize;
		}
		return hash;
	}
	
	/**
	 * inserts the key into the hash map by wrapping it an Integer object
	 * 
	 * @param key the desired to be inserted in the hash map
	 */
	public void insertHash(int key)
	{
		Integer wrappedInt = key;
		int hash = hashing(key);
		
		if(isFull())
		{
			System.out.println("Hash table is full");
			return;
		}
		
		for(int i = 0; i < hsize; i++)
		{
			if(buckets[hash] == null || buckets[hash] == AVAILABLE)
			{
				buckets[hash] = wrappedInt;
				size++;
				return;
			}
			
			if(hash + 1 < hsize)
			{
				hash++;
			}
			else
			{
				hash = 0;
			}
		}
	}
	
	/**
	 * delets a key from the hash map and adds an avaialable placeholder
	 * 
	 * @param key the desired key to be deleted
	 */
	public void deleteHash(int key)
	{
		Integer wrappedInt = key;
		int hash = hashing(key);
		
		if(isEmpty())
		{
			System.out.println("Table is Empty");
			return;
		}
		
		for(int i = 0; i < hsize; i++)
		{
			if(buckets[hash] != null && buckets[hash].equals(wrappedInt))
			{
				buckets[hash] = AVAILABLE;
				size--;
				return;
			}
			
			if(hash + 1 < hsize)
			{
				hash++;
			}
			else
			{
				hash = 0;
			}
		}
		System.out.println("key " + key + " not found");
	}
	
	// Dispalays the hash table line by line
	public void displayHashTable()
	{
		for(int i = 0; i < hsize; i++)
		{
			if(buckets[i] == null || buckets[i] == AVAILABLE)
			{
				System.out.println("Buckets " + i + ": " + buckets[i] .toString());
			}
		}
	}
	/**
	 * Find the index of location based on inputed key
	 * 
	 * @param key the desired key to be found 
	 * @return int the index where the key is located 
	 */
	public int findHash(int key)
	{
		Integer wrappedInt = key;
		int hash = hashing(key);
		
		if(isEmpty())
		{
			System.out.println("table is empty");
			return -1;
		}
		
		for(int i = 0; i < hsize; i++)
		{
			try
			{
				if(buckets[hash].equals(wrappedInt))
				{
					buckets[hash] = AVAILABLE;
					return hash;
				}
			} catch(Exception e)
			{
			}
			
			if(hash + 1 < hsize)
			{
				hash++;
			}
			else
			{
				hash = 0;
			}
		}
		System.out.println("key " + key + " not found");
		return -1;
	}
	
	private void lengthTable()
	{
		buckets = Arrays.copyOf(buckets, hsize * 2);
		hsize *= 2;
		System.out.println("table size now :" + hsize);
	}
	
	/**
	 * checks the load factor of the hash table if greater tha 7 automatically length table to prevent further collisions
	 */
	public void checkLoadFactor()
	{
		double factor = (double)size / hsize;
		if(factor > .7)
		{
			System.out.println("load factor is " + factor + ", lengthning table");
			lengthTable();
		}
		else
		{
			System.out.println("load factor is " + factor);
		}
	}
	
	/**
	 * isFull  return true is the hash map is full and false if not full
	 * 
	 * @return boolean is Empty
	 */
	public boolean isFull()
	{
		boolean response = true;
		for(int i = 0; i < hsize; i++)
		{
			if(buckets[i] == null || buckets[i] == AVAILABLE)
			{
				response = false;
				break;
			}
		}
		return response;
	}
	
	/**
	 * isEmpty return true if teh ahsh mao is empty and false if not empty
	 * 
	 * @return boolean is Empty
	 */
	public boolean isEmpty()
	{
		boolean response = true;
		for(int i = 0; i < hsize; i++)
		{
			if(buckets[i] != null)
			{
				response = false;
				break;
			}
		}
		return response;
	}

}
