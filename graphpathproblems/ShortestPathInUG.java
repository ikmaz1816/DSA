package graphpathproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair
{
    int vertex;
    int distance;
    public Pair(int vertex,int distance)
    {
        this.vertex=vertex;
        this.distance=distance;
    }
}
public class ShortestPathInUG {
	public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] distance = new int[n];
        Arrays.fill(distance,(int)1e9);
        // here we can use a priority queue as well
        Queue<Pair> q=new LinkedList<>();
        distance[src]=0;
        q.add(new Pair(src,0));
        while(!q.isEmpty())
        {
            int vertex = q.peek().vertex;
            int dist = q.peek().distance;
            q.poll();
            for(int j:adj.get(vertex))
            {
                if(dist + 1 < distance[j])
                {
                    distance[j] = 1 + dist;
                    q.add(new Pair(j,1+dist));
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(distance[i]==(int)1e9)
                distance[i]=-1;
        }
        return distance;
    }
}
