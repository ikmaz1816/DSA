package binarytreemediumproblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import binarytreetraversal.Node;

class TopView
{
    Node node;
    int index;
    public TopView(Node node,int index)
    {
        this.node=node;
        this.index=index;
    }
}
public class TopViewBinaryTree {
	static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<TopView> q=new LinkedList<>();
        q.add(new TopView(root,0));
        while(!q.isEmpty())
        {
            TopView view=q.poll();
            int index = view.index;
            Node node = view.node;
            if(!map.containsKey(index))
            {
                map.put(index,node.data);
            }
            if(node.left!=null)
                q.add(new TopView(node.left,index-1));
            if(node.right!=null)
                q.add(new TopView(node.right,index+1));
        }
        for(Integer i:map.values())
        {
            ans.add(i);
        }
        return ans;
    }
}
