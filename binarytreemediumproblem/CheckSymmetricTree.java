package binarytreemediumproblem;

import binarytreetraversal.TreeNode;

public class CheckSymmetricTree {
	public boolean checkSymmetric(TreeNode p, TreeNode q) {
        if(p==null || q==null)
            return p==q;
        return p.val == q.val && checkSymmetric(p.left,q.right) && checkSymmetric(p.right,q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return true;
        return checkSymmetric(root.left,root.right);
    }
}
