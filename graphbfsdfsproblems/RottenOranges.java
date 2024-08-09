package graphbfsdfsproblems;

import java.util.LinkedList;
import java.util.Queue;

class Pair
{
    int data;
    int row;
    int col;
    public Pair(int data,int row,int col)
    {
        this.data=data;
        this.row=row;
        this.col=col;
    }
}
public class RottenOranges {
	public int orangesRotting(int[][] grid) {
        int cntFresh = 0;
        Queue<Pair> q=new LinkedList<>();
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] visited = new int[rowLength][colLength];
        for(int i=0;i<rowLength;i++)
        {
            for(int j=0;j<colLength;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(0,i,j));
                    visited[i][j]=1;
                }
                else if(grid[i][j]==1)
                {
                    cntFresh++;
                }
            }
        }
        int[] rowTraversal ={0,-1,0,1};
        int[] colTraversal={1,0,-1,0};
        int cntOfRotten = 0;
        int maxdata=0;
        while(!q.isEmpty())
        {
            Pair p = q.peek();
            int step = p.data;
            int row = p.row;
            int col = p.col;
            q.poll();
            maxdata=Math.max(maxdata,step);
            for(int i=0;i<4;i++)
            {
                int currentRow = row + rowTraversal[i];
                int currentCol = col + colTraversal[i];
                if(isValid(currentRow,currentCol,rowLength,colLength) && grid[currentRow][currentCol]==1 
                            && visited[currentRow][currentCol]==0)
                {
                    q.add(new Pair(step+1,currentRow,currentCol));
                    visited[currentRow][currentCol]=1;
                    cntOfRotten++;
                }
            }
        }
        if(cntFresh==cntOfRotten)
            return maxdata;
        return -1;
    }

    public boolean isValid(int row,int col,int rowLength,int colLength)
    {
        return row>=0 && col>=0 && row<rowLength && col < colLength;
    }
}
