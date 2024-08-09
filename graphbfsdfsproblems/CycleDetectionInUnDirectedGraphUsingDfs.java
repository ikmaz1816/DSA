package graphbfsdfsproblems;

import java.util.ArrayList;

public class CycleDetectionInUnDirectedGraphUsingDfs {
	public boolean isCyclePresent(int child,int parent,int[] visited,ArrayList<ArrayList<Integer>> adj)
    {
        visited[child] = 1;
        for(int j:adj.get(child))
        {
            if(visited[j]==0)
            {
                if(isCyclePresent(j,child,visited,adj)==true)
                    return true;
            }
            else if(j!=parent)
                return true;
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                if(isCyclePresent(i,-1,visited,adj)==true)
                    return true;        
            }
        }
        return false;
    }
}
