package bstpractice;

import binarytreetraversal.TreeNode;

public class TwoSumInBst {
	public boolean findTarget(TreeNode root, int k) {
        BstIteratorAscending bstascending = new BstIteratorAscending(root);
        BstIteratorDescending bstdescending = new BstIteratorDescending(root);
        int i=bstascending.next();;
        int j=bstdescending.next();
        while(i < j)
        {
            int sum = i+j;
            if(sum==k)
                return true;
            else if(sum>k)
                j=bstdescending.next();
            else
                i=bstascending.next();
        }
        return false;
    }
}
