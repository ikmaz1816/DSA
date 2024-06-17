package implementation;

public class ArrayDeque<T> {
	private T[] arr;
	private int size;
	private int front;
	private int rear;
	
	public ArrayDeque()
	{
		this.arr=(T[]) new Object[5];
		this.size=0;
		this.front=0;
		this.rear=0;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return this.size==0;
	}
	
	public boolean isFull()
	{
		return this.size == arr.length;
	}
	
	public void addFirst(T element)
	{
		if(isFull())
		{
			return;
			//we can also double the size of the array
		}
		if(isEmpty())
		{
			arr[front]=element;
		}
		else
		{
			front = (front - 1 + arr.length) % arr.length;
			arr[front]=element;
		}
		size++;
	}
	
	public void addLast(T element)
	{
		if(isFull())
		{
			return;
			//we can also double the size of the array
		}
		if(isEmpty())
		{
			arr[front]=element;
		}
		else
		{
			rear = (rear + 1 ) % arr.length;
			arr[rear]=element;
		}
		size++;
	}
	
	public T removeFirst()
	{
		if(isEmpty())
			return null;// We can also throw exception in this case
		T element = arr[front];
		arr[front] = null;
		front = (front+1)%arr.length;
		size--;
		return element;
	}
	
	public T removeLast()
	{
		if(isEmpty())
		{
			return null;
		}
		T element = arr[rear];
		arr[rear]=null;
		rear = (rear-1+arr.length)%arr.length;
		size--;
		return element;
	}
	
	@Override
	public String toString()
	{
		StringBuffer sb=new StringBuffer();
		int length=arr.length;
		for(int i=front;i<front+length;i++)
		{
			T element = arr[i%length];
			if(element!=null)
				sb.append(arr[i%length]+" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ArrayDeque<Integer> ad=new ArrayDeque<>();
		ad.addFirst(1);
		ad.addFirst(2);
		ad.addFirst(3);
		ad.addLast(20);
		ad.addLast(10);
		System.out.println(ad);
		ad.removeFirst();
		System.out.println(ad);
		ad.removeLast();
		System.out.println(ad);
		ad.addFirst(40);
		ad.addLast(90);
		System.out.println(ad);
		
	}
}
