package graphbfsdfsproblems;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteDfs {
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
                if(dfs(i,0,col,adj)==false)
                    return false;
            }
        }
        
        return true;
    }

    public static boolean dfs(int i,int c,int[] col,ArrayList<ArrayList<Integer>> adj)
    {
        col[i]=c;
        for(int j:adj.get(i))
        {
            if(col[j]==-1)
            {
                if(dfs(j,1-col[i],col,adj)==false)
                    return false;
            }
            else 
            {
                if(col[j]==col[i])
                    return false;
            }
        }   
        return true;      
    }
}
