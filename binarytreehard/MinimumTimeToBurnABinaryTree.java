package binarytreehard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import binarytreetraversal.Node;

public class MinimumTimeToBurnABinaryTree {
	public static int minTime(Node root, int target) 
    {
        int minTime=0;
        if(root==null)
            return 0;
        HashMap<Node,Node> parents=new HashMap<>();
        Node targetNode = markParent(root,parents,target);
        HashMap<Node,Boolean> visited=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        
        q.add(targetNode);
        visited.put(targetNode,true);
        while(!q.isEmpty())
        {
            int size=q.size();
            boolean flag=false;
            for(int i=0;i<size;i++)
            {
                Node node = q.poll();
                
                if(node.left!=null && visited.get(node.left)==null)
                {
                    q.add(node.left);
                    visited.put(node.left,true);
                    flag=true;
                }
                if(node.right!=null && visited.get(node.right)==null)
                {
                    q.add(node.right);
                    visited.put(node.right,true);
                    flag=true;
                }
                if(parents.get(node)!=null && visited.get(parents.get(node))==null)
                {
                    q.add(parents.get(node));
                    visited.put(parents.get(node),true);
                    flag=true;
                }
                
            }
            if(flag)
                minTime++;
        }
        return minTime;
    }
    public static Node markParent(Node root,HashMap<Node,Node> map,int target)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        map.put(root,null);
        Node targetNode = null;
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(node.data==target)
            {
                targetNode=node;
            }
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
        return targetNode;
    }
}
