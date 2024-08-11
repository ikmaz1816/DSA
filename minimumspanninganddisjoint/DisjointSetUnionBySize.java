package minimumspanninganddisjoint;

import java.util.ArrayList;

public class DisjointSetUnionBySize {
	ArrayList<Integer> parent;
	ArrayList<Integer> size;
	private int capacity;
	public DisjointSetUnionBySize(int capacity)
	{
		parent=new ArrayList<>();
		size=new ArrayList<>();
		this.capacity=capacity;
		for(int i=0;i<capacity;i++)
		{
			//considering the size greater than the edges
			parent.add(i);
			size.add(1);
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
	
	public void unionBySize(int u,int v)
	{
		u = findParent(u);
		v = findParent(v);
		if(u==v)
			return;
		if(size.get(u)<size.get(v))
		{
			parent.set(u,v);
			size.set(v, size.get(u)+size.get(v));
		}
		else
		{
			parent.set(v,u);
			size.set(u, size.get(u)+size.get(v));
		}
	}
	
	public int components()
	{
		int count=0;
		for(int i=0;i<capacity;i++)
		{
			if(i==findParent(i))
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		DisjointSetUnionBySize disjointset=new DisjointSetUnionBySize(5);
		System.out.println(disjointset.findParent(0));
		disjointset.unionBySize(1, 0);
		disjointset.unionBySize(1, 2);
		disjointset.unionBySize(2, 3);
		System.out.println(disjointset.findParent(0));
		System.out.println(disjointset.findParent(1));
		System.out.println(disjointset.findParent(2));
		System.out.println(disjointset.findParent(3));
		System.out.println(disjointset.size.get(1));
	}
}
