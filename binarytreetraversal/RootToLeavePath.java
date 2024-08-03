package binarytreetraversal;

import java.util.ArrayList;

public class RootToLeavePath {
	public static void pathOfNodes(Node root,ArrayList<Integer> path)
	{
		if(root.left==null && root.right==null)
		{
			path.add(root.data);
			System.out.println(path);
			path.remove(path.size()-1);
			return;
		}
		path.add(root.data);
		pathOfNodes(root.left,path);
		pathOfNodes(root.right,path);
		path.remove(path.size()-1);
	}
	public static void main(String[] args) {
		Node root=CreateTree.createTree();
		pathOfNodes(root,new ArrayList<>());
	}
}
