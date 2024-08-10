package toposort;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodeDfs {
	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj,List<Integer> ans) {
        int[] visited = new int[V];
        int[] path = new int[V];
        boolean flag = false;
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                if(dfs(i,visited,path,adj))
                    flag = true;
            }
        }
        for(int i=0;i<V;i++)
        {
            if(path[i]==0)
                ans.add(i);
        }
        return flag;
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
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        //now using dfs we won't able to detect cycle
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int rowLength = graph.length;
        for(int i=0;i<rowLength;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<rowLength;i++)
        {
            int colLength = graph[i].length;
            for(int j=0;j<colLength;j++)
            {
                adj.get(i).add(graph[i][j]);
            }
        }
        isCyclic(rowLength,adj,ans);
        return ans;
    }
}
