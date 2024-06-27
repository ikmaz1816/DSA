package linkedlistimplementation;

public class DoublyLinkedList {
	private DNode head;
	private DNode tail;
	private int size;
	
	public DoublyLinkedList()
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
		DNode node = new DNode(element);
		if(isEmpty())
		{
			head=tail=node;
		}
		else
		{
			node.next = head;
			head.prev= node;
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
		DNode node = new DNode(element);
		tail.next = node;
		node.prev= tail;
		tail = node;
		size++;
	}
	
	public DNode getNode(int index)
	{
		DNode temp = head;
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
		else if(index==size)
		{
			addLast(element);
		}
		else
		{
			DNode node = getNode(index);
			DNode newNode = new DNode(element);
			newNode.next = node.next;
			newNode.prev = node;
			node.next.prev=newNode;
			node.next = newNode;
			size++;
		}
	}
	
	public int deleteFirst()
	{
		int value = Integer.MIN_VALUE;
		if(isEmpty())
			return value;
		else if(size==1)
		{
			value = head.data;
			head = head.next;
		}
		else
		{
			value = head.data;
			head = head.next;
			head.prev.next = null;
			head.prev=null;
		}
		size--;
		return value;
	}
	
	public int deleteLast()
	{
		int value = Integer.MIN_VALUE;
		if(isEmpty())
			return value;
		else if(size==1)
		{
			value=deleteFirst();
		}
		else
		{
			DNode temp = getNode(size-1);
			temp.next = null;
			value = tail.data;
			tail.prev = null;
			tail =temp;
			size--;
		}
		return value;
	}
	
	public int delete(int index)
	{
		int value = Integer.MIN_VALUE;
		if(isEmpty())
		{
			return value;
		}
		else if(size==1)
		{
			value = deleteFirst();
		}
		else if(size-1==index)
		{
			value=deleteLast();
		}
		else {
			DNode temp = getNode(index-1);
			DNode nodeToBeDeleted = temp.next;
			temp.next = temp.next.next;
			temp.next.prev = temp;
			size--;
			value = nodeToBeDeleted.data;
			nodeToBeDeleted.next=null;
			nodeToBeDeleted.prev=null;
		}
		return value;
	}
	
	@Override
	public String toString()
	{
		DNode temp =head;
		StringBuilder sb=new StringBuilder();
		while(temp.next!=null)
		{
			sb.append(temp.data+"->");
			temp=temp.next;
		}
		sb.append(temp.data);
		return sb.toString();
	}
	
	public DNode getHead()
	{
		return this.head;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList ll=new DoublyLinkedList();
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
		
	}	
}
