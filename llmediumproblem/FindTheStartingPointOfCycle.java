package llmediumproblem;

public class FindTheStartingPointOfCycle {
	public ListNode detectCycle(ListNode head) {
       ListNode slow = head;
       ListNode fast=head;
       while(fast!=null && fast.next!=null)
       {
           fast=fast.next.next;
           slow = slow.next;
           if(slow==fast)
           {
               ListNode temp = head;
               while(temp!=slow)
               {
                   temp=temp.next;
                   slow=slow.next;
               }
               return temp;
           }
           
       }
       return null;
   }
}
