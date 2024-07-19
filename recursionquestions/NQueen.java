package recursionquestions;

public class NQueen {
	public static void main(String[] args) {
		boolean[][] queen=new boolean[4][4];
		solve(queen,0,0,queen.length,queen[0].length,4);
	}
	
	private static void solve(boolean[][] queen, int r, int c, int rowlength, int collength,int target) {
		if(target==0)
		{
			print(queen);
			return;
		}
		if(r==rowlength)
		{
			return;
		}
		if(c==collength)
		{
			solve(queen,r+1,0,rowlength,collength,target);
			return;
		}
		if(isSafe(queen,r,c,rowlength,collength))
		{
			queen[r][c]=true;
			solve(queen,r+1,0,rowlength,collength,target-1);
			queen[r][c]=false;
		}
		solve(queen,r,c+1,rowlength,collength,target);
	}

	private static boolean isSafe(boolean[][] queen, int r, int c, int rowlength, int collength) {
		for(int i=0;i<rowlength;i++)
		{
			if(queen[i][c])
				return false;
		}
		int maxLeft = Math.min(r, c);
		int maxRight = Math.min(r, rowlength-c-1);
		for(int i=1;i<=maxLeft;i++)
		{
			if(queen[r-i][c-i])
				return false;
		}
		for(int i=1;i<=maxRight;i++)
		{
			if(queen[r-i][c+i])
				return false;
		}
		return true;
	}

	public static void print(boolean[][] queen)
	{
		for(boolean[] row:queen)
		{
			for(boolean col:row)
			{
				if(col)
					System.out.print("Q ");
				else
					System.out.print("X ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
