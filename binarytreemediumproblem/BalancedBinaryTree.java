package binarytreemediumproblem;

import binarytreetraversal.TreeNode;

public class BalancedBinaryTree {
	public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftHeight = maxDepth(root.left);
        if(leftHeight==-1)
            return -1;
        int rightHeight = maxDepth(root.right);
        if(rightHeight==-1)
            return -1;
        if(Math.abs(leftHeight-rightHeight)>1) return -1;
        return 1 + Math.max(leftHeight,rightHeight);
    }
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)!=-1;
    }
}
