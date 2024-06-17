package implementation;

public class CircularQueue<T> {
	
	private T[] arr;
	private int size;
	private int front;
	private int rear;
	
	public CircularQueue()
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
	
	private void doubleArray() {
		T[] arr1 = arr;
		int length = arr1.length;
		arr = (T[]) new Object[length * 2];
		for(int i=0; i<length;i++)
		{
			arr[i] = arr1[i];
		}
		front=0;
		rear=length-1;
	}
	
	public void add(T element)
	{
		if(isFull())
		{
			doubleArray();
		}
		if(isEmpty())
		{
			arr[front]=element;
		}
		else
		{
			arr[++rear%arr.length]=element;
		}
		size++;
	}
	
	public T poll()
	{
		if(isEmpty())
			return null; // exception can also be thrown 
		T element = arr[front];
		arr[front]=null;
		front+=1%arr.length;
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
		CircularQueue<Integer> cq=new CircularQueue<>();
		cq.add(1);
		cq.add(2);
		cq.add(3);
		cq.add(4);
		cq.add(5);
		System.out.println(cq);
		cq.add(6);
		System.out.println(cq);
		
		cq.poll();
		cq.poll();
		cq.add(10);
		System.out.println(cq);
		System.out.println(cq.front+" "+cq.rear);
	}
}
