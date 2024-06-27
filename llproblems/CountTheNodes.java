package llproblems;

public class CountTheNodes {
	 public static int getCount(Node head)
	    {
	        
	       int count =0;
	       Node temp = head;
	       while(temp!=null)
	       {
	           temp=temp.next;
	           count++;
	       }
	       return count;
	    }
}
