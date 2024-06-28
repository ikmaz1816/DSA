package llmediumproblem;

public class BubbleSortLL {
	 public int size(ListNode head)
	    {
	        int size=0;
	        ListNode temp = head;
	        while(temp!=null)
	        {
	            size++;
	            temp=temp.next;
	        }
	        return size;
	    }

	    public ListNode getNode(ListNode head,int index)
	    {
	        ListNode temp = head;
	        for(int i=0;i<index-1;i++)
	        {
	            temp=temp.next;
	        }
	        return temp;
	    }

	    public ListNode sortList(ListNode head) {
	        int n = size(head);
	        for(int i=0;i<n-1;i++)
	        {
	            for(int j=0;j<n-i;j++)
	            {
	                ListNode first = getNode(head,j);
	                ListNode second = getNode(head,j+1);
	                if(first.val>second.val)
	                {
	                    int temp = first.val;
	                    first.val = second.val;
	                    second.val = temp;
	                }
	            }
	        }
	        return head;
	    }
}
