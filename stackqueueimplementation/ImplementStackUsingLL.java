package stackqueueimplementation;

class Node<T>
{
	T data;
	Node<T> next;
	public Node(T data)
	{
		this.data = data;
	}
}
public class ImplementStackUsingLL<T> {
	private Node<T> head;
	private int size;
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return this.size==0;
	}
	
	public void push(T element)
	{
		Node<T> node = new Node<>(element);
		if(isEmpty())
		{
			head=node;
		}
		else
		{
			node.next=head;
			head=node;
		}
		size++;
	}
	
	public T pop()
	{
		if(isEmpty())
			return null;
		T value = head.data;
		Node<T> node = head;
		head = head.next;
		size--;
		node.next=null;
		return value;
	}
	
	@Override
	public String toString()
	{
		Node<T> temp=head;
		StringBuilder sb = new StringBuilder();
		while(temp.next!=null)
		{
			sb.append(temp.data+"->");
			temp=temp.next;
		}
		return sb.append(temp.data).toString();
		
	}
	
	public static void main(String[] args) {
		ImplementStackUsingLL<Integer> ll=new ImplementStackUsingLL<>();
		ll.push(1);
		ll.push(2);
		ll.push(3);
		ll.push(4);
		ll.push(5);
		ll.push(6);
		System.out.println(ll);
		while(!ll.isEmpty())
		{
			System.out.print(ll.pop()+" ");
		}
	}
}
