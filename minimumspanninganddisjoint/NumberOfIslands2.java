package minimumspanninganddisjoint;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
	public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        List<Integer> ans=new ArrayList<>();
        int[][] visited = new int[rows][cols];
        DisjointSetUnionBySize ds=new DisjointSetUnionBySize(rows*cols);
        int count=0;
        for(int i=0;i<operators.length;i++)
        {
            int row = operators[i][0];
            int col = operators[i][1];
            if(visited[row][col]==1)
            {
                ans.add(count);
                continue;
            }
            visited[row][col]=1;
            count++;
            int[] rowTraversal = {-1,0,1,0};
            int[] colTraversal = {0,1,0,-1};
            for(int k=0;k<4;k++)
            {
                int adjRow = row + rowTraversal[k];
                int adjCol = col + colTraversal[k];
                if(isValid(adjRow,adjCol,rows,cols) && visited[adjRow][adjCol]==1)
                {
                    int u = ds.findParent(row*cols+col);
                    int v = ds.findParent(adjRow*cols+adjCol);
                    if(u!=v)
                    {
                        ds.unionBySize(row*cols+col,adjRow*cols+adjCol);
                        count--;
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
    public static boolean isValid(int r,int c,int rowLength,int colLength)
	{
		return r>=0 && c>=0 && r<rowLength && c<colLength;
	}
}
