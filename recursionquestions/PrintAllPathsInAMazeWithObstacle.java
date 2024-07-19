package recursionquestions;

public class PrintAllPathsInAMazeWithObstacle {
	public static void main(String[] args) {
		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		printAllPaths(matrix,0,0,matrix.length,matrix[0].length,"");
	}

	private static void printAllPaths(int[][] matrix, int r, int c, int rowlength, int collength,String ans) {
		if(r==rowlength-1 && c==collength-1 && matrix[r][c]!=0)
		{
			System.out.println(ans);
			return;
		}
		
		if(matrix[r][c]==0)
			return;
		matrix[r][c]=0;
		if(r<rowlength-1 && c<collength-1)
			printAllPaths(matrix,r+1,c+1,rowlength,collength,ans+'V');
		if(r<rowlength-1)
			printAllPaths(matrix,r+1,c,rowlength,collength,ans+'D');
		if(c<collength-1)
			printAllPaths(matrix,r,c+1,rowlength,collength,ans+'R');
		if(r>0)
			printAllPaths(matrix,r-1,c,rowlength,collength,ans+'U');
		if(c>0)
			printAllPaths(matrix,r,c-1,rowlength,collength,ans+'L');
		matrix[r][c]=1;
	}
}
