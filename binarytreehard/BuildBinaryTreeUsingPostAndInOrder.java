package binarytreehard;

import java.util.HashMap;

import binarytreetraversal.TreeNode;

public class BuildBinaryTreeUsingPostAndInOrder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inMap=new HashMap<>();
       for(int i=0;i<inorder.length;i++)
       {
           inMap.put(inorder[i],i);
       }
       return build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inMap);
   }

   public TreeNode build(int[] postorder,int poststart,int postend,int[] inorder,int instart,int inend,HashMap<Integer,Integer> inMap)
   {
       if(poststart>postend || instart>inend)
           return null;
       TreeNode node = new TreeNode(postorder[postend]);
       int rootElementInOrder= inMap.get(node.val);
       int numsLeft = rootElementInOrder-instart;
       node.left  = build(postorder,poststart,poststart+numsLeft-1,inorder,instart,rootElementInOrder-1,inMap);
       node.right  = build(postorder,poststart+numsLeft,postend-1,inorder,rootElementInOrder+1,inend,inMap);
       return node;
   }
}
