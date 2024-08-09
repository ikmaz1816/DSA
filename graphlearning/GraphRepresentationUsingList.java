package graphlearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphRepresentationUsingList {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//number of vertex-> considering zero based indexing
		int n = sc.nextInt();
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<=n;i++)
		{
			adj.add(new ArrayList<>());
		}
		
		//getting the number of edges
		int m = sc.nextInt();
		for(int i=0;i<m;i++)
		{
			int vertex1 = sc.nextInt();
			int vertex2 = sc.nextInt();
			if(vertex1 >= n+1 || vertex2 >= n+1)
			{
				i--;
			}
			//for undirected
			adj.get(vertex1).add(vertex2);
			adj.get(vertex2).add(vertex1);
			
			/* for directed
				adj.get(vertex1).add(vertex2);
			*/
		}
		
		for(int i=0;i<=n;i++)
		{
			System.out.print(i+":");
			for(int j:adj.get(i))
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
