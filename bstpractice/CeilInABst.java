package bstpractice;

import binarytreetraversal.Node;

public class CeilInABst {
	int findCeil(Node root, int key) {
        if (root == null) return -1;
        Node current = root;
        int ans = -1;
        while(current!=null)
        {
            if(current.data==key)
            {
                ans=current.data;
                break;
            }
            if(current.data>key)
            {
                ans = current.data;
                current=current.left;
            }
            else
                current = current.right;
        }
        return ans;
	}
}
