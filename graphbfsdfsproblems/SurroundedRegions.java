package graphbfsdfsproblems;

import java.util.LinkedList;
import java.util.Queue;

class Surrounded
{
    int row;
    int col;
    public Surrounded(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}
public class SurroundedRegions {
	public void solve(char[][] board) {
        int rowLength = board.length;
        int colLength = board[0].length;
        int[][] visited = new int[rowLength][colLength];
        Queue<Surrounded> q=new LinkedList<>();
        for(int i=0;i<rowLength;i++)
        {
            for(int j=0;j<colLength;j++)
            {
                if(i==0 || j==0 || i==rowLength-1 || j==colLength-1)
                    if(board[i][j]=='O')
                    {
                        q.add(new Surrounded(i,j));
                        visited[i][j]=1;
                    }
            }
        }
        int[] rowTraversal ={0,-1,0,1};
        int[] colTraversal={1,0,-1,0};
        while(!q.isEmpty())
        {
            Surrounded s=q.poll();
            int row = s.row;
            int col = s.col;
            for(int i=0;i<4;i++)
            {
                int currentRow = row + rowTraversal[i];
                int currentCol = col + colTraversal[i];
                if(isValid(currentRow,currentCol,rowLength,colLength) && board[currentRow][currentCol]=='O' 
                            && visited[currentRow][currentCol]==0)
                {
                    q.add(new Surrounded(currentRow,currentCol));
                    visited[currentRow][currentCol]=1;
                }
            }
        }

        for(int i=0;i<rowLength;i++)
        {
            for(int j=0;j<colLength;j++)
            {
                if(visited[i][j]==1)
                    board[i][j] ='O';
                else
                    board[i][j] ='X';
            }
        }
    }

    public boolean isValid(int row,int col,int rowLength,int colLength)
    {
        return row>=0 && col>=0 && row<rowLength && col < colLength;
    }
}
