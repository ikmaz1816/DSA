package binarytreemediumproblem;

import java.util.ArrayList;
import java.util.List;

import binarytreetraversal.TreeNode;

public class LeftViewOfBinaryTree {
	 public void getLeftView(TreeNode root,List<Integer> ls,int index)
	    {
	        if(root==null)
	            return;
	        if(ls.size()==index)
	            ls.add(root.val);
	        getLeftView(root.left,ls,index+1);
		    getLeftView(root.right,ls,index+1);
	           
	    }
	    public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> ls = new ArrayList<>();
	        getLeftView(root,ls,0);
	        return ls;
	    }
}
