package DataStructuresTrees;

import DataStructuresTrees.BinaryTree.Node;

/**
 * 
 * This code is recursively validates whether given Binary tree (BST) is balanced or not.
 * Trees with only distinct values are supposed
 * 
 * Key points:
 * 1. According to the definition of BST, each node in a tree must be range [min, max], where
 * 'min' and 'max' values represent the child nodes (left, right).
 * 2. The smallest possible node value is Integer.MIN_VALUE, the biggest  - Integer.MAX_VALUE/
 *
 */
public class CheckBinaryTreeIsValidBST {
	public static boolean isBST(BinaryTree.Node root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);	
	}

	private static boolean isBSTUtil(BinaryTree.Node node, int min, int max) {
		
		// empty tree is BST
		if(node == null) {
			return true;
		}
		
		if(node.data < min || node.data > max) {
			return false;
		}
		
		
		
		return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
	}
}
