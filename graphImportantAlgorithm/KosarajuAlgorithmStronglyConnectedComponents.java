package graphImportantAlgorithm;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithmStronglyConnectedComponents {
	public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //use of stack is done to get the terminal node
        Stack<Integer> st=new Stack<>();
        // we will change the edges from u to v to v to u
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adjT.add(new ArrayList<>());
        }
        int[] visited = new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,visited,st,adj);
            }
        }
        for(int i=0;i<V;i++)
        {
            visited[i]=0;
            for(int j:adj.get(i))
            {
                adjT.get(j).add(i);
            }
        }
        int count=0;
        while(!st.isEmpty())
        {
            int node = st.pop();
            if(visited[node]==0)
            {
                count++;
                dfs(node,visited,adjT);
            }
        }
        return count;
    }
    
    public void dfs(int vertex,int[] visited,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj)
    {
        visited[vertex] = 1;
        for(int j:adj.get(vertex))
        {
            if(visited[j]==0)
            {
                dfs(j,visited,st,adj);
            }
        }
        st.push(vertex);
    }
    
    public void dfs(int vertex,int[] visited,ArrayList<ArrayList<Integer>> adjT)
    {
        visited[vertex] = 1;
        for(int j:adjT.get(vertex))
        {
            if(visited[j]==0)
            {
                dfs(j,visited,adjT);
            }
        }
    }
}
