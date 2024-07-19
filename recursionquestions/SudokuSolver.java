package recursionquestions;

public class SudokuSolver {
	public static void main(String[] args) {
		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
             };
		if(solve(grid,0,0,grid.length,grid[0].length))
		{
			print(grid);
		}
		else
		{
			System.out.println("Not possible");
		}
	}
	
	private static boolean solve(int[][] grid, int r, int c, int rowlength, int collength) {
		if(r==rowlength-1 && c==collength)
		{
			return true;
		}
		if(c==collength)
		{
			return solve(grid,r+1,0,rowlength,collength);
		}
		if(grid[r][c]!=0)
			return solve(grid,r,c+1,rowlength,collength);
		for(int i=1;i<=9;i++)
		{
			if(isSafe(grid,i,r,c,rowlength,collength))
			{
				grid[r][c] = i;
				if(solve(grid,r,c+1,rowlength,collength))
				{
					return true;
				}
				grid[r][c] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] grid, int target, int r, int c, int rowlength, int collength) {
		for(int i=0;i<rowlength;i++)
		{
			if(grid[r][i]==target)
				return false;
		}
		for(int i=0;i<collength;i++)
		{
			if(grid[i][c]==target)
				return false;
		}
		int sqrt = (int)Math.sqrt(rowlength);
		int rstart = r - (r%sqrt);
		int cstart = c- (c%sqrt);
		for(int i=rstart;i<rstart+3;i++)
		{
			for(int j=cstart;j<cstart+3;j++)
			{
				if(grid[i][j]==target)
					return false;
			}
		}
		return true;
	}

	public static void print(int[][] queen)
	{
		for(int[] row:queen)
		{
			for(int col:row)
			{
				System.out.print(col+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
