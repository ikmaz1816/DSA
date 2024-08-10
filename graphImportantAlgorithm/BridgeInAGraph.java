package graphImportantAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeInAGraph {
	private int count=0;
    public void dfs(int vertex,int parent,int[] visited,int[] low,int[] tin,List<List<Integer>> connections,List<List<Integer>> ans)
    {
        count++;
        low[vertex]=tin[vertex]=count;
        visited[vertex]=1;
        for(int j:connections.get(vertex))
        {
            if(j==parent) 
                continue;
            if(visited[j]==0)
            {
                dfs(j,vertex,visited,low,tin,connections,ans);
                low[vertex] = Math.min(low[vertex],low[j]);
                if(low[j]>tin[vertex])
                {
                    ans.add(new ArrayList<>(Arrays.asList(vertex,j)));
                }
            }
            else
            {
                low[vertex] = Math.min(low[vertex],low[j]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans=new ArrayList<>();
        int[] visited = new int[n];
        int[] low = new int[n];
        int[] tin = new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<connections.size();i++)
        {
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,-1,visited,low,tin,adj,ans);
            }
        }
        return ans;
    }
}
