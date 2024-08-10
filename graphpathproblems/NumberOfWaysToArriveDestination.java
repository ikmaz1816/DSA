package graphpathproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Ways
{
    long vertex;
    long distance;
    public Ways(long vertex,long distance)
    {
        this.vertex=vertex;
        this.distance=distance;
    }
}
public class NumberOfWaysToArriveDestination {
	public int countPaths(int n, int[][] roads) {
        long[] distance = new long[n];
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[0]=0;
        long mod =(int)(1e9 + 7);
        long[] ways=new long[n];
        ways[0]=1L;
        List<List<Ways>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            adj.get(roads[i][0]).add(new Ways(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Ways(roads[i][0],roads[i][2]));
        }
        PriorityQueue<Ways> q=new PriorityQueue<>((a,b)->Long.compare(a.distance,b.distance));
        q.add(new Ways(0,0));
        while(!q.isEmpty())
        {
            int vertex = (int)q.peek().vertex;
            long dist = q.peek().distance;
            q.poll();
            for(Ways j:adj.get(vertex))
            {
                int adjNode = (int)j.vertex;
                long adjDistance = j.distance;
                if(dist + adjDistance < distance[adjNode])
                {
                    distance[adjNode] = dist +adjDistance;
                    q.add(new Ways(adjNode,distance[adjNode]));
                    ways[adjNode] =ways[vertex];
                }
                else if(dist + adjDistance == distance[adjNode])
                {
                    ways[adjNode] =(ways[vertex]+ways[adjNode])%mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    }
}
