package graphpathproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
	public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<times.length;i++)
        {
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance,(int)1e9);
        distance[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new Pair(k,0));
        
        while(!pq.isEmpty())
        {
            int data = pq.peek().vertex;
            int dist = pq.peek().distance;
            pq.poll();
            for(Pair j:adj.get(data))
            {
                if(dist + j.distance < distance[j.vertex])
                {
                    distance[j.vertex] = dist + j.distance;
                    pq.add(new Pair(j.vertex,distance[j.vertex]));
                }
            }
        }
        int minCost=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        {
            if(distance[i]==(int)1e9)
                return -1;
            minCost=Math.max(minCost,distance[i]);
        }
        return minCost;
    }
}
