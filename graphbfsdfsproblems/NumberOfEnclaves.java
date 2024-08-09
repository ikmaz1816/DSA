package graphbfsdfsproblems;

public class NumberOfEnclaves {
	public void dfs(int i,int j,int[][] visited,int[][] grid,int rowLength,int colLength)
    {
        visited[i][j]=1;
        int[] rowTraversal ={0,-1,0,1};
        int[] colTraversal={1,0,-1,0};
        for(int k=0;k<4;k++)
        {
            int currentRow = i + rowTraversal[k];
            int currentCol = j + colTraversal[k];
            if(isValid(currentRow,currentCol,rowLength,colLength) && grid[currentRow][currentCol]==1
                            && visited[currentRow][currentCol]==0)
            {
                dfs(currentRow,currentCol,visited,grid,rowLength,colLength);
            }
        }    
    }
    public int numEnclaves(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] visited = new int[rowLength][colLength];
        for(int i=0;i<rowLength;i++)
        {
            for(int j=0;j<colLength;j++)
            {
                if(i==0 || j==0 || i==rowLength-1 || j==colLength-1)
                    if(grid[i][j]==1)
                    {
                        dfs(i,j,visited,grid,rowLength,colLength);
                    }
            }
        }
        int count=0;
        for(int i=0;i<rowLength;i++)
        {
            for(int j=0;j<colLength;j++)
            {
                if(grid[i][j]==1 && visited[i][j]==0)
                    count++;
            }
        }
        return count;
    }

    public boolean isValid(int row,int col,int rowLength,int colLength)
    {
        return row>=0 && col>=0 && row<rowLength && col < colLength;
    }
}	
