package bstpractice;

import binarytreetraversal.TreeNode;

public class DeleteANodeInBst {
	public TreeNode deleteNode(TreeNode node)
    {
        if(node.left==null)
            return node.right;
        if(node.right==null)
            return node.left;
        TreeNode temproot=node.left;
        TreeNode root = temproot;
        //let us traverse till we reach null in the right part of bst
        while(temproot.right!=null)
        {
            temproot=temproot.right;
        }
        temproot.right=node.right;
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        TreeNode current = root;
        if(current.val==key)
            return deleteNode(root);
        while(current!=null)
        {
            if(current.left!=null && current.left.val==key)
            {
                current.left=deleteNode(current.left);
                break;
            }
            else if(current.right!=null && current.right.val==key)
            {
                current.right=deleteNode(current.right);
                break;
            }
            else if(current.val>key)
                current=current.left;
            else
                current=current.right;
        }
        return root;
    }
}
