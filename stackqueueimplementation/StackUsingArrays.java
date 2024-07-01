package stackqueueimplementation;

public class StackUsingArrays<T> {
	T[] arr;
	int size;
	
	public StackUsingArrays()
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
	
	public void push(T element)
	{
		if(size()==arr.length)
		{
			doubleArray();
		}
		arr[size++] = element;
	}

	private void doubleArray() {
		T[] arr1=arr;
		int length =arr1.length;
		arr=(T[]) new Object[2*length];
		for(int i=0;i<length;i++)
		{
			arr[i]=arr1[i];
		}
		
	}
	
	public T pop()
	{
		if(isEmpty())
			return null;
		T value = arr[size-1];
		arr[size-1]=null;
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
		StackUsingArrays<Integer> s=new StackUsingArrays<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		System.out.println(s);
		while(!s.isEmpty())
		{
			System.out.print(s.pop()+" ");
		}
	}
}
