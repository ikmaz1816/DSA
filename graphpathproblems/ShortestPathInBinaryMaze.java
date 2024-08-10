package graphpathproblems;

import java.util.Arrays;
import java.util.PriorityQueue;

class Matrix
{
    int row;
    int col;
    int step;
    public Matrix(int row,int col,int step)
    {
        this.row=row;
        this.col=col;
        this.step=step;
    }
}
public class ShortestPathInBinaryMaze {
	public int shortestPathBinaryMatrix(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int sc=0,sr=0,dr=rowLength-1,dc=colLength-1;
        if(grid[sc][sr]==1 || grid[dr][dc]==1)
            return -1;
        //edge case if there is only one element
        if(sr==dr && sc==dc)
            return 1;
        PriorityQueue<Matrix> pq=new PriorityQueue<>((a,b)->a.step-b.step);
        pq.add(new Matrix(sr,sc,1));
        int[][] distance = new int[rowLength][colLength];
        for(int[] i:distance)
        {
            Arrays.fill(i,(int)1e9);
        }
        distance[sr][sc]=1;
        while(!pq.isEmpty())
        {
            int row = pq.peek().row;
            int col = pq.peek().col;
            int step = pq.peek().step;
            pq.poll();
            for(int r=-1;r<=1;r++)
            {
                for(int c=-1;c<=1;c++)
                {
                    int adjRow=r+row;
                    int adjCol =c+col;
                    if(isValid(adjRow,adjCol,rowLength,colLength) && step+1<distance[adjRow][adjCol] && grid[adjRow][adjCol]==0)
                    {
                        if(adjRow==dr && adjCol==dc)
                            return step+1;
                        distance[adjRow][adjCol] = step+1;
                        pq.add(new Matrix(adjRow,adjCol,step+1));
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
