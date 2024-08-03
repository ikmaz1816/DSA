package binarytreehard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binarytreetraversal.TreeNode;

public class AllNodesAtDistanceK {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ls = new ArrayList<>();
        if(root==null || target==null)
            return ls;
        HashMap<TreeNode,TreeNode> parents=new HashMap<>();
        markParent(root,parents);
        HashMap<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        visited.put(target,true);
        while(k>0 && !q.isEmpty())
        {
            k--;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.poll();
                if(node.left!=null && visited.get(node.left)==null)
                {
                    q.add(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null)
                {
                    q.add(node.right);
                    visited.put(node.right,true);
                }
                if(parents.get(node)!=null && visited.get(parents.get(node))==null)
                {
                    q.add(parents.get(node));
                    visited.put(parents.get(node),true);
                }
            }
        }
        while(!q.isEmpty())
        {
            ls.add(q.poll().val);
        }
        return ls;
    }

    public void markParent(TreeNode root,HashMap<TreeNode,TreeNode> map)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        map.put(root,null);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node.left!=null)
            {
                map.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null)
            {
                map.put(node.right,node);
                q.offer(node.right);
            }
        }
    }
}
