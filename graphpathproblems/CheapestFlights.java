package graphpathproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Flights
{
    int vertex;
    int distance;
    int stops;
    public Flights(int vertex,int distance,int stops)
    {
        this.vertex=vertex;
        this.distance=distance;
        this.stops=stops;
    }
}
public class CheapestFlights {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        int[] distance = new int[n];
        Arrays.fill(distance,(int)1e9);
        distance[src]=0;
        Queue<Flights> q=new LinkedList<>();
        q.add(new Flights(src,0,0));
        while(!q.isEmpty())
        {
            int data = q.peek().vertex;
            int dist = q.peek().distance;
            int stops=q.peek().stops;
            q.poll();
            if(stops>k)
                continue;
            for(Pair j:adj.get(data))
            {
                if(dist + j.distance < distance[j.vertex] && stops<=k)
                {
                    distance[j.vertex] = dist + j.distance;
                    q.add(new Flights(j.vertex,distance[j.vertex],stops+1));
                }
            }
        }
        return distance[dst]==(int)1e9 ? -1 : distance[dst];
    }
}
