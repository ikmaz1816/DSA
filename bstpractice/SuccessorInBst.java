package bstpractice;

import binarytreetraversal.Node;

public class SuccessorInBst {
	public Node inorderSuccessor(Node root,Node x)
    {
        if (root == null) return root;
        Node current = root;
        Node ans = null;
        while(current!=null)
        {
            if(current.data>x.data)
            {
                ans = current;
                current=current.left;
            }
            else
                current = current.right;
        }
        return ans;
    }
}
