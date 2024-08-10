package graphpathproblems;

import java.util.Arrays;

public class FindTheCity {
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // int n = matrix.length;
	        //this is a multisource path to root algorithm
	        int[][] matrix = new int[n][n];
            for(int[] i:matrix)
                Arrays.fill(i,(int)1e9);
                
	        for(int i=0;i<edges.length;i++)
	        {
	            int u = edges[i][0];
                int v = edges[i][1];
                int w = edges[i][2];
                matrix[u][v]=w;
                matrix[v][u]=w;
	        }
	        for(int k=0;k<n;k++)
	        {
                matrix[k][k]=0;
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

            int city=-1;
	        int minCount=n;
	        for(int i=0;i<n;i++)
	        {
                int count=0;
	            for(int j=0;j<n;j++)
	            {
	                if(matrix[i][j]<=distanceThreshold)
	                    count++;
	            }
                if(count<=minCount)
                {
                    minCount=count;
                    city=i;
                }
	        }
        return city;
    }
}
