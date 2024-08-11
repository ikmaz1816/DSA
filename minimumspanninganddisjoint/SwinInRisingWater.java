package minimumspanninganddisjoint;

import java.util.Arrays;
import java.util.PriorityQueue;

class Path
{
    int row;
    int col;
    int diff;
    public Path(int row,int col,int diff)
    {
        this.row=row;
        this.col=col;
        this.diff=diff;
    }
}
public class SwinInRisingWater {
    public int swimInWater(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] distance=new int[rowLength][colLength];
        PriorityQueue<Path> pq=new PriorityQueue<>((a,b)->a.diff-b.diff);
        pq.add(new Path(0,0,grid[0][0]));
        for(int[] i:distance)
        {
            Arrays.fill(i,(int)1e9);
        }
        distance[0][0]=0;
        while(!pq.isEmpty())
        {
            int row = pq.peek().row;
            int col=pq.peek().col;
            int diff=pq.peek().diff;
            pq.poll();
            if(row==rowLength-1 && col==colLength-1)
                return diff;
            int[] rowTraversal ={-1,0,1,0};
            int[] colTraversal = {0,1,0,-1};
            for(int i=0;i<4;i++)
            {
                
                int adjRow = row+rowTraversal[i];
                int adjCol = col+colTraversal[i];
                if(isValid(adjRow,adjCol,rowLength,colLength))
                {
                    int max = Math.max(diff,grid[adjRow][adjCol]);
                    if(max<distance[adjRow][adjCol])
                    {
                        distance[adjRow][adjCol]=max;
                        pq.add(new Path(adjRow,adjCol,max));
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int r,int c,int rowLength,int colLength)
	{
		return r>=0 && c>=0 && r<rowLength && c<colLength;
	}
}	
