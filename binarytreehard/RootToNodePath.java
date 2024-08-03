package binarytreehard;

import java.util.ArrayList;

import binarytreetraversal.CreateTree;
import binarytreetraversal.Node;

public class RootToNodePath {
	public static void rootToNode(Node root,Node target)
	{
		ArrayList<Integer> ans=new ArrayList<>();
		getPath(root,target,ans);
		System.out.println(ans);
	}

	//when reference is given
	private static boolean getPath(Node root, Node target, ArrayList<Integer> ans) {
		if(root==null)
			return false;
		ans.add(root.data);
		if(root==target)
		{
			return true;
		}
		if(getPath(root.left,target,ans) || getPath(root.right,target,ans))
			return true;
		ans.remove(ans.size()-1);
		return false;
	}
	
	//when value is given
	private static boolean getPath(Node root, int target, ArrayList<Integer> ans) {
		if(root==null)
			return false;
		ans.add(root.data);
		if(root.data==target)
		{
			return true;
		}
		if(getPath(root.left,target,ans) || getPath(root.right,target,ans))
			return true;
		ans.remove(ans.size()-1);
		return false;
	}
	
	public static void main(String[] args) {
		Node root = CreateTree.createTree();
		ArrayList<Integer> ans=new ArrayList<>();
		getPath(root,6,ans);
		System.out.println(ans);
	}
}
