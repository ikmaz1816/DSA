package minimumspanninganddisjoint;

public class StonesRemoved {
	public int removeStones(int[][] stones) {
        int maxRow = -1,maxCol=-1;
        // the number of edges is equivalent to number of edges
        int n = stones.length;
        for(int i=0;i<n;i++)
        {
            maxRow=Math.max(maxRow,stones[i][0]);
            maxCol=Math.max(maxCol,stones[i][1]);
        }
        //as in disjoint set we have considered <size hence adding 2 to the matrix
        DisjointSetUnionBySize ds=new DisjointSetUnionBySize(maxRow+maxCol+2);
        for(int i=0;i<n;i++)
        {
            int u = stones[i][0];
            /*  
                treating rows and column in form of numbers
                rows -> 0,1,2
                column -> 3,4,5(col+maxrow+1 = 0+2+1 for 0th row)
            */
            int v = stones[i][1] + maxRow + 1;
            ds.unionBySize(u,v);
        }
        int components=ds.components();
        //number of stones removed is number of stones or edges - number of components
        return n-components;
    }
}
