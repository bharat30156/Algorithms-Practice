package DataStructuresTrees;

import java.util.Queue;
import java.util.LinkedList;

/**
 * 
 * @author Bharat
 * 
 * This entire class is used to build a binary tree data structure. There is the 
 * Node class and the tree class, both explained below
 * 
 * 
 * A binary Tree is a data structure in which an element has two
 * Successor (children). the left child is usually smaller than the parent, and
 * the right child is usually bigger.
 *
 */

public class BinaryTree {
	
	/**
	 * This class implements the nodes that will go on the Binary Tree. they consist of the data 
	 * in them, the node to the left, the node to the right, and the parent from which they came form
	 */
	
	static class Node{
		
		/**
		 * data for the node
		 */
		public int data;
		/**
		 * The node to the left of this one
		 */
		public Node left;
		/**
		 * The node to the right of this one
		 */
		public Node right;
		/**
		 * The parent of this node
		 */
		public Node parent;
		
		/**
		 * Constructor of Node 
		 * 
		 * @param value value to put in the Node
		 */
		public Node(int value) {
			data = value;
			left = null;
			right = null;
			parent = null;
			
		}
	}
	
	/**
	 * The root of the Binary Tree
	 */
	private Node root;
	
	/**
	 * constructor
	 */
	public BinaryTree() {
		root = null;
	}
	
	/**
	 * Parameterised constructor
	 */
	public BinaryTree(Node root) {
		this.root = root;
	}
	
	/**
	 * Method to find a Node with a certain value
	 * 
	 * @param key value being looked for 
	 * @return The node if it finds it, otherwise returns the parent
	 */
	
	public Node find(int key) {
		Node current = root;
		while(current != null) {
			if(key < current.data) {
				if(current.left == null) {
					return current; // The key isn't exists, returns the parent
				}
				current = current.left;
			}
			else if (key > current.data) {
				if(current.right == null) {
					return current;
				}
				current = current.left;
			} else if (key > current.data) {
				if(current.right == null) {
					return current;
				}
				current = current.right;
			} else {
				return current;
			}
		}
		return null;
	}
	
	/**
	 * Inserts certain value into the Binary Tree
	 * @param value value to be inserted 
	 */
	
	public void put(int value) {
		Node newNode = new Node(value);
		if(root == null) {
			root = newNode;
		} else {
			// this will return the soon to be parent of the value you're inserting 
			Node parent = find(value);
			
			// This if/else assigns the new node to be either the left or right child of the parent
			if(value< parent.data) {
				parent.left = newNode;
				parent.left.parent = parent;
			}
		}
	}
	
	/**
	 * Deletes a given value from the Binary Tree
	 * 
	 * @param value Value to be deleted
	 * @return if the Value was deleted 
	 */
	public boolean remove(int value) {
		// temp is the node to be deleted
		Node temp = find(value);
		
		// if the value doesn't exists
		if(temp.data != value) {
			return false;
		}
		
		// No children
		if(temp.right == null && temp.left == null) {
			if(temp == root) {
				root = null;
			}
			else if (temp.parent.data < temp.data) {
				temp.parent.right = null;
			}
			else {
				temp.parent.left = null;
			}
			return true;
		} // two children
		else if (temp.left != null && temp.right != null) {
			Node successor = findSuccessor(temp);
			
			// The left tree of temp is made the left tree of the successor
			successor.left = temp.left;
			successor.left.parent = successor;
			
			// if the succesor has the right child, the childs grandparent is it's new parent
			
		if(successor.parent != temp) {
			if(successor.right != null) {
				successor.right.parent = successor.parent;
				successor.parent.left = successor.right;
			} else {
				successor.parent.left = null;
			}
			successor.right = temp.right;
			successor.right.parent = successor;
		}
		
		if(temp == root) {
			successor.parent = null;
			root = successor;
		} // if you're not deleting the root 
		else {
			successor.parent = temp.parent;
			
			// this is/else assigns the new node to be either the left or right of the 
			//parent
			if(temp.parent.data < temp.data) {
				temp.parent.right = successor;
			}
			else 
			{
				temp.parent.left = successor;
			}
		}
		return true;
	
	} // one child 
	else 
	{
		// if it has a right child 
		if(temp.right != null) {
			if(temp == root) {
				root = temp.right;
				return true;
			}
			temp.right.parent = temp.parent;
			
			//Assigns temp to the left or right child 
			if(temp.data < temp.parent.data) {
				temp.parent.left = temp.right;
			}
			else 
			{
				temp.parent.right = temp.right;
			}
		} // if it has left child 
		else
		{
			if(temp == root) {
				root = temp.left;
				return true;
			}
			
			temp.left.parent = temp.parent;
			
			//assigns temp to the left or right side 
			if(temp.data < temp.parent.data) {
				temp.parent.left = temp.left;
			}
			else
			{
				temp.parent.right = temp.right;
			}
		}
		return true;
	}
}

	private Node findSuccessor(Node n) {
		// TODO Auto-generated method stub
		if(n.right == null) {
			return n;
		}
		
		Node current = n.right;
		Node parent = n.right;
		while(current != null) {
			parent = current;
			current = current.left;
		}
		return parent;
	}
	
	/**
	 * Return the root of the Binart tree
	 * 
	 * @return the root of the Binary tree
	 */
	
	public Node getRoot() {
		return root;
	}
	
	/**
	 * Prints leftChild - root - rightChild This is equivalent of a depth
	 * 
	 *  fist serach 
	 *  
	 *  @param localroot The local root of the binary tree
	 */
	public void inOrder(Node localRoot) {
		if(localRoot != null) {
			inOrder(localRoot.left);
			System.out.println(localRoot.data + " ");
			inOrder(localRoot.right);
		}
	}
	
	/**
	 * Prints root - leftchild - rightchild
	 * 
	 * @param localRoot The local root of the binary tree
	 */
	public void preOrder(Node localRoot) {
		if(localRoot != null) {
			System.out.println(localRoot.data + " ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	
	/**
	 * Prints rightchild - lefchild - root
	 * 
	 * @param localRoot The local root of the binary tree
	 */
	public void postOrder(Node localRoot) {
		if(localRoot != null) {
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.println(localRoot.data + " ");
			
		}
	}
	
	/**
	 * Prints the tree in a breadth first search order This is similar to pre-order traversal, but instead of being 
	 * implemented with a stack (or recursion), it is implemented with a queue
	 * 
	 *  @param localRoot The local root of the Binary Tree
	 */
	
	public void bfs(Node localRoot) {
		// create a queue for the order of the nodes 
		 Queue<Node> queue = new LinkedList<>();
		 
		 
		 // if the given root is null we don't add to the queue
		 // and won't do anything
		 
		 if(localRoot != null) {
			 queue.add(localRoot);
		 }
		 
		 //continue until the queue is empty
		 while(!queue.isEmpty()) {
			 //Get the next node on the queue to visit
			 localRoot = queue.remove();
			 
			 //prints the data from the node we are visiting 
			 System.out.println(localRoot.data + " ");
			 
			 //add the children to the queue if not null
			 
			 if(localRoot.right != null) {
				 queue.add(localRoot.right);
			 }
			 if(localRoot.left != null) {
				 queue.add(localRoot.left);
			 }
		 }
	}
}
