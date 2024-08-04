package bstpractice;

import binarytreetraversal.Node;

class LargestBst
{
    int size;
    int min;
    int max;
    public LargestBst(int size,int min,int max)
    {
        this.size=size;
        this.min=min;
        this.max=max;
    }
}
public class LargestBstInBt {
	static LargestBst largest(Node root)
    {
        if(root==null)
        {
            return new LargestBst(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        LargestBst left = largest(root.left);
        LargestBst right = largest(root.right);
        if(left.max<root.data && root.data<right.min)
        {
            return new LargestBst(1+left.size+right.size, Math.min(left.min,root.data),Math.max(right.max,root.data));
        }
        return new LargestBst(Math.max(left.size,right.size), Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    static int largestBst(Node root)
    {
        return largest(root).size;
    }
}
