package binarytreehard;

import java.util.ArrayList;
import java.util.List;

import binarytreetraversal.TreeNode;

public class MorrisPreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode current=root;
        while(current!=null)
        {
            if(current.left==null)
            {
                ans.add(current.val);
                current=current.right;
            }
            else
            {
                TreeNode prev = current.left;
                while(prev.right!=null && prev.right!=current)
                {
                    prev=prev.right;
                }
                if(prev.right==null)
                {
                    prev.right=current;
                    ans.add(current.val);
                    current=current.left;
                }
                else
                {
                    prev.right=null;
                    current=current.right;
                }
            }
        }
        return ans;
    }
}
