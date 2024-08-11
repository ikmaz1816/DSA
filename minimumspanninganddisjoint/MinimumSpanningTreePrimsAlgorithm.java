package minimumspanninganddisjoint;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
public class MinimumSpanningTreePrimsAlgorithm {
	static int spanningTree(int V, int E, List<List<int[]>> adjT) {
        int mst=0;
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<V;i++)
        {
            for(int[] j:adjT.get(i))
            {
                adj.get(i).add(new Pair(j[0],j[1]));
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new Pair(0,0));
        int[] visited = new int[V];
        while(!pq.isEmpty())
        {
            int vertex = pq.peek().vertex;
            int dist = pq.peek().distance;
            pq.poll();
            
            if(visited[vertex]==1)
                continue;
            mst+=dist;
            visited[vertex]=1;
            for(Pair p:adj.get(vertex))
            {
                if(visited[p.vertex]==0)
                {
                    pq.add(new Pair(p.vertex,p.distance));
                }
            }
        }
        return mst;
    }
}
