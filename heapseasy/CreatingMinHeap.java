package heapseasy;

import java.util.ArrayList;

public class CreatingMinHeap {
	private ArrayList<Integer> tree;
	public CreatingMinHeap()
	{
		tree=new ArrayList<>();
	}
	public boolean isEmpty()
	{
		return size()==0;
	}
	public int size()
	{
		return tree.size();
	}
	public int getMin()
	{
		if(isEmpty())
			return -1;
		return tree.get(0);
	}
	public void addElement(int element)
	{
		tree.add(element);
		int index = size()-1;
		int parentindex = (index-1)/2;
		while(parentindex>=0)
		{
			if(tree.get(parentindex)>tree.get(index))
			{
				int temp = tree.get(parentindex);
				tree.set(parentindex, tree.get(index));
				tree.set(index, temp);
				index = parentindex;
				parentindex = (index-1)/2;
			}
			else
				break;
		}
	}
	public int removeMin()
	{
		if(isEmpty())
			return -1;
		int element = tree.get(0);
		tree.set(0, tree.get(tree.size()-1));
		tree.remove(tree.size()-1);
		int parentIndex = 0;
		int leftindex = parentIndex * 2 + 1;
		int rightindex = parentIndex * 2 + 2;
		while(leftindex<size())
		{
			int minindex = parentIndex;
			if(tree.get(minindex)>tree.get(leftindex))
				minindex = leftindex;
			if(rightindex<size() && tree.get(minindex)>tree.get(rightindex))
				minindex = rightindex;
			if(minindex == parentIndex)
				break;
			int temp = tree.get(parentIndex);
			tree.set(parentIndex, tree.get(minindex));
			tree.set(minindex, temp);
			parentIndex = minindex;
			leftindex = parentIndex * 2 + 1;
			rightindex = parentIndex * 2 + 2;
		}
		return element;
	}
	public static void main(String[] args) {
		CreatingMinHeap CreatingMinHeap=new CreatingMinHeap();
		CreatingMinHeap.addElement(100);
		CreatingMinHeap.addElement(60);
		CreatingMinHeap.addElement(80);
		CreatingMinHeap.addElement(70);
		CreatingMinHeap.addElement(40);
		
		System.out.println(CreatingMinHeap.tree);
		System.out.println(CreatingMinHeap.removeMin());
		System.out.println(CreatingMinHeap.tree);
		System.out.println(CreatingMinHeap.removeMin());
		System.out.println(CreatingMinHeap.removeMin());
		System.out.println(CreatingMinHeap.removeMin());
		System.out.println(CreatingMinHeap.removeMin());
	}
}
