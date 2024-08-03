package binarytreemediumproblem;

import java.util.ArrayList;
import java.util.List;

import binarytreetraversal.TreeNode;

public class RightViewOfBinaryTree {
	 public void getRightView(TreeNode root,List<Integer> ls,int index)
	    {
	        if(root==null)
	            return;
	        if(ls.size()==index)
	            ls.add(root.val);
	        getRightView(root.right,ls,index+1);
	        getRightView(root.left,ls,index+1);
	        
	    }
	    public List<Integer> rightSideView(TreeNode root) {
	        List<Integer> ls = new ArrayList<>();
	        getRightView(root,ls,0);
	        return ls;
	    }
}
