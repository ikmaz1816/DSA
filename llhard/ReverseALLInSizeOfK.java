package llhard;

public class ReverseALLInSizeOfK {
	public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            size++;
            temp = temp.next;
        }
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
         if(current!=null)
                next = current.next;
        int count =0;
        while(true)
        {
            int i = k;
            ListNode newHead = prev;
            ListNode newTail = current;
            while(i>0 && current!=null)
            {
                current.next=prev;
                prev=current;
                current=next;
                if(next!=null)
                    next=next.next;
                i--;
            }
            count+=k;
            if(newHead==null)
            {
                head = prev;
            }
            else
            {
                newHead.next=prev;
            }
            newTail.next = current;
            prev = newTail;
            if(count>size-k)
                break;
        }

        return head;
    }
}
