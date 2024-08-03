package binarytreehard;

import binarytreetraversal.CreateTree;
import binarytreetraversal.LevelOrderTraversal;
import binarytreetraversal.Node;

public class ChildrenSumProperty {
	public static void main(String[] args) {
		Node root = CreateTree.createTree();
		childrenSumProperty(root);
		LevelOrderTraversal.print(root);
	}

	private static void childrenSumProperty(Node root) {
		if(root.left==null && root.right==null)
			return;
		int sum=0;
		if(root.left!=null)
			sum+=root.left.data;
		if(root.right!=null)
			sum+=root.right.data;
		if(sum>=root.data)
		{
			root.data=sum;
		}
		else
		{
			if(root.left!=null)
				root.left.data=root.data;
			if(root.right!=null)
				root.right.data=root.data;
		}
		childrenSumProperty(root.left);
		childrenSumProperty(root.right);
		sum=0;
		if(root.left!=null)
			sum+=root.left.data;
		if(root.right!=null)
			sum+=root.right.data;
		root.data=sum;
	}
	
	//check for children sum property
	public static int isSumProperty(Node root)
    {
        if(root==null || (root.left==null && root.right==null))
            return 1;
        int count=0;
        if(root.left!=null)
            count+=root.left.data;
        if(root.right!=null)
            count+=root.right.data;
        if(root.data!=count)
            return 0;
        int left = isSumProperty(root.left);
        if(left==0)
            return 0;
        int right=isSumProperty(root.right);
        if(right==0)
            return 0;
        return 1;
    }
}
