package stackqueueimplementation;

class QueueNode<T>
{
	T data;
	QueueNode<T> next;
	QueueNode(T a)
	{
	    data = a;
	}
}
public class QueueUsingLL<T> {
	private QueueNode<T> head, tail;
	private int size;
	
	public QueueUsingLL()
	{
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
	
	public void offer(T element)
	{
		QueueNode<T> node =new QueueNode<>(element);
		if(isEmpty())
		{
			head = tail=node;
		}
		else
		{
			tail.next=node;
			tail=tail.next;
		}
		size++;
	}
	
	public T poll()
	{
		if(isEmpty())
			return null;
		T element = head.data;
		QueueNode<T> node=head;
		head=head.next;
		node.next=null;
		size--;
		return element;
	}
	
	public static void main(String[] args) {
		QueueUsingLL<Integer> q=new QueueUsingLL<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		q.offer(6);
		while(!q.isEmpty())
		{
			System.out.print(q.poll()+" ");
		}
	}
}
