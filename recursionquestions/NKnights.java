package recursionquestions;

public class NKnights {
	public static void main(String[] args) {
		boolean[][] knights=new boolean[4][4];
		solve(knights,0,0,knights.length,knights[0].length,4);
	}
	
	private static void solve(boolean[][] knight, int r, int c, int rowlength, int collength,int target) {
		if(target==0)
		{
			print(knight);
			return;
		}
		if(r==rowlength)
		{
		    return;
		}
		if(c==collength)
		{
			solve(knight,r+1,0,rowlength,collength,target);
			return;
		}
		if(isSafe(knight,r,c,rowlength,collength))
		{
			knight[r][c]=true;
			solve(knight,r,c+1,rowlength,collength,target-1);
			knight[r][c]=false;
		}
		solve(knight,r,c+1,rowlength,collength,target);
	}
	
	public static void print(boolean[][] knight)
	{
		for(boolean[] row:knight)
		{
			for(boolean col:row)
			{
				if(col)
					System.out.print("K ");
				else
					System.out.print("X ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static boolean isValid(int r,int c,int rowlength,int collength)
	{
		return r>=0 && r<rowlength && c>=0 && c<collength;
	}
	private static boolean isSafe(boolean[][] knight, int r, int c, int rowlength, int collength) {
		if(isValid(r-1,c-2,rowlength,collength))
		{
			if(knight[r-1][c-2])
				return false;
		}
		if(isValid(r-1,c+2,rowlength,collength))
		{
			if(knight[r-1][c+2])
				return false;
		}
		if(isValid(r-2,c-1,rowlength,collength))
		{
			if(knight[r-2][c-1])
				return false;
		}
		if(isValid(r-2,c+1,rowlength,collength))
		{
			if(knight[r-2][c+1])
				return false;
		}
		return true;
	}
}
