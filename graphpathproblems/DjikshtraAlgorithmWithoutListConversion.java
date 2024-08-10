package graphpathproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DjikshtraAlgorithmWithoutListConversion {
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adg, int S)
    {
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
		    for(int i=0;i<adg.get(vertex).size();i++)
		    {
		        int adjNode = adg.get(vertex).get(i).get(0);
		        int distadjNode =adg.get(vertex).get(i).get(1);
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
