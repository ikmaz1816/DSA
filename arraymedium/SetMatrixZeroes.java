package arraymedium;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
        int rowlength = matrix.length;
        int collength = matrix[0].length;
        int col=1;
        for(int i=0;i<rowlength;i++)
        {
            if(matrix[i][0]==0)
                col=0;
            for(int j=1;j<collength;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=rowlength-1;i>=0;i--)
        {
            for(int j=collength-1;j>=1;j--)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
            if(col==0)
                matrix[i][0]=0;
        }
    }
}
