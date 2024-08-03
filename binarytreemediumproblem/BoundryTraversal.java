package binarytreemediumproblem;

import java.util.ArrayList;
import java.util.Collections;

import binarytreetraversal.Node;

public class BoundryTraversal {
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans=new ArrayList<>();
	    if(node==null)
	        return ans;
	    if(node.left==null && node.right==null)
	    {
	        ans.add(node.data);
	        return ans;
	    }
	    ans.add(node.data);
	    addLeftBoundry(node,ans);
	    addLeaves(node,ans);
	    addRightBoundry(node,ans);
	    return ans;
	}
	
	public boolean isLeafNode(Node node)
	{
	    return node.left==null && node.right==null;
	}
	
	public void addLeftBoundry(Node node,ArrayList<Integer> ans)
	{
	    Node current = node.left;
	    while(current!=null)
	    {
	        if(!isLeafNode(current)) 
	            ans.add(current.data);
	        if(current.left!=null)
	            current=current.left;
	        else
	            current=current.right;
	    }
	}
	
	public void addLeaves(Node node,ArrayList<Integer> ans)
	{
	    if(node==null)
	        return;
	    if(isLeafNode(node))
	    {
	        ans.add(node.data);
	        return;
	    }
	    addLeaves(node.left,ans);
	    addLeaves(node.right,ans);
	}
	
	public void addRightBoundry(Node node,ArrayList<Integer> ans)
	{
	    Node current = node.right;
	    ArrayList<Integer> reverseAns=new ArrayList<>();
	    while(current!=null)
	    {
	        if(!isLeafNode(current)) 
	            reverseAns.add(current.data);
	        if(current.right!=null)
	            current=current.right;
	        else
	            current=current.left;
	    }
	    Collections.reverse(reverseAns);
	    ans.addAll(reverseAns);
	}
}
