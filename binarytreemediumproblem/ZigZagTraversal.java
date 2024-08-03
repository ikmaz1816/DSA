package binarytreemediumproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binarytreetraversal.TreeNode;

public class ZigZagTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root==null)
            return ls;
        boolean flag=true;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            ArrayList<Integer> ans=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.poll();
                ans.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            if(!flag)
                Collections.reverse(ans);
            flag=!flag;
            ls.add(new ArrayList<>(ans));
        }
        return ls;
    }
}
