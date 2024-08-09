package graphbfsdfsproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Cycle
{
    int child;
    int parent;
    public Cycle(int child,int parent)
    {
        this.child=child;
        this.parent=parent;
    }
}
public class CycleDetectionInUnDirectedGraphUsingBfs {
	public boolean isCyclePresent(int vertex, int[] visited,ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Cycle> q=new LinkedList<>();
        q.add(new Cycle(vertex,-1));
        visited[vertex] = 1;
        while(!q.isEmpty())
        {
            Cycle c = q.poll();
            int child = c.child;
            int parent = c.parent;
            for(int connected : adj.get(child))
            {
                if(visited[connected]==0)
                {
                    q.add(new Cycle(connected,child));
                    visited[connected]=1;
                }
                else if(connected!=parent)
                    return true;        
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                if(isCyclePresent(i,visited,adj)==true)
                    return true;        
            }
        }
        return false;
    }
}
