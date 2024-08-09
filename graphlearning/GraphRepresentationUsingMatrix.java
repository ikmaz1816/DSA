package graphlearning;

import java.util.Scanner;

public class GraphRepresentationUsingMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//number of vertex-> considering zero based indexing
		int n = sc.nextInt();
		int[][] matrix = new int[n+1][n+1];
		
		//getting the number of edges
		/*
		 	Types of graph -> Directed and undirected
		 	undirected 0 -> 1 then 1 -> 0 it is a birectional graph
		 	edges would be on both the ends
		 	
		 	directed 
		 	It is unidirectional
		 	0 -> 1
		 */
		int m = sc.nextInt();
		for(int i=0;i<m;i++)
		{
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			if(vertex1 >= n+1 || vertex2 >= n+1)
			{
				i--;
			}
			
			// for undirected
			matrix[vertex1][vertex2]=1;
			matrix[vertex2][vertex1]=1;
			
			/*
			 	for directed, matrix[vertex1][vertex2]=1;
			 */
		}
		
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(matrix[i][j]==1)
				{
					System.out.println("There is a edge between "+i+" and "+j);
				}
			}
			
		}
		sc.close();
	}
}
