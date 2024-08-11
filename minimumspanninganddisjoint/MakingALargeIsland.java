package minimumspanninganddisjoint;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
	 public int largestIsland(int[][] grid) {
	        int rows = grid.length,cols=grid[0].length;
	        DisjointSetUnionBySize ds=new DisjointSetUnionBySize(rows*cols);
	        for(int i=0;i<rows;i++)
	        {
	            for(int j=0;j<cols;j++)
	            {
	                if(grid[i][j]==1)
	                {
	                    int[] rowTraversal = {-1,0,1,0};
	                    int[] colTraversal = {0,1,0,-1};
	                    for(int k=0;k<4;k++)
	                    {
	                        int adjRow = i + rowTraversal[k];
	                        int adjCol = j + colTraversal[k];
	                        if(isValid(adjRow,adjCol,rows,cols) && grid[adjRow][adjCol]==1)
	                        {
	                            int u = ds.findParent(i*cols+j);
	                            int v = ds.findParent(adjRow*cols+adjCol);
	                            if(u!=v)
	                            {
	                                ds.unionBySize(i*cols+j,adjRow*cols+adjCol);
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        int maxSize =0;
	        for(int i=0;i<rows;i++)
	        {
	            for(int j=0;j<cols;j++)
	            {
	                if(grid[i][j]==0)
	                {
	                    int[] rowTraversal = {-1,0,1,0};
	                    int[] colTraversal = {0,1,0,-1};
	                    int size=0;
	                    Set<Integer> set=new HashSet<>();
	                    for(int k=0;k<4;k++)
	                    {
	                        int adjRow = i + rowTraversal[k];
	                        int adjCol = j + colTraversal[k];
	                        if(isValid(adjRow,adjCol,rows,cols) && grid[adjRow][adjCol]==1)
	                        {
	                            set.add(ds.findParent(adjRow*cols+adjCol));
	                        }
	                    }
	                    for(int w:set)
	                        size += ds.size.get(w);
	                    maxSize=Math.max(maxSize,size+1);
	                }
	            }
	        }
	        for(int i=0;i<rows*cols;i++)
	        {
	            maxSize = Math.max(maxSize,ds.size.get(i));
	        }
	        return maxSize;
	    }
	    public static boolean isValid(int r,int c,int rowLength,int colLength)
		{
			return r>=0 && c>=0 && r<rowLength && c<colLength;
		}
}
