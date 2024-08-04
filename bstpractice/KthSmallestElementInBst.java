package bstpractice;

import binarytreetraversal.TreeNode;

public class KthSmallestElementInBst {
	public int kthSmallest(TreeNode root, int k) {
        int[] max=new int[1];
        int[] ans = new int[1];
        kthsmallest(root,k,ans,max);
        return ans[0];
        //the same question can be approached using morris traversal as well 
    }

    public void kthsmallest(TreeNode root,int k,int[] ans,int[] max)
    {
        if(root==null || k==0)
        {
            return;
        }
        kthsmallest(root.left,k,ans,max);
        max[0]++;
        if(max[0]==k)
        {
            ans[0] = root.val;
            k=0;
            return;
        }
        kthsmallest(root.right,k,ans,max);
    }
    
    public int kthSmallestMorris(TreeNode root, int k) {
        TreeNode current = root;
        int count=0;
        int ans =0;
        while(current!=null)
        {
            if(current.left==null)
            {
                count++;
                if(count==k)
                {
                    ans = current.val;
                    break;
                }
                current = current.right;
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
                    current=current.left;
                }
                else
                {
                    count++;
                    if(count==k)
                    {
                        ans = current.val;
                        break;
                    }
                    prev.right=null;
                    current = current.right;
                }
            }
        }
        return ans;
    }
}	
