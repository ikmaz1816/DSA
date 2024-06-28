package llmediumproblem;

public class RecursiveReverseLL {
	 ListNode tail = null,actual_head=null;
	    public ListNode reverseList(ListNode head) {
	        if(head==null || head.next==null)
	        {
	            return head;
	        }
	        actual_head = head;
	        reverse(head);
	        return actual_head;
	    }

	    public void reverse(ListNode head)
	    {
	       if(head==null || head.next==null)
	        {
	            tail = head;
	            actual_head = tail;
	            return;
	        }
	        reverse(head.next);
	        tail.next = head;
	        tail=tail.next;
	        tail.next=null;
	    }
}
