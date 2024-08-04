package bstpractice;

import binarytreetraversal.TreeNode;

public class RecoverBst {
	private TreeNode prev,first,last,second;
	public void recover(TreeNode root) {
        if(root==null)
        {
            return;
        }
        recover(root.left);
        if(prev!=null && prev.val > root.val)
        {
            if(first==null)
            {
                first = prev;
                second = root;
            }
            else 
                last = root;
        }
        prev=root;
        recover(root.right);
    }

    public void recoverTree(TreeNode root) {
        if(root==null) 
            return;
        recover(root);
        if(first!=null && last!=null)
        {
            int temp = first.val;
            first.val=last.val;
            last.val=temp;
        }
        else if(first!=null && second!=null)
        {
            int temp = first.val;
            first.val=second.val;
            second.val=temp;
        }
    }
}
