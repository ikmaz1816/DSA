package graphbfsdfsproblems;

import java.util.ArrayList;

public class NumberOfProvinces {
	public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int rowLength = isConnected.length;
        //it is a n*n matrix
        //Here if there is a one in cell this means i and j are connected
        for(int i=0;i<rowLength;i++)
            adj.add(new ArrayList<>());
        int[] visited = new int[rowLength];
        for(int i=0;i<rowLength;i++)
        {
            for(int j=i+1;j<rowLength;j++)
            {
                if(isConnected[i][j]==1)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count =0;
        for(int i=0;i<rowLength;i++)
        {
            if(visited[i]==0)
            {
                count++;
                dfs(i,visited,adj);
            }
        }
        return count;
    }

    public void dfs(int vertex,int[] visited,ArrayList<ArrayList<Integer>> adj)
    {
        visited[vertex]=1;
        for(int j:adj.get(vertex))
        {
            if(visited[j]==0)
            {
                dfs(j,visited,adj);
            }
        }
    }
}
