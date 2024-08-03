package binarytreetraversal;

public class PreorderTraversalRecursive {
	public static void print(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		print(root.left);
		print(root.right);
	}
}
