package minimumspanninganddisjoint;

import java.util.ArrayList;

public class DisjointSetUnionByRank {
	ArrayList<Integer> parent;
	ArrayList<Integer> rank;
	public DisjointSetUnionByRank(int size)
	{
		parent=new ArrayList<>();
		rank=new ArrayList<>();
		for(int i=0;i<size;i++)
		{
			//considering the size greater than the edges
			parent.add(i);
			rank.add(0);
		}
	}
	
	public int findParent(int x)
	{
		if(parent.get(x)==x)
		{
			return x;
		}
		int xParent = findParent(parent.get(x));
		parent.set(x, xParent);
		return xParent;
	}
	
	public void unionByRank(int u,int v)
	{
		u = findParent(u);
		v = findParent(v);
		if(u==v)
			return;
		if(rank.get(u)<rank.get(v))
		{
			parent.set(u,v);
		}
		else if(rank.get(v)<rank.get(u))
		{
			parent.set(v,u);
		}
		else
		{
			int rankOfU = parent.get(v);
			parent.set(u, v);
			rank.set(v, rankOfU+1);
		}
	}
	public static void main(String[] args) {
		DisjointSetUnionByRank disjointset=new DisjointSetUnionByRank(5);
		System.out.println(disjointset.findParent(0));
		disjointset.unionByRank(0, 1);
		disjointset.unionByRank(1, 2);
		disjointset.unionByRank(2, 3);
		System.out.println(disjointset.findParent(0));
		System.out.println(disjointset.findParent(1));
		System.out.println(disjointset.findParent(2));
		System.out.println(disjointset.findParent(3));
	}
}
