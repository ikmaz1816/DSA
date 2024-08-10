package toposort;

import java.util.ArrayList;
import java.util.Stack;

public class TopoSortUsingDfs {
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,st,visited,adj);
            }
        }
        int[] ans = new int[V];
        int index = 0;
        while(!st.isEmpty())
        {
            ans[index++] =st.pop();
        }
        return ans;
    }
    
    public static void dfs(int vertex,Stack<Integer> st,int[] visited,ArrayList<ArrayList<Integer>> adj)
    {
        visited[vertex]=1;
        for(int j:adj.get(vertex))
        {
            if(visited[j]==0)
            {
                dfs(j,st,visited,adj);
            }
        }
        st.push(vertex);
    }
}
