package bstbasics;

import binarytreetraversal.Node;

public class MaximumInABst {
	int maxValue(Node root) {
        if(root==null)
            return -1;
        Node current = root;
        while(current.right!=null)
        {
            current=current.right;
        }
        return current.data;
    }
}
