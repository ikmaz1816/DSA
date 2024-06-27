package dllhardproblems;
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}
public class DeleteAllOccurenceOfAGivenKeyInADLL {
	static Node deleteAllOccurOfX(Node head, int x) {
        while(head!=null && head.data==x)
        {
            Node currentNode = head;
            head=head.next;
            head.prev=null;
            currentNode.next=null;
        }
        if(head == null || head.next==null) return head;
        
        Node temp = head;
        while(temp!=null)
        {
            Node next = temp.next;
            if(temp.data==x)
            {
                Node currentNode = temp;
                temp.prev.next = temp.next;
                if(temp.next!=null)
                    temp.next.prev=temp.prev;
                currentNode.next=null;
                currentNode.prev=null;
            }
            temp=next;
        }
        return head;
    }
}
