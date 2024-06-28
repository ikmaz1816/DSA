package llmediumproblem;

import linkedlistimplementation.Node;

public class AddOneToLL {
	 public static Node reverse(Node head)
	    {
	        Node prev=null,current=head;
	        Node next=current.next;
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
	    public static Node addOne(Node head) 
	    { 
	        if(head==null)
	            return head;
	        else if(head.next==null)
	        {
	            return new Node(head.data+1);
	        }
	        Node newHead = reverse(head);
	        Node temp = newHead;
	        Node prev=null;
	        int carry=0;
	        while(temp!=null)
	        {
	            
	            int sum = temp==newHead ? temp.data + carry +1 : temp.data+carry;
	            int remainder=sum%10;
	            temp.data=remainder;
	            carry = sum/10;
	            prev=temp;
	            temp=temp.next;
	        }
	        if(carry>0)
	        {
	            Node n = new Node(carry);
	            prev.next=n;
	        }
	        return reverse(newHead);
	    }
}
