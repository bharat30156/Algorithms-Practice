package SearchAlgorithms;

/**
 * 
 * @author Bharat
 *
 */

// The Common interface of the most searching Algorithm

public interface SearchAlgorithm {
	/**
	 * @param key is an Element which should be found 
	 * @param array is array where the element should be found 
	 * @param <T> Comparable type
	 * @return first found index of the element
	 */
	<T extends Comparable<T>> int find(T array[], T key);

}
