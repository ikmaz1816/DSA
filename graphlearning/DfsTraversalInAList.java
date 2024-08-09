package graphlearning;

import java.util.ArrayList;

public class DfsTraversalInAList {
	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans=new ArrayList<>();
        int[] visited = new int[V];
        dfs(0,ans,visited,adj);
        return ans;
    }
    
    public void dfs(int vertex,ArrayList<Integer> ans,int[] visited,ArrayList<ArrayList<Integer>> adj)
    {
        visited[vertex]=1;
        ans.add(vertex);
        for(int j:adj.get(vertex))
        {
            if(visited[j]==0)
            {
                dfs(j,ans,visited,adj);
                visited[j]=1;
            }
        }
    }
}
