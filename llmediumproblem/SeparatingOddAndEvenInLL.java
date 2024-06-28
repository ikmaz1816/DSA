package llmediumproblem;

public class SeparatingOddAndEvenInLL {
	public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = null;
        ListNode oddHead =null;
        ListNode evenTail = null;
        ListNode oddTail=null;
        ListNode temp = head;
        int count=1;
        while(temp!=null)
        {
            if(count%2==0)
            {
                if(evenHead==null)
                {
                    evenHead = evenTail = temp;
                }
                else
                {
                    evenTail.next = temp;
                    evenTail = evenTail.next;
                }
            }
            else
            {
                if(oddHead==null)
                {
                    oddHead = oddTail = temp;
                }
                else
                {
                    oddTail.next = temp;
                    oddTail = oddTail.next;
                }
            }
            temp=temp.next;
            count++;
        }
        if(oddHead==null)
        {
            return evenHead;
        }
        else if(evenHead==null)
            return oddHead;
        else 
        {
            oddTail.next=evenHead;
            evenTail.next=null;
        }
        return oddHead;
    }
}
