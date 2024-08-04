package bstpractice;

import binarytreetraversal.Node;

public class FloorInABst {
	public static int floor(Node root, int x) {
        Node current = root;
        int ans = -1;
        if(current==null)
        {
            return ans;
        }
        while(current!=null)
        {
            if(current.data==x)
            {
                ans = current.data;
                break;
            }
            else if(current.data<x)
            {
                ans = current.data;
                current=current.right;
            }
            else
                current=current.left;
        }
        return ans;
    }
}
