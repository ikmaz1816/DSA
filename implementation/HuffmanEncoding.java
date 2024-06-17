package implementation;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class HuffNode
{
	Character ch;
	int count;
	HuffNode left;
	HuffNode right;
	
	public HuffNode(Character ch,Integer count)
	{
		this.ch=ch;
		this.count = count;
	}
}

class MyComparator implements Comparator<HuffNode>
{

	@Override
	public int compare(HuffNode o1, HuffNode o2) {
		return o1.count - o2.count;
	}
	
}
public class HuffmanEncoding {
	public static void main(String[] args) {
		String string = "aaaabbbccd";
		printEncoding(string);
	}

	private static void printEncoding(String string) {
		PriorityQueue<HuffNode> pq=new PriorityQueue<>(new MyComparator());
		HashMap<Character,Integer> map=new HashMap<>();
		int length = string.length();
		for(int i=0;i<length;i++)
		{
			map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0)+1);
		}
		
		for(Map.Entry<Character, Integer> m: map.entrySet())
		{
			HuffNode p = new HuffNode(m.getKey(),m.getValue());
			pq.offer(p);
		}
		
		HuffNode root = null;
		while(pq.size()>1)
		{
			HuffNode p1 = pq.poll();
			HuffNode p2 = pq.poll();
			
			HuffNode node = new HuffNode('-',p1.count+p2.count);
			node.left=p1;
			node.right=p2;
			
			root=node;
			pq.add(node);
		}
		print(root,"");
	}
	
	private static void print(HuffNode root, String str)
	{
		if(root.left==null && root.right==null && Character.isAlphabetic(root.ch))
		{
			System.out.println(root.ch + " "+ str);
			return;
		}
		
		print(root.left, str+'0');
		print(root.right,str+'1');
	}
}
