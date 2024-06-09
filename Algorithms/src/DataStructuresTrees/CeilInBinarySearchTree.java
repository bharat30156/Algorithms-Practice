package DataStructuresTrees;

import DataStructuresTrees.BinaryTree.Node;

/**
 * 
 * Problem statement ceil value for any Number x in collection is a number y which is 
 * either equal to x or the least greater number than x 
 * 
 * Problem: Given a binary tree containing positive integer values. Find ceil value for a given key
 * O(log(n)) time. In case if it is not present return -1
 * 
 * EX.1. [30,20,40,10,25,35,10] represents level order traversal of binary search tree. 
 * Find ceil for 10 Answer 20
 * 
 * EX. 2 [30,20,40,10,25,35,50] represents level order traversal of binary search tree. Find  ceil for 22 
 * Answer : 25
 *
 */
/**
 * 
 * Solution 1 : brute force solution: do an in order traversal and save result 
 * into an array. Iterate over the array to get element equal to or greater than current key.
 * Time Complexity: O(n) space complexity: O(n) for auxiliary array to save representation of tree.
 * 
 * <p>
 * Solution 2: Brute force Solution: Do an inorder traversal and save result
 * into array. Since array is sorted do a binary search over the array to get an element equal to or greater 
 * than current key. Time complexity: O(n) for traversal of tree and O(log(n)) for binary search in array. Total = O(n) space
 * Complexity: O(n) for auxiliary  array to save inorder representation of tree.
 * 
 * <p>
 * Solution 3: Optimal we can do DFS search on given tree in following, fashion.
 * i) if root is null then return null because then ceil doesn't exixt 
 * ii) if the key is lesser than root value than ceil will be in right subtree so
 * call recursively on right subtree
 * iii) if key is greater than current root, then either 
 * a) the root is ceil
 * b) ceil is in left subtree: call for left subtree. if left subtree returns a non-null value then that will be ceil 
 * otherwise the root is ceil.
 *
 */


public class CeilInBinarySearchTree {
	
	public static Node getCeil(Node root, int key) {
		if(root == null) {
			return null;
		}
		
		// if root value is same as key than root is the ceiling 
		if(root.data == key) {
			return root;
		}
		
		// if root value is lesser than key then ceil must be in right subtree
		if(root.data < key) {
			return getCeil(root.right, key);
		}
		
		// if root value is greater than key then ceil can be in left subtree or if
		// it is not in left subtree then current node will be ceil 
		Node result = getCeil(root.left, key);
		
		// if result is null it means that there is no ceil in children subtree
		// and the root is the ceil otherwise the returned node is the ceil
		return result == null ? root : result;
		
	}

}
