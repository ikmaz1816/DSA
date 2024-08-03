package binarytreetraversal;

public class RootToLeaveSum {
	public static void main(String[] args) {
		Node root=CreateTree.createTree();
		sumOfNodes(root,0);
	}

	private static void sumOfNodes(Node root, int sum) {
		if(root.right==null && root.left==null)
		{
			System.out.println(sum+root.data);
			return;
		}
		sumOfNodes(root.left,sum+root.data);
		sumOfNodes(root.right,sum+root.data);
	}
}
