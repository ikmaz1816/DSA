package linkedlistimplementation;


class SingleNode
{
	int data;
	SingleNode next;
	
	public SingleNode(int data)
	{
		this.data=data;
	}
	
	public SingleNode(int data,SingleNode next)
	{
		this.data=data;
		this.next=next;
	}
	
}
public class SinglyLinkedList {
	private SingleNode head;
	private SingleNode tail;
	private int size;
	public SinglyLinkedList()
	{
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return this.size==0;
	}
	
	public void addFirst(int element)
	{
		SingleNode node = new SingleNode(element);
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
		else
		{
			SingleNode node = new SingleNode(element);
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	public void add(int index,int element)
	{
		if(index>size)
		{
			return; // exception can be thrown
		}
		if(isEmpty())
		{
			addFirst(element);
			return;
		}
		else if(index==size)
		{
			addLast(element);
			return;
		}
		else
		{
			SingleNode node = new SingleNode(element);
			SingleNode temp = getNode(index-1);
			node.next = temp.next;
			temp.next = node;
		}
		size++;
	}
	
	@Override
	public String toString()
	{
		SingleNode node = head;
		StringBuilder sb=new StringBuilder();
		while(node.next!=null)
		{
			sb.append(node.data+"->");
			node = node.next;
		}
		sb.append(node.data);
		return sb.toString();
	}
	
	public int deleteFirst()
	{
		if(isEmpty())
			return Integer.MIN_VALUE;
		int value = head.data;
		SingleNode node =head;
		head=head.next;
		node.next=null;
		size--;
		return value;
	}
	
	public int deleteLast()
	{
		if(isEmpty())
		{
			return Integer.MIN_VALUE;
		}
		if(size==1)
		{
			deleteFirst();
		}
		SingleNode node = head;
		while(node.next!=tail)
		{
			node = node.next;
		}
		int value = tail.data;
		tail=node;
		tail.next=null;
		size--;
		return value;
	}
	
	public SingleNode getNode(int index)
	{
		SingleNode temp=head;
		while(index>0)
		{
			temp=temp.next;
			index--;
		}
		return temp;
	}
	
	public int delete(int index)
	{
		if(isEmpty())
			return Integer.MIN_VALUE;
		if(size==1)
			deleteFirst();
		if(index==size)
			deleteLast();
		if(index>size)
			return Integer.MIN_VALUE;
		size--;
		SingleNode temp=getNode(index-1);
		int value=temp.next.data;
		if(temp.next!=null)
			temp.next=temp.next.next;
		return value;
	}	
	
	public static void main(String[] args) {
		SinglyLinkedList ll=new SinglyLinkedList();
		ll.addFirst(4);
		ll.addFirst(3);
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(6);
		ll.add(5, 10);
		System.out.println(ll);
		ll.deleteFirst();
		System.out.println(ll);
		ll.deleteLast();
		System.out.println(ll);
		ll.delete(3);
		System.out.println(ll);
	}
}
