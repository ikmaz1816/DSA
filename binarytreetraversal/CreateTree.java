package binarytreetraversal;

import java.util.Scanner;

public class CreateTree {
	static Scanner sc=new Scanner(System.in);;
	public static Node createTree()
	{
		int data = sc.nextInt();
		if(data==-1)
			return null;
		Node node=new Node(data);
		node.left = createTree();
		node.right = createTree();
		return node;
	}
	
	public static void print(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		print(root.left);
		print(root.right);
	}
	
	/*
	 	Binary Tree Traversals 
	 	Preorder Root Left Right
	 	Inorder Left Root Right
	 	PostOrder Left Right Root
	*/
	
	public static void main(String[] args) {
		Node root=createTree();
		print(root);
	}
}
