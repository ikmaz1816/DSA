package llproblems;

public class InsertingNode {
	Node insertAtBeginning(Node head, int element)
    {
        Node node = new Node(element);
		if(head==null)
		{
			head=node;
		}
		else
		{
			node.next=head;
			head=node;
		}
		return head;
    }
    
    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int element)
    {
         Node n=new Node(element);
		if(head==null)
		{
			head=n;
		}
		else
		{
			Node temp=head;
			while(temp.next!=null)
			    temp=temp.next;
			temp.next=n;
		}
		return head;
    }
}
