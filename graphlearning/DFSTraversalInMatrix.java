package graphlearning;

public class DFSTraversalInMatrix {
	public static void dfsInMatrix(int[][] matrix)
	{
		//Time Complexity :- O(n*m)  Space Complexity:- O(n*m)
		/*
		 	Number of connected components
		 	In a graph some nodes are connected to certain nodes
		 	They form a group of nodes
		 	This is called as one connected component and there can be multiple connected components
		 */
		//traveling in all directions vertical,diagonal and horizontal
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		int[][] visited = new int[rowLength][colLength];
		int count=0;
		for(int i=0;i<rowLength;i++)
		{
			for(int j=0;j<colLength;j++)
			{
				if(matrix[i][j]==1 && visited[i][j]==0)
				{
					count++;
					dfs(matrix,i,j,visited,rowLength,colLength);
				}
			}
		}
		//number of connected components
		System.out.println(count);
	}

	private static void dfs(int[][] matrix, int i, int j, int[][] visited,int rowLength,int colLength) {
		visited[i][j]=1;
		for(int r=-1;r<=1;r++)
		{
			for(int c=-1;c<=1;c++)
			{
				int currentRow = i + r;
				int currentCol = j + c;
				if(isValid(currentRow,currentCol,rowLength,colLength) 
						&& matrix[currentRow][currentCol]==1 && visited[currentRow][currentCol]==0)
				{
					dfs(matrix,currentRow,currentCol,visited,rowLength,colLength);
				}
			}
		}
			
	}
	
	public static boolean isValid(int r,int c,int rowLength,int colLength)
	{
		return r>=0 && c>=0 && r<rowLength && c<colLength;
	}
}
