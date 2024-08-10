package toposort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeNodeBfs {
	public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        //now using dfs we won't able to detect cycle
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int rowLength = graph.length;
        for(int i=0;i<rowLength;i++)
            adj.add(new ArrayList<>());
        int[] indegree=new int[rowLength];
        for(int i=0;i<rowLength;i++)
        {
            int colLength = graph[i].length;
            for(int j=0;j<colLength;j++)
            {
                //now here we will reverse the edges, for finding eventaul safe nodes 
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<rowLength;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        while(!q.isEmpty())
        {
            int i = q.poll();
            ans.add(i);
            for(int j:adj.get(i))
            {
                indegree[j]--;
                if(indegree[j]==0)
                    q.add(j);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
