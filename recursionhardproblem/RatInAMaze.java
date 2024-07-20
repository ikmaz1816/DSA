package recursionhardproblem;

import java.util.ArrayList;

public class RatInAMaze {
	public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        int rlength = mat.length;
        int clength = mat[0].length;
        if(mat[rlength-1][clength-1]==0) return ans;
        path(mat,0,0,rlength,clength,"",ans);
        return ans;
    }
    
    public void path(int[][] mat,int r,int c,int rowlength,int collength,String p,ArrayList<String> ans)
    {
        if(r==rowlength-1 && c==collength-1)
        {
            ans.add(p);
            return;
        }
        if(mat[r][c]==0)
            return;
        mat[r][c]=0;
        if(r<rowlength-1)
            path(mat,r+1,c,rowlength,collength,p+'D',ans);
        if(c<collength-1)
            path(mat,r,c+1,rowlength,collength,p+'R',ans);
        if(r>0)
            path(mat,r-1,c,rowlength,collength,p+'U',ans);
        if(c>0)
            path(mat,r,c-1,rowlength,collength,p+'L',ans); 
        mat[r][c]=1;
    }
}
