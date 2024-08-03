package binarytreetraversal;

public class CountOfNodes {
	public static int countNodes(Node root)
	{
		if(root==null)
			return 0;
		return 1+ countNodes(root.left) + countNodes(root.right);
	}
	
	public static void main(String[] args) {
		Node root=CreateTree.createTree();
		System.out.println(countNodes(root));
	}
}
