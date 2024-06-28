package llmediumproblem;

public class PalindromeLL {
	public ListNode getMid(ListNode head){
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head)
    {
        ListNode prev=null,current=head;
        ListNode next = current.next;
        while(current!=null)
        {
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null)
                next=next.next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode mid = getMid(head);
        ListNode rev = reverse(mid);
        ListNode revHead = rev;
        ListNode temp = head;
        while(temp!=null && rev!=null)
        {
            if(temp.val!=rev.val)
                return false;
            temp=temp.next;
            rev=rev.next;
        }

        reverse(revHead);
        return true;

    }
}
