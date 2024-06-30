package linkedlistimplementation;



public class SinglyLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public SinglyLinkedList()
	{
		setHead(tail=null);
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
			setHead(tail=node);
		}
		else
		{
			node.next=getHead();
			setHead(node);
		}
		size++;
	}
	
	public Node getHead()
	{
		return this.head;
	}
	
	public void addRecursively(int index,int element)
	{
		setHead(addRecursively(getHead(),element,index));
	}
	private Node addRecursively(Node head, int element, int index) {
		if(index==0)
		{
			Node n = new Node(element);
			n.next = head;
			return n;
		}
		head.next = addRecursively(head.next,element,index-1);
		return head;
	}
	
	public void deleteRecursively(int index)
	{
		setHead(deleteRecursively(index,getHead()));
	}

	private Node deleteRecursively(int index, Node head) {
		if(index==0)
		{
			return head.next;
		}
		
		head.next = deleteRecursively(index-1,head.next);
		return head;
		
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
		Node temp = getHead();
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
		Node node =getHead();
		setHead(getHead().next);
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
	
	@Override
	public String toString()
	{
		Node temp =getHead();
		StringBuilder sb=new StringBuilder();
		while(temp.next!=null)
		{
			sb.append(temp.data+"->");
			temp=temp.next;
		}
		sb.append(temp.data);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SinglyLinkedList ll=new SinglyLinkedList();
		ll.addFirst(4);
		ll.addFirst(3);
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(5);
		ll.add(5, 10);
		ll.add(2, 11);
		System.out.println(ll);
		ll.deleteFirst();
		System.out.println(ll);
		ll.deleteLast();
		System.out.println(ll);
		ll.delete(4);
		System.out.println(ll);
		ll.addFirst(1);
		ll.addLast(5);
		System.out.println(ll);
		ll.addRecursively(2, 20);
		System.out.println(ll);
		ll.deleteRecursively(2);
		System.out.println(ll);
		
	}

	public void setHead(Node head) {
		this.head = head;
	}	
}
