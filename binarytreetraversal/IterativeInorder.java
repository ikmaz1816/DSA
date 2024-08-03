package binarytreetraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode current = root;
        while(true)
        {
            if(current!=null){
                st.push(current);
                current=current.left;
            }
            else
            {
                if(st.isEmpty())
                    break;
                current=st.pop();
                ans.add(current.val);
                current=current.right;
            }
        }
        return ans;
    }
}
