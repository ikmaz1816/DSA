package binarytreemediumproblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import binarytreetraversal.TreeNode;

class Traversal
{
   TreeNode data;
   int x;
   int y;
   public Traversal(TreeNode data,int x,int y)
   {
       this.data=data;
       this.x=x;
       this.y=y;
   }
}
public class VerticalOrderTraversal {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Traversal> q=new LinkedList<>();
        q.add(new Traversal(root,0,0));
        while(!q.isEmpty())
        {
            Traversal t=q.peek();
            q.poll();
            TreeNode data = t.data;
            int x = t.x;
            int y = t.y;
            if(!map.containsKey(x))
            {
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y))
            {
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(data.val);
            if(data.left!=null)
                q.offer(new Traversal(data.left,x-1,y+1));
            if(data.right!=null)
                q.offer(new Traversal(data.right,x+1,y+1));
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> m:map.values())
        {
            List<Integer> subAnswer = new ArrayList<>();
            for(PriorityQueue<Integer> pq:m.values())
            {
                while(!pq.isEmpty())
                {
                    subAnswer.add(pq.poll());
                }
            }
            ans.add(new ArrayList<>(subAnswer));
        }
        return ans;
    }
}	
