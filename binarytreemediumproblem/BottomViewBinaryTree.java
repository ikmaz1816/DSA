package binarytreemediumproblem;

import binarytreetraversal.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class BottomView
{
    Node node;
    int index;
    public BottomView(Node node,int index)
    {
        this.node=node;
        this.index=index;
    }
}
public class BottomViewBinaryTree {
	public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<BottomView> q=new LinkedList<>();
        q.add(new BottomView(root,0));
        while(!q.isEmpty())
        {
            BottomView view=q.poll();
            int index = view.index;
            Node node = view.node;
            map.put(index,node.data);
            if(node.left!=null)
                q.add(new BottomView(node.left,index-1));
            if(node.right!=null)
                q.add(new BottomView(node.right,index+1));
        }
        for(Integer i:map.values())
        {
            ans.add(i);
        }
        return ans;
    }
}
