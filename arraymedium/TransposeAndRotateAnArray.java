package arraymedium;

public class TransposeAndRotateAnArray {
	 public void transpose(int[][] matrix)
	    {
	        int rowlength = matrix.length;
	        int columnlength = matrix[0].length;
	        for(int i=0;i<rowlength;i++)
	        {
	            for(int j=i+1;j<columnlength;j++)
	            {
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[j][i];
	                matrix[j][i] = temp;
	            }
	        }
	        for(int i[]:matrix)
	        {
	            for(int j:i)
	            {
	                System.out.print(j+" ");
	            }
	            System.out.println();
	        }
	    }
	    public void swapMatrix(int[][] matrix)
	    {
	        int start = 0;
	        int end = matrix.length - 1;
	        int columnlength = matrix[0].length;
	        while(start<end)
	        {
	            for(int i=0;i<columnlength;i++)
	            {
	                int temp = matrix[start][i];
	                matrix[start][i] = matrix[end][i];
	                matrix[end][i] = temp;
	            }
	            start++;
	            end--;
	        }
	        for(int i[]:matrix)
	        {
	            for(int j:i)
	            {
	                System.out.print(j+" ");
	            }
	            System.out.println();
	        }
	    }
	    public void rotate(int[][] matrix) {
	        swapMatrix(matrix);
	        transpose(matrix);
	        
	    }
}
