package binarytreehard;

import java.util.HashMap;

import binarytreetraversal.TreeNode;

public class CreateBinaryTreeFromPreAndInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inMap.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
    }

    public TreeNode build(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend,HashMap<Integer,Integer> inMap)
    {
        if(prestart>preend || instart>inend)
            return null;
        TreeNode node = new TreeNode(preorder[prestart]);
        int rootElementInOrder= inMap.get(node.val);
        int numsLeft = rootElementInOrder-instart;
        node.left  = build(preorder,prestart+1,prestart+numsLeft,inorder,instart,rootElementInOrder-1,inMap);
        node.right  = build(preorder,prestart+numsLeft+1,preend,inorder,rootElementInOrder+1,inend,inMap);
        return node;
    }
}
