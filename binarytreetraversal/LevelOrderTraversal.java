package binarytreetraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	public static void print(Node root)
	{
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node node = q.poll();
			System.out.print(node.data+" ");
			if(node.left!=null)
			{
				q.add(node.left);
			}
			if(node.right!=null)
			{
				q.add(node.right);
			}
		}
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			int size = q.size();
            List<Integer> subAnswer=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node = q.poll();
                subAnswer.add(node.val);
                if(node.left!=null)
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }
            }
            ans.add(new ArrayList<>(subAnswer));
		}
        return ans;
    }
}
