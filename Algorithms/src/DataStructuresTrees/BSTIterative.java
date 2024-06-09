package DataStructuresTrees;

import DataStructuresTrees.BinaryTree.Node;

public class BSTIterative {
	
	/**
	 * 
	 * <h1> Binary search Tree (iterative) </h1>
	 * 
	 * <p>
	 * An implementation of BST iteratively. Binary search tree is a binary tree which 
	 * satisfies three properties: left Child is less than root node, right child is greater
	 * that root node, both left and right child must themseleves be a BST
	 * 
	 *  @author Bharat
	 */
	
	/**
	 * 
	 * Reference for the node BST
	 */
	private Node root;
	
	/**
	 * 
	 * Default constructor Initializes the root of BST with null
	 */
	BSTIterative(){
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	
	/**
	 * 
	 * A method to insert a  new value in BST. if the given value is already 
	 * present in BST the insertion is ignored
	 * 
	 * @param data the value to be inserted 
	 */
	public void add(int data) {
		Node parent = null;
		Node temp = this.root;
		int rightOrLeft= -1;
		
		/**
		 * Find the proper place this can be placed in according to rules of BST
		 */
		
		while(temp != null) {
			if(temp.data > data) {
				parent = temp;
				temp = parent.left;
				rightOrLeft = 0;
			} else if (temp.data < data) {
				parent = temp;
				temp = parent.right;
				rightOrLeft = 1;
			} else {
				System.out.println(data + " is already present in BST.");
				return; // if data already present we ignore insertion
			}
		}
		
		/**
		 * Creates a newNode with the value passed
		 * Since this data doesn't already exists
		 */
		
		Node newNode = new Node (data);
		/**
		 * If the parent node is null
		 * then the insertion is to be done in
		 * root itself
		 */
		if (parent == null) {
            this.root = newNode;
        } else {
            /* Check if insertion is to be made in
             * left or right subtree.
             */
            if (rightOrLeft == 0) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }
	
	/**
	 * 
	 * A method to delete the node in BST. if node us present it will be deleted
	 * 
	 * @param data the value that needs to be deleted
	 */
	public void remove(int data) {
		Node parent = null;
		Node temp = this.root;
		int rightOrLeft = -1;
		
		/**
		 * Find the parent of the node and node itself
		 * That is to be deleted
		 * parent variable store parent
		 * temp stores node itself
		 * rightOrLeft use to keep track weather child
		 * is Left or right subtree
		 */
		while(temp != null) {
			if(temp.data == data) {
				break;
			} else if ( temp.data > data) {
				parent = temp;
				temp = parent.left;
				rightOrLeft = 0;
			} else {
				parent = temp;
				temp = parent.right;
				rightOrLeft = 1;
			}
		}
		
		/**
		 * If temp is null than node with given value is not
		 * present is our tree
		 */
		if(temp != null) {
			Node replacement; // used to store the new values for replacing nodes
			if(temp.right == null && temp.left == null) { // leaf node case
				replacement = null;
			} else if ( temp.right == null) {
				// Node with right child
				replacement = temp.left;
				temp.left = null;
			} else if (temp.left == null) {
				// Node with only left child 
				replacement = temp.right;
				temp.right = null;
			} else {
				/**
				 * If both left and right child are present
				 * we replace this nodes data with 
				 * leftmost node's data in its right subtree
				 * and then delete that node
				 */
				
				if(temp.right.left == null) {
					temp.data = temp.right.data;
					replacement = temp;
					temp.right = temp.right.right;
				} else {
					Node parent2 = temp.right;
					Node child = temp.right.left;
					while(child.left != null) {
						parent2 = child;
						child = parent2.left;
					}
					temp.data = child.data;
					parent2.left = child.right;
					replacement = temp;
				}
			}
			
			/**
			 * change refrences of parent after 
			 * deleting the child
			 */
			
			if(parent == null) {
				this.root = replacement;
			} else {
				if(rightOrLeft == 0) {
					parent.left = replacement;
				} else {
					parent.right = replacement;
				}
			}
		}
	}
	
	/**
	 * 
	 * A method to check if given data exists in out Binary search tree
	 * 
	 * @param data the value that needs to be searched for
	 * @return boolean representing if the value was find
	 */
	
	public boolean find(int data) {
		Node temp = this.root;
		
		/**
		 * Check if node exists
		 */
		while(temp != null) {
			if(temp.data > data) {
				temp = temp.left;
			} else if (temp.data < data) {
				temp = temp.right;
			} else {
				/**
				 * if found return true
				 */
				System.out.println(data + " is present in the BST.");
				return true;
			}
		}
		System.out.println(data + " not found.");
		return false;
	}
}
