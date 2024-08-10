package graphImportantAlgorithm;

import java.util.ArrayList;
public class ArticulationPointInGraph {
	private int count=0;
    public void dfs(int vertex,int parent,int[] visited,int[] low,int[] tin,int[] mark,
        ArrayList<ArrayList<Integer>> connections)
    {
        count++;
        low[vertex]=tin[vertex]=count;
        visited[vertex]=1;
        int child=0;
        for(int j:connections.get(vertex))
        {
            if(j==parent) 
                continue;
            if(visited[j]==0)
            {
                dfs(j,vertex,visited,low,tin,mark,connections);
                low[vertex] = Math.min(low[vertex],low[j]);
                if(low[j]>=tin[vertex] && parent!=-1)
                {
                    mark[vertex] = 1;
                }
                child++;
            }
            else
            {
                low[vertex] = Math.min(low[vertex],tin[j]);
            }
        }
        if(child>1 && parent==-1)
            mark[vertex] = 1;
        
    }
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> ans= new ArrayList<>();
        int[] visited = new int[V];
        int[] low = new int[V];
        int[] tin = new int[V];
        int[] mark = new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,-1,visited,low,tin,mark,adj);
            }
        }
        for(int i=0;i<V;i++)
        {
            if(mark[i]==1)
                ans.add(i);
        }
        if(ans.size()==0)
            ans.add(-1);
        return ans;
    }
}
