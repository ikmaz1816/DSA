package graphlearning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsTraversalInList {
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		//here we are considering only one component, if there would be more components then
		// we would have to iterate on every node.
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visited = new int[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0]=1;
        while(!q.isEmpty())
        {
            int vertex = q.poll();
            ans.add(vertex);
            for(int j:adj.get(vertex))
            {
                if(visited[j]==0)
                {
                    visited[j]=1;
                    q.add(j);
                }
            }
        }
        return ans;
    }
}
