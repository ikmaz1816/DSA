package graphbfsdfsproblems;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithm {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> q=new LinkedList<>();
        int rowLength = image.length;
        int colLength = image[0].length;
        int[][] visited = new int[rowLength][colLength];
        int[] rowTraversal ={0,-1,0,1};
        int[] colTraversal={1,0,-1,0};
        q.add(new Pair(image[sr][sc],sr,sc));
        int initialColor = image[sr][sc];
        while(!q.isEmpty())
        {
            Pair p = q.peek();
            int row = p.row;
            int col = p.col;
            q.poll();
            image[row][col] = color;
            for(int i=0;i<4;i++)
            {
                int currentRow = row + rowTraversal[i];
                int currentCol = col + colTraversal[i];
                if(isValid(currentRow,currentCol,rowLength,colLength) && image[currentRow][currentCol]==initialColor 
                            && visited[currentRow][currentCol]==0)
                {
                    q.add(new Pair(image[currentRow][currentCol],currentRow,currentCol));
                    visited[currentRow][currentCol]=1;
                }
            }
        }
        return image;
    }

    public boolean isValid(int row,int col,int rowLength,int colLength)
    {
        return row>=0 && col>=0 && row<rowLength && col < colLength;
    }
}
