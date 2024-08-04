package bstpractice;

import binarytreetraversal.TreeNode;

public class InsertIntoBst {
	public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root;
        if(current==null)
        {
            return new TreeNode(val);
        }
        while(current!=null)
        {
            if(current.val<val)
            {
                if(current.right!=null)
                    current=current.right;
                else
                {
                    current.right=new TreeNode(val);
                    break;
                }
            }
            else
            {
                if(current.left!=null)
                    current=current.left;
                else
                {
                    current.left=new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
