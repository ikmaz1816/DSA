package llproblems;


class Node { 
    int data; 
    Node next; 

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
}  

class SinglyLinkedList {
	Node head;
	private Node tail;
	private int size;
	
	public SinglyLinkedList()
	{
		head=tail=null;
		size=0;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return size()==0;
	}
	
	public void addFirst(int element)
	{
		Node node = new Node(element);
		if(isEmpty())
		{
			head=tail=node;
		}
		else
		{
			node.next=head;
			head=node;
		}
		size++;
	}
	
	public void addLast(int element)
	{
		if(isEmpty())
		{
			addFirst(element);
			return;
		}
		Node node = new Node(element);
		tail.next=node;
		tail=tail.next;
		size++;
	}
	
	public Node getNode(int index)
	{
		Node temp = head;
		for(int i=0;i<index-1;i++)
		{
			temp = temp.next;
		}
		return temp;
	}
	
	public void add(int index,int element)
	{
		if(index>size)
		{
			return;
		}
		else if(isEmpty())
		{
			addFirst(element);
		}
		else if(size==index)
		{
			addLast(element);
		}
		else
		{
			Node temp = getNode(index);
			Node newNode = new Node(element);
			newNode.next = temp.next;
			temp.next = newNode;
			size++;
		}
	}
	
	public int deleteFirst()
	{
		if(isEmpty())
		{
			return Integer.MIN_VALUE;
		}
		Node node =head;
		head=head.next;
		node.next = null;
		size--;
		return node.data;
	}
	
	public int deleteLast()
	{
		int value = Integer.MIN_VALUE;
		if(isEmpty())
		{
			return value;
		}
		else if(size==1)
		{
			value=deleteFirst();
		}
		else
		{
			Node temp = getNode(size-1);
			value = tail.data;
			temp.next = null;
			tail = temp;
			size--;
		}
		return value;
	}
	
	public int delete(int index)
	{
		int value = Integer.MIN_VALUE;
		if(index>size)
		{
			return value;
		}
		else if(index==0)
		{
			value=deleteFirst();
		}
		else if(index==size-1)
		{
			value=deleteLast();
		}
		else
		{
			Node temp = getNode(index-1);
			Node nodeToBeDeleted = temp.next;
			value = nodeToBeDeleted.data;
			temp.next = temp.next.next;
			nodeToBeDeleted.next = null;
			size--;
		}
		return value;
	}
}

public class IntroductionToLinkedList {
    static Node constructLL(int arr[]) {
        SinglyLinkedList ll=new SinglyLinkedList();
        for(int i:arr)
        {
            ll.addLast(i);
        }
        return ll.head;
    }

}
