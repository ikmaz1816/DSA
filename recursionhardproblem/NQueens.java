package recursionhardproblem;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public void solve(boolean[][] board,int r,int c,int n,int length,List<List<String>> ans)
    {
        if(n==0)
        {
            
            List<String> partAnswer = new ArrayList<>();
            for(boolean[] row:board)
            {
                String str = new String();
                for(boolean col:row)
                {
                    if(col)
                        str+="Q";
                    else
                        str+=".";
                }
                partAnswer.add(str); 
            }
            ans.add(new ArrayList<>(partAnswer));
        }
        if(r==length)
        {
            return;
        }
        if(c==length)
        {
            solve(board,r+1,0,n,length,ans);
            return;
        }
        if(isSafe(board,r,c,length))
        {
            board[r][c] = true;
            solve(board,r+1,0,n-1,length,ans);
            board[r][c] = false;
        }
        solve(board,r,c+1,n,length,ans);
    }

    public boolean isSafe(boolean[][] board,int r,int c,int length)
    {
        for(int i=0;i<r;i++)
        {
            if(board[i][c])
                return false;
        }
        int maxLeft=Math.min(r,c);
        int maxRight=Math.min(r,length-c-1);
        for(int i=1;i<=maxLeft;i++)
        {
            if(board[r-i][c-i])
                return false;
        }
        for(int i=1;i<=maxRight;i++)
        {
            if(board[r-i][c+i])
                return false;
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        solve(board,0,0,n,n,ans);
        return ans;
    }
}
