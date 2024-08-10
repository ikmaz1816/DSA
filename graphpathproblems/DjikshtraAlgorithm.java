package graphpathproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DjikshtraAlgorithm {
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adg, int S)
    {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<adg.size();i++)
        {
            for(int j=0;j<adg.get(i).size();j++)
            {
                int adjNode = adg.get(i).get(j).get(0);
                int distance = adg.get(i).get(j).get(1);
                adj.get(i).add(new Pair(adjNode,distance));
                adj.get(adjNode).add(new Pair(i,distance));
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
		int[] distance = new int[V];
        Arrays.fill(distance,(int)1e9);
		distance[S]=0;
		pq.add(new Pair(S,0));
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
		for(int i=0;i<V;i++)
		{
		    if(distance[i]==(int)1e9)
		        distance[i]=-1;
		}
		return distance;
    }
}
