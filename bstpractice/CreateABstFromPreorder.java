package bstpractice;

import binarytreetraversal.TreeNode;

public class CreateABstFromPreorder {
	public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,new int[]{0},Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] preorder,int[] index,int max) {
        if(index[0]==preorder.length || preorder[index[0]]>=max)
        {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index[0]++]);
        node.left = bstFromPreorder(preorder,index,node.val);
        node.right = bstFromPreorder(preorder,index,max);
        return node;
    }
}
