package bstpractice;

import binarytreetraversal.TreeNode;

public class LcaInBst {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return root;
        TreeNode current = root;
        while(current!=null)
        {
            if(current.val > p.val && current.val>q.val)
            {
                current = current.left;
            }
            else if(current.val < p.val && current.val < q.val)
            {
                current = current.right;
            }
            else
                return current;
        }
        return current;
    }
}
