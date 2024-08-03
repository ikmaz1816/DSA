package binarytreemediumproblem;

import binarytreetraversal.TreeNode;

public class MaxPathSum {
	public int getSum(TreeNode root,int[] max)
    {
        if(root==null)
        {
            return 0;
        }
        // max is taken to be zero for this case [2,-1]
        int leftSum = Math.max(0,getSum(root.left,max));
        int rightSum = Math.max(0,getSum(root.right,max));
        max[0] = Math.max(max[0],root.val+leftSum+rightSum);
        return root.val + Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
        int[]  max = new int[1];
        max[0] = Integer.MIN_VALUE;
        getSum(root,max);
        return max[0];
    }
}
