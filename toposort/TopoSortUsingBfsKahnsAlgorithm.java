package toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortUsingBfsKahnsAlgorithm {
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
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
        int[] ans = new int[V];
        int index =0;
        while(!q.isEmpty())
        {
            int number = q.poll();
            ans[index++]=number;
            for(int j:adj.get(number))
            {
                indegree[j]--;
                if(indegree[j]==0)
                {
                    q.add(j);
                }
            }
        }
        return ans;
    }
}	
