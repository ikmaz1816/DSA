package minimumspanninganddisjoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge
{
    int u;
    int v;
    int wt;
    public Edge(int u,int v,int wt)
    {
        this.u=u;
        this.v=v;
        this.wt=wt;
    }
}
public class KrukshalAlgorithm {
	static int spanningTree(int V, int E, List<List<int[]>> adj) {
        DisjointSetUnionBySize ds=new DisjointSetUnionBySize(V);
        int mst=0;
        List<Edge> edges=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            for(int[] j:adj.get(i))
            {
                Edge edge=new Edge(i,j[0],j[1]);
                edges.add(edge);
            }
        }
        Collections.sort(edges,(a,b)->a.wt-b.wt);
        for(Edge e:edges)
        {
            int u=e.u;
            int v=e.v;
            int wt=e.wt;
            if(ds.findParent(u)!=ds.findParent(v))
            {
                mst+=wt;
                ds.unionBySize(u,v);
            }
        }
        return mst;
    }
}
