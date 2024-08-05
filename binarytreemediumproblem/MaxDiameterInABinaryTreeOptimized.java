package binarytreemediumproblem;

import binarytreetraversal.TreeNode;

public class MaxDiameterInABinaryTreeOptimized {
	public int diameter(TreeNode root,int[] max)
    {
        if(root==null)
            return 0;
        int left = diameter(root.left,max);
        int right = diameter(root.right,max);
        max[0]=Math.max(max[0],1+left+right);
        return 1 + Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max=new int[1];
        diameter(root,max);
        //as leetcode is not considering root to be a part
        // else we return max[0]-1
        return max[0]-1;
    }
}
