package toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckCycleInDirectedGraphKahn {
	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree=new int[V];
       for(int i=0;i<V;i++)
       {
           for(int j:adj.get(i))
           {
               indegree[j]++;
           }
       }
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<V;i++)
       {
           if(indegree[i]==0)
           {
               q.add(i);
           }
       }
       int index =0;
       while(!q.isEmpty())
       {
           int number = q.poll();
           index++;
           for(int j:adj.get(number))
           {
               indegree[j]--;
               if(indegree[j]==0)
               {
                   q.add(j);
               }
           }
       }
       if(index==V)
           return false;
       return true;
   }
}
