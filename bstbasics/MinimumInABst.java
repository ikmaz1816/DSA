package bstbasics;

import binarytreetraversal.Node;

public class MinimumInABst {
	int minValue(Node root) {
        if(root==null)
            return -1;
        Node current = root;
        while(current.left!=null)
        {
            current=current.left;
        }
        return current.data;
    }
}
