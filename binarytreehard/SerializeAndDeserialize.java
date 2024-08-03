package binarytreehard;

import java.util.LinkedList;
import java.util.Queue;

import binarytreetraversal.TreeNode;

public class SerializeAndDeserialize {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node==null)
            {
                sb.append("n ");
                continue;
            }
            else
                sb.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)
            return null;
        String[] d=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(d[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        for(int i=1;i<d.length;i++)
        {
            TreeNode node = q.poll();
            if(!d[i].equals("n"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(d[i]));
                node.left=left;
                q.add(left);
            }
            if(!d[++i].equals("n"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(d[i]));
                node.right=right;
                q.add(right);
            }
        }
        return root;
    }
}
