package graphbfsdfsproblems;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01Bfs {
	public int[][] updateMatrix(int[][] mat) {
        int rowLength = mat.length;
        int colLength = mat[0].length;
        int[][] ans = new int[rowLength][colLength];
        Queue<Pair> q=new LinkedList<>();
        int[][] visited=new int[rowLength][colLength];
        for(int i=0;i<rowLength;i++)
        {
            for(int j=0;j<colLength;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new Pair(0,i,j));
                    visited[i][j]=1;
                }
            }
        }
        int[] rowTraversal ={0,-1,0,1};
        int[] colTraversal={1,0,-1,0};
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int data = p.data;
            int row = p.row;
            int col = p.col;
            ans[row][col] = data;
             for(int i=0;i<4;i++)
            {
                int currentRow = row + rowTraversal[i];
                int currentCol = col + colTraversal[i];
                if(isValid(currentRow,currentCol,rowLength,colLength) && mat[currentRow][currentCol]==1 
                            && visited[currentRow][currentCol]==0)
                {
                    q.add(new Pair(data+1,currentRow,currentCol));
                    visited[currentRow][currentCol]=1;
                }
            }
        }
        return ans;
    }

    public boolean isValid(int row,int col,int rowLength,int colLength)
    {
        return row>=0 && col>=0 && row<rowLength && col < colLength;
    }
}
