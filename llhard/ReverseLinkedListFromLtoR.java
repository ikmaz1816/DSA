package llhard;

public class ReverseLinkedListFromLtoR {
	public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left-right==0)
        {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        for(int i=0;i<left-1 && current!=null;i++)
        {
            prev=current;
            current=current.next;
        }

        if(current==null)
            return head;

        ListNode next = current.next;
        ListNode newHead = prev;
        ListNode newTail = current;
        for(int i=0;i<right-left+1 && current!=null;i++)
        {
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null)
                next=next.next;
        }

        if(newHead==null)
        {
            head = prev;
        }
        else
        {
            newHead.next = prev;
        }
        newTail.next = current;
        return head;
    }
}
