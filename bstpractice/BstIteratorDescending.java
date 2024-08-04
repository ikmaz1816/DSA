package bstpractice;

import java.util.Stack;

import binarytreetraversal.TreeNode;

public class BstIteratorDescending {
	Stack<TreeNode> st;
    public BstIteratorDescending(TreeNode root) {
        st=new Stack<>();
        pushAll(root);
    }
    
    public void pushAll(TreeNode root)
    {
        while(root!=null)
        {
            st.push(root);
            root=root.right;
        }
    }

    public int next() {
        if(st.isEmpty())
            return -1;
        TreeNode current = st.pop();
        pushAll(current.left);
        return current.val;
    }
    
    public boolean hasNext() {
        return st.size()!=0;
    }
}
