package binarytreehard;

import binarytreetraversal.TreeNode;

public class FlattenABinaryList {
	public void flatten(TreeNode root) {
        TreeNode current=root;
        while(current!=null)
        {
            if(current.left!=null)
            {
                TreeNode prev = current.left;
                while(prev.right!=null)
                {
                    prev=prev.right;
                }
                prev.right=current.right;
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }
    }
}
