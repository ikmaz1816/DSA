package llhard;


public class CloneALL {
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	public Node copyRandomList(Node head) {
        if(head==null)
            return head;
        Node temp = head;
        while(temp!=null)
        {
            Node n = new Node(temp.val);
            n.next=temp.next;
            temp.next=n;
            temp=temp.next.next;
        }

        temp=head;
        while(temp!=null && temp.next!=null)
        {
            temp.next.random = temp.random!=null ? temp.random.next:null;
            temp=temp.next.next;
        }
        Node headToBeReturned = head.next;
        Node copy=head.next;
        Node original = head;
        while(copy!=null)
        {
            if(original.next!=null)
            {
                original.next=original.next.next;
            }
            if(copy.next!=null)
            {
                copy.next=copy.next.next;
            }
            original=original.next;
            copy=copy.next;
        }
        return headToBeReturned;
    }
}
