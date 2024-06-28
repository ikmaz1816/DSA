package llmediumproblem;

public class AddTwoLLWithoutExtraSpace {
	public int size(ListNode head)
    {
        ListNode current=head;
        int size=0;
        while(current!=null)
        {
            current=current.next;
            size++;
        }
        return size;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev1 = l1;
        ListNode rev2 = l2;
        int size1 = size(l1);
        int size2 = size(l2);
        if(size2>size1)
            return addTwoNumbers(l2,l1);
        int carry = 0;
        ListNode prev=null;
        while(rev1!=null && rev2!=null)
        {
            int sum = rev1.val+rev2.val+carry;
            int remainder = sum%10;
            rev1.val = remainder;
            carry = sum/10;
            prev=rev1;
            rev1=rev1.next;
            rev2=rev2.next;
        }
        while(rev1!=null)
        {
            int sum = rev1.val+carry;
            int remainder = sum%10;
            rev1.val = remainder;
            prev=rev1;
            carry = sum/10;
            rev1=rev1.next;
        }
        while(carry>0)
        {
            ListNode node = new ListNode(carry%10);
            prev.next=node;
            prev=prev.next;
            carry/=10;
        }
        return l1;
    }
}
