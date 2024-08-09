package graphbfsdfsproblems;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {
	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] path = new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                if(dfs(i,visited,path,adj)==true)
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int i,int[] visited,int[] path,ArrayList<ArrayList<Integer>> adj)
    {
        visited[i] = 1;
        path[i] =1 ;
        for(int j:adj.get(i))
        {
            if(visited[j]==0)
            {
                if(dfs(j,visited,path,adj))
                    return true;
            }
            else if(path[j]==1)
                return true;
        }
        path[i]=0;
        return false;
    }
}
