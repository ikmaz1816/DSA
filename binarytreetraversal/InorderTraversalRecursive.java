package binarytreetraversal;

public class InorderTraversalRecursive {
	public static void print(Node root)
	{
		if(root==null)
			return;
		print(root.left);
		System.out.print(root.data+" ");
		print(root.right);
	}
}
