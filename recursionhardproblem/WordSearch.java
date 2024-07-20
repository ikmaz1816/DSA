package recursionhardproblem;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        int rowlength = board.length;
        int collength = board[0].length;
        for(int i=0;i<rowlength;i++)
        {
            for(int j=0;j<collength;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(searchWord(board,word,i,j,rowlength,collength,0))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean searchWord(char[][] board,String word,int r,int c,int rowlength,int collength,int index)
    {
        if(index==word.length())
        {
            return true;
        }
        if(r<0 || c<0 || r>=rowlength || c>=collength || board[r][c]==' ' || board[r][c]!=word.charAt(index))
            return false;
        board[r][c]=' ';
        if(searchWord(board,word,r+1,c,rowlength,collength,index+1)
        || searchWord(board,word,r,c+1,rowlength,collength,index+1)
        || searchWord(board,word,r-1,c,rowlength,collength,index+1)
        || searchWord(board,word,r,c-1,rowlength,collength,index+1))
            return true;
        board[r][c]=word.charAt(index);
        return false;
    }
}
