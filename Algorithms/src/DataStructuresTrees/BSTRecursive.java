package DataStructuresTrees;

import DataStructuresTrees.BinaryTree.Node;

/**
 * 
 * <h1> Binary Search Tree (recursive) </h1>
 * 
 * An implementation of BST recursively. In recursive implementation the checks are down the 
 * tree First root is checked if not found then its children are checked Binary search tree is a binary tree which satisfies three properties:
 * left child is less than root node, right child is grater than root node, both left and right children must themselves be BST.
 * 
 *  
 *  <p> 
 *  I have made public functions as methods and to actually implement recursive approach
 *  I have used private methods 
 *  
 *  @author Bharat
 *
 */

public class BSTRecursive {
	
	/**
	 * Only data member is root of BST
	 */
	private Node root;
	
	/**
	 * constructor use to initialise node as null;
	 */
	BSTRecursive(){
		root = null;
	}
	
	
	public Node getRoot() {
		return root;
	}
	
	/**
	 * Recursive method to delete a data if present in BST
	 * 
	 * @param node the current node to search for data 
	 * @param data the value to be deleted 
	 * @return Node the updated value of root parameter after delete operation
	 */
	
	private Node delete(Node node, int data) {
		if(node == null) {
			System.out.println("no such data present in BST");
		} else if (node.data > data) {
			node.left = delete(node.left, data);
		} else if ( node.data < data) {
			node.right = delete(node.right, data);
		} else {
			if(node.right == null && node.left == null) {
				node = null;
			} else if (node.left == null) {
				Node temp = node.right;
				node.right = null;
				node = temp;
			} else if (node.right == null) {
				Node temp = node.left;
				node.left = null;
				node = temp;
			} else {
				Node temp = node.right;
				while(temp.left != null) {
					temp = temp.left;
				}
				node.data = temp.data;
				node.right = delete(node.right, temp.data);
			}
		}
		return node;
	}
	
	/**
	 * Recursive insertion of value of BST
	 * 
	 * @param node to check if the data can be inserted in current node or its subtree
	 * 
	 * @param data the value to be inserted 
	 * @return the modified value of the root parameter after insertion
	 */
	
	private Node insert (Node node, int data) {
		if(node == null) {
			node  = new Node(data);
		} else if (node.data > data) {
			node.left = insert(node.left, data);
		} else if (node.data < data) {
			node.right = insert(node.right, data);
		}
		return node;
	}
	
	
	/**
	 * Serach recursively if the given value is present in BST or not
	 * 
	 * @param node the current node to check 
	 * @param data the value to be checked 
	 * @return boolean if data is present or not 
	 */
	private boolean search(Node node, int data) {
		if(node == null) {
			return false;
		} else if (node.data == data) {
			return true;
		} else if (node.data > data) {
			return search (node.left,data);
		} else {
			return search(node.right, data);
		}
	}
	
	/**
	 *  add in BNST. if the value is not present it is inserted or else no 
	 *  change takes place
	 *  
	 * @param data the value to be inserted
	 */
	public void add (int data) {
		this.root = insert(this.root,data);
	}
	
	/**
	 *  If present in BST delete it else do nothing
	 *  
	 *  @param data the value to be removed 
	 */
	public void remove (int data) {
		this.root = delete(this.root, data);
	}
	
	/**
	 *  To check if given value is present in tree or not
	 *  @param data the data to be found for
	 */
	public boolean find(int data) {
		if(search(this.root, data)) {
			System.out.println(data + " is presnet in given BST." );
			return true;
		}
		System.out.println(data + " not found");
		return false;
	}
}
