package binarytreehard;

import java.util.LinkedList;
import java.util.Queue;

import binarytreetraversal.TreeNode;

class Width
{
   TreeNode node;
   int value;
   public Width(TreeNode node,int value)
   {
       this.node=node;
       this.value=value;
   }
}
public class MaximumWidthInABinaryTree {
	public int widthOfBinaryTree(TreeNode root) {
        Queue<Width> q=new LinkedList<>();
        q.add(new Width(root,0));
        int maxWidth=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            int last=0,first=0;
            int min = q.peek().value;
            for(int i=0;i<size;i++)
            {
                Width width = q.poll();
                TreeNode node = width.node;
                int value = width.value-min;
                if(i==0)
                    first=value;
                if(i==size-1)
                    last=value;
                if(node.left!=null)
                {
                    q.add(new Width(node.left,2*value+1));
                }
                if(node.right!=null)
                {
                    q.add(new Width(node.right,2*value+2));
                }
            }
            maxWidth = Math.max(maxWidth,last-first+1);
        }
        return maxWidth;
    }
}
