package bstpractice;

import binarytreetraversal.TreeNode;

public class CheckIfABtIsBst {
	public boolean isValidBST(TreeNode root) {
        return isValidBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBst(TreeNode root,long min,long max)
    {
        //for this to be a valid bst the root value has to be greater than min and less than max
        if(root==null)
            return true;
        if(min>=root.val || max<=root.val)
            return false;
        return isValidBst(root.left,min,root.val) && isValidBst(root.right,root.val,max);
    }
}
