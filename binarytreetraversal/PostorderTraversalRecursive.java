package binarytreetraversal;

public class PostorderTraversalRecursive {
	public static void print(Node root)
	{
		if(root==null)
			return;
		print(root.left);
		print(root.right);
		System.out.print(root.data+" ");
	}
}
