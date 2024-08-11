package minimumspanninganddisjoint;

public class MakingANetworkConnected {
	public int makeConnected(int n, int[][] connections) {
        DisjointSetUnionBySize ds=new DisjointSetUnionBySize(n);
        int cntExtra=0;
        for(int i=0;i<connections.length;i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findParent(u)==ds.findParent(v))
            {
                cntExtra++;
            }
            else
            {
                ds.unionBySize(u,v);
            }
        }
        int components = 0;
        for(int i=0;i<n;i++)
        {
            if(i==ds.findParent(i))
                components++;
        }
        //Number of components are 3 and there are two edges hence 
        // to connect all components we need only two edges and hence the components-1 <=cntExtra Edges
        components-=1;
        if(cntExtra>=components)
        {
            return components;
        }
        return -1;
    }
}
