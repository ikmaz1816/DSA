package graphpathproblems;

public class FloydWarshall {
	 public void shortest_distance(int[][] matrix)
	    {
	        int n = matrix.length;
	        //this is a multisource path to root algorithm
	        
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                if(matrix[i][j]==-1)
	                    matrix[i][j]=(int)1e9;
	            }
	        }
	        for(int k=0;k<n;k++)
	        {
	            for(int i=0;i<n;i++)
	            {
	                for(int j=0;j<n;j++)
	                {
	                    if(matrix[i][k]==(int)1e9 || matrix[k][j]==(int)1e9)
	                        continue;
	                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
	                }
	            }
	        }
	        
	        //for checking if there is negative cycle
	        for(int i=0;i<n;i++)
	        {
	            if(matrix[i][i]<0)
	                return;
	        }
	        
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                if(matrix[i][j]==(int)1e9)
	                    matrix[i][j]=-1;
	            }
	        }
	    }
}
