package binarysearch2d;

public class PeakElementInMatrix {
	public int[] findPeakGrid(int[][] mat) {
        int startrow = 0;
        int endrow = mat.length-1;
        int rowlength = mat.length-1;
        while(startrow<=endrow)
        {
            int midrow = startrow + (endrow-startrow)/2;
            int max = Integer.MIN_VALUE;
            int column = -1;
            int length = mat[midrow].length;
            for(int i=0;i<length;i++)
            {
                if(max<mat[midrow][i])
                {
                    max=mat[midrow][i];
                    column=i;
                }
            } 
            if(startrow==endrow)
                return new int[]{midrow,column};
            if(midrow==0)
            {
                if(mat[midrow][column]>mat[midrow+1][column])
                    return new int[]{midrow,column};
            }
            if(midrow==rowlength)
            {
                if(mat[midrow][column]>mat[midrow-1][column])
                    return new int[]{midrow,column};
            }
            if(mat[midrow][column]>mat[midrow+1][column] && mat[midrow][column]>mat[midrow-1][column])
                    return new int[]{midrow,column};
            else if(mat[midrow][column]<mat[midrow+1][column])
                startrow=midrow+1;
            else
                endrow=midrow-1;
        }
        return new int[]{-1,-1};
    }
}
