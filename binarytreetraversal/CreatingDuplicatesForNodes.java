package binarytreetraversal;

public class CreatingDuplicatesForNodes {
	public static void createDuplicates(Node root)
	{
		if(root==null && root==null)
			return;
		createDuplicates(root.left);
		createDuplicates(root.right);
		Node duplicateNode = new Node(root.data);
		duplicateNode.left=root.left;
		root.left=duplicateNode;
	}
	public static void main(String[] args) {
		Node root=CreateTree.createTree();
		createDuplicates(root);
		CreateTree.print(root);
	}
}
