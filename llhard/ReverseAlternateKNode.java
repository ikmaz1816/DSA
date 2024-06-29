package llhard;

import linkedlistimplementation.Node;
import linkedlistimplementation.SinglyLinkedList;

public class ReverseAlternateKNode {
	public static Node reverseKGroup(Node head, int k) {
        int size = 0;
        Node temp = head;
        while(temp!=null)
        {
            size++;
            temp = temp.next;
        }
        Node current = head;
        Node prev = null;
        Node next = null;
//        if(current!=null)
//            next = current.next;
        int count =0;
        while(true)
        {
            int i = k;
            Node newHead = prev;
            Node newTail = current;
            next = current.next;
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
//            prev=newTail;
            
            for(int j=0;j<k&& current!=null;j++)
            {
            	prev=current;
            	current=current.next;
            }
            count+=k;
            if(count>size-k)
                break;
        }

        return head;
    }
	public static void main(String[] args) {
		SinglyLinkedList ll=new SinglyLinkedList();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.addLast(6);
		ll.addLast(7);
		ll.addLast(8);
		ll.addLast(9);
		Node head=reverseKGroup(ll.getHead(),3);
		ll.setHead(head);
		System.out.println(ll);
	}
}
