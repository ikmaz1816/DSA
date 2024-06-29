package llhard;

class ListNode {
	  int val;
	  ListNode next;
	  ListNode() {}
	  ListNode(int val) { this.val = val; }
	  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RotateLL {
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0)
            return head;
        int size =0;
        ListNode temp =head;
        while(temp!=null) 
        {
            size++;
            temp = temp.next;
        }
        if(k>size)
            k%=size;
        if(k==0 || size==k)
            return head;
        temp=head;
        for(int i=0;i<size-k-1;i++)
        {
            temp=temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;

        temp = newHead;
        while(temp.next!=null)
        {
            temp = temp.next;
        }

        temp.next = head;

        head = newHead;
        
        return head;
    }
}
