package DataStructuresTrees;

/**
 * 
 * @author Bharat
 * 
 * AVL is algo that balance itself while adding new rules to trees 
 * by rotating branches of binary tree and make itself Binary Search tree 
 * there are four cases which has to be tackle 
 * 
 * Roatating- left right, left left, right right, right left
 *
 */

public class AVLSimple {
	private class Node
	{
		int data;
		int height;
		Node left;
		Node right;
		Node(int data)
		{
			this.data = data;
			this.height = 1;
		}
	}
	
	private Node root;
	
	public void insert(int data)
	{
		this.root = insert(this.root,data);
	}
	
	private Node insert(Node node, int item)
	{
		if(node == null)
		{
			Node add = new Node(item);
			return add;
		}
		if(node.data>item)
		{
			node.left = insert(node.left,item);
		}
		if(node.data<item)
		{
			node.right=insert(node.right,item);
		}
		node.height=Math.max(height(node.left), height(node.right)) + 1;
		int bf = bf(node);
		
		//LL case
		if(bf>1&&item<node.left.data)
			return rightRotate(node);
		
		//RR case
		if(bf<-1&&item<node.left.data)
			return leftRoatate(node);
		
		//RL case
		if(bf<-1&&item<node.right.data)
		{
			node.right=rightRotate(node.right);
			return leftRoatate(node);
		}
		
		//LR case
		if(bf>1&&item>node.left.data)
		{
			node.left=leftRoatate(node.left);
			return rightRotate(node);
		}
		
		return node;
	}
	
	public void display()
	{
		this.display(this.root);
		System.out.println(this.root.height);
	}
	
	public void display(Node node)
	{
		String str="";
		if(node.left!=null)
			str+=node.left.data+"=>";
		else
			str+="END=>";
		str+=node.data+"";
		if(node.right!=null)
			str+="<="+node.right.data;
		else
			str+="<=END";
		System.out.println(str);
		if(node.left!=null)
			display(node.left);
		if(node.right!=null)
			display(node.right);
	}
	private int height(Node node)
	{
		if(node==null)
		{
			return 0;
		}
		return node.height;
	}
	
	private int bf(Node node)
	{
		if(node==null)
			return 0;
		return height(node.left)-height(node.right);
	}
	
	private Node rightRotate(Node c)
	{
		Node b=c.left;
		Node T3=b.right;
		
		b.right=c;
		c.left=T3;
		c.height=Math.max(height(c.left), height(c.right))+1;
		b.height=Math.max(height(b.left), height(b.right))+1;
		return b;
	}
	
	private Node leftRoatate(Node c)
	{
		Node b=c.right;
		Node T3=b.left;
		
		b.left=c;
		c.right=T3;
		c.height=Math.max(height(c.left), height(c.right))+1;
		b.height=Math.max(height(b.left), height(b.right))+1;
		return b;
	}

	
}
