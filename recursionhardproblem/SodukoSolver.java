package recursionhardproblem;

public class SodukoSolver {
	public boolean solve(char[][] board,int r,int c,int length)
    {
        if(r==length-1 && c==length)
        {
            return true;
        }
        if(c==length)
            return solve(board,r+1,0,length);
        if(board[r][c]!='.')
            return solve(board,r,c+1,length);
        for(int i=1;i<=9;i++)
        {
            char ch = (char)(i+'0');
            if(isSafe(board,r,c,ch,length))
            {
                board[r][c] = ch;
                if(solve(board,r,c+1,length))
                {
                    return true;
                }
                board[r][c] = '.';
            }
        }
        return false;
        
    }
    public boolean isSafe(char[][] board,int r,int c,char num,int length)
    {
        for(int i=0;i<length;i++)
        {
            if(board[i][c]==num)
                return false;
        }

        for(int i=0;i<length;i++)
        {
            if(board[r][i]==num)
                return false;
        }

        int sqrt = (int)Math.sqrt(length);
        int rstart = r- (r%sqrt);
        int cstart = c -(c%sqrt);
        for(int i=rstart;i<rstart+3;i++)
        {
            for(int j=cstart;j<cstart+3;j++)
            {
                if(board[i][j]==num)
                    return false;
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        int length = board.length;
        solve(board,0,0,length);
    }
}
