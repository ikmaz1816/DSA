package graphpathproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathInDAG {
	public int[] shortestPath(int N,int M, int[][] edges) {
		PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
		int[] distance = new int[N];
		List<List<Pair>> adj=new ArrayList<>();
		for(int i=0;i<N;i++)
		    adj.add(new ArrayList<>());
		for(int i=0;i<M;i++)
		{
		    int vertex = edges[i][0];
		    int adjNode = edges[i][1];
		    int dist = edges[i][2];
		    adj.get(vertex).add(new Pair(adjNode,dist));
		}
		Arrays.fill(distance,(int)1e9);
		distance[0]=0;
		pq.add(new Pair(0,0));
		while(!pq.isEmpty())
		{
		    int vertex = pq.peek().vertex;
		    int dist = pq.peek().distance;
		    pq.poll();
		    for(Pair p:adj.get(vertex))
		    {
		        int adjNode = p.vertex;
		        int distadjNode = p.distance;
		        if(dist + distadjNode < distance[adjNode])
		        {
		            distance[adjNode] = dist + distadjNode;
		            pq.add(new Pair(adjNode,distance[adjNode]));
		        }
		    }
		}
		for(int i=0;i<N;i++)
		{
		    if(distance[i]==(int)1e9)
		        distance[i]=-1;
		}
		return distance;
	}
}
