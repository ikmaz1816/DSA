package stackqueueimplementation;

public class ImplementQueueUsingArray<T> {
	private T[] arr;
	private int size;
	private int front;
	private int back;
	
	public ImplementQueueUsingArray()
	{
		arr=(T[]) new Object[5];
		size=0;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return this.size==0;
	}
	
	public void offer(T element)
	{
		if(size()==arr.length)
		{
			doubleArray();
		}
		arr[back] = element;
		back=(back+1)%arr.length;
		size++;
	}

	private void doubleArray() {
		T[] arr1=arr;
		int length =arr1.length;
		arr=(T[]) new Object[2*length];
		for(int i=0;i<length;i++)
		{
			arr[i]=arr1[i];
		}
		front=0;
		back=length;
	}
	
	public T poll()
	{
		if(isEmpty())
			return null;
		T value = arr[front];
		arr[front]=null;
		front=(front+1)%arr.length;
		size--;
		return value;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		int length = arr.length;
		for(int i=0;i<length;i++)
		{
			if(arr[i]!=null)
				sb.append(arr[i]+" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ImplementQueueUsingArray<Integer> q=new ImplementQueueUsingArray<>();
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
