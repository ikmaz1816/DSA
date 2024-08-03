package binarytreemediumproblem;

import binarytreetraversal.TreeNode;

class Diameter
{
   int diameter;
   int height;
   public Diameter(int diameter,int height)
   {
       this.diameter=diameter;
       this.height=height;
   }
}
public class MaxDiameterInABinaryTree {
	public Diameter getDiameter(TreeNode root)
    {
        if(root==null)
            return new Diameter(0,0);
        Diameter left = getDiameter(root.left);
        Diameter right = getDiameter(root.right);

        int leftHeight = left.height;
        int rightHeight = right.height;
        int maxHeight = 1 + Math.max(leftHeight,rightHeight);

        int diameterLeft = left.diameter;
        int diameterRight = right.diameter;
        int diameterRoot = 1 + leftHeight + rightHeight;

        int maxDiameter = Math.max(diameterLeft,Math.max(diameterRight,diameterRoot));
        return new Diameter(maxDiameter,maxHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return getDiameter(root).diameter -1;
    }
}
