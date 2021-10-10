package DataStructuresHeaps;

/**
 * 
 * @author Bharat
 *
 */

/**
 * 
 * Class for heap elements,br.
 * 
 * <p> A heap element comnatains two atributes : a key which will be used to build the tree(int or
 * double either primitive type or object) any kind of IMMUTABLE object the user ses fit to carry any information he/she likesw. be awar5e that the use of mutable Object might jeopardize 
 * the integrity of this information 
 *
 */
public class HeapElement {
	private final double key;
	private final Object additionalInfo;
	
	//constructors 
	/**
	 * @param keuy : a number of primitive tye 'double'
	 * @param info : any kind of IMMUTABLE object. May be null since the purpose is only ot carry 
	 * additional information of uses for the users
	 */
	
	public HeapElement(double key, Object info)
	{
		this.key = key;
		this.additionalInfo = info;
	}
	
	/**
	 * @param key : a number of primitive type 'int'
	 * @param info : qany kind of IMMUTABLE object, May be null, Since the purpose is oly to carry
	 * addtional information of use for the users 
	 */
	
	public HeapElement(int key, Object info)
	{
		this.key = key;
		this.additionalInfo = info;
	}
	
	/**
	 * @param key : a number of Object type 'Integer'
	 * @param info : any kind of Immutable objecty. May benull, Since the purpose is only 
	 * additional of use for the users 
	 */
	
	public HeapElement(Integer key, Object info)
	{
		this.key = key;
		this.additionalInfo = info;
	}
	
	/**
	 * @param key :  a number of object type 'double'
	 * @param info : any kind of IMMUTABLE object. May be null, since the purpose is only to carry
	 * additional information of use for the users 
	 */
	
	public HeapElement(Double key, Object info)
	{
		this.key = key;
		this.additionalInfo = info;
	}
	
	/**
	 * @param key:  a number of primitive type 'int'
	 */
	public HeapElement(double key)
	{
		this.key = key;
		this.additionalInfo = null;
	}
	
	/**
	 * @param key : a number of object type double
	 */
	public HeapElement(int key)
	{
		this.key = key;
		this.additionalInfo = null;
	}
	
	/**
	 * @param key : a number of object type 'double'
	 */
	public HeapElement(Integer key)
	{
		this.key = key;
		this.additionalInfo = null;
	}
	
	/**
	 * @param key : a number of object type Double
	 */
	public HeapElement(Double key)
	{
		this.key = key;
		this.additionalInfo = null;
	}
	
	//Getters
	
	/**
	 * @return the object contaning the additional info provided by the user 
	 */
	public Object getInfo()
	{
		return additionalInfo;
	}
	
	/**
	 * @return the key value of element
	 */
	public double getKey()
	{
		return key;
	}
	
	/**
	 * @param otherHeapElement
	 * @return true if the keys on both elements are identical and the additional info objects are 
	 * identical.
	 */
	
	public boolean equals(Object o)
	{
		if(o != null)
		{
			if(!(o instanceof HeapElement)) return false;
			HeapElement otherHeapElement = (HeapElement) o;
			return (this.key == otherHeapElement.key)
					&& (this.additionalInfo.equals(otherHeapElement.additionalInfo));
		}
		return false;
	}
	
	public int hashCode()
	{
		int result = 0;
		result = 31 * result + (int) key;
		result = 31 * result + (additionalInfo != null ? additionalInfo.hashCode() : 0);
		return result;
	}
	
	

}
