package binarytreetraversal;

public class SumOfNodes {
	public static int sumOfNodes(Node root)
	{
		if(root==null)
			return 0;
		return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
	}
	
	public static void main(String[] args) {
		Node root=CreateTree.createTree();
		System.out.println(sumOfNodes(root));
	}
}
