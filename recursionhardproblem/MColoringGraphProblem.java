package recursionhardproblem;

import java.util.Arrays;

public class MColoringGraphProblem {
	public boolean graphColoring(boolean graph[][], int m, int n) {
        int length = graph.length;
        int[] color = new int[length];
        Arrays.fill(color,-1);
        return solve(graph,color,m,0);
    }
    
    public boolean solve(boolean graph[][],int[] color,int m,int index)
    {
        if(index==graph.length)
            return true;
        
        for(int i=1;i<=m;i++)
        {
            if(isValid(graph,color,index,i))
            {
                color[index]=i;
                if(solve(graph,color,m,index+1))
                    return true;
                color[index]=-1;
            }
        }
        return false;
    }
    
    public boolean isValid(boolean[][] graph,int[] color,int index,int col)
    {
        int length = graph[index].length;
        for(int i=0;i<length;i++)
        {
            if(graph[index][i])
            {
                if(color[i]==col)
                    return false;
            }
        }
        return true;
    }
}
