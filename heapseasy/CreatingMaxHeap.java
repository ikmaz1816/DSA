package heapseasy;

import java.util.ArrayList;

public class CreatingMaxHeap {
	private ArrayList<Integer> tree;
	public CreatingMaxHeap()
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
			if(tree.get(parentindex)<tree.get(index))
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
			int maxindex = parentIndex;
			if(tree.get(maxindex)<tree.get(leftindex))
				maxindex = leftindex;
			if(rightindex<size() && tree.get(maxindex)<tree.get(rightindex))
				maxindex = rightindex;
			if(maxindex == parentIndex)
				break;
			int temp = tree.get(parentIndex);
			tree.set(parentIndex, tree.get(maxindex));
			tree.set(maxindex, temp);
			parentIndex = maxindex;
			leftindex = parentIndex * 2 + 1;
			rightindex = parentIndex * 2 + 2;
		}
		return element;
	}
	public static void main(String[] args) {
		CreatingMaxHeap CreatingMaxHeap=new CreatingMaxHeap();
		CreatingMaxHeap.addElement(100);
		CreatingMaxHeap.addElement(70);
		CreatingMaxHeap.addElement(60);
		CreatingMaxHeap.addElement(80);
		CreatingMaxHeap.addElement(40);
		
		System.out.println(CreatingMaxHeap.tree);
		System.out.println(CreatingMaxHeap.removeMin());
		System.out.println(CreatingMaxHeap.tree);
		System.out.println(CreatingMaxHeap.removeMin());
		System.out.println(CreatingMaxHeap.removeMin());
		System.out.println(CreatingMaxHeap.removeMin());
		System.out.println(CreatingMaxHeap.removeMin());
	}
}
