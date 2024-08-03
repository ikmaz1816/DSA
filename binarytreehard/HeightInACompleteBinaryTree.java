package binarytreehard;

import binarytreetraversal.TreeNode;

public class HeightInACompleteBinaryTree {
	public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int left = checkLeftHeight(root.left);
        int right = checkRightHeight(root.right);
        if(left==right)
            return (2<<left)-1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int checkLeftHeight(TreeNode root)
    {
        int count=0;
        TreeNode current=root;
        while(current!=null)
        {
            count++;
            current=current.left;
        }
        return count;
    }
    public int checkRightHeight(TreeNode root)
    {
        int count=0;
        TreeNode current=root;
        while(current!=null)
        {
            current=current.right;
        }
        return count;
    }
}
