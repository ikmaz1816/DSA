package graphpathproblems;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
	static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        //We use bellman ford algorithm only in case when there are negative cycles present
        // as Djikshtra won't be able to identify negative cycles
        //Bellman ford algorithm only works for directed so in case of undirected make it directed
        int[] distance = new int[V];
        Arrays.fill(distance,(int)1e8);
        distance[S]=0;
        for(int i=0;i<V-1;i++)
        {
            for(ArrayList<Integer> arr:edges)
            {
                int u=arr.get(0);
                int v=arr.get(1);
                int w=arr.get(2);
                if(distance[u]!=(int)1e8 && distance[u]+w<distance[v])
                {
                    distance[v]=w+distance[u];
                }
            }
        }
        
        for(ArrayList<Integer> arr:edges)
        {
            int u=arr.get(0);
            int v=arr.get(1);
            int w=arr.get(2);
            if(distance[u]!=(int)1e8 && distance[u]+w<distance[v])
            {
                //if value keeps decreasing this means that there is a negative cycle
                return new int[]{-1};
            }
        }
        
        return distance;
    }
}
