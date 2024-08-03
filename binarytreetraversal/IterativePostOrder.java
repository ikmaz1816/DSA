package binarytreetraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Stack<TreeNode> st=new Stack<>();
        TreeNode current = root;
        while(current!=null || !st.isEmpty())
        {
            if(current!=null)
            {
                st.push(current);
                current=current.left;
            }
            else
            {
                TreeNode temp = st.peek().right;
                if(temp==null)
                {
                    temp = st.pop();
                    ans.add(temp.val);
                    while(!st.isEmpty() && temp==st.peek().right)
                    {
                        temp=st.pop();
                        ans.add(temp.val);
                    }
                }
                else
                    current=temp;
            }
        }
        return ans;
    }
}
