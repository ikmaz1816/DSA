package llmediumproblem;

public class ReverseALL {
	public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode prev = null;
        ListNode current=head;
        ListNode next = current.next;
        while(current!=null)
        {
            current.next=prev;
            prev=current;
            current = next;
            if(next!=null)
                next=next.next;
        }
        return prev;
    }
}
