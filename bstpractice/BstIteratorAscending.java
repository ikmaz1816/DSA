package bstpractice;

import java.util.Stack;

import binarytreetraversal.TreeNode;

public class BstIteratorAscending {
	Stack<TreeNode> st;
    public BstIteratorAscending(TreeNode root) {
        st=new Stack<>();
        pushAll(root);
    }
    
    public void pushAll(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root=root.left;
        }
    }

    public int next() {
        if(st.isEmpty())
            return -1;
        TreeNode current = st.pop();
        pushAll(current.right);
        return current.val;
    }
    
    public boolean hasNext() {
        return st.size()!=0;
    }
}
