package bstbasics;

import binarytreetraversal.TreeNode;

public class SearchInABst {
	public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;
        while(current!=null && current.val!=val)
        {
            current = current.val > val ? current.left : current.right;
        }
        return current;
    }
}
