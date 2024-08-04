package bstpractice;

import binarytreetraversal.TreeNode;

public class KthLargestElementInBst {
	public int kthSmallest(TreeNode root, int k) {
        int[] max=new int[1];
        int[] ans = new int[1];
        kthlargest(root,k,ans,max);
        return ans[0];
        //the same question can be approached using morris traversal as well 
    }

    public void kthlargest(TreeNode root,int k,int[] ans,int[] max)
    {
        if(root==null || k==0)
        {
            return;
        }
        kthlargest(root.right,k,ans,max);
        max[0]++;
        if(max[0]==k)
        {
            ans[0] = root.val;
            k=0;
            return;
        }
        kthlargest(root.left,k,ans,max);
    }
    
    public int kthSmallestMorrisTraversal(TreeNode root, int k) {
        TreeNode current = root;
        int count=0;
        int ans =0;
        while(current!=null)
        {
            if(current.right==null)
            {
                count++;
                if(count==k)
                {
                    ans = current.val;
                    break;
                }
                current = current.left;
            }
            else
            {
                TreeNode prev = current.right;
                while(prev.left!=null && prev.left!=current)
                {
                    prev=prev.left;
                }
                if(prev.left==null)
                {
                    prev.left=current;
                    current=current.right;
                }
                else
                {
                    count++;
                    if(count==k)
                    {
                        ans = current.val;
                        break;
                    }
                    prev.left=null;
                    current = current.left;
                }
            }
        }
        return ans;
    }
}	
