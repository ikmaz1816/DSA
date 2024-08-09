package graphbfsdfsproblems;

import java.util.HashSet;
import java.util.Set;

public class DistinctNumberOfIslands2 {
	int countDistinctIslands(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        Set<String> set= new HashSet<>();
        int[][] visited = new int[rowLength][colLength];
        for(int i=0;i<rowLength;i++)
        {
            for(int j=0;j<colLength;j++)
            {
                if(grid[i][j]==1 && visited[i][j]==0)
                {
                    StringBuilder sb=new StringBuilder();
                    dfs(i,j,visited,grid,i,j,sb,rowLength,colLength);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    public void dfs(int i,int j,int[][] visited,int[][] grid,int basei,int basej,StringBuilder sb
                            ,int rowLength,int colLength)
    {
        visited[i][j]=1;
        sb.append((i-basei)+""+(j-basej));
        int[] rowTraversal ={0,-1,0,1};
        int[] colTraversal={1,0,-1,0};
        for(int k=0;k<4;k++)
        {
            int currentRow = i + rowTraversal[k];
            int currentCol = j + colTraversal[k];
            if(isValid(currentRow,currentCol,rowLength,colLength) && grid[currentRow][currentCol]==1 
                        && visited[currentRow][currentCol]==0)
            {
                dfs(currentRow,currentCol,visited,grid,basei,basej,sb,rowLength,colLength);
            }
        }
    }
    
    public boolean isValid(int row,int col,int rowLength,int colLength)
    {
        return row>=0 && col>=0 && row<rowLength && col < colLength;
    }
}
