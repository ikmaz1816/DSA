package arraymedium;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiral {
	public List<Integer> spiralOrder(int[][] matrix) {
		int rs=0;
        int cs=0;
        int re=matrix.length-1;
        int ce=matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        int count=0;
        while(rs<=re && cs<=ce)
        {
        	if(count%4==0)
        	{
	            for(int i=cs;i<=ce;i++)
	            {
	                ans.add(matrix[rs][i]);
	            }
	            rs++;
        	}
        	if(count%4==1)
        	{
	            for(int i=rs;i<=re;i++)
	            {
	                ans.add(matrix[i][ce]);
	            }
	            ce--;
        	}
        	if(count%4==2)
        	{
	            for(int i=ce;i>=cs;i--)
	            {
	                ans.add(matrix[re][i]);
	            }
	            re--;
        	}
        	if(count%4==3)
        	{
	            for(int i=re;i>=rs;i--)
	            {
	                ans.add(matrix[i][cs]);
	            }
	            cs++;
        	}
        	count++;
        }
       return ans;
    }
}
