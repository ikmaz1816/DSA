package graphbfsdfsproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBfs {
	public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int V = graph.length;
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj.get(i).add(graph[i][j]);
                adj.get(graph[i][j]).add(i);
            }
        }
       
        int[] col = new int[V];
        Arrays.fill(col,-1);
        for(int i=0;i<V;i++)
        {
            if(col[i]==-1)
            {
                if(bfs(i,col,adj)==false)
                    return false;
            }
        }
        
        return true;
    }

    public static boolean bfs(int i,int[] col,ArrayList<ArrayList<Integer>> adj)
    {
        col[i]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty())
        {
            int vertex = q.poll();
            for(int j:adj.get(vertex))
            {
                if(col[j]==-1)
                {
                    q.add(j);
                    col[j] = 1 - col[vertex];
                }
                else 
                {
                    if(col[j]==col[vertex])
                        return false;
                }
            }
        }    
        return true;      
    }
}
