package llmediumproblem;

public class SeparatingOddEvenIndex {
	 public ListNode oddEvenList(ListNode head) {
		 // 1 based indexing
		 // 1->3->5 2->4->6 connecting indexes irrespective of the value
	        if(head==null || head.next==null)
	            return head;
	        ListNode evenNode = head.next;
	        ListNode even = head.next;
	        ListNode odd = head;
	        while(even!=null && even.next!=null)
	        {
	            odd.next=odd.next.next;
	            even.next=even.next.next;
	            odd=odd.next;
	            even=even.next;
	        }
	        odd.next=evenNode;
	        return head;
	    }
}
