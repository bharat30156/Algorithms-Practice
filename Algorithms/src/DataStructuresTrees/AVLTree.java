package DataStructuresTrees;

public class AVLTree {
	
	private Node root;
	private class Node
	{
		private int key;
		private int balance;
		private int height;
		private Node left, right, parent;
		
		Node(int k, Node p)
		{
			key = k;
			parent = p;
		}
	}
	
	public boolean insert(int key)
	{
		if(root == null)
		{
			root = new Node(key,Null);
		}
		else
		{
			Node n = root;
			Node Parent;
			while(true)
			{
				if(n.key == key)
				{
					return false;
				}
				Parent = n;
				
				boolean goLeft = n.key > key;
				n = goLeft ? n.left : n.right;
				
				if(n == null)
				{
					if(goLeft)
					{
						parent.left = new Node(key, parent);
					}
					else
					{
						parent.right = new Node(key, parent);
					}
					rebalance(parent);
					break;
				}
			}
		}
		return true;
	}
	
	
	private void delete(Node node)
	{
		if(node.left == null && node.right == null)
		{
			if(node.parent == null)
			{
				root = null;
			}
			else
			{
				Node parent = node.parent;
				if(parent.left == node)
				{
					parent.left = null;
				}
				else
				{
					parent.right = null;
				}
				rebalance(parent);
			}
			return;
		}
		if(node.left != null)
		{
			Node child = node.left;
			while(child.right != null)
			{
				child = child.right;
			}
			node.key = child.key;
			delete(child);
		}
		else
		{
			Node child = node.right;
			while(child.left != null)
			{
				child = child.left;
			}
			
			node.key = child.key;
			delete(child);
		}
	}
	
	public void delete(int delKey)
	{
		if(root == null)
		{
			return;
		}
		Node node = root;
		Node child = root;
		
		while(child != null)
		{
			node = child;
			child = delKey>= node.key ? node.right : node.left;
			if(delKey == node.key)
			{
				delete(node);
				return;
			}
		}
	}
	
	private void rebalance(Node n)
	{
		setBalance(n);
		
		if(n.balance == -2)
		{
			if(height(n.left) >= height(n.left.right))
			{
				n = rotateRight(n);
			}
			else
			{
				n = rotateLeftThenRight(n);
			}
		}
		else if(n.balance == 2)
		{
			if(height(n.right.right) >= height(n.right.left))
			{
				n = rotateLeft(n);
			}
			else
			{
				n = rotateRightTenLeft(n);
			}
		}
		
		if(n.parent != null)
		{
			rebalance(n.balance);
		}
		else
		{
			root = n;
		}
	}
	
	private Node rotateLeft(Node a)
	{
		Node b = a.right;
		b.parent = a.parent;
		
		a.right = b.left;
		
		if(a.right != null)
		{
			a.right.parent = a;
		}
		
		b.left = a;
		a.parent = b;
		
		if(b.parent != null)
		{
			if(b.parent.right == a)
			{
				b.parent.right = b;
			}
			else
			{
				b.parent.left = b;
			}
		}
		setBalance(a,b);
		
		return b;
	}
}
