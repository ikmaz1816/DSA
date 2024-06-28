package llmediumproblem;

public class DeleteMiddleOfALL {
	public ListNode getMidPrevious(ListNode head)
    {
        ListNode slow=head;
        ListNode fast = head;
        ListNode midPrev = null;
        while(fast!=null && fast.next!=null)
        {
            midPrev = slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        return midPrev;
    }
    public ListNode deleteMiddle(ListNode head) {
        // if(head==null || head.next==null)  
        //     return head;
    	// The above condition fails for this [1] testcase as for [1] -> it should be [] empty output 
        ListNode midPrev = getMidPrevious(head);
        if(midPrev==null) return null;
        if(midPrev.next!=null)
            midPrev.next = midPrev.next.next;
        return head;
    }
}
