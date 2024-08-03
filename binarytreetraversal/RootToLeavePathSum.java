package binarytreetraversal;

import java.util.ArrayList;

public class RootToLeavePathSum {
	public static void sumOfNodes(Node root,ArrayList<Integer> sum)
	{
		if(root.left==null && root.right==null)
		{
			sum.add(root.data);
			System.out.println(sum);
			System.out.println(sum.stream().reduce(0,(c,e)->c+e));
			sum.remove(sum.size()-1);
			return;
		}
		sum.add(root.data);
		sumOfNodes(root.left,sum);
		sumOfNodes(root.right,sum);
		sum.remove(sum.size()-1);
	}
	public static void main(String[] args) {
		Node root=CreateTree.createTree();
		sumOfNodes(root,new ArrayList<>());
	}
}
